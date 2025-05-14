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
        SELECT tb FROM TermBooksEntity tb 
        WHERE tb.language = :language 
        AND tb.name = :bookName
    """)
    List<TermBooksEntity> findByLanguageAndName(
        @Param("language") String language,
        @Param("bookName") String bookName
    );
} 