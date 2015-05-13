package com.bank.miasi.konta;

import com.bank.miasi.Klient;
import com.bank.miasi.OperacjaBankowa;
import com.bank.miasi.konta.typy.TypKonta;
import com.bank.miasi.exceptions.NiewspieranaOperacja;
import com.bank.miasi.wizytator.ProduktBankowy;
import com.bank.miasi.wizytator.Raport;
import java.math.BigDecimal;


/**
 *
 * @author Krzysztof
 */
public class Lokata extends Konto{

    public Lokata(TypKonta typ, String numer, Klient wlasciciel, BigDecimal kwota){
        super(typ, numer, wlasciciel);
        stan = kwota;
    }
    @Override
    public void wplata(OperacjaBankowa operacjaBankowa) throws NiewspieranaOperacja {
            throw new NiewspieranaOperacja();
    }

    @Override
    public ProduktBankowy accept(Raport raport) {
        return raport.visit(this); //To change body of generated methods, choose Tools | Templates.
    }

}
