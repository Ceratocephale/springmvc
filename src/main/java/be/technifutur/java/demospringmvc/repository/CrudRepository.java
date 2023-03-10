package be.technifutur.java.demospringmvc.repository;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<TENTITY, TID> {

    List<TENTITY> getALl();

    Optional<TENTITY> getById(TID id);

    void save (TENTITY entity);

    void delete(TENTITY entity);

    void deleteById(TID id);

    boolean existsById(TID id);
}
