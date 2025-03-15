package com.museolba.modelo.jpaController;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class PersistenceJpaController {
    
     private static EntityManagerFactory emf;

    public static EntityManagerFactory getEmf() {
        if (emf == null) {
            Map<String, String> properties = new HashMap<>();
            properties.put("javax.persistence.jdbc.url", System.getenv("DB_MUSEUM_URL"));
            properties.put("javax.persistence.jdbc.user", System.getenv("DB_MUSEUM_USER"));
            properties.put("javax.persistence.jdbc.password", System.getenv("DB_MUSEUM_PASSWORD"));

            emf = Persistence.createEntityManagerFactory("museolbaPU", properties);
        }
        return emf;
    }
}