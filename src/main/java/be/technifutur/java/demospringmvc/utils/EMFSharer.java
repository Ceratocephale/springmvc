package be.technifutur.java.demospringmvc.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.stereotype.Component;

@Component

public final class EMFSharer {

    // region SINGLETON
    private static EMFSharer instance;
    public static EMFSharer getInstance() {
        return instance == null ? instance = new EMFSharer() : instance;
//        if( instance == null ){
//            instance = new EMFSharer();
//        }
//
//        return instance;
    }
    public EMFSharer() {
        this.emf = Persistence.createEntityManagerFactory("hotel-manager");
    }
    // endregion

    private final EntityManagerFactory emf;


    public EntityManagerFactory getEmf() {
        return emf;
    }

    public EntityManager createEntityManager(){
        return emf.createEntityManager();
    }

    public void close(){
        emf.close();
    }
}
