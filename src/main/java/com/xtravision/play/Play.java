package com.xtravision.play;

public abstract class Play {
    private String name;
    private double duration;
    private String actor;

    public Play(String name, double duration, String actor){
        this.name = name;
        this.duration = duration;
        this.actor = actor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor){
        this.actor = actor;
    }
}
