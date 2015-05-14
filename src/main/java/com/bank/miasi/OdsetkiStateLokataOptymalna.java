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
    
    private static final Integer dzielnik = 200;
    private static final Integer liczbaDniRoku = 365;
    private static final Integer wynikMiejscaPoPrzecinku = 2;
    
    @Override
    public BigDecimal obliczOdsetki( BigDecimal stanKonta, TypKonta typKonta) {
        BigDecimal wynik = null;
        BigDecimal procent = typKonta.getOprocentowanie();

        wynik = stanKonta;
        wynik = wynik.multiply(procent);
        wynik = wynik.divide(new BigDecimal(dzielnik), BigDecimal.ROUND_DOWN);
        wynik = wynik.multiply(new BigDecimal(typKonta.getOkresRozliczeniowy()));
        wynik = wynik.divide(new BigDecimal(liczbaDniRoku), BigDecimal.ROUND_DOWN);
        
        wynik = wynik.setScale(wynikMiejscaPoPrzecinku, RoundingMode.DOWN);

        return wynik;
    }
}
