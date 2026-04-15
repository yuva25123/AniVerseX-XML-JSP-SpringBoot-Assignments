package com.aniversex.model;

import jakarta.persistence.*;

@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "comment", length = 1000)
    private String comment;

    @Column(name = "score")
    private Integer score;

    // Many reviews belong to one anime.
    @ManyToOne
    @JoinColumn(name = "anime_id")
    private Anime anime;

    public Review() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }

    public Integer getScore() { return score; }
    public void setScore(Integer score) { this.score = score; }

    public Anime getAnime() { return anime; }
    public void setAnime(Anime anime) { this.anime = anime; }
}
