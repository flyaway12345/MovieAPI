package org.yearup.moviecatalog.movie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yearup.moviecatalog.movie.domain.Movie;
import org.yearup.moviecatalog.movie.exception.ResourceNotFoundException;
import org.yearup.moviecatalog.movie.repository.MovieRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        List<Movie> movieList = new ArrayList<>();
        movieRepository.findAll().forEach(movieList::add);
        return movieList;
    }

    public Optional<Movie> getMovieById(Long id) {
        verifyMovie(id);
        return movieRepository.findById(id);
    }

    public void addMovie(Movie movie) {
        movieRepository.save(movie);
    }

    public void updateMovie(Movie movie, Long id) {
        verifyMovie(id);
        for (Movie movie1: movieRepository.findAll()) {
            if(movie1.getId().equals(id)) {
                movieRepository.save(movie);
            }
        }
    }

    public void deleteMovieById(Long id) {
        verifyMovie(id);
        movieRepository.deleteById(id);
    }

    public void verifyMovie(Long id) throws ResourceNotFoundException {
        Optional<Movie> movie = movieRepository.findById(id);
        if (movie.isEmpty()) {
            throw new ResourceNotFoundException("Movie with id " + id + " not found");

        }
    }

}
