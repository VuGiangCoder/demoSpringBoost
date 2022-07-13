package com.example.demo2.word;

import javax.persistence.*;
import javax.transaction.Transactional;

@Entity
@Table(name="word")
public class Word {
    @Id
    @SequenceGenerator(
            name="word_sequence",
            sequenceName = "word_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "word_sequence"
    )
     // chu thich no khong lien quan den truong nao trong database
    private Long id;
    @Column(name="word_target")
    private String word_target;
    @Column(name="word_explain")
    private String word_explain;

    /**
     * Constructor 1.
     */
    public Word() {
        this.id = 0L;
        this.word_target = "";
        this.word_explain = "";
    }

    /**
     * Constructor 2.
     *
     * @param id           (Long).
     * @param word_target  (String) is new word.
     * @param word_explain (String) is mean of word.
     */
    public Word(Long id, String word_target, String word_explain) {
        this.id = id;
        this.word_target = word_target;
        this.word_explain = word_explain;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWord_target() {
        return word_target;
    }

    /**
     * set value for word_explain.
     *
     * @param word_target (String) .
     */
    public void setWord_target(String word_target) {
        if (word_target != "") {
            this.word_target = word_target;
        }
    }

    public String getWord_explain() {
        return word_explain;
    }

    /**
     * set value for word_explain.
     *
     * @param word_explain (String).
     */
    public void setWord_explain(String word_explain) {
        if (word_explain != "") {
            this.word_explain = word_explain;
        }

    }
}
