package com.server.sumnote.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.server.sumnote.quiz.entity.Quiz;
import com.server.sumnote.summary.entity.Summary;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USER")
public class User {

    @Id
    @Column(name = "email")
    private String email;

    private String name;

    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties({"user"})
    private List<Summary> summaries = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties({"user"})
    private List<Quiz> quizzes = new ArrayList<>();

    @Override
    public String toString() {
        return "User{" +
                "email=" + email +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
