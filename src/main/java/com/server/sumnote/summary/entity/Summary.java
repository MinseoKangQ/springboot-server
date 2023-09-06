package com.server.sumnote.summary.entity;

import com.server.sumnote.user.entity.User;
import com.server.sumnote.util.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SUMMARY")
public class Summary extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sum_id")
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    // FK -> 주인
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    // 수동추가
    public LocalDateTime getCreatedAt() {
        return this.getCreated_at();
    }
}
