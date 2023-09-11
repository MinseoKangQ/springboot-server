package com.server.sumnote.quiz.service;

import com.server.sumnote.quiz.entity.Quiz;
import com.server.sumnote.quiz.repository.QuizRepository;
import com.server.sumnote.summary.entity.Summary;
import com.server.sumnote.summary.repository.SummaryRepository;
import com.server.sumnote.user.entity.User;
import com.server.sumnote.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class QuizService {

    private final QuizRepository quizRepository;
    private final SummaryRepository summaryRepository;
    private final UserRepository userRepository;

    public Quiz createQuiz(String question, String selections, Integer answer, String commentary, String email, Long sum_id) {
        Quiz newQuiz = new Quiz();
        newQuiz.setQuestion(question);
        newQuiz.setSelections(selections);
        newQuiz.setAnswer(answer);
        newQuiz.setCommentary(commentary);
        newQuiz.setSummary(summaryRepository.findSummaryById(sum_id));
        newQuiz.setUser(userRepository.findByEmail(email));

        userRepository.save(userRepository.findByEmail(email));
        summaryRepository.save(summaryRepository.findSummaryById(sum_id));
        quizRepository.save(newQuiz);
        return newQuiz;
    }

    public Quiz getQuiz(Long id) { return quizRepository.findQuizById(id); }

    public ArrayList<Quiz> getAllQuizzes(String email) {
        return quizRepository.findQuizzesByUser(userRepository.findByEmail(email));
    }
}
