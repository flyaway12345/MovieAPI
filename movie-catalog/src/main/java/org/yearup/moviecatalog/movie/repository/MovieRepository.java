package org.yearup.moviecatalog.movie.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.yearup.moviecatalog.movie.domain.Movie;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface MovieRepository extends CrudRepository<Movie, Long> {



}
