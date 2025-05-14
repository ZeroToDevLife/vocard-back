package com.korit.vocard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.korit.vocard.common.entity.TermsEntity;

@Repository
public interface TermsRepository extends JpaRepository<TermsEntity, Long> {
    int countByTermDaysId(Long termDaysId);
} 