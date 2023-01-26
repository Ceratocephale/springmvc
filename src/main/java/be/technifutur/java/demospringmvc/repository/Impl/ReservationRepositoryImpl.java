package be.technifutur.java.demospringmvc.repository.Impl;

import be.technifutur.java.demospringmvc.models.entity.Reservation;
import be.technifutur.java.demospringmvc.repository.AbstractCrudRepository;
import be.technifutur.java.demospringmvc.repository.ReservationRepository;
import be.technifutur.java.demospringmvc.utils.EMFSharer;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

public class ReservationRepositoryImpl
        extends AbstractCrudRepository<Reservation, Long>
        implements ReservationRepository {
    public ReservationRepositoryImpl(EMFSharer emfSharer) {
        super(Reservation.class, emfSharer.createEntityManager());
    }

    @Override
    public List<Reservation> getFromMonth(Month month, int year) {
        String qlQuery = String.format("SELECT r FROM Reservation r WHERE r.getMonthValue() = ?1 AND r.getYearValue() = ?2");
        TypedQuery<Reservation> query = entityManager.createQuery(qlQuery, Reservation.class);
        query.setParameter(1, month.getValue());
        query.setParameter(2, year);
        List<Reservation> list = query.getResultList();
        entityManager.clear();
        return list;

    }

    @Override
    public int getBreakfastNeededForDay(LocalDate date) {
        String qlQuery = String.format("""
                        SELECT COUNT(r)
                        FROM Reservation r 
                        WHERE ?1 BETWEEN r.getDateBegin() AND r.getDateEnd()
                        """);
        Reservation reservation = new Reservation();
        TypedQuery<Integer> query = entityManager.createQuery(qlQuery, Integer.class);
        query.setParameter(1, date);
        int result = query.getSingleResult();
        entityManager.clear();
        return result;
    }

    @Override
    public List<Reservation> getFutureShortReservation() {

        String qlQuery = String.format("""
                SELECT ALL(r)
                FROM Reservation r
                WHERE r.getDateBegin() BETWEEN ?1 AND ?2
                """);
        TypedQuery<Reservation> query = entityManager.createQuery(qlQuery, Reservation.class);
        query.setParameter(1, LocalDateTime.now());
        query.setParameter(1, LocalDateTime.now().plusWeeks(1));
        List<Reservation> list = query.getResultList();
        entityManager.clear();
        return list;
    }

    @Override
    public List<Reservation> getFutureLongReservation() {
        String qlQuery = String.format("""
                SELECT ALL(r)
                FROM Reservation r
                WHERE r.getDateBegin().compareTo(?1) = 1
                """);
        TypedQuery<Reservation> query = entityManager.createQuery(qlQuery, Reservation.class);
        query.setParameter(1, LocalDateTime.now().plusWeeks(1));
        List<Reservation> list = query.getResultList();
        entityManager.clear();
        return list;
    }

    @Override
    public List<Reservation> getFutureReservation() {
        String qlQuery = String.format("""
                SELECT ALL(r)
                FROM Reservation r
                WHERE r.getDateBegin().compareTo(?1) = 1
                """);
        TypedQuery<Reservation> query = entityManager.createQuery(qlQuery, Reservation.class);
        query.setParameter(1, LocalDateTime.now());
        List<Reservation> list = query.getResultList();
        entityManager.clear();
        return list;
    }
}



