package com.server.sumnote.quiz.controller;


import com.server.sumnote.quiz.dto.AllQuizzesResDto;
import com.server.sumnote.quiz.dto.QuizReqDto;
import com.server.sumnote.quiz.dto.QuizResDto;
import com.server.sumnote.quiz.entity.Quiz;
import com.server.sumnote.quiz.service.QuizService;
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
    @PostMapping("/create-quiz")
    @ApiOperation(value = "퀴즈 만들기")
    public QuizResDto createQuiz(@RequestBody QuizReqDto req) {
        Quiz createdQuiz = quizService.createQuiz(
                req.getQuestion(),
                req.getSelections(),
                req.getAnswer(),
                req.getCommentary(),
                req.getEmail(),
                req.getSum_id());

        System.out.println("=== 생성된 퀴즈 ===");
        System.out.println(createdQuiz);
        System.out.println("=== 연관된 요약 노트 제목 ===");
        System.out.println(createdQuiz.getSummary().getTitle());

        return new QuizResDto(createdQuiz.getQuestion(), createdQuiz.getSelections(), createdQuiz.getAnswer(), createdQuiz.getCommentary());
    }

    @ResponseBody
    @GetMapping("/quizzes")
    @ApiOperation(value = "유저의 모든 퀴즈 보여주기")
    public AllQuizzesResDto getAllQuizzes(@RequestParam String email) {
        System.out.println("==== getAllQuizzes 들어옴 ===");
        List<AllQuizzesResDto.QuizResDto> quizList = new ArrayList<>();
        ArrayList<Quiz> docs = quizService.getAllQuizzes(email);
        for (Quiz quiz: docs) {
            String created_at = ChangeDateFormat.doChange(quiz.getCreated_at().toString());
            quizList.add(new AllQuizzesResDto.QuizResDto(
                    quiz.getQuestion(),
                    quiz.getSelections(),
                    quiz.getAnswer(),
                    quiz.getCommentary(),
                    created_at
            ));
        }
        return new AllQuizzesResDto(quizList);
    }

}
