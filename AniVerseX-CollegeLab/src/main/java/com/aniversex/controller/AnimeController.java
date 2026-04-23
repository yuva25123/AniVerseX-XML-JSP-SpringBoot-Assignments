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

    @GetMapping
    public String listAnime(Model model) {
        model.addAttribute("animeList", animeService.getAllAnime());
        return "anime-list";
    }

    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("anime", new Anime());
        model.addAttribute("formTitle", "Add Anime");
        return "anime-form";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("anime", animeService.getAnimeById(id));
        model.addAttribute("formTitle", "Edit Anime");
        return "anime-form";
    }

    @PostMapping("/save")
    public String saveAnime(@ModelAttribute Anime anime) {
        animeService.saveAnime(anime);
        return "redirect:/anime";
    }

    @GetMapping("/delete/{id}")
    public String deleteAnime(@PathVariable Long id) {
        animeService.deleteAnime(id);
        return "redirect:/anime";
    }
}
