package com.xtravision.Application;

import org.springframework.stereotype.Component;

@Component
public class PotentialRental {
    private String movieName;
    private String movieCover;

    public PotentialRental(){

    }



    public PotentialRental(String movieName, String movieCover) {
        this.movieName = movieName;
        this.movieCover = movieCover;

    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieCover() {
        return movieCover;
    }

    public void setMovieCover(String movieCover) {
        this.movieCover = movieCover;
    }
}
