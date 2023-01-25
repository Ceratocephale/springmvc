package be.technifutur.java.demospringmvc.controllers;

import be.technifutur.java.demospringmvc.models.Person;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/person")
public class PersonController {

    @GetMapping("/add")
    public String insertForm(@ModelAttribute("person") Person person) {
        return "person/add";
    }


    @PostMapping("/add")
    public String processInsert(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "person/add";
        }
        return "person/show";
    }

}
