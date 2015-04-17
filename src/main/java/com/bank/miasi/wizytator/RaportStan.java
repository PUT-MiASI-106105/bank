/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.miasi.wizytator;

import com.bank.miasi.konta.KontoBankowe;
import com.bank.miasi.konta.Lokata;
import com.bank.miasi.konta.Pozyczka;

/**
 *
 * @author nowekonto
 */
public class RaportStan implements Raport{

    @Override
    public ProduktBankowy visit(Lokata lokata) {
        return lokata; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProduktBankowy visit(KontoBankowe konto) {
        return konto; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProduktBankowy visit(Pozyczka pozyczka) {
        return pozyczka; //To change body of generated methods, choose Tools | Templates.
    }
    
}
