package be.technifutur.java.demospringmvc.repository;

import be.technifutur.java.demospringmvc.models.entity.Reservation;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Set;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {

    /*
    * Gets the reservation that begins or ends in a month
    * @param month
    * @param year
    * @return the set of reservation for a specific month
    * */
    List<Reservation> getFromMonth(Month month, int year);

    /*
    * Gets the number of breakfast needed for the specific date
    * */

    int getBreakfastNeededForDay(LocalDate date);


    //less than a weke
    List<Reservation> getFutureShortReservation();

    //more than a week
    List<Reservation> getFutureLongReservation();

    List<Reservation> getFutureReservation();

}
