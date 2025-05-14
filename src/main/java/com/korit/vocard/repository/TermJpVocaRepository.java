package com.korit.vocard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.korit.vocard.common.entity.TermDetailJpVocaEntity;

@Repository
public interface TermJpVocaRepository extends JpaRepository<TermDetailJpVocaEntity, Integer> {

    @EntityGraph(attributePaths = {
        "terms",
        "terms.termDays",
        "jpVocaExamples",
        "jpVocaExamples.jpVocaExampleGroup"
    })
    @Query("""
        SELECT DISTINCT td FROM TermDetailJpVocaEntity td 
        JOIN td.terms t 
        JOIN t.termDays d 
        JOIN d.termLevels l 
        JOIN l.termBooks b 
        WHERE b.language = :language 
        AND b.name = :bookName 
        AND l.level = :level 
        AND d.dayNumber = :dayNumber
    """)
    List<TermDetailJpVocaEntity> findTermDetailsByBookNameAndLevelAndDayNumber(
        @Param("language") String language,
        @Param("bookName") String bookName,
        @Param("level") String level,
        @Param("dayNumber") int dayNumber
    );
    
}