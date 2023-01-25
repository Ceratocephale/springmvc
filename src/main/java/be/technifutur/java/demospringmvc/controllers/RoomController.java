package be.technifutur.java.demospringmvc.controllers;

import be.technifutur.java.demospringmvc.models.form.Room;
import be.technifutur.java.demospringmvc.services.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/room")
public class RoomController {

    // 3 conditions à DI:
    // 1 - je peux injecter une dependance pour creer un Bean
    // 2 - il existe un Bean qui correspond au type de la dependance souhaite
    // 3 - la dependance est declare


    private final RoomService roomService;


    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

//    @GetMapping("/room/all")
//    public String hotel1(Model model){
//        List<Room> rooms = roomService.getAll();
//        model.addAttribute("rooms", rooms);
//        return "room/all";
//    }
//    @GetMapping("/room/all")
//    public String hotel2(Model model){
//        List<Room> rooms = roomService.getAll();
//        model.addAttribute("rooms", rooms);
//        return "room/all";
//    }
//    @GetMapping("/room/all")
//    public String hotel3(Model model){
//        List<Room> rooms = roomService.getAll();
//        model.addAttribute("rooms", rooms);
//        return "room/all";
//    }
//    @GetMapping("/room/all")
//    public String hotel4(Model model){
//        List<Room> rooms = roomService.getAll();
//        model.addAttribute("rooms", rooms);
//        return "room/all";
//    }
//    @GetMapping("/room/all")
//    public String hotel5(Model model){
//        List<Room> rooms = roomService.getAll();
//        model.addAttribute("rooms", rooms);
//        return "room/all";
//    }
    @GetMapping("/all")
    public String allRoom(Model model){
        List<Room> rooms = roomService.getAll();
        model.addAttribute("rooms", rooms);
        return "room/all";
    }



    @GetMapping("/{numRoom}")
    public String oneRoom(Model model,@PathVariable int numRoom){
        model.addAttribute("room", roomService.getOne(numRoom));
        return "room/one";
    }

    @GetMapping("/add")
    public String insertForm(Model model){
        model.addAttribute("room", new Room());
        return "room/insert";
    }
    @PostMapping("/add")
    public String proccessInsert(Room form){
        roomService.insert(form);
        return "redirect:all";
    }
    @GetMapping("/update/{num}")
    public String updateForm(Model model, @PathVariable int num){
        Room toUpdate = roomService.getOne(num);

        model.addAttribute("room", toUpdate);

        return "room/update";
    }
    @PostMapping("/update/{num}")
    public String processUpdate(Room room, @PathVariable int num){
        roomService.update(num, room);

        return "redirect:/room/all";
    }

//    @GetMapping("/hotel/all")
//    public String allHotel(Model model){
//
//    }
}
