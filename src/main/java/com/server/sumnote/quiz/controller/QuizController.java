package com.server.sumnote.quiz.controller;


import com.server.sumnote.quiz.dto.AllQuizzesResDto;
import com.server.sumnote.quiz.dto.QuizReqDto;
import com.server.sumnote.quiz.dto.QuizResDto;
import com.server.sumnote.quiz.entity.Quiz;
import com.server.sumnote.quiz.service.QuizService;
import com.server.sumnote.summary.dto.AllSumNoteResDto;
import com.server.sumnote.summary.entity.Summary;
import com.server.sumnote.util.ChangeDateFormat;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@Component("quizController")
@Api(tags = {"Quiz API"})
public class QuizController {

    private final QuizService quizService;

    @ResponseBody
    @PostMapping("/quiz")
    @ApiOperation(value = "퀴즈 만들기")
    public void createQuiz(@RequestBody QuizReqDto req) {
        Quiz createdQuiz = quizService.createQuiz(
                req.getEmail(),
                req.getSum_id(),
                req.getQuestion(),
                req.getSelections(),
                req.getAnswer(),
                req.getCommentary());
    }

    @ResponseBody
    @GetMapping("/quizzes")
    @ApiOperation(value = "유저의 모든 퀴즈 보여주기")
    public AllQuizzesResDto getAllQuizzes(@RequestParam String email) {
        List<AllQuizzesResDto.QuizResDto> docList = new ArrayList<>();
        ArrayList<Quiz> notes = quizService.getAllQuizzes(email);
        for (Quiz quizzes : notes) {
            String created_at = ChangeDateFormat.doChange(quizzes.getCreated_at().toString());
            docList.add(new AllQuizzesResDto.QuizResDto(
                    quizzes.getId(),
                    quizzes.getQuiz_doc_title(),
                    created_at
            ));
        }
        return new AllQuizzesResDto(docList);
    }

}
