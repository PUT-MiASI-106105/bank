/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.miasi.wizytator;

import com.bank.miasi.OperacjaBankowa;
import com.bank.miasi.konta.KontoBankowe;
import com.bank.miasi.konta.Lokata;
import com.bank.miasi.konta.Pozyczka;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author nowekonto
 */
public class RaportPrzynajmniejJednaOperacjaOWartosciMin1000 implements Raport{

    @Override
    public ProduktBankowy visit(Lokata lokata) {
        
        List<OperacjaBankowa> historia = lokata.getHistoria();
        BigDecimal value = new BigDecimal("1000");
        
        if (historia.size() > 0)
        {
            for (OperacjaBankowa operacja : historia)
            {
                BigDecimal kwota = operacja.getKwota();
                if (kwota.compareTo(value) == 1 || kwota.compareTo(value) == 0)
                {
                    return lokata;
                }
            }
        }
        
        return null;
    }

    @Override
    public ProduktBankowy visit(KontoBankowe konto) {
        List<OperacjaBankowa> historia = konto.getHistoria();
        BigDecimal value = new BigDecimal("1000");
        
        if (historia.size() > 0)
        {
            for (OperacjaBankowa operacja : historia)
            {
                BigDecimal kwota = operacja.getKwota();
                if (kwota.compareTo(value) == 1 || kwota.compareTo(value) == 0)
                {
                    return konto;
                }
            }
        }
        
        return null;
    }

    @Override
    public ProduktBankowy visit(Pozyczka pozyczka) {
        List<OperacjaBankowa> historia = pozyczka.getHistoria();
        BigDecimal value = new BigDecimal("1000");
        
        if (historia.size() > 0)
        {
            for (OperacjaBankowa operacja : historia)
            {
                BigDecimal kwota = operacja.getKwota();
                if (kwota.compareTo(value) == 1 || kwota.compareTo(value) == 0)
                {
                    return pozyczka;
                }
            }
        }
        
        return null;
    }
    
}
