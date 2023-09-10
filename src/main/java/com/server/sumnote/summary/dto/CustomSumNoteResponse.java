package com.server.sumnote.summary.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class CustomSumNoteResponse {

    private List<CustomSumNote> noteList;

    @AllArgsConstructor
    @Getter
    @Setter
    public static class CustomSumNote {
        private Long id;
        private String title;
        private String content;
        private LocalDateTime created_at;
    }

}
