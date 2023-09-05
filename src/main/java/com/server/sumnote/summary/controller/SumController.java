package com.server.sumnote.summary.controller;

import com.server.sumnote.quiz.entity.Quiz;
import com.server.sumnote.summary.dto.CreateSumNoteRequest;
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
    public CreateSumNoteRequest createSumNote(@RequestBody CreateSumNoteRequest createSumNoteRequest) {

        // Summary 의 user 에 user_id를 FK로 지정, Summary 객체를 저장
        System.out.println("user email : " + createSumNoteRequest.getUser().getEmail());
        System.out.println("summary title : " + createSumNoteRequest.getSummary().getTitle());
        System.out.println("summary content : " + createSumNoteRequest.getSummary().getContent());

        String isSuccess = summaryService.createSumNote(
                createSumNoteRequest.getSummary().getTitle(),
                createSumNoteRequest.getSummary().getTitle(),
                createSumNoteRequest.getUser());
        // 영속성 컨텍스트에 저장

        System.out.println(isSuccess);

        return createSumNoteRequest;
    }

    @GetMapping("/sum-notes")
    @ApiOperation(value = "유저의 모든 요약 노트 보여주기")
    public List<Quiz> getAllSumNotes(@RequestBody User user) {

        // 유저의 아이디에 해당하는 요약 문서들 가져오기

        // 일단 null
        return null;
    }

    // 터치한 문서의 번호로 접근
    @GetMapping("/sum-notes-detail")
    @ApiOperation(value = "요약 노트 조회")
    public Quiz getSumNote(@RequestBody Long id) {

        // 문서 아이디에 해당하는 요약 문서 하나 가져오기

        // 일단 null
        return null;
    }

    // 터치한 문서의 번호로 접근
    @DeleteMapping("sum-notes")
    @ApiOperation(value = "요약 노트 삭제")
    public void deleteSumNote(@PathVariable Long id) {

        // 문서 아이디에 해당하는 요약 문서 하나 가져와서 삭제

    }

}