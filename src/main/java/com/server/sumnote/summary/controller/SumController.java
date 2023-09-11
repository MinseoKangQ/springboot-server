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

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    public createSumNoteResDto createSumNote(@RequestBody createSumNoteReqDto req) {
        Summary createdSummary = summaryService.createSumNote(
                req.getSummary().getTitle(),
                req.getSummary().getContent(),
                req.getUser());
        return new createSumNoteResDto(createdSummary.getTitle(), createdSummary.getContent());
    }

    @ResponseBody
    @GetMapping("/sum-notes")
    @ApiOperation(value = "유저의 모든 요약 노트 보여주기")
    public CustomSumNoteResponse getAllSumNotes(@RequestParam String email, @RequestParam String name) {
        List<CustomSumNoteResponse.CustomSumNote> customNotes = new ArrayList<>();
        ArrayList<Summary> notes = summaryService.getAllSumNotes(email);
        for (Summary note : notes) {
            String created_at = ChangeDateFormat.doChange(note.getCreated_at().toString());
            customNotes.add(new CustomSumNoteResponse.CustomSumNote(
                    note.getId(),
                    note.getTitle(),
                    note.getContent(),
                    created_at
            ));
        }
        return new CustomSumNoteResponse(customNotes);
    }

    @ResponseBody
    @GetMapping("/sum-note-detail/{id}")
    @ApiOperation(value = "요약 노트 조회")
    public createSumNoteResDto getSumNote(@PathVariable Long id) {
        Summary gotSummary = summaryService.getSumNote(id);
        return new createSumNoteResDto(gotSummary.getTitle(), gotSummary.getContent());
    }

    @ResponseBody
    @PutMapping("/sum-note/{id}")
    @ApiOperation(value = "요약 노트 제목 수정")
    public UpdateTitleRes updateSumNote(@PathVariable Long id, @RequestBody UpdateTitleReq updateTitleReq) {
        summaryService.updateSumNote(id, updateTitleReq.getTitle());
        Summary gotUpdatedSummary = summaryService.getSumNote(id);
        return new UpdateTitleRes(gotUpdatedSummary.getTitle(), gotUpdatedSummary.getContent(), gotUpdatedSummary.getLast_modified_at());
    }

    @ResponseBody
    @DeleteMapping("/sum-note/{id}")
    @ApiOperation(value = "요약 노트 삭제")
    public void deleteSumNote(@PathVariable Long id) {
        summaryService.deleteSumNote(id);
    }

}