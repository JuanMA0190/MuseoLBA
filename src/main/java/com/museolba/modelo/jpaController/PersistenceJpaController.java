package com.museolba.modelo.jpaController;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class PersistenceJpaController {
    /*
    private static EntityManagerFactory emf;
    
    public synchronized EntityManagerFactory getEmf(){
        if(emf == null)
            emf=Persistence.createEntityManagerFactory("museolbaPU");
        return emf;
    }
    */
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("museolbaPU");

    public static EntityManagerFactory getEmf() {
        return emf;
    }
}