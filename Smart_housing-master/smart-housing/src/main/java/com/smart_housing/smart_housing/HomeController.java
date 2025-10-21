package com.smart_housing.smart_housing;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller


public class HomeController {

    @RequestMapping("/")
    public  String greetings(){

        return "redirect:/index.html";
    }
}
