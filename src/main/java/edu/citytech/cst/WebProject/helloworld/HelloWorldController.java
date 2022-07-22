package edu.citytech.cst.WebProject.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
    @RequestMapping("/Salutations")
    public String helloWorld(Model model){

        model.addAttribute("author", "Hamzat Olowu");

        return "HelloWorld.jsp";
    }
}
