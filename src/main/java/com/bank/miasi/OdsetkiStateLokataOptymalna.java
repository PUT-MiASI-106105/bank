/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.miasi;

import com.bank.miasi.konta.typy.TypKonta;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author student
 */
public class OdsetkiStateLokataOptymalna implements OdsetkiState{

    @Override
    public BigDecimal obliczOdsetki( BigDecimal stanKonta, TypKonta typKonta) {
       BigDecimal wynik = null;
        BigDecimal procent = typKonta.getOprocentowanie();

        wynik = stanKonta;
        wynik = wynik.multiply(procent);
        wynik = wynik.divide(new BigDecimal("100"), BigDecimal.ROUND_DOWN);
        wynik = wynik.multiply(new BigDecimal(typKonta.getOkresRozliczeniowy()));
        wynik = wynik.divide(new BigDecimal("365"), BigDecimal.ROUND_DOWN);
        
        wynik = wynik.setScale(2, RoundingMode.DOWN);

        return wynik;
    }




}
