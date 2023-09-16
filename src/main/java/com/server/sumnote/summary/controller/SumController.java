package com.server.sumnote.summary.controller;

import com.server.sumnote.summary.dto.*;
import com.server.sumnote.summary.entity.Summary;
import com.server.sumnote.summary.repository.SummaryRepository;
import com.server.sumnote.summary.service.SummaryService;
import com.server.sumnote.util.ChangeDateFormat;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
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
    @PostMapping("/sum-note")
    @ApiOperation(value = "요약 노트 만들기")
    public void createSumNote(@RequestBody SumNoteReqDto req) {
        Summary createdSummary = summaryService.createSumNote(
                req.getEmail(),
                req.getSum_doc_title(),
                req.getTitle(),
                req.getContent());
    }

    @ResponseBody
    @GetMapping("/sum-notes")
    @ApiOperation(value = "유저의 모든 요약 노트 보여주기")
    public AllSumNoteResDto getAllSumNotes(@RequestParam String email) {
        List<AllSumNoteResDto.SumNoteResDto> noteList = new ArrayList<>();
        ArrayList<Summary> notes = summaryService.getAllSumNotes(email);
        for (Summary note : notes) {
            String created_at = ChangeDateFormat.doChange(note.getCreated_at().toString());
            noteList.add(new AllSumNoteResDto.SumNoteResDto(
                    note.getId(),
                    note.getSum_doc_title(),
                    created_at
            ));
        }
        return new AllSumNoteResDto(noteList);
    }

    @ResponseBody
    @GetMapping("/sum-note/{id}")
    @ApiOperation(value = "요약 노트 조회")
    public SumNoteResDto getSumNote(@PathVariable Long id) {
        Summary gotSummary = summaryService.getSumNote(id);
        return new SumNoteResDto(gotSummary.getSum_doc_title(), gotSummary.getTitle(), gotSummary.getContent());
    }

    @ResponseBody
    @PutMapping("/sum-note/title/{id}")
    @ApiOperation(value = "요약 노트 제목 수정")
    public void updateSumNoteTitle(@PathVariable Long id, @RequestBody UpdateTitleReqDto req) {
        summaryService.updateSumNoteTitle(id, req.getSum_doc_title());
        Summary gotUpdatedSumNote = summaryService.getSumNote(id);
    }

    @ResponseBody
    @PutMapping("/sum-note/content/{id}")
    @ApiOperation(value = "요약 노트 페이지 추가")
    public void updateSumNoteContent(@PathVariable Long id, @RequestBody UpdateContentReqDto req) {
        summaryService.updateSumNoteContent(id, req.getAddTitle(), req.getAddContent());
        Summary gotUpdatedSumNote = summaryService.getSumNote(id);
    }

    @ResponseBody
    @DeleteMapping("/sum-note/{id}")
    @ApiOperation(value = "요약 노트 삭제")
    public void deleteSumNote(@PathVariable Long id) {
        summaryService.deleteSumNote(id);
    }

}