package org.yearup.moviecatalog.movie.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.yearup.moviecatalog.account.model.Accounts;
import org.yearup.moviecatalog.movie.enumerations.Genre;
import org.yearup.moviecatalog.movie.enumerations.Rating;
import org.yearup.moviecatalog.movie.enumerations.Recommended;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity(name = "Movie")
public class Movie {

    @Id
    private Long id;

    private String title;
    private String description;
    private String release_date;
    private Integer duration;
    private String cast;
    private double userRating;
    private String imgURL;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Enumerated(EnumType.STRING)
    private Rating rating;

    @Enumerated
    private Recommended recommended;

    @ManyToOne
    private Accounts accounts;
    public Movie() {
    }

}
