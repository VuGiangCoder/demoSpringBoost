package com.example.demo2.word;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordRepository extends JpaRepository<Word, Long> {

    @Query(value="select * from Word w where w.word_target=?1",nativeQuery = true)
    List<Word> findByWord_target(String word_target);

}
