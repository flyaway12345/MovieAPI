package org.yearup.moviecatalog.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.yearup.moviecatalog.movie.domain.Movie;
import org.yearup.moviecatalog.movie.service.MovieService;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @RequestMapping(method = RequestMethod.GET, value = "/movies")
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> movies = movieService.getAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/movies/{id}")
    public ResponseEntity<Optional<Movie>> getMovieById(@PathVariable Long id) {
        Optional<Movie> movie = movieService.getMovieById(id);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/movies")
    public ResponseEntity<?> addMovie(@Valid @RequestBody Movie movie) {
        movieService.addMovie(movie);
        HttpHeaders httpHeaders = new HttpHeaders();
        URI newMovieUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/movies")
                .buildAndExpand(movie.getId())
                .toUri();
        httpHeaders.setLocation(newMovieUri);
        return new ResponseEntity<>(movie, httpHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/movies/{id}")
    public ResponseEntity<?> updateMovieById(@Valid @RequestBody Movie movie, @PathVariable Long id) {
        movieService.updateMovie(movie, id);
        return new ResponseEntity<>(movie, HttpStatus.ACCEPTED);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/movies/{id}")
    public ResponseEntity<?> deleteMovieById(@PathVariable Long id) {
        movieService.deleteMovieById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

//    @RequestMapping(method = RequestMethod.GET, value = "/movies")
//    public List<Movie> getAllMovies() {
//        return movieService.getAllMovies();
//    }

//    @RequestMapping(method = RequestMethod.GET, value = "/movies/{id}")
//    public Optional<Movie> getMovieById(@PathVariable Long id) {
//        return movieService.getMovieById(id);
//    }

//    @RequestMapping(method = RequestMethod.POST, value = "/movies")
//    public void addMovie(@RequestBody Movie movie) {
//        movieService.addMovie(movie);
//    }

//    @RequestMapping(method = RequestMethod.PUT, value = "/movies/{id}")
//    public void updateMovieById(@RequestBody Movie movie, @PathVariable Long id) {
//        movieService.updateMovie(movie, id);
//    }

//    @RequestMapping(method = RequestMethod.DELETE, value = "/movies/{id}")
//    public void deleteMovieById(@PathVariable Long id) {
//        movieService.deleteMovieById(id);
//    }

}
