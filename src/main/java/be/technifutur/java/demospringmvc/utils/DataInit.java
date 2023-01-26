package be.technifutur.java.demospringmvc.utils;


import be.technifutur.java.demospringmvc.models.entity.*;
import be.technifutur.java.demospringmvc.models.entity.enums.RoomType;
import be.technifutur.java.demospringmvc.models.entity.enums.RoomView;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Component
public class DataInit implements InitializingBean {

    private final EntityManager manager;

    public DataInit(EMFSharer emfSharer) {
        this.manager = emfSharer.createEntityManager();
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        manager.getTransaction().begin();

        Employee employee = new Employee();
        employee.setId(1L);
        employee.setFirstName("luc");
        employee.setLastName("dubois");
        employee.setAddress("une adresse");
        employee.setEmail("@.com");
        employee.setPhone("000");

        employee = manager.merge(employee);
        manager.flush();


        Hotel hotel = new Hotel();
      //  hotel.setId(1l);
        hotel.setName("Hilton");
        hotel.setAddress("Liege");
        hotel.setReceptionist(employee);

        hotel = manager.merge(hotel);


        Room room = new Room();
        room.setId(2L);
        room.setSize(10);
        room.setHotel(hotel);
        room.setAvailable(true);
        room.setDoubleBeds(1);
        room.setNumber(101);
        room.setFloor(1);
        room.setType(RoomType.BASIC);
        room.setView(RoomView.AVERAGE);

        manager.merge( room );

        Client client = new Client();

        client.setId(2L);
        client.setUsername("client");
        client.setPassword("pass");
        client.setRole("customer");
        client.setAddress("adresse");
        client.setEmail("email");
        client.setPhone("phone");
        client.setFirstName("luc");
        client.setLastName("dubois");

        manager.merge(client);

        Reservation reservation = new Reservation();

        reservation.setId(1L);
        reservation.setDateBegin(LocalDateTime.of(2023, 10, 29,12,0,0));
        reservation.setDateEnd(LocalDateTime.of(2023, 11, 02,12,0,0));
        reservation.setRoom(room);
        reservation.setClient(client);
        reservation.setPrice(100);
        reservation.setBreakfastIncluded(true);
        reservation.setCreationDate(LocalDateTime.now());

        manager.merge(reservation);

        reservation = new Reservation();

        reservation.setId(2L);
        reservation.setDateBegin(LocalDateTime.of(2023, 9, 30,12,0,0));
        reservation.setDateEnd(LocalDateTime.of(2023, 10, 3,12,0,0));
        reservation.setRoom(room);
        reservation.setClient(client);
        reservation.setPrice(100);
        reservation.setBreakfastIncluded(true);
        reservation.setCreationDate(LocalDateTime.now());

        manager.merge(reservation);


        reservation = new Reservation();

        reservation.setId(3L);
        reservation.setDateBegin(LocalDateTime.of(2023, 10, 3,12,0,0));
        reservation.setDateEnd(LocalDateTime.of(2023, 10, 30,12,0,0));
        reservation.setRoom(room);
        reservation.setClient(client);
        reservation.setPrice(100);
        reservation.setBreakfastIncluded(false);
        reservation.setCreationDate(LocalDateTime.now());

        manager.merge(reservation);

        manager.getTransaction().commit();

    }
}