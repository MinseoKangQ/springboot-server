package com.server.sumnote.summary.controller;

import com.server.sumnote.summary.dto.*;
import com.server.sumnote.summary.entity.Summary;
import com.server.sumnote.summary.service.SummaryService;
import com.server.sumnote.util.ChangeDateFormat;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@Component("summaryController")
@Api(tags = {"Summary API"})
public class SumController {

    private final SummaryService summaryService;

    @ResponseBody
    @PostMapping("/create-sum-note")
    @ApiOperation(value = "요약 노트 만들기")
    public SumNoteResDto createSumNote(@RequestBody SumNoteReqDto req) {
        Summary createdSummary = summaryService.createSumNote(
                req.getSummary().getTitle(),
                req.getSummary().getContent(),
                req.getUser());
        return new SumNoteResDto(createdSummary.getTitle(), createdSummary.getContent());
    }

    @ResponseBody
    @GetMapping("/sum-notes")
    @ApiOperation(value = "유저의 모든 요약 노트 보여주기")
    public AllSumNoteResDto getAllSumNotes(@RequestParam String email, @RequestParam String name) {
        List<AllSumNoteResDto.SumNoteResDto> customNotes = new ArrayList<>();
        ArrayList<Summary> notes = summaryService.getAllSumNotes(email);
        for (Summary note : notes) {
            String created_at = ChangeDateFormat.doChange(note.getCreated_at().toString());
            customNotes.add(new AllSumNoteResDto.SumNoteResDto(
                    note.getId(),
                    note.getTitle(),
                    note.getContent(),
                    created_at
            ));
        }
        return new AllSumNoteResDto(customNotes);
    }

    @ResponseBody
    @GetMapping("/sum-note-detail/{id}")
    @ApiOperation(value = "요약 노트 조회")
    public SumNoteResDto getSumNote(@PathVariable Long id) {
        Summary gotSummary = summaryService.getSumNote(id);
        return new SumNoteResDto(gotSummary.getTitle(), gotSummary.getContent());
    }

    @ResponseBody
    @PutMapping("/sum-note/{id}")
    @ApiOperation(value = "요약 노트 제목 수정")
    public UpdateTitleResDto updateSumNote(@PathVariable Long id, @RequestBody UpdateTitleReqDto req) {
        summaryService.updateSumNote(id, req.getTitle());
        Summary gotUpdatedSumNote = summaryService.getSumNote(id);
        return new UpdateTitleResDto(gotUpdatedSumNote.getTitle(), gotUpdatedSumNote.getContent(), gotUpdatedSumNote.getLast_modified_at());
    }

    @ResponseBody
    @DeleteMapping("/sum-note/{id}")
    @ApiOperation(value = "요약 노트 삭제")
    public void deleteSumNote(@PathVariable Long id) {
        summaryService.deleteSumNote(id);
    }

}