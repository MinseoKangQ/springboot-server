package com.server.sumnote.quiz.controller;


import com.server.sumnote.quiz.dto.*;
import com.server.sumnote.quiz.entity.Quiz;
import com.server.sumnote.quiz.service.QuizService;
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

    @ResponseBody
    @GetMapping("/quiz/{id}")
    @ApiOperation(value = "퀴즈 조회")
    public QuizResDto getQuiz(@PathVariable Long id) {
        Quiz gotQuiz = quizService.getQuiz(id);
        return new QuizResDto(gotQuiz.getQuiz_doc_title(), gotQuiz.getQuestion(), gotQuiz.getSelections(), gotQuiz.getAnswer(), gotQuiz.getCommentary());
    }

    @ResponseBody
    @PutMapping("/quiz/title/{id}")
    @ApiOperation(value = "퀴즈 제목 수정")
    public void updateQuizTitle(@PathVariable Long id, @RequestBody UpdateTitleReqDto req) {
        quizService.updateQuizTitle(id, req.getQuiz_doc_title());
        Quiz gotUpdatedQuiz = quizService.getQuiz(id);
    }

    @ResponseBody
    @PutMapping("/quiz/content/{id}")
    @ApiOperation(value = "퀴즈 페이지 추가")
    public void updateQuizContent(@PathVariable Long id, @RequestBody UpdateContentReqDto req) {
        quizService.updateQuizContent(id, req.getAddQuestion(), req.getAddSelections(), req.getAddAnswer(), req.getAddCommentary());
        Quiz gotUpdatedQuiz = quizService.getQuiz(id);
    }

    @ResponseBody
    @DeleteMapping("/quiz/{id}")
    @ApiOperation(value = "퀴즈 삭제")
    public void deleteQuiz(@PathVariable Long id) {
        quizService.deleteQuizById(id);
    }

}
