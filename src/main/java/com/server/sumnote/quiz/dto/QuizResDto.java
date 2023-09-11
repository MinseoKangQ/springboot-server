package com.server.sumnote.quiz.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class QuizResDto {
    private String question;
    private String selections;
    private Integer answer;
    private String commentary;
}
