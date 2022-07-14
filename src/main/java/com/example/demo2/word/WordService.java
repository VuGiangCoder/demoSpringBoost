package com.example.demo2.word;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WordService {
    private final WordRepository wordRepository;

    public WordService(WordRepository wordRepository) {

        this.wordRepository = wordRepository;
    }

    public List<Word> getWord() {
        return wordRepository.findAll();
    }

    public void addWord(Word word) {
            wordRepository.save(word);
    }

    public Optional<Word> findByWordTarget(String word_target){
        return  wordRepository.findByWordTarget(word_target);
    }
}
