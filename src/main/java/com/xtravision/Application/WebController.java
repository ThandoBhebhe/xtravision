package com.xtravision.Application;

import com.xtravision.movie.MoviePreOrder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebController {

    @RequestMapping("/home")
    public String returnIndexPage(Model welcomeModel){

        welcomeModel.addAttribute("welcomeMessage","Welcome to XtraVision");
        return "index";
    }

    @RequestMapping("/rent")
    public String returnRentPage(Model rentalInstructorModel){

        rentalInstructorModel.addAttribute("instruction", "Select a com.xtravision.movie and click rent");
        return "rent";
    }

//    @RequestMapping(method = RequestMethod.POST, value = "/potentialRental")
//    public String returnPotenialRentalPage(@RequestBody MoviePreOrder moviePreOrder){
//
//
//
//        return "potentialRental";
//    }
    @RequestMapping("/potentialRental")
    public String returnPotenialRentalPage(){

        return "potentialRental";
    }


}
