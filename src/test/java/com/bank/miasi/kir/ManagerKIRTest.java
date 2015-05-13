/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bank.miasi.kir;

import com.bank.miasi.test.SymulatorZewnetrznegoKIR;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.reflect.*;
import java.math.BigDecimal;
import java.util.List;
/**
 *
 * @author Johnny
 */
public class ManagerKIRTest {
    
    private SymulatorZewnetrznegoKIR symulator;
    private ManagerKIR manager;
    
    public ManagerKIRTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        symulator = new SymulatorZewnetrznegoKIR();
        symulator.zasymuluj(symulator, 100);
        manager = new ManagerKIR(symulator, 4, "test");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of pobierzPaczki method, of class ManagerKIR.
     */
    @Test
    public void testPobierzPaczki() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
      
        System.out.println("pobierzPaczki");
      
        manager.pobierzPaczki();
        
        Field field = manager.getClass().getDeclaredField("listaPaczekDoWyslania");
        field.setAccessible(true);
        
        List<Paczka> lista = (List<Paczka>) field.get(manager);
                
        assertEquals(100, lista.size());
    }

    /**
     * Test of wyslijPaczki method, of class ManagerKIR.
     */
    @Test
    public void testWyslijPaczki() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        
        manager.pobierzPaczki();
        manager.wyslijPaczki();
        
        Field field = manager.getClass().getDeclaredField("listaPaczekDoWyslania");
        field.setAccessible(true);
        
        List<Paczka> lista = (List<Paczka>) field.get(manager);
                
        assertNull(lista);
    }

    /**
     * Test of przetworzPaczke method, of class ManagerKIR.
     */
    @Test
    public void testPrzetworzPaczke() {
        
       /* Przesylka przesylka = new Przesylka(BigDecimal.ZERO, null, null, null)
        System.out.println("przetworzPaczke");
        Przesylka przesylka = null;
        ManagerKIR instance = null;
        instance.przetworzPaczke(przesylka);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");*/
    }

    /**
     * Test of dodajPaczkeDoWyslania method, of class ManagerKIR.
     */
    @Test
    public void testDodajPaczkeDoWyslaniaTestPrzesylki() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        
        Przesylka przesylka = new Przesylka(new BigDecimal("1000"), "test", "123", "321");
        int idBankuDocelowego = 5;
        
        manager.dodajPaczkeDoWyslania(idBankuDocelowego, przesylka);
       
        Field field = manager.getClass().getDeclaredField("listaPaczekDoWyslania");
        field.setAccessible(true);
        
        List<Paczka> lista = (List<Paczka>) field.get(manager);
        
        // TODO review the generated test code and remove the default call to fail.
        int lastIndex = (lista.size() - 1);
        Paczka dodanaPaczka = lista.get(lastIndex);
        
        Field fieldPaczki = dodanaPaczka.getClass().getDeclaredField("przesylka");
        fieldPaczki.setAccessible(true);
        
        Przesylka testowana = (Przesylka) fieldPaczki.get(dodanaPaczka);
        
        assertEquals(przesylka, testowana);
    }
    
    @Test
    public void testDodajPaczkeDoWyslaniaTestIdBankuOdbiorcy() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        
        Przesylka przesylka = new Przesylka(new BigDecimal("1000"), "test", "123", "321");
        int idBankuDocelowego = 5;
        
        manager.dodajPaczkeDoWyslania(idBankuDocelowego, przesylka);
       
        Field field = manager.getClass().getDeclaredField("listaPaczekDoWyslania");
        field.setAccessible(true);
        
        List<Paczka> lista = (List<Paczka>) field.get(manager);
        
        // TODO review the generated test code and remove the default call to fail.
        int lastIndex = (lista.size() - 1);
        Paczka dodanaPaczka = lista.get(lastIndex);
        
        Field fieldPaczki = dodanaPaczka.getClass().getDeclaredField("idBankuOdbiorcy");
        fieldPaczki.setAccessible(true);
        
        int idBankuOdbiorcyTest = (int) fieldPaczki.get(dodanaPaczka);
        
        assertEquals(idBankuDocelowego, idBankuOdbiorcyTest);
    }
    
}
