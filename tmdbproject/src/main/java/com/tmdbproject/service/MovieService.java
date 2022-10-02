package com.tmdbproject.service;

import com.tmdbproject.model.Movie;
import com.tmdbproject.model.QMovie;
import com.tmdbproject.repository.MovieRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

//    public JPAQueryFactory getJpaQueryFactory() {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MovieCatalog");
//        EntityManager em = emf.createEntityManager();
//        return new JPAQueryFactory(em);
//    }
//
//    public List<Movie> getMovieListForController() {
//        return getJpaQueryFactory().selectFrom(QMovie.movie).fetch();
//    }

    public MovieService() {}

    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public List<Movie> saveMovies(List<Movie> movies) {
        return movieRepository.saveAll(movies);
    }

    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(Integer id) {
        return movieRepository.findById(id).orElse(null);
    }

    public Movie getMovieByTitle(String title) {
        return movieRepository.findByTitle(title);
    }

    public String deleteMovie (Integer id) {
        movieRepository.deleteById(id);
        return "Movie removed for id: " + id + ".";
    }

    public Movie updateMovie(Movie movie) {
        Movie existingMovie = movieRepository.findById(movie.getId()).orElse(null);
        existingMovie.setTitle(movie.getTitle());
        existingMovie.setRelease_date(movie.getRelease_date());
//        existingMovie.setOverview(movie.getOverview());
        existingMovie.setOriginal_language (movie.getOriginal_language ());
        existingMovie.setVote_avarage(movie.getVote_avarage());
        return movieRepository.save(existingMovie);
    }
}
