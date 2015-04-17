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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nowekonto
 */
public class RaportKontaOWiecejNiz2OperacjachBankowych implements Raport{

    @Override
    public ProduktBankowy visit(Lokata lokata) {
        
        List<OperacjaBankowa> historia = lokata.getHistoria();
        
        if (historia.size() > 2)
        {
            return lokata;
        }
        
        return null;
    }

    @Override
    public ProduktBankowy visit(KontoBankowe konto) {
        List<OperacjaBankowa> historia = konto.getHistoria();
        
        if (historia.size() > 2)
        {
            return konto;
        }
        
        return null;
    }

    @Override
    public ProduktBankowy visit(Pozyczka pozyczka) {
        List<OperacjaBankowa> historia = pozyczka.getHistoria();
        
        if (historia.size() > 2)
        {
            return pozyczka;
        }
        
        return null;
    }
    
}
