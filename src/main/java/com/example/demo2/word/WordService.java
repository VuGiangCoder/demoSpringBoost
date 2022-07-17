package com.example.demo2.word;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class WordService {
    private final WordRepository wordRepository;

    @Autowired
    public WordService(WordRepository wordRepository) {

        this.wordRepository = wordRepository;
    }

    public List<Word> getWord() {
        return wordRepository.findAll();
    }

    public void addWord(Word word) {
        wordRepository.save(word);
    }

    public ResponseEntity<List<Word>> getWordbyWord_target(
            @RequestParam String word_target) {
        return new ResponseEntity<List<Word>>(
                wordRepository.findByWord_target(word_target), HttpStatus.OK);
    }


}
