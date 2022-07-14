package com.example.demo2.word;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.ManyToOne;
import java.util.List;

@RestController
@RequestMapping
public class WordController {


    private final WordService wordService;

    @Autowired
    public WordController(WordService wordService) {
        this.wordService = wordService;
    }


    @GetMapping("/word/list")
    public List<Word> getWord() {
        return wordService.getWord();
    }

    @GetMapping("/word/add")
    public String addWord() {
        wordService.commandLineRunner();
        return "Succes";
    }

}
