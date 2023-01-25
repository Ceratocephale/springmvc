package be.technifutur.java.demospringmvc.controllers;

import be.technifutur.java.demospringmvc.models.form.Hotel;
import be.technifutur.java.demospringmvc.models.HotelForm;
import be.technifutur.java.demospringmvc.services.HotelService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/hotel")
@Controller
public class HotelController {

    private final HotelService hotelService;


    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/all")
    public String allHotel(Model model) {
        List<Hotel> hotels = hotelService.getAll();
        model.addAttribute("hotels", hotels);
        return "hotel/all";
    }


    @GetMapping("/{id}")
    public String oneHotel(Model model, @PathVariable int id) {
        model.addAttribute("hotel", hotelService.getOne(id));
        return "hotel/one";
    }

    @GetMapping("/new")
    public String insert(@ModelAttribute ("hotel") HotelForm form) {
        return "hotel/new";
    }
    @PostMapping("/new")
    public String processInsert(@ModelAttribute("hotel") @Valid HotelForm hotel, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "hotel/new";
        }
        hotelService.insertForm(hotel);

        return "redirect:/hotel/all";
    }

}
