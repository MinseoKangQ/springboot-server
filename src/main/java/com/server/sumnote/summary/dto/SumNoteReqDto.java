package com.server.sumnote.summary.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SumNoteReqDto {
    String email; // 이메일
    String sum_doc_title; // 요약 노트 제목
    String title; // 요약노트 한 페이지의 제목
    String content; // 요약노트 한 페이지의 내용
}
