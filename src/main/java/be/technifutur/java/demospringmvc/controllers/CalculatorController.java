package be.technifutur.java.demospringmvc.controllers;

import be.technifutur.java.demospringmvc.models.Nombres;
import be.technifutur.java.demospringmvc.services.CalculatorService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/Calculator")
@Controller
public class CalculatorController {

    private CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService){
        this.calculatorService = calculatorService;
    }
    @GetMapping("/insert")
    public String insertForm(Model model){
        model.addAttribute("result", new Nombres());
        return "Calculator/insert";
    }

    @PostMapping("/insert")
    public String calculate(Model model,@Valid Nombres nombres){
        int result = 0;
        switch(nombres.getOperand()) {
            case '*': result = nombres.getOne()*nombres.getTwo();
                    break;
            case '+':result = nombres.getOne()+nombres.getTwo();
            break;
            case '-':result = nombres.getOne()-nombres.getTwo();
            break;
            case '%':result = nombres.getOne()%nombres.getTwo();
            break;
            case '/':result = nombres.getOne()/nombres.getTwo();
            break;
        }
        model.addAttribute("result",result);

        return "Calculator/result";
    }
}
