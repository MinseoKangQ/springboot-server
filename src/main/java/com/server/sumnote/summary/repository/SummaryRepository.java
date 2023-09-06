package com.server.sumnote.summary.repository;

import com.server.sumnote.summary.entity.Summary;
import com.server.sumnote.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface SummaryRepository extends JpaRepository<Summary, Long> {

    Summary findSummaryById(Long id);
    ArrayList<Summary> findSummariesByUser(User user);
    void deleteById(Long id);
}
