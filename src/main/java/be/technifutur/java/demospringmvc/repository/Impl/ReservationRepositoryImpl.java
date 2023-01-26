package be.technifutur.java.demospringmvc.repository.Impl;

import be.technifutur.java.demospringmvc.models.entity.Reservation;
import be.technifutur.java.demospringmvc.repository.AbstractCrudRepository;
import be.technifutur.java.demospringmvc.repository.ReservationRepository;
import be.technifutur.java.demospringmvc.utils.EMFSharer;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.List;

@Repository
public class ReservationRepositoryImpl
        extends AbstractCrudRepository<Reservation, Long>
        implements ReservationRepository {
    public ReservationRepositoryImpl(EMFSharer emfSharer) {
        super(Reservation.class, emfSharer.createEntityManager());
    }

    @Override
    public List<Reservation> getFromMonth(Month month, int year) {
        String qlQuery = """
                SELECT r
                FROM Reservation r
                WHERE EXTRACT(MONTH FROM r.dateBegin) = ?1 AND EXTRACT(YEAR FROM r.dateBegin) = ?2
                """;
        TypedQuery<Reservation> query = entityManager.createQuery(qlQuery, Reservation.class);
        query.setParameter(1, month.getValue());
        query.setParameter(2, year);
        List<Reservation> list = query.getResultList();
        entityManager.clear();
        return list;
    }

    @Override
    public int getBreakfastNeededForDay(LocalDate date) {
        String qlQuery ="""
                        SELECT COUNT(r)
                        FROM Reservation r
                        WHERE ?1 BETWEEN r.dateBegin AND r.dateEnd
                        """;
        Reservation reservation = new Reservation();
        TypedQuery<Long> query = entityManager.createQuery(qlQuery, Long.class);
        LocalDateTime dateNow = date.atTime(LocalTime.now());
        query.setParameter(1, dateNow);
        long result = query.getSingleResult();
        entityManager.clear();
        return (int)result;
    }

    @Override
    public List<Reservation> getFutureShortReservation() {

        String qlQuery = """
                SELECT r
                FROM Reservation r
                WHERE r.dateBegin BETWEEN ?1 AND ?2
                """;
        TypedQuery<Reservation> query = entityManager.createQuery(qlQuery, Reservation.class);
        query.setParameter(1, LocalDateTime.now());
        query.setParameter(2, LocalDateTime.now().plusWeeks(1));
        List<Reservation> list = query.getResultList();
        entityManager.clear();
        return list;
    }

    @Override
    public List<Reservation> getFutureLongReservation() {
        String qlQuery = """
                SELECT r
                FROM Reservation r
                WHERE r.dateBegin > ?1
                """;
        TypedQuery<Reservation> query = entityManager.createQuery(qlQuery, Reservation.class);
        query.setParameter(1, LocalDateTime.now().plusWeeks(1));
        List<Reservation> list = query.getResultList();
        entityManager.clear();
        return list;
    }

    @Override
    public List<Reservation> getFutureReservation() {
        String qlQuery = """
                SELECT r
                FROM Reservation r
                WHERE r.dateBegin > ?1
                """;
        TypedQuery<Reservation> query = entityManager.createQuery(qlQuery, Reservation.class);
        query.setParameter(1, LocalDateTime.now());
        List<Reservation> list = query.getResultList();
        entityManager.clear();
        return list;
    }
}



