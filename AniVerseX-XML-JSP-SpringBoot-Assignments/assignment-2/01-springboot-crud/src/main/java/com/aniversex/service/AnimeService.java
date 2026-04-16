package com.aniversex.service;

import com.aniversex.model.Anime;
import com.aniversex.repository.AnimeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimeService {

    private final AnimeRepository animeRepository;

    public AnimeService(AnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }

    // Get all anime records from database.
    public List<Anime> getAllAnime() {
        return animeRepository.findAll();
    }

    // Get one anime by primary key.
    public Anime getAnimeById(Long animeId) {
        return animeRepository.findById(animeId).orElse(null);
    }

    // Save new anime or update existing anime.
    public Anime saveAnime(Anime anime) {
        return animeRepository.save(anime);
    }

    // Delete anime by primary key.
    public void deleteAnime(Long animeId) {
        animeRepository.deleteById(animeId);
    }
}
