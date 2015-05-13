/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.chainsOfResponsibility;

import com.bank.miasi.OperacjaBankowa;
import com.bank.miasi.exceptions.NiewspieranaOperacja;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nowekonto
 */
public class NumerKontaFilter extends Filter {

    public NumerKontaFilter(OperacjaBankowa operacja) {
        super(operacja);
    }
    
    @Override
    public void wykonajFilter()
    {
        if (operacjaBankowa.getDoKogo().getNumer() == null)
        {
            System.err.println("Brak numeru konta odbiorcy");
        }
        else
        {
            try {
                operacjaBankowa.wykonajOperacjePoFiltrowaniu();
            } catch (NiewspieranaOperacja ex) {
                Logger.getLogger(NumerKontaFilter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
