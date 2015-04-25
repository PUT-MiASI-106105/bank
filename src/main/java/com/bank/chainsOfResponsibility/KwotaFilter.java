/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.chainsOfResponsibility;

import com.bank.miasi.OperacjaBankowa;
import java.math.BigDecimal;

/**
 *
 * @author nowekonto
 */
public class KwotaFilter extends Filter{
    
    
    public KwotaFilter(OperacjaBankowa operacja)
    {
        super(operacja);
       nastepnyFilter = new TytulFilter(operacja); 
    }
    
    public void wykonajFilter()
    {
        BigDecimal kwota = new BigDecimal("20000");
        if (operacjaBankowa.getKwota().compareTo(kwota) > 0)
        {
            System.err.println("Przelew trafia do wyjasnienia");
        }
        else
        {
            nastepnyFilter.wykonajFilter();
        }
    }
   
}
