package com.server.sumnote.quiz.repository;

import com.server.sumnote.quiz.entity.Quiz;
import com.server.sumnote.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {

    Quiz findQuizById(Long id);
    ArrayList<Quiz> findQuizzesByUser(User user);
    void deleteQuizById(Long id);
}
