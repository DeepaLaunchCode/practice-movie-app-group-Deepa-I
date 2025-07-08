package com.example.practice_movie_description_Deepa_I.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Scanner;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private int rating;
   // private String description;
    private String description;
    private String starcast;
    private String directors;

    public Movie() {
    }

    public Movie(String title, int rating, String description,String starcast, String directors) {
        this.title = title;
        this.rating = rating;
        this.description = description;
        this.starcast = starcast;
        this.directors = directors;
     }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
    public String getStarcast() {
        return starcast;
    }

    public void setStarcast(String starcast) {
        this.starcast = starcast;
    }
    public String getDirectors() {
        return directors;
    }

    public void setDirectors(String directors) {
        this.directors = directors;
    }
}
