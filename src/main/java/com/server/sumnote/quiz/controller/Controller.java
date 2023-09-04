package com.server.sumnote.quiz.controller;

import com.server.sumnote.quiz.entity.Quiz;
import com.server.sumnote.user.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@Slf4j
@RestController
@RequestMapping
@RequiredArgsConstructor
@Component("quizController")
@Api(tags = {"Quiz API"})
public class Controller {

    @GetMapping("/quizzes")
    @ApiOperation(value = "유저의 모든 퀴즈 문서 보여주기")
    public List<Quiz> getAllQuizzes(@RequestBody User user) {

        // 유저의 아이디에 해당하는 퀴즈 문서들 가져오기

        // 일단 null
        return null;
    }

    // 터치한 문서의 번호로 접근
    @GetMapping("/quizzes-detail")
    @ApiOperation(value = "퀴즈 문서 조회")
    public Quiz getQuiz(@RequestBody Long id) {

        // 문서 아이디에 해당하는 퀴즈 문서 하나 가져오기

        // 일단 null
        return null;
    }

    // 터치한 문서의 번호로 접근
    @DeleteMapping("/quiz")
    @ApiOperation(value = "퀴즈 문서 삭제")
    public void deleteQuiz(@PathVariable Long id) {

        // 문서 아이디에 해당하는 퀴즈 문서 하나 가져와서 삭제

    }

}