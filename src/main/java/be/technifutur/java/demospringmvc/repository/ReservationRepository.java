package be.technifutur.java.demospringmvc.repository;

import be.technifutur.java.demospringmvc.models.entity.Reservation;

import java.time.Month;
import java.util.Set;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {

    Set<Reservation> getFromMonth(Month month);

}
