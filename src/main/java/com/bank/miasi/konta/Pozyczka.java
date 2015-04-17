package com.bank.miasi.konta;

import com.bank.miasi.Klient;
import com.bank.miasi.OperacjaBankowa;
import com.bank.miasi.konta.typy.TypKonta;
import com.bank.miasi.exceptions.BlednaKwota;
import com.bank.miasi.exceptions.NieWystarczajacoSrodkow;
import com.bank.miasi.exceptions.NiewspieranaOperacja;
import com.bank.miasi.wizytator.ProduktBankowy;
import com.bank.miasi.wizytator.Raport;
import java.math.BigDecimal;

/**
 *
 * @author Krzysztof
 */
public class Pozyczka extends Konto {

    public Pozyczka(TypKonta typ, String numer, Klient wlasciciel, BigDecimal kwota) {
        super(typ, numer, wlasciciel);
        stan = kwota;
    }

    @Override
    public void wplata(OperacjaBankowa operacjaBankowa) throws NiewspieranaOperacja {
        BigDecimal ile = operacjaBankowa.getKwota();
        if (ile.signum() >= 0) {
            throw new BlednaKwota();
        }
        if (stan.add(ile).signum() < 0) {
            throw new NieWystarczajacoSrodkow();
        }
        stan = stan.add(ile);
        historia.add(operacjaBankowa);
    }

    @Override
    public ProduktBankowy accept(Raport raport) {
        return raport.visit(this); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
