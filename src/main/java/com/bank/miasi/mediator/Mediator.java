/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.miasi.mediator;

import com.bank.miasi.Bank;
import java.math.BigDecimal;

/**
 *
 * @author nowekonto
 */
public interface Mediator {
    public void dodajBank(String przedrostek, Bank bank);
    public void przelejNaRachunek(String numerKontaNadawcy, String numerKontaOdbiorcy, BigDecimal kwota);
}
