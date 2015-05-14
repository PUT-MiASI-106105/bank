/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.miasi.service;

import com.bank.miasi.Bank;
import com.bank.miasi.Klient;
import com.bank.miasi.konta.Konto;
import com.bank.miasi.konta.KontoBankowe;
import com.bank.miasi.konta.Lokata;
import com.bank.miasi.konta.Pozyczka;
import com.bank.miasi.konta.typy.KontoWygodne;
import com.bank.miasi.konta.typy.LokataOptymalna;
import com.bank.miasi.konta.typy.LokataRoczna;
import com.bank.miasi.mediator.PrzelewyMediator;
import com.bank.miasi.wizytator.ProduktBankowy;
import com.bank.miasi.wizytator.Raport;
import com.bank.miasi.wizytator.RaportKontaTypLokataRoczna;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;

/**
 *
 * @author Krzysztof
 */
public class BankControllerTest {
    
    public BankControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }


    @org.junit.Test
    public void testMediator() {
        
        PrzelewyMediator mediator = new PrzelewyMediator();
        
        Klient klient1 = new Klient("krzychu", "nowak", "ccc", "92012812173", "nip", "783874334", BigDecimal.valueOf(4000.00));
        Klient klient2 = new Klient("krzychu", "kowalski", "ccc", "92012812133", "nip", "783874434", BigDecimal.valueOf(3000.00)); 
        KontoBankowe konto = new KontoBankowe(new KontoWygodne(), "02123", klient1);
        KontoBankowe konto2 = new KontoBankowe(new KontoWygodne(), "02124", klient2);
        
        List<Konto> listaKontDlaBankuB1 = new ArrayList<>();
        listaKontDlaBankuB1.add(konto);
        listaKontDlaBankuB1.add(konto2);
        
        Klient klient3 = new Klient("andrzej", "nowak", "ccc", "91012812173", "nip", "783874384", BigDecimal.valueOf(4000.00));
        Klient klient4 = new Klient("andrzej", "kowalski", "ccc", "95012812133", "nip", "783874554", BigDecimal.valueOf(3000.00)); 
        KontoBankowe konto3 = new KontoBankowe(new KontoWygodne(), "04113", klient3 );
        KontoBankowe konto4 = new KontoBankowe(new KontoWygodne(), "04124", klient4);
        
        List<Konto> listaKontDlaBankuB2 = new ArrayList<>();
        listaKontDlaBankuB2.add(konto3);
        listaKontDlaBankuB2.add(konto4);
        
        Bank b1 = new Bank(mediator, listaKontDlaBankuB1, "02", "BZWBK", "test");
        Bank b2 = new Bank(mediator, listaKontDlaBankuB2, "04", "PKO", "test");
        
        mediator.przelejNaRachunek("02124", "04113", new BigDecimal("100.0"));
        
        assertEquals(new BigDecimal("100.0"), b2.pobierzKonto("04113").getStan());
    }
    
    @org.junit.Test
    public void testRaportStan() {
        
        List<ProduktBankowy> result = new ArrayList<>();
        List<ProduktBankowy> products = new ArrayList<>();
        List<ProduktBankowy> expected = new ArrayList<>();
        
        Klient klient1 = new Klient("imie", "nazwisko", "adres", "pesel", "nip", "numer", BigDecimal.ZERO);
        products.add(new Lokata(new LokataRoczna(), "12345", klient1, new BigDecimal("1000")));
        expected.add(new Lokata(new LokataRoczna(), "12345", klient1, new BigDecimal("1000")));
        
        products.add(new Lokata(new LokataRoczna(), "12345", klient1, new BigDecimal("2000")));
        expected.add(new Lokata(new LokataRoczna(), "12345", klient1, new BigDecimal("2000")));
        
        products.add(new Lokata(new LokataRoczna(), "12345", klient1, new BigDecimal("4000")));
        expected.add(new Lokata(new LokataRoczna(), "12345", klient1, new BigDecimal("4000")));
        
        products.add(new Pozyczka(new LokataOptymalna(), "12345", klient1, new BigDecimal("5000")));
        
        products.add(new KontoBankowe(new LokataRoczna(), "12345", klient1));
        expected.add(new KontoBankowe(new LokataRoczna(), "12345", klient1));
        
        Raport report = new RaportKontaTypLokataRoczna();
        
        for (ProduktBankowy product : products) { 
            
            ProduktBankowy productObject = product.accept(report);
            
            if (productObject != null)
            {
                result.add(productObject);
            }
        }
        
        assertEquals(expected.size(), result.size());
    }
}
