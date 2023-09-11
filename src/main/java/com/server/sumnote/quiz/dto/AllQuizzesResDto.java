package com.server.sumnote.quiz.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class AllQuizzesResDto {

    private List<QuizResDto> quizList;

    @AllArgsConstructor
    @Getter
    @Setter
    public static class QuizResDto {
        private String question;
        private String selections;
        private Integer answers;
        private String commentary;
        private String created_at;
        // 관련 Summary 도 보내줘야?
    }
}
