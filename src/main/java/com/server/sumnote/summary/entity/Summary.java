package com.server.sumnote.summary.entity;

import lombok.*;
import java.util.Objects;
import javax.persistence.*;
import java.time.LocalDateTime;
import com.server.sumnote.quiz.entity.Quiz;
import com.server.sumnote.user.entity.User;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SUMMARY")
@EntityListeners(AuditingEntityListener.class)
public class Summary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sum_id")
    private Long id; // 자동 생성되는 기본키

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user; // 유저 외래키

    private String sum_doc_title; // 요약 노트 제목

    @OneToOne(mappedBy = "summary")
    @JsonIgnoreProperties({"summary"})
    private Quiz quiz; // 요약노트에 해당하는 퀴즈

    private String title; // 요약노트 한 페이지의 제목

    @Column(columnDefinition = "TEXT")
    private String content; // 요약노트 한 페이지의 내용

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
        Summary summary = (Summary) o;
        return Objects.equals(id, summary.id) && Objects.equals(user, summary.user) && Objects.equals(title, summary.title) && Objects.equals(content, summary.content) && Objects.equals(created_at, summary.created_at) && Objects.equals(last_modified_at, summary.last_modified_at);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, title, content, created_at, last_modified_at);
    }

    @Override
    public String toString() {
        return "Summary{" +
                "id=" + id +
                ", user=" + user +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", created_at=" + created_at +
                ", last_modified_at=" + last_modified_at +
                '}';
    }
}
