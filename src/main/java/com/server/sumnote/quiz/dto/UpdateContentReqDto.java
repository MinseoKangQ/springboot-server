package com.server.sumnote.quiz.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateContentReqDto {
    private String addQuestion;
    private String addSelections;
    private String addAnswer;
    private String addCommentary;
}
