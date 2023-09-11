package com.server.sumnote.summary.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class AllSumNoteResDto {

    private List<SumNoteResDto> noteList;

    @AllArgsConstructor
    @Getter
    @Setter
    public static class SumNoteResDto {
        private Long id;
        private String title;
        private String content;
        private String created_at;
    }

}
