package com.example.demo2.word;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordService {

    Word word = new Word(3L, "giang", "dep trai");
    private final WordRepository wordRepository;

    public WordService(WordRepository wordRepository) {

        this.wordRepository = wordRepository;
    }

    public List<Word> getWord() {
        return wordRepository.findAll();
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            wordRepository.save(word);
        };
    }
}
