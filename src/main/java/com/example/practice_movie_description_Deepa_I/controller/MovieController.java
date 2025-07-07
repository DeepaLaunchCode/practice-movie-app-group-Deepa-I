package com.example.practice_movie_description_Deepa_I.controller;

import com.example.practice_movie_description_Deepa_I.model.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.practice_movie_description_Deepa_I.controller.GeminiService;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MovieController {
    GeminiService geminiService;
    private List<Movie> movies = new ArrayList<>();

    public MovieController() {
        geminiService = new GeminiService();
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("movies", movies);
        model.addAttribute("movie", new Movie());
        return "index";
    }

    @PostMapping("/add")
    public String addMovie(@ModelAttribute Movie movie) {
        String starcast = geminiService.generateStarcast(movie.getTitle());
        movie.setStarcast(starcast); // add a description field in your Movie class
        String directors = geminiService.generateDirectors(movie.getTitle());
        movie.setDirectors(directors); // add a description field in your Movie class
        String description = geminiService.generateDescription(movie.getTitle());
        movie.setDescription(description); // add a description field in your Movie class

        movies.add(movie);
        return "redirect:/";
    }
}