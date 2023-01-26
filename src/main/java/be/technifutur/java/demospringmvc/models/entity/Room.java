package be.technifutur.java.demospringmvc.models.entity;

import be.technifutur.java.demospringmvc.models.entity.enums.RoomType;
import be.technifutur.java.demospringmvc.models.entity.enums.RoomView;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id", nullable = false)
    private long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "room_view", nullable = false)
    private RoomView view;

    @Enumerated(EnumType.STRING)
    @Column(name = "room_type", nullable = false)
    private RoomType type;

    @Column(nullable = false)
    private int number;

    @Column(name = "room_floor", nullable = false)
    private int floor;

    @Column(name = "simple_beds", nullable = false)
    private int simpleBeds;

    @Column(name = "double_beds", nullable = false)
    private int doubleBeds;

    @Column(nullable = false)
    private int size;

    @Column(name = "additional_beds", nullable = false)
    private int additionalBeds;

    @Column(nullable = false)
    private boolean available;

    @OneToMany(mappedBy = "room")
    private List<Reservation> reservations;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

}
