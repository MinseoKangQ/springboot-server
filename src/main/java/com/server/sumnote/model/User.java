package com.server.sumnote.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "user")
//@Data
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
public class User {

    @Id
    private Integer id;

    private String pw;

    public User() {
    }

    public User(Integer id, String pw) {
        this.id = id;
        this.pw = pw;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }
}
