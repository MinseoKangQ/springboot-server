package com.server.sumnote.summary.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class createSumNoteResDto {
    private String title;
    private String content;
}
