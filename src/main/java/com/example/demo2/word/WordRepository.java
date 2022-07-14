package com.example.demo2.word;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface WordRepository extends JpaRepository<Word,Long> {
    @Query("SELECT id,word_target,word_explain FROM Word")
    Optional<Word> findByWordTarget(String word_target);


}
