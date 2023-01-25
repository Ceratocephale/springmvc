package be.technifutur.java.demospringmvc.services;

import be.technifutur.java.demospringmvc.models.form.Room;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class RoomService {
    private List<Room> rooms = new ArrayList<>();
    private List<Room> rooms1 = new ArrayList<>();
    private List<Room> rooms2 = new ArrayList<>();
    private List<Room> rooms3 = new ArrayList<>();
    private List<Room> rooms4 = new ArrayList<>();
    private List<Room> rooms5 = new ArrayList<>();

    public RoomService() {
        rooms1.add(new Room(1, 1, 1, 0, 20));
        rooms1.add(new Room(1, 2, 1, 0, 25));
        rooms1.add(new Room(1, 3, 1, 0, 30));
        rooms1.add(new Room(1, 4, 1, 2, 50));
        rooms2.add(new Room(2, 1, 1, 0, 20));
        rooms2.add(new Room(2, 2, 1, 0, 35));
        rooms2.add(new Room(2, 3, 0, 3, 20));
        rooms2.add(new Room(2, 4, 1, 0, 20));
        rooms3.add(new Room(3, 1, 1, 0, 40));
        rooms3.add(new Room(3, 2, 0, 2, 20));
        rooms3.add(new Room(3, 3, 1, 0, 60));
        rooms3.add(new Room(3, 4, 1, 2, 55));
        rooms4.add(new Room(4, 1, 1, 0, 20));
        rooms4.add(new Room(4, 2, 1, 0, 20));
        rooms4.add(new Room(4, 3, 1, 0, 20));
        rooms4.add(new Room(4, 4, 3, 0, 25));
        rooms5.add(new Room(5, 4, 1, 0, 20));
        rooms5.add(new Room(5, 4, 1, 0, 35));
        rooms5.add(new Room(5, 4, 0, 2, 20));
        rooms5.add(new Room(5, 4, 1, 0, 20));

        rooms.addAll(rooms1);
        rooms.addAll(rooms2);
        rooms.addAll(rooms3);
        rooms.addAll(rooms4);
        rooms.addAll(rooms5);
    }


    public List<Room> getAll() {
        return new ArrayList<>(rooms);
    }

    public Room getOne(int numRoom) {
        return rooms.stream()
                .filter(room -> room.getNumRoom() == numRoom)
                .findFirst().orElseThrow(() -> new RuntimeException("Pas de chambre avec ce numero"));
    }

    public void insert(Room room) {
        if (room.getNumRoom() < 0
                || room.getNbrSimpleBed() < 0
                || room.getNbrDoubleBed() < 0
                || room.getSize() < 0) {
            throw new RuntimeException("valeur invalide");
        }
        rooms.add(room);
    }

    public void update(int num, Room room) {
        if (room.getNbrSimpleBed() < 0
                || room.getNbrDoubleBed() < 0
                || room.getSize() < 0) {
            throw new RuntimeException("valeur invalide");
        }


        Room toUpdate = getOne(num);
        toUpdate.setNbrSimpleBed(room.getNbrSimpleBed());
        toUpdate.setNbrDoubleBed(room.getNbrDoubleBed());
        toUpdate.setSize(room.getSize());
    }

}
