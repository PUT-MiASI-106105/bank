/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.chainsOfResponsibility;

import com.bank.miasi.OperacjaBankowa;

/**
 *
 * @author nowekonto
 */
public abstract class Filter {
    
    protected Filter nastepnyFilter;
    protected OperacjaBankowa operacjaBankowa;
    
    public Filter (OperacjaBankowa operacja)
    {
        operacjaBankowa = operacja;
    }
    
    public void wykonajFilter()
    {
        
    }
}
