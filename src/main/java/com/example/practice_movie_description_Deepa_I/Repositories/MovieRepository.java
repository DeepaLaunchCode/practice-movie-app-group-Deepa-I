package com.example.practice_movie_description_Deepa_I.Repositories;

import com.example.practice_movie_description_Deepa_I.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
