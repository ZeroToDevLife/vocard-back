package com.korit.vocard.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.korit.vocard.common.entity.TermLevelsEntity;

@Repository
public interface TermLevelsRepository extends JpaRepository<TermLevelsEntity, Integer> {
    List<TermLevelsEntity> findByTermBooksId(Integer bookId);
    Optional<TermLevelsEntity> findByTermBooksIdAndLevel(Integer bookId, String level);
} 