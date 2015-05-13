/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.miasi;

import com.bank.miasi.konta.Konto;
import com.bank.miasi.mediator.Mediator;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author nowekonto
 */
public class Bank {
    
    private List<Konto> konta;
    private String idBanku;
    private String nazwaBanku;
    private String adresBanku;
    protected Mediator mediator;
    
    public Bank (Mediator mediator, List <Konto> konta, String idBanku, String nazwaBanku, String adresBanku)
    {
       this.mediator = mediator;
       this.konta = konta;
       this.idBanku = idBanku;
       this.adresBanku = adresBanku;
       this.nazwaBanku = nazwaBanku;
       this.mediator.dodajBank(idBanku, this);
    }
    
    public Konto pobierzKonto(String numerKonta)
    {
        Konto kontoWynikowe = null;
        
        for (Konto konto : konta)
        {
            if (konto.getNumer().equals(numerKonta))
            {
               kontoWynikowe = konto; 
            }
        }
        
        return kontoWynikowe;
    }
    
    public void wyslijPrzelew(String numerKontaNadawcy, String numerKontaOdbiorcy, BigDecimal kwota)
    {
        mediator.przelejNaRachunek(numerKontaNadawcy, numerKontaOdbiorcy, kwota);
    }
}
