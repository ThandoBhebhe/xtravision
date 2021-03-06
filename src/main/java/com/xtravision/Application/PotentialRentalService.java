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
    public String createPotentialRentals(PotentialRental potentialRentalMovie){
        //in futurs we can check if its the users first time or a allow the amount they can rent based on that

        if(potentialRentals.size() == 4){
            return "You cant rent more than 4 movies";
        }
        potentialRentals.add(potentialRentalMovie);
        return "success";
    }

    public double getPrice(){
        return potentialRentals.size()*2.99;
    }

    //go through the potentialRentals stream and get a movie that matches the given name
    public PotentialRental getPotentialRentalByName(String name){

        return potentialRentals.stream().filter(m ->m.getMovieName().equals(name)).findFirst().get();
    }

    public void removePotentialRentalById(int id){
        potentialRentals.remove(id);
        System.out.println("Removed "+id);


    }

    public List removePotentialRentalByName(String givenName){

        potentialRentals.removeIf(potentialRental -> potentialRental.getMovieName().equals(givenName));

        return potentialRentals;
    }

    public int getPotentialRentalsLength(){
        return potentialRentals.size();
    }

    public void clearAllPotentialRentals(){
        potentialRentals.clear();
    }


}

