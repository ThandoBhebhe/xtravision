package com.xtravision.movie;
import com.xtravision.play.Play;

public class Movie extends Play {
    private boolean cover;

    public Movie(String name, double duration, String actor){
        super(name, duration,actor);
        this.cover = true;
    }
    public Movie(String name){
        super(name,1.00,"");
        this.cover = true;
    }
}
