package com.museolba.modelo.jpaController;

import com.museolba.modelo.entidades.Personal;


public class PersonalJpaController extends BaseJpaController<Personal, Long> {
    
    public PersonalJpaController() {
        super(Personal.class);
    }

    public Personal findPersonal(long id) {
        return find(id);
    }
    
}
