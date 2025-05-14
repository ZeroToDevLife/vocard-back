package com.korit.vocard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.korit.vocard.common.entity.TermDetailCnEntity;

@Repository
public interface TermCnRepository extends JpaRepository<TermDetailCnEntity, Integer> {

    @Query("""
        SELECT td FROM TermDetailCnEntity td 
        JOIN td.terms t 
        JOIN t.termDays d 
        JOIN d.termLevels l 
        JOIN l.termBooks b 
        WHERE b.language = :language 
        AND b.name = :bookName 
        AND l.level = :level 
        AND d.dayNumber = :dayNumber
    """)
    List<TermDetailCnEntity> findTermDetailsByBookNameAndLevelAndDayNumber(
        @Param("language") String language,
        @Param("bookName") String bookName,
        @Param("level") String level,
        @Param("dayNumber") int dayNumber
    );
    
}