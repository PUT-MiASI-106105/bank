/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bank.miasi;

import com.bank.miasi.konta.typy.KontoWygodne;
import com.bank.miasi.konta.typy.LokataOptymalna;
import com.bank.miasi.konta.typy.LokataRoczna;
import com.bank.miasi.konta.typy.TypKonta;
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
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of obliczOdsetki method, of class Odsetki.
     */
    @org.junit.Test
    public void testObliczOdsetkiLokataRoczna() {
        System.out.println("obliczOdsetki");
        BigDecimal stanKonta = new BigDecimal(1000);
        LokataRoczna lokata = new LokataRoczna();
        
        TypKonta typKonta = null;
        BigDecimal expResult = new BigDecimal("20.00");
        
        OdsetkiStateLokataRoczna odsetki = new OdsetkiStateLokataRoczna();
        BigDecimal result = odsetki.obliczOdsetki(stanKonta, lokata);
        assertEquals(expResult, result);
    }
    
    @org.junit.Test
    public void testObliczOdsetkiLokataOptymalna() {
        BigDecimal stanKonta = new BigDecimal("1000");
        LokataOptymalna lokata = new LokataOptymalna();
        
        BigDecimal expResult = new BigDecimal("0.59");
        
        OdsetkiStateLokataOptymalna odsetki = new OdsetkiStateLokataOptymalna();
        BigDecimal result = odsetki.obliczOdsetki(stanKonta, lokata);
        assertEquals(expResult, result);
    }
    
    @org.junit.Test
    public void testObliczOdsetkiKontoWygodne() {
        BigDecimal stanKonta = new BigDecimal("1000");
        KontoWygodne konto = new KontoWygodne();
        
        BigDecimal expResult = new BigDecimal("0.00");
        OdsetkiStateKontoWygodne odsetki = new OdsetkiStateKontoWygodne();
        BigDecimal result = odsetki.obliczOdsetki(stanKonta, konto);
        assertEquals(expResult, result);
    }
    
    @org.junit.Test
    public void testObliczOdsetkiLokataRoczna100000PLN59GR() {
        
        System.out.println("obliczOdsetki");
        
         LokataRoczna lokata = new LokataRoczna();
         BigDecimal stanKonta = new BigDecimal("100000.59");
        
        OdsetkiStateLokataRoczna odsetki = new OdsetkiStateLokataRoczna();
        
        BigDecimal expResult = new BigDecimal("2000.01");
    
        BigDecimal result = odsetki.obliczOdsetki(stanKonta, lokata);
        assertEquals(expResult, result);
    }
    
    @org.junit.Test
    public void testObliczOdsetkiLokataOptymalna100000PLN59GR() {
        BigDecimal stanKonta = new BigDecimal("100000.59");
        LokataOptymalna lokata = new LokataOptymalna();
        
        BigDecimal expResult = new BigDecimal("59.45");
        OdsetkiStateLokataOptymalna odsetki = new OdsetkiStateLokataOptymalna();
        BigDecimal result = odsetki.obliczOdsetki(stanKonta, lokata);
        assertEquals(expResult, result);
    }
}
