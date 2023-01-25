package be.technifutur.java.demospringmvc.services;

import be.technifutur.java.demospringmvc.models.form.Hotel;
import be.technifutur.java.demospringmvc.models.HotelForm;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelService {

    private List<Hotel> hotels = new ArrayList<>();
    private RoomService roomService = new RoomService();

    public HotelService() {
//        hotels.add(new Hotel(roomService.getRooms1(),1, "Paris", 2, "Andrew", 4));
//        hotels.add(new Hotel(roomService.getRooms2(),2, "Bruxelles", 3, "Michael", 4));
//        hotels.add(new Hotel(roomService.getRooms3(),3, "Madrid", 4, "Thomas", 4));
//        hotels.add(new Hotel(roomService.getRooms4(),4, "Rome", 2, "Albert", 4));
//        hotels.add(new Hotel(roomService.getRooms5(),5, "Berlin", 5, "Simon", 4));
    }

    public List<Hotel> getAll() {
        return new ArrayList<>(hotels);
    }

    public Hotel getOne(int id) {
        return hotels.stream()
                .filter(hotel -> hotel.getId() == id)
                .findFirst().orElseThrow(() -> new RuntimeException("Pas de hotel avec cet id"));
    }

    public void insertForm (HotelForm form){
        Hotel hotel = new Hotel(form.getId(),
            form.getAddress(),
            form.getStarNumber(),
            form.getReceptionName(),
            form.getName());

        hotels.add(hotel);
    }

}
