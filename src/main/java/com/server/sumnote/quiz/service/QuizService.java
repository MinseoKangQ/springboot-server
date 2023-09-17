package com.server.sumnote.quiz.service;

import com.server.sumnote.quiz.entity.Quiz;
import com.server.sumnote.quiz.repository.QuizRepository;
import com.server.sumnote.summary.entity.Summary;
import com.server.sumnote.summary.repository.SummaryRepository;
import com.server.sumnote.user.entity.User;
import com.server.sumnote.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class QuizService {

    private final QuizRepository quizRepository;
    private final SummaryRepository summaryRepository;
    private final UserRepository userRepository;

    public Quiz createQuiz(String email, Long sum_id, String question, String selections, String answer, String commentary){
        Quiz newQuiz = new Quiz();
        newQuiz.setUser(userRepository.findByEmail(email));
        newQuiz.setSummary(summaryRepository.findSummaryById(sum_id));
        newQuiz.setQuiz_doc_title(summaryRepository.findSummaryById(sum_id).getSum_doc_title() + "의 퀴즈");
        newQuiz.setQuestion(question);
        newQuiz.setSelections(selections);
        newQuiz.setAnswer(answer);
        newQuiz.setCommentary(commentary);
        userRepository.save(userRepository.findByEmail(email));
        summaryRepository.save(summaryRepository.findSummaryById(sum_id));
        quizRepository.save(newQuiz);

        return newQuiz;
    }

    public Quiz getQuiz(Long id) { return quizRepository.findQuizById(id); }

    public ArrayList<Quiz> getAllQuizzes(String email) {
        return quizRepository.findQuizzesByUser(userRepository.findByEmail(email));
    }

    public void updateQuizTitle(Long id, String newTitle) {
        Quiz gotQuiz = quizRepository.findQuizById(id);
        gotQuiz.setQuiz_doc_title(newTitle);
        quizRepository.save(gotQuiz);
    }

    public void updateQuizContent(Long id, String addQuestion, String addSelections, String addAnswer, String addCommentary) {
        Quiz gotQuiz = quizRepository.findQuizById(id);
        System.out.println(gotQuiz);
        gotQuiz.setQuestion(gotQuiz.getQuestion().concat(addQuestion));
        gotQuiz.setSelections(gotQuiz.getSelections().concat(addSelections));
        gotQuiz.setAnswer(gotQuiz.getAnswer().concat(addAnswer));
        gotQuiz.setCommentary(gotQuiz.getCommentary().concat(addCommentary));
        quizRepository.save(gotQuiz);
    }

    @Transactional
    public void deleteQuizById(Long id) {
        quizRepository.deleteQuizById(id);
    }
}
