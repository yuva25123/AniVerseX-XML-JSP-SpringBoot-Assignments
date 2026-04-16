package com.aniversex.controller;

import com.aniversex.model.Anime;
import com.aniversex.service.AnimeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/anime")
public class AnimeController {

    private final AnimeService animeService;

    public AnimeController(AnimeService animeService) {
        this.animeService = animeService;
    }

    // Show all anime records.
    @GetMapping
    public String listAnime(Model model) {
        model.addAttribute("animeList", animeService.getAllAnime());
        return "anime-list";
    }

    // Open add anime form.
    @GetMapping("/new")
    public String openAddForm(Model model) {
        model.addAttribute("anime", new Anime());
        model.addAttribute("formTitle", "Add Anime");
        return "anime-form";
    }

    // Open edit anime form.
    @GetMapping("/edit/{animeId}")
    public String openEditForm(@PathVariable Long animeId, Model model) {
        model.addAttribute("anime", animeService.getAnimeById(animeId));
        model.addAttribute("formTitle", "Edit Anime");
        return "anime-form";
    }

    // Save anime data.
    @PostMapping("/save")
    public String saveAnime(@ModelAttribute Anime anime) {
        animeService.saveAnime(anime);
        return "redirect:/anime";
    }

    // Delete anime by id.
    @GetMapping("/delete/{animeId}")
    public String deleteAnime(@PathVariable Long animeId) {
        animeService.deleteAnime(animeId);
        return "redirect:/anime";
    }
}
