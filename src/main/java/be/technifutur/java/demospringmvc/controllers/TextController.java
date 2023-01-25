package be.technifutur.java.demospringmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class TextController {


    @GetMapping("/mots/{wordsNum}")
    public String words(Model model, @PathVariable int wordsNum) {
        List<String> words = new ArrayList<>();
        Random rnd = new Random();
        for (int i = wordsNum; i > 0; i--) {
            StringBuilder strb = new StringBuilder("");
            for (int j = rnd.nextInt(6) + 5; j > 0; j--) {
                strb.append(Character.toString((char) rnd.nextInt(26) + 97));
            }
            words.add(String.valueOf(strb));
        }
        model.addAttribute("words", words);
        return "mots/mots";
    }

}
