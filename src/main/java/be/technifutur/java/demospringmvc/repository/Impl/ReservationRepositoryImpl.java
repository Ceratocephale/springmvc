package be.technifutur.java.demospringmvc.repository.Impl;

import be.technifutur.java.demospringmvc.models.entity.Reservation;
import be.technifutur.java.demospringmvc.repository.AbstractCrudRepository;
import be.technifutur.java.demospringmvc.repository.ReservationRepository;
import be.technifutur.java.demospringmvc.utils.EMFSharer;

import java.util.Set;

public class ReservationRepositoryImpl
        extends AbstractCrudRepository<Reservation, Long>
        implements ReservationRepository {
    public ReservationRepositoryImpl(EMFSharer emfSharer) {
        super(Reservation.class, emfSharer.createEntityManager());
    }

    @Override
    public void adaptId(Long id, Reservation entity) {

    }

    @Override
    public Set<Reservation> getFromMonth() {
        return null;
    }
}

