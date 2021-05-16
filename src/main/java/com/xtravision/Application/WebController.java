package com.xtravision.Application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class WebController {
    @Autowired //this web controller depends on the PotentialRental class thats why we autowire these two classes together
    PotentialRentalService potentialRentalService;

    @RequestMapping("/home") //home page route
    public String returnIndexPage(Model welcomeModel){

        welcomeModel.addAttribute("welcomeMessage","Welcome to XtraVision");
        return "index";
    }

    @RequestMapping("/rent") //rental page route
    public String returnRentPage(Model model){

        model.addAttribute("instruction", "Select a com.xtravision.movie and click rent");
        return "rent";
    }

    @PostMapping("/addprental") // add potentialRental
    @ResponseBody
    public String addPotentialRental(@RequestBody PotentialRental potentialRentalMovie){

        return potentialRentalService.createPotentialRentals(potentialRentalMovie);
    }

    @RequestMapping("getprentals") //get potential rentals
    @ResponseBody
    public List<PotentialRental> getPotentialRentals(){
        return potentialRentalService.getPotentialRentals();
    }

    @RequestMapping("getprentalbn/{name}") //get potential rental by name
    @ResponseBody
    public PotentialRental getPotentialRentalsByName(@PathVariable String name){
        return potentialRentalService.getPotentialRentalByName(name);
    }

    @DeleteMapping("rm-potrbid/{id}")
    @ResponseBody
    public List deletePotentialRentalById(@PathVariable int id){
        System.out.println("Given " +id);
        potentialRentalService.removePotentialRentalById(id);

        return potentialRentalService.getPotentialRentals();
    }

    @DeleteMapping("rm-potrbn/{name}")
    @ResponseBody
    public List removePotentialRentalByName(@PathVariable String name){

        System.out.println("This is the name we got "+name);
        return potentialRentalService.removePotentialRentalByName(name);
    }

    @DeleteMapping("cpr")
    @ResponseBody
    public void clearPotentialRentals(){
        potentialRentalService.clearAllPotentialRentals();
    }

    @RequestMapping("/potential-rental") //potential rent page route

    public String returnPotenialRentalPage(){

        return "potentialRental";
    }

    @GetMapping("/getprs")
    @ResponseBody
    public int getPotentialRentalsListSize(){
        return potentialRentalService.getPotentialRentalsLength();
    }


}
