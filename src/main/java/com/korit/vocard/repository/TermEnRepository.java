package com.korit.vocard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.korit.vocard.common.entity.TermDetailEnEntity;

@Repository
public interface TermEnRepository extends JpaRepository<TermDetailEnEntity, Integer> {

    @Query("""
        SELECT td FROM TermDetailEnEntity td 
        JOIN td.terms t 
        JOIN t.termDays d 
        JOIN d.termLevels l 
        JOIN l.termBooks b 
        WHERE b.language = :language 
        AND b.name = :bookName 
        AND l.level = :level 
        AND d.dayNumber = :dayNumber
    """)
    List<TermDetailEnEntity> findTermDetailsByBookNameAndLevelAndDayNumber(
        @Param("language") String language,
        @Param("bookName") String bookName,
        @Param("level") String level,
        @Param("dayNumber") int dayNumber
    );
    
}