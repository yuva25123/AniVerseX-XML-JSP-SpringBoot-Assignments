package com.aniversex.xmljsp.model;

public class Anime {

    private String animeId;
    private String title;
    private String genre;
    private int episodes;
    private double rating;
    private String shortReview;
    private String recommendationType;

    public Anime() {
    }

    public Anime(String animeId, String title, String genre, int episodes, double rating,
                 String shortReview, String recommendationType) {
        this.animeId = animeId;
        this.title = title;
        this.genre = genre;
        this.episodes = episodes;
        this.rating = rating;
        this.shortReview = shortReview;
        this.recommendationType = recommendationType;
    }

    public String getAnimeId() {
        return animeId;
    }

    public void setAnimeId(String animeId) {
        this.animeId = animeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getEpisodes() {
        return episodes;
    }

    public void setEpisodes(int episodes) {
        this.episodes = episodes;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getShortReview() {
        return shortReview;
    }

    public void setShortReview(String shortReview) {
        this.shortReview = shortReview;
    }

    public String getRecommendationType() {
        return recommendationType;
    }

    public void setRecommendationType(String recommendationType) {
        this.recommendationType = recommendationType;
    }
}
