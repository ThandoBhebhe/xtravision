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

        potentialRentalService.createPotentialRentals(potentialRentalMovie);
        return "Success";
    }

    @RequestMapping("getprentals") //get potential rentals
    @ResponseBody
    public List<PotentialRental> getPotentialRentals(){
        return potentialRentalService.getPotentialRentals();
    }

    @RequestMapping("getprentalbid/{name}") //get potential rental by name
    @ResponseBody
    public PotentialRental getPotentialRentalsByName(@PathVariable String name){
        return potentialRentalService.getPotentialRentalByName(name);
    }

    @DeleteMapping("rm-potrbn/{id}")
    @ResponseBody
    public List deletePotentialRentalByName(@PathVariable int id){
        System.out.println("Given " +id);
        potentialRentalService.removePotentialRentalByName(id);

        return potentialRentalService.getPotentialRentals();
    }

    @RequestMapping("/potential-rental") //potential rent page route

    public String returnPotenialRentalPage(){

        return "potentialRental";
    }


}
