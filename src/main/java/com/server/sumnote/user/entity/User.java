package com.server.sumnote.user.entity;

import com.server.sumnote.summary.entity.Summary;
import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

//    @OneToMany(mappedBy = "user")
//    private List<Summary> summaryList = new ArrayList<>();

    public User() {
    }

    public User(Long id, List<Summary> summaryList) {
        this.id = id;
//        this.summaryList = summaryList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public List<Summary> getSummaryList() {
//        return summaryList;
//    }
//
//    public void setSummaryList(List<Summary> summaryList) {
//        this.summaryList = summaryList;
//    }
}
