package com.example.demo2.word;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
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
    public ResponseEntity<List<Word>> getWordbyWord_target() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter word_target to find word");
        String word_target = sc.nextLine();
        return wordService.getWordbyWord_target(word_target);
    }

}
