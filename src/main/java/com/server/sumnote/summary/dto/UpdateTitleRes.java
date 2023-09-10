package com.server.sumnote.summary.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class UpdateTitleRes {
    private String title;
    private String content;
    private LocalDateTime last_modified_at;
}
