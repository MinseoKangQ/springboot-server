package com.server.sumnote.quiz.entity;

import com.server.sumnote.summary.entity.Summary;
import com.server.sumnote.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "QUIZ")
@EntityListeners(AuditingEntityListener.class)
public class Quiz {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quiz_id")
    private Long id; // 자동 생성되는 기본키

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user; // 유저 외래키

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sum_id")
    private Summary summary; // 퀴즈에 해당하는 요약노트

    private String quiz_doc_title; // 퀴즈 문서 제목

    private String question; // 퀴즈 내용

    private String selections; // 퀴즈 선택지들 (4지선다)

    private String answer; // 정답

    private String commentary; // 해설

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime created_at; // 생성일

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime last_modified_at; // 수정일

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quiz quiz = (Quiz) o;
        return Objects.equals(id, quiz.id) && Objects.equals(user, quiz.user) && Objects.equals(question, quiz.question) && Objects.equals(selections, quiz.selections) && Objects.equals(answer, quiz.answer) && Objects.equals(commentary, quiz.commentary) && Objects.equals(created_at, quiz.created_at) && Objects.equals(last_modified_at, quiz.last_modified_at);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, question, selections, answer, commentary, created_at, last_modified_at);
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "id=" + id +
                ", user=" + user +
                ", question='" + question + '\'' +
                ", selections='" + selections + '\'' +
                ", answer=" + answer +
                ", commentary='" + commentary + '\'' +
                ", created_at=" + created_at +
                ", last_modified_at=" + last_modified_at +
                '}';
    }
}
