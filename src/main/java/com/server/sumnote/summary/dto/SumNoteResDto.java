package com.server.sumnote.summary.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SumNoteResDto {
    private String sum_doc_title;
    private String title;
    private String content;
}
