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

    // Return all anime records.
    public List<Anime> getAllAnime() {
        return animeRepository.findAll();
    }

    public Anime getAnimeById(Long id) {
        return animeRepository.findById(id).orElse(null);
    }

    public Anime saveAnime(Anime anime) {
        return animeRepository.save(anime);
    }

    public void deleteAnime(Long id) {
        animeRepository.deleteById(id);
    }
}
