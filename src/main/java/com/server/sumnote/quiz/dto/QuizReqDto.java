package com.server.sumnote.quiz.dto;

import com.server.sumnote.summary.entity.Summary;
import com.server.sumnote.user.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuizReqDto {
    private String question;
    private String selections;
    private Integer answer;
    private String commentary;
    private String email;
    private Long sum_id;
}
