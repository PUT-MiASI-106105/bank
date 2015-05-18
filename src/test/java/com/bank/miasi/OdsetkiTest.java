/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bank.miasi;

import com.bank.di.DodajModul;
import com.bank.miasi.konta.typy.KontoWygodne;
import com.bank.miasi.konta.typy.LokataOptymalna;
import com.bank.miasi.konta.typy.LokataRoczna;
import com.bank.miasi.konta.typy.TypKonta;
import com.google.inject.Guice;
import com.google.inject.Injector;
import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;

/**
 *
 * @author Johnny
 */
public class OdsetkiTest {
    
    private Injector injector;
    
    public OdsetkiTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        injector = Guice.createInjector(new DodajModul());
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of obliczOdsetki method, of class Odsetki.
     */
    @org.junit.Test
    public void testObliczOdsetkiLokataRoczna() {
         
       OdsetkiStateLokataRoczna odsetki = injector.getInstance(OdsetkiStateLokataRoczna.class);
       BigDecimal stanKonta = new BigDecimal(1000);
       BigDecimal expResult = new BigDecimal("20.00");
       
       LokataRoczna lokata = injector.getInstance(LokataRoczna.class);
       
       BigDecimal result = odsetki.obliczOdsetki(stanKonta, lokata);

        assertEquals(expResult, result);
    }
    
    @org.junit.Test
    public void testObliczOdsetkiLokataOptymalna() {
        BigDecimal stanKonta = new BigDecimal("1000");
        
        OdsetkiStateLokataOptymalna odsetki = injector.getInstance(OdsetkiStateLokataOptymalna.class);
        LokataOptymalna lokata = injector.getInstance(LokataOptymalna.class);
        BigDecimal expResult = new BigDecimal("0.29");
        BigDecimal result = odsetki.obliczOdsetki(stanKonta, lokata);
        assertEquals(expResult, result);
    }
    
    @org.junit.Test
    public void testObliczOdsetkiKontoWygodne() {
        BigDecimal stanKonta = new BigDecimal("1000");

        OdsetkiStateKontoWygodne odsetki = injector.getInstance(OdsetkiStateKontoWygodne.class);
        KontoWygodne konto = injector.getInstance(KontoWygodne.class);
        BigDecimal expResult = new BigDecimal("0.00");
        BigDecimal result = odsetki.obliczOdsetki(stanKonta, konto);
        
        assertEquals(expResult, result);
    }
    
    @org.junit.Test
    public void testObliczOdsetkiLokataRoczna100000PLN59GR() {
        
        System.out.println("obliczOdsetki");
        
         LokataRoczna lokata = injector.getInstance(LokataRoczna.class);
         BigDecimal stanKonta = new BigDecimal("100000.59");
        
        OdsetkiStateLokataRoczna odsetki = injector.getInstance(OdsetkiStateLokataRoczna.class);
        
        BigDecimal expResult = new BigDecimal("2000.01");
    
        BigDecimal result = odsetki.obliczOdsetki(stanKonta, lokata);
        assertEquals(expResult, result);
    }
    
    @org.junit.Test
    public void testObliczOdsetkiLokataOptymalna100000PLN59GR() {
        BigDecimal stanKonta = new BigDecimal("100000.59");
        LokataOptymalna lokata = injector.getInstance(LokataOptymalna.class);
        OdsetkiStateLokataOptymalna odsetki = injector.getInstance(OdsetkiStateLokataOptymalna.class);
        BigDecimal expResult = new BigDecimal("29.72");
        
        BigDecimal result = odsetki.obliczOdsetki(stanKonta, lokata);
        assertEquals(expResult, result);
    }
}
