package com.xtravision.Application;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service //Spring is just going to create one instance of this class
public class PotentialRentalService {
    private List<PotentialRental> potentialRentals= new ArrayList();


    public List<PotentialRental> getPotentialRentals(){
        return this.potentialRentals;
    }
    public void createPotentialRentals(PotentialRental potentialRentalMovie){
        potentialRentals.add(potentialRentalMovie);
    }

    //go through the potentialRentals stream and get a movie that matches the given name
    public PotentialRental getPotentialRentalByName(String name){
        createPotentialRentals(new PotentialRental("Ironman","imageUrl"));
        return potentialRentals.stream().filter(m ->m.getMovieName().equals(name)).findFirst().get();
    }

}

