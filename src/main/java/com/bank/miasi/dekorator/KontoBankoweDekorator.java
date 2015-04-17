/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.miasi.dekorator;

import com.bank.miasi.wizytator.ProduktBankowy;
import com.bank.miasi.wizytator.Raport;
import com.bank.miasi.konta.KontoBankowe;
import java.math.BigDecimal;

/**
 *
 * @author nowekonto
 */
public class KontoBankoweDekorator extends Dekorator{

    public KontoBankoweDekorator(KontoBankowe konto) {
        super(konto);
    }
    
    @Override
    public ProduktBankowy accept(Raport raport) {
         return super.accept(raport);
    }
    
    public void zerujDebet() {
       super.konto.setDebet(new BigDecimal("0"));
    }
    
    public BigDecimal sprawdzStanDebetu() {
       return super.konto.getDebet();
    }
    
    public void wypiszWlascicielaIStanDebetu (){
        System.out.println(super.konto.getWlasciciel().getImie());
        System.out.println(super.konto.getWlasciciel().getNazwisko());
        System.out.println(super.konto.getDebet());
    }
}
