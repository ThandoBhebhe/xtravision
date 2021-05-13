package com.xtravision.movie;

public class MoviePreOrder {
    String movieName;
    String movieCover;

    public MoviePreOrder(String movieName, String movieCover){
        this.movieCover = movieCover;
        this.movieName = movieName;

    }

    public String getName() {
        return movieName;
    }

    public void setName(String name) {
        this.movieName = name;
    }

    public String getImageCover() {
        return movieCover;
    }

    public void setImageCover(String movieCover) {
        this.movieCover = movieCover;
    }
}
