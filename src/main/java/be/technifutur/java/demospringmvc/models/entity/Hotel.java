package be.technifutur.java.demospringmvc.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotel_id", nullable = false)
    private Long id;

    @Column(scale = 1)
    private int stars;

    @OneToOne
    @JoinColumn(name = "receptionist_id", unique = true)
    private Employee receptionist;
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @OneToMany(mappedBy = "hotel")
    private List<Room> rooms;

    @OneToMany(mappedBy = "hotel")
    private List<WorkDetail> workDetails;




}
