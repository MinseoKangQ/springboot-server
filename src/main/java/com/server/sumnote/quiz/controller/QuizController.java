package com.server.sumnote.quiz.controller;

import com.server.sumnote.quiz.dto.QuizReq;
import com.server.sumnote.quiz.entity.Quiz;
import com.server.sumnote.quiz.entity.Selection;
import com.server.sumnote.quiz.service.QuizService;
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
@Component("quizController")
@Api(tags = {"Quiz API"})
public class QuizController {

    private final QuizService quizService;

    @ResponseBody
    @PostMapping("/create-quiz")
    @ApiOperation(value = "퀴즈 만들기")
    public List<Selection> createQuiz(@RequestBody QuizReq req) {

        return null;
    }

    @ResponseBody
    @GetMapping("/quizzes")
    @ApiOperation(value = "유저의 모든 퀴즈 문서 보여주기")
    public List<Quiz> getAllQuizzes(@RequestBody User user) {

        return null;
    }

    @ResponseBody
    @GetMapping("/quizzes-detail/{id}")
    @ApiOperation(value = "퀴즈 문서 조회")
    public Quiz getQuiz(@PathVariable Long id) {

        return null;
    }

    @ResponseBody
    @PutMapping("/quiz/{id}/{title}")
    @ApiOperation(value = "퀴즈 문서 제목 수정")
    public void updateQuiz(@PathVariable Long id, @PathVariable String title) {

    }

    @ResponseBody
    @DeleteMapping("/quiz/{id}")
    @ApiOperation(value = "퀴즈 문서 삭제")
    public void deleteQuiz(@PathVariable Long id) {

    }

}