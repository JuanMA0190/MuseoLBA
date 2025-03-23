package com.museolba.modelo.jpaController.obraJpaController;

import com.museolba.modelo.entidades.obra.Obra;
import com.museolba.modelo.jpaController.BaseJpaController;


public class ObraJpaController extends BaseJpaController<Obra, Long> {
    
     public ObraJpaController() {
        super(Obra.class);
    }
    

}
