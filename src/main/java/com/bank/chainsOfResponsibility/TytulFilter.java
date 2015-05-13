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
public class TytulFilter extends Filter{
    
    public TytulFilter(OperacjaBankowa operacja)
    {
       super(operacja);
       nastepnyFilter = new NumerKontaFilter(operacja); 
    }
    
    /**
     *
     */
    @Override
    public void wykonajFilter()
    {
        if (operacjaBankowa.getTytul() == null)
        {
            System.err.println("Przelew nie ma tytułu");
        }
        else
        {
            nastepnyFilter.wykonajFilter();
        }
    }
    
}
