package com.korit.vocard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.korit.vocard.common.entity.TermBooksEntity;

@Repository
public interface TermBooksRepository extends JpaRepository<TermBooksEntity, Integer> {
    
    @Query("""
        SELECT b FROM TermBooksEntity b 
        WHERE b.language = :language 
        AND b.name = :bookName
    """)
    TermBooksEntity findByLanguageAndName(
        @Param("language") String language,
        @Param("bookName") String bookName
    );
    
    @Query("""
        SELECT l.level FROM TermLevelsEntity l 
        WHERE l.termBooks.language = :language 
        AND l.termBooks.name = :bookName
    """)
    List<String> findLevelsByLanguageAndBookName(
        @Param("language") String language,
        @Param("bookName") String bookName
    );
    
    @Query("""
        SELECT COUNT(d) FROM TermDaysEntity d 
        JOIN d.termLevels l 
        JOIN l.termBooks b 
        WHERE b.language = :language 
        AND b.name = :bookName 
        AND l.level = :level
    """)
    Integer countDaysByLanguageAndBookNameAndLevel(
        @Param("language") String language,
        @Param("bookName") String bookName,
        @Param("level") String level
    );
} 