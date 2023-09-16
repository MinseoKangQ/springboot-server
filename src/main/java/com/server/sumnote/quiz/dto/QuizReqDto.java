package com.server.sumnote.quiz.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuizReqDto {
    private String email; // 이메일
    private Long sum_id; // 관련 요약 노트 아이디
    private String question; // 퀴즈 내용
    private String selections; // 퀴즈 선택지
    private String answer; // 퀴즈 정답
    private String commentary; // 퀴즈 해설
}
