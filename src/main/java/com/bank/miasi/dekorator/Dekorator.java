/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.miasi.dekorator;

import com.bank.miasi.wizytator.Element;
import com.bank.miasi.wizytator.ProduktBankowy;
import com.bank.miasi.wizytator.Raport;
import com.bank.miasi.konta.Konto;
import com.bank.miasi.konta.KontoBankowe;

/**
 *
 * @author nowekonto
 */
public class Dekorator implements Element{

     protected KontoBankowe konto;
    
     public Dekorator (KontoBankowe konto)
     {
         this.konto = konto;
     }
     
    @Override
    public ProduktBankowy accept(Raport raport) {
         return konto.accept(raport);
    }
    
}
