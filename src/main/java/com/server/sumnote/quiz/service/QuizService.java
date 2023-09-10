package com.server.sumnote.quiz.service;

import com.server.sumnote.quiz.entity.Quiz;
import com.server.sumnote.quiz.entity.Selection;
import com.server.sumnote.quiz.repository.QuizRepository;
import com.server.sumnote.quiz.repository.SelectionRepository;
import com.server.sumnote.user.entity.User;
import com.server.sumnote.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizService {

    private final QuizRepository quizRepository;
    private final SelectionRepository selectionRepository;
    private final UserRepository userRepository;

//    Quiz(
//    Long id, -> 자동 생성
//    User user,
//    String quiz,
//    String commentary,
//    List<Selection> selections,
//    LocalDateTime created_at, -> 자동 생성
//    LocalDateTime last_modified_at -> 자동 생성

    // 퀴즈 생성
    public Quiz createQuiz(User user, String quiz, String commentary, List <Selection> selections) {

        // 퀴즈 만들기
        Quiz newQuiz = new Quiz();
        newQuiz.setUser(user);
        newQuiz.setQuiz(quiz);
        newQuiz.setCommentary(commentary);

        for (Selection selection : selections) {
            selection.setQuiz(newQuiz);
        }

        newQuiz.setSelections(selections);
        userRepository.save(user);
        quizRepository.save(newQuiz);

        for (Selection s : selections) {
            selectionRepository.save(s);
        }

        return newQuiz;

//        newQuiz.setSelections(selections);
//        userRepository.save(user); // 유저 저장
//        quizRepository.save(newQuiz); // 퀴즈 저장
//
//        for(Selection s : selections) { // 선택지 저장
//            selectionRepository.save(s);
//        }
//
//        return newQuiz;

    }
}
