package com.example.practice_movie_description_Deepa_I.controller;

import com.example.practice_movie_description_Deepa_I.Repositories.MovieRepository;
import com.example.practice_movie_description_Deepa_I.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("")
public class MovieController {

    private final GeminiService geminiService;
    private final MovieRepository movieRepository;

    @Autowired
    public MovieController(GeminiService geminiService, MovieRepository movieRepository) {
        this.geminiService = geminiService;
        this.movieRepository = movieRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("movies", movieRepository.findAll());
        model.addAttribute("movie", new Movie());
        return "index";
    }

    @PostMapping("/add")
    public String addMovie(@ModelAttribute Movie movie) {

        String starcast = geminiService.generateStarcast(movie.getTitle());
        movie.setStarcast(starcast);

        String directors = geminiService.generateDirectors(movie.getTitle());
        movie.setDirectors(directors);

        String description = geminiService.generateDescription(movie.getTitle());
        movie.setDescription(description);

        movieRepository.save(movie);

        return "redirect:/";
    }
}
