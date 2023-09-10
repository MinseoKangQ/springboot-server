package com.server.sumnote.quiz.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name = "QUIZ")
@EntityListeners(AuditingEntityListener.class)
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quiz_id")
    private Long id;

    // FK
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String quiz;

    private String commentary;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"quiz"})
    private List<Selection> selections = new ArrayList<>();

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
        Quiz quiz1 = (Quiz) o;
        return Objects.equals(id, quiz1.id) && Objects.equals(user, quiz1.user) && Objects.equals(quiz, quiz1.quiz) && Objects.equals(commentary, quiz1.commentary) && Objects.equals(selections, quiz1.selections) && Objects.equals(created_at, quiz1.created_at) && Objects.equals(last_modified_at, quiz1.last_modified_at);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, quiz, commentary, selections, created_at, last_modified_at);
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "id=" + id +
                ", user=" + user +
                ", quiz='" + quiz + '\'' +
                ", commentary='" + commentary + '\'' +
                ", selections=" + selections +
                ", created_at=" + created_at +
                ", last_modified_at=" + last_modified_at +
                '}';
    }
}
