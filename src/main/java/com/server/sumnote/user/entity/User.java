package com.server.sumnote.user.entity;

import com.server.sumnote.summary.entity.Summary;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String token;

    private String username;
    private String password;

    @OneToMany(mappedBy = "user_sum")
    private List<Summary> summaryList = new ArrayList<>();

    public User() {
    }

    public User(Long id, String token, String username, String password, List<Summary> summaryList) {
        this.id = id;
        this.token = token;
        this.username = username;
        this.password = password;
        this.summaryList = summaryList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Summary> getSummaryList() {
        return summaryList;
    }

    public void setSummaryList(List<Summary> summaryList) {
        this.summaryList = summaryList;
    }
}
