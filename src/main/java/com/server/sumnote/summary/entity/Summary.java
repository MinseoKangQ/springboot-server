package com.server.sumnote.summary.entity;

import com.server.sumnote.quiz.entity.Quiz;
import com.server.sumnote.user.entity.User;
import javax.persistence.*;

@Entity
@Table(name = "SUMMARY")
public class Summary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sum_id")
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    // FK -> 주인
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user_sum;

    @OneToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    public Summary() {
    }

    public Summary(Long id, String title, String content, User user_sum) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.user_sum = user_sum;
    }

    public Summary(Long id, String title, String content, User user_sum, Quiz quiz) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.user_sum = user_sum;
        this.quiz = quiz;
    }
}
