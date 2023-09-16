package com.server.sumnote.summary.service;

import com.server.sumnote.summary.entity.Summary;
import com.server.sumnote.summary.repository.SummaryRepository;
import com.server.sumnote.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class SummaryService {

    private final SummaryRepository summaryRepository;
    private final UserRepository userRepository;

    public Summary createSumNote(String email, String sum_doc_title, String title, String content) {
        Summary newSumNote = new Summary();
        newSumNote.setUser(userRepository.findByEmail(email));
        newSumNote.setSum_doc_title(sum_doc_title);
        newSumNote.setTitle(title);
        newSumNote.setContent(content);
        userRepository.save(userRepository.findByEmail(email));
        summaryRepository.save(newSumNote);
        return newSumNote;
    }

    public Summary getSumNote(Long id) {
        return summaryRepository.findSummaryById(id);
    }

    public ArrayList<Summary> getAllSumNotes(String email) {
        return summaryRepository.findSummariesByUser(userRepository.findByEmail(email));
    }

    public void updateSumNoteTitle(Long id, String newTitle) {
        Summary gotSummary = summaryRepository.findSummaryById(id);
        gotSummary.setSum_doc_title(newTitle);
        summaryRepository.save(gotSummary);
    }

    public void updateSumNoteContent(Long id, String addTitle, String addContent) {
        Summary gotSummary = summaryRepository.findSummaryById(id);
        gotSummary.setTitle(gotSummary.getTitle().concat(addTitle));
        gotSummary.setContent(gotSummary.getContent().concat(addContent));
        summaryRepository.save(gotSummary);
    }

    @Transactional
    public void deleteSumNote(Long id) {
        summaryRepository.deleteSummaryById(id);
    }
}
