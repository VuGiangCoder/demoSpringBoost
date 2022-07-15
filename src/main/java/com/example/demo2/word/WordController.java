package com.example.demo2.word;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

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
    public int addWord() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter New Word:    ");
        Long id = 1L;
        String word_target = sc.nextLine();
        System.out.println("Enter mean of Word: ");
        String word_explain = sc.nextLine();
        Word word = new Word(id, word_target, word_explain);
        wordService.addWord(word);
        return 1;
    }

    @GetMapping("/word/find")
    @ResponseBody
    public Optional<Word> findByWordTarget() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the word you wanna find:");
        String word_target = sc.nextLine();
        return wordService.findByWordTarget(word_target);
    }


}
