package com.server.sumnote.summary.entity;

import com.server.sumnote.user.entity.User;
import javax.persistence.*;

@Entity
@Table(name = "SUMMARY")
public class Summary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "summary_id")
    private Long id;

    @Column(name = "sum_title")
    private String title;

    @Column(name = "sum_content", columnDefinition = "TEXT")
    private String content;

    // FK -> 주인
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;

    public Summary() {
    }

    public Summary(Long id, String title, String content, User user) {
        this.id = id;
        this.title = title;
        this.content = content;
//        this.user = user;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
}
