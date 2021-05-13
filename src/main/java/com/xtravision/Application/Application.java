package com.xtravision.Application;

import com.xtravision.movie.Movie;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.xtravision.play.Rent;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		Movie movie = new Movie("gonna get from model");
		Rent renter = new Rent();
		renter.rentMovie(movie);
	}



}
