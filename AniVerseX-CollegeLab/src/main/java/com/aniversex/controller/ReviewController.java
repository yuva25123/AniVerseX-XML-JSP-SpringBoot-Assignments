package com.aniversex.controller;

import com.aniversex.model.Review;
import com.aniversex.service.AnimeService;
import com.aniversex.service.ReviewService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;
    private final AnimeService animeService;

    public ReviewController(ReviewService reviewService, AnimeService animeService) {
        this.reviewService = reviewService;
        this.animeService = animeService;
    }

    @GetMapping
    public String listReviews(Model model) {
        model.addAttribute("reviewList", reviewService.getAllReviews());
        return "review-list";
    }

    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("review", new Review());
        model.addAttribute("animeList", animeService.getAllAnime());
        model.addAttribute("formTitle", "Add Review");
        return "review-form";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("review", reviewService.getReviewById(id));
        model.addAttribute("animeList", animeService.getAllAnime());
        model.addAttribute("formTitle", "Edit Review");
        return "review-form";
    }

    @PostMapping("/save")
    public String saveReview(@ModelAttribute Review review) {
        reviewService.saveReview(review);
        return "redirect:/reviews";
    }

    @GetMapping("/delete/{id}")
    public String deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return "redirect:/reviews";
    }
}
