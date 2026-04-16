package com.aniversex.jspjdbc.controller;

import com.aniversex.jspjdbc.dao.AnimeDao;
import com.aniversex.jspjdbc.model.Anime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AnimeController {

    private final AnimeDao animeDao;

    public AnimeController(AnimeDao animeDao) {
        this.animeDao = animeDao;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/anime")
    public String listAnime(Model model) {
        model.addAttribute("animeList", animeDao.getAllAnime());
        return "anime-list";
    }

    @GetMapping("/anime/add")
    public String showAddForm(Model model) {
        model.addAttribute("anime", new Anime());
        model.addAttribute("formTitle", "Add Anime");
        return "anime-form";
    }

    @GetMapping("/anime/edit/{animeId}")
    public String showEditForm(@PathVariable Integer animeId, Model model) {
        model.addAttribute("anime", animeDao.getAnimeById(animeId));
        model.addAttribute("formTitle", "Edit Anime");
        return "anime-form";
    }

    @PostMapping("/anime/save")
    public String saveAnime(@ModelAttribute Anime anime) {
        if (anime.getAnimeId() == null) {
            animeDao.addAnime(anime);
        } else {
            animeDao.updateAnime(anime);
        }
        return "redirect:/anime";
    }

    @GetMapping("/anime/delete/{animeId}")
    public String deleteAnime(@PathVariable Integer animeId) {
        animeDao.deleteAnime(animeId);
        return "redirect:/anime";
    }
}
