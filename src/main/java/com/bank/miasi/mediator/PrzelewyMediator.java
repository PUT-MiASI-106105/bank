/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.miasi.mediator;

import com.bank.miasi.Bank;
import com.bank.miasi.kir.ManagerKIR;
import com.bank.miasi.kir.Paczka;
import com.bank.miasi.kir.Przesylka;
import com.bank.miasi.konta.Konto;
import com.bank.miasi.test.SymulatorZewnetrznegoKIR;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author nowekonto
 */
public class PrzelewyMediator implements Mediator{ 
    
    private Map<String, Bank> listaBankow;
    
    public PrzelewyMediator() {
        listaBankow = new HashMap<String, Bank>();
    }
    
    @Override
    public void dodajBank(String przedrostek, Bank bank) { 
        listaBankow.put(przedrostek, bank);
    }

    @Override
    public void przelejNaRachunek(String numerKontaNadawcy, String numerKontaOdbiorcy, BigDecimal kwota) {
        String klucz = numerKontaOdbiorcy.substring(0,2);
        Bank bank = listaBankow.get(klucz);
        
        this.przelej (numerKontaNadawcy, bank, kwota);
    }
    
    private void przelej(String numerKontaNadawcy, Bank bank, BigDecimal kwota) {
        
        Konto konto = bank.pobierzKonto(numerKontaNadawcy);
        konto.wplacKwote(kwota); 
    }
}
