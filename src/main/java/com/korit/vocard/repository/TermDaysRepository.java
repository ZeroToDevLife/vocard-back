package com.korit.vocard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.korit.vocard.common.entity.TermDaysEntity;

@Repository
public interface TermDaysRepository extends JpaRepository<TermDaysEntity, Integer> {
    List<TermDaysEntity> findByTermLevelsId(Integer levelId);
} 