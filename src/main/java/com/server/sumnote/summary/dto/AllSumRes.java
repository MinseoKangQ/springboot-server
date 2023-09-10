package com.server.sumnote.summary.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class AllSumRes {
    private Long id;
    private String title;
    private LocalDateTime created_at;
}
