package com.xtravision.Application;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

    @RequestMapping("/home")
    public String returnIndexPage(Model welcomModel){

        welcomModel.addAttribute("welcomeMessage","Weclome to XVision");
        return "index";
    }

    @RequestMapping("/rent")
    public String returnRentPage(){
        return "rent";
    }




}
