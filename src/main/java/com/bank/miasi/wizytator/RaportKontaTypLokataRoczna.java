/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.miasi.wizytator;

import com.bank.miasi.konta.KontoBankowe;
import com.bank.miasi.konta.Lokata;
import com.bank.miasi.konta.Pozyczka;
import com.bank.miasi.konta.typy.LokataRoczna;

/**
 * Raport wybiera tylko te konta, które są typu Lokata Roczna
 * @author nowekonto
 */
public class RaportKontaTypLokataRoczna implements Raport{

    @Override
    public ProduktBankowy visit(Lokata lokata) {
        if (lokata.getTyp().getClass() == LokataRoczna.class)
        {
            return lokata;
        }
        
        return null;
    }

    @Override
    public ProduktBankowy visit(KontoBankowe konto) {
        if (konto.getTyp().getClass() == LokataRoczna.class)
        {
            return konto;
        }
        
        return null;
    }

    @Override
    public ProduktBankowy visit(Pozyczka pozyczka) {
        if (pozyczka.getTyp().getClass() == LokataRoczna.class)
        {
            return pozyczka;
        }
        
        return null;
    }
    
}
