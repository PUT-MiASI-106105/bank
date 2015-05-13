/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.miasi;

import com.bank.miasi.konta.Konto;
import com.bank.miasi.konta.KontoBankowe;
import com.bank.miasi.konta.typy.KontoWygodne;
import com.bank.miasi.konta.typy.LokataRoczna;
import com.bank.miasi.mediator.PrzelewyMediator;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kuba
 */
public class BankTest {
    
    public BankTest() {
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
     * Test of pobierzKonto method, of class Bank.
     */
    @Test
    public void testPobierzKonto() {
        
       PrzelewyMediator mediator = new PrzelewyMediator();
        
       Klient testowyKlient = new Klient("imie", "nazwisko", "adres", "pesel", "nip", "numer", BigDecimal.ZERO);
       
       String testowyNumerKonta = "12345";
       
       KontoBankowe kontoTestowe = new KontoBankowe(new LokataRoczna(), testowyNumerKonta, testowyKlient); 
       
       List<Konto> listaTestowychKont = new ArrayList<>();
       listaTestowychKont.add(kontoTestowe);
       String idTestoweBanku = "01";
       
        Bank bank = new Bank(mediator, listaTestowychKont, idTestoweBanku, "Testowa Nazwa", "Adres testowy");
        
        Konto znalezioneKonto = bank.pobierzKonto(testowyNumerKonta);

        assertEquals(kontoTestowe.getNumer(), znalezioneKonto.getNumer());
    }

    /**
     * Test of wyslijPrzelew method, of class Bank.
     */
    @Test
    public void testWyslijPrzelew() {
        PrzelewyMediator mediator = new PrzelewyMediator();
        PrzelewyMediator mediatorBankuDocelowego = new PrzelewyMediator();
        
       Klient testowyKlientBankuB = new Klient("imie", "nazwisko", "adres", "pesel", "nip", "numer", BigDecimal.ZERO);
       String testowyNumerKontaBankuB = "12345";
       KontoBankowe kontoTestowe = new KontoBankowe(new KontoWygodne(), testowyNumerKontaBankuB, testowyKlientBankuB); 
       List<Konto> listaTestowychKontBankuA = new ArrayList<>();
       listaTestowychKontBankuA.add(kontoTestowe);
       
       String idTestoweBanku = "12";
       Bank bankDocelowyTestowy = new Bank(mediatorBankuDocelowego, listaTestowychKontBankuA, idTestoweBanku, "Testowa Nazwa", "Adres testowy");
       mediator.dodajBank("12", bankDocelowyTestowy);
       
       BigDecimal kwotaTestowa = new BigDecimal(200);
        
       Bank bankNadawca = new Bank(mediator, null, "02", "BANK TESTOWY", "ADRES");
       
        bankNadawca.wyslijPrzelew("02567", testowyNumerKontaBankuB, kwotaTestowa);
        
        Konto kontoPoPrzelewie = bankDocelowyTestowy.pobierzKonto("12345");

        assertEquals(kwotaTestowa, kontoPoPrzelewie.getStan());
    }
    
}
