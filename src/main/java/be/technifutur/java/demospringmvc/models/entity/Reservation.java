package be.technifutur.java.demospringmvc.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id", nullable = false)
    private long id;

    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate;

    @Column(name = "cancellation_date")
    private int cancellationDate;

    @Column(name = "additional_beds", nullable = false)
    private int additionalBeds;

    @Column(nullable = false)
    private double price;

    private Double discount;

    @Column(name = "breakfast_included", nullable = false)
    private boolean breakfastIncluded;

    @Column(name = "date_begin",nullable = false)
    private LocalDateTime dateBegin;

    @Column(name = "date_end",nullable = false)
    private LocalDateTime dateEnd;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Client client;
}
