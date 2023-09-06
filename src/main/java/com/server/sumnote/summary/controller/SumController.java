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

    @ResponseBody // 이 메소드가 응답을 직접 처리하도록 알림
    @PostMapping("/create-sum-note")
    @ApiOperation(value = "요약 노트 만들기")
    public SumRes createSumNote(@RequestBody SumReq createSumRequest) {

        Summary createdSummary = summaryService.createSumNote(
                createSumRequest.getSummary().getTitle(),
                createSumRequest.getSummary().getContent(),
                createSumRequest.getUser());

        return new SumRes(createdSummary.getTitle(), createdSummary.getContent());

    }


    @ResponseBody // 이 메소드가 응답을 직접 처리하도록 알림
    @GetMapping("/sum-notes")
    @ApiOperation(value = "유저의 모든 요약 노트 보여주기")
    public List<AllSumRes> getAllSumNotes(@RequestBody User user) {

        // 유저의 아이디에 해당하는 요약 문서들 가져오기
        ArrayList<Summary> notes = summaryService.getAllSumNotes(user.getEmail());

        // Summary 객체를 AllSumRes 객체로 변환
        List<AllSumRes> result = new ArrayList<>();
        for (Summary note : notes) {
            AllSumRes allSumRes = new AllSumRes(note.getTitle(), note.getCreated_at());
            result.add(allSumRes);
        }

        // 배열 형태로 보내기, [ {"title" : ~~ , "created_at" : ~~ }, ]
        return result;

    }

    // 터치한 문서의 번호로 접근
    @ResponseBody // 이 메소드가 응답을 직접 처리하도록 알림
    @GetMapping("/sum-note-detail/{id}")
    @ApiOperation(value = "요약 노트 조회")
    public SumRes getSumNote(@PathVariable("id") Long id) {

        Summary gotSummary = summaryService.getSumNote(id);
        return new SumRes(gotSummary.getTitle(), gotSummary.getContent());

    }

    // 여기 만들기
    // 터치한 문서의 번호로 접근
    @ResponseBody
    @PutMapping("/sum-note/{id}")
    @ApiOperation(value = "요약 노트 제목 수정")
    public void updateSumNote(@PathVariable Long id) {

    }

    // 터치한 문서의 번호로 접근
    @ResponseBody
    @DeleteMapping("/sum-note/{id}")
    @ApiOperation(value = "요약 노트 삭제")
    public void deleteSumNote(@PathVariable Long id) {

        // 문서 아이디에 해당하는 요약 문서 하나 가져와서 삭제
        summaryService.deleteNote(id);

    }

}