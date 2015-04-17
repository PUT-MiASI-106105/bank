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
public interface Raport {
   // public ProduktBankowy visit(ProduktBankowy produkt);
    public ProduktBankowy visit(Lokata lokata);
    public ProduktBankowy visit(KontoBankowe konto);
    public ProduktBankowy visit(Pozyczka pozyczka);
}
