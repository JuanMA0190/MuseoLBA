package com.museolba.modelo.jpaController;

import com.museolba.modelo.entidades.Recibo;

public class ReciboJpaController extends BaseJpaController<Recibo, Long> {
    
    public ReciboJpaController() {
        super(Recibo.class);
    }
}
