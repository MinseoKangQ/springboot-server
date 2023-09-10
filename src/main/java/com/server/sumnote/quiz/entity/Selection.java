package com.server.sumnote.quiz.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SELECTION")
public class Selection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "selection_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    private String content;

    private Boolean is_answer = false;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Selection selection = (Selection) o;
        return Objects.equals(id, selection.id) && Objects.equals(quiz, selection.quiz) && Objects.equals(content, selection.content) && Objects.equals(is_answer, selection.is_answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quiz, content, is_answer);
    }

    @Override
    public String toString() {
        return "Selection{" +
                "id=" + id +
                ", quiz=" + quiz +
                ", content='" + content + '\'' +
                ", is_answer=" + is_answer +
                '}';
    }
}
