package com.server.sumnote.quiz.entity;

import com.server.sumnote.summary.entity.Summary;
import com.server.sumnote.user.entity.User;

import javax.persistence.*;

@Entity
@Table(name = "QUIZ")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quiz_id")
    private Long id;

    private String title;

    private String answer;

    private String content;

    private String commentary;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user_quiz;

    @OneToOne(mappedBy = "quiz")
    private Summary summary;

    public Quiz() {
    }

    public Quiz(Long id, String title, String answer, String content, String commentary, User user_quiz, Summary summary) {
        this.id = id;
        this.title = title;
        this.answer = answer;
        this.content = content;
        this.commentary = commentary;
        this.user_quiz = user_quiz;
        this.summary = summary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }

    public User getUser_quiz() {
        return user_quiz;
    }

    public void setUser_quiz(User user_quiz) {
        this.user_quiz = user_quiz;
    }

    public Summary getSummary() {
        return summary;
    }

    public void setSummary(Summary summary) {
        this.summary = summary;
    }
}
