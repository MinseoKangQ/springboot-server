package com.server.sumnote.summary.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.server.sumnote.quiz.entity.Quiz;
import com.server.sumnote.user.entity.User;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    private Long id;

    // FK
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "summary")
    @JsonIgnoreProperties({"summary"})
    private List<Quiz> quizzes = new ArrayList<>();

    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime created_at;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime last_modified_at;

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
