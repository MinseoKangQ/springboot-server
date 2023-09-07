package com.server.sumnote.quiz.entity;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    private String quiz;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
    private List<Selection> selections = new ArrayList<>();

    private String commentary;

}
