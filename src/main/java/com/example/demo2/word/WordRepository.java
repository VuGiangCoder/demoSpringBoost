package com.example.demo2.word;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface WordRepository extends JpaRepository<Word,Long> {
    @Query("SELECT w FROM Word w WHERE w.word_target= :c")
    Optional<Word> findByWordTarget(@Param("c") String word_target);


}
