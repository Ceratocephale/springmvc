package be.technifutur.java.demospringmvc.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter @Setter
public class WorkDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "workDetail_id", nullable = false)
    private Long id;

    @Column(name = "date_debut", nullable = false)
    private LocalDate dateDebut;


    @Column(name = "date_fin")
    private LocalDate dateFin;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;


}
