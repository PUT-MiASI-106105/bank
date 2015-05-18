/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.di;

import com.bank.miasi.OdsetkiState;
import com.bank.miasi.OdsetkiStateKontoWygodne;
import com.bank.miasi.konta.Konto;
import com.bank.miasi.konta.KontoBankowe;
import com.bank.miasi.konta.typy.KontoWygodne;
import com.bank.miasi.konta.typy.LokataRoczna;
import com.bank.miasi.konta.typy.TypKonta;
import com.bank.miasi.mediator.Mediator;
import com.bank.miasi.mediator.PrzelewyMediator;
import com.google.inject.AbstractModule;
import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Provides;
import java.math.BigDecimal;

/**
 *
 * @author Kuba
 */
public class DodajModul extends AbstractModule{
    
    /**
     *
     * @param binder
     */
    
    
    @Provides
    TypKonta provideEvent(){
        KontoWygodne wygodne = new KontoWygodne();
        return wygodne;
    }
    
    @Provides
    BigDecimal provideDecimal(){
        BigDecimal decimal = new BigDecimal("1");
        return decimal;
    }
    
    @Override
    protected void configure() {
        
        bind(Mediator.class).to(PrzelewyMediator.class);
        bind(OdsetkiState.class).to(OdsetkiStateKontoWygodne.class);
        bind(Konto.class).to(KontoBankowe.class);
       // bind(TypKonta.class).to(LokataRoczna.class);
       //To change body of generated methods, choose Tools | Templates.
    }
    
}
