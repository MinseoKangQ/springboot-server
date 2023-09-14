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
        private Long id;
        private String quiz_doc_title;
        private String created_at;
    }
}
