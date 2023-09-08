package com.server.sumnote.summary.controller;

import com.server.sumnote.quiz.entity.Quiz;
import com.server.sumnote.summary.dto.AllSumRes;
import com.server.sumnote.summary.dto.SumReq;
import com.server.sumnote.summary.dto.SumRes;
import com.server.sumnote.summary.entity.Summary;
import com.server.sumnote.summary.service.SummaryService;
import com.server.sumnote.user.entity.User;
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
    public SumRes createSumNote(@RequestBody SumReq createSumRequest) {

        Summary createdSummary = summaryService.createSumNote(
                createSumRequest.getSummary().getTitle(),
                createSumRequest.getSummary().getContent(),
                createSumRequest.getUser());

        return new SumRes(createdSummary.getTitle(), createdSummary.getContent());

    }


    @ResponseBody
    @GetMapping("/sum-notes")
    @ApiOperation(value = "유저의 모든 요약 노트 보여주기")
    public ArrayList<AllSumRes> getAllSumNotes(@RequestBody User user) {

        ArrayList<AllSumRes> result = new ArrayList<>();
        ArrayList<Summary> notes = summaryService.getAllSumNotes(user.getEmail());

        for (Summary note : notes) {
            result.add(new AllSumRes(note.getTitle(), note.getCreated_at()));
        }

        return result;
    }

    @ResponseBody
    @GetMapping("/sum-note-detail/{id}")
    @ApiOperation(value = "요약 노트 조회")
    public SumRes getSumNote(@PathVariable Long id) {
        Summary gotSummary = summaryService.getSumNote(id);
        return new SumRes(gotSummary.getTitle(), gotSummary.getContent());
    }

    @ResponseBody
    @PutMapping("/sum-note/{id}/{title}")
    @ApiOperation(value = "요약 노트 제목 수정")
    public void updateSumNote(@PathVariable Long id, @PathVariable String title) {
        summaryService.updateNote(id, title);
    }

    @ResponseBody
    @DeleteMapping("/sum-note/{id}")
    @ApiOperation(value = "요약 노트 삭제")
    public void deleteSumNote(@PathVariable Long id) {
        summaryService.deleteNote(id);
    }

}