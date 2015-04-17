package com.bank.miasi.service;

import com.bank.miasi.Klient;
import com.bank.miasi.OperacjaBankowa;
import com.bank.miasi.dekorator.KontoBankoweDekorator;
import com.bank.miasi.exceptions.NiewspieranaOperacja;
import com.bank.miasi.wizytator.ProduktBankowy;
import com.bank.miasi.wizytator.Raport;
import com.bank.miasi.wizytator.RaportKontaTypLokataRoczna;
import com.bank.miasi.wizytator.RaportStan;
import com.bank.miasi.kir.ManagerKIR;
import com.bank.miasi.konta.Konto;
import com.bank.miasi.konta.KontoBankowe;
import com.bank.miasi.konta.Lokata;
import com.bank.miasi.konta.Pozyczka;
import com.bank.miasi.konta.typy.KontoWygodne;
import com.bank.miasi.konta.typy.LokataOptymalna;
import com.bank.miasi.konta.typy.LokataRoczna;
import com.bank.miasi.operacje.PrzelewWychodzacy;
import com.bank.miasi.test.SymulatorZewnetrznegoKIR;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Krzysztof
 */
public class BankController {

    public static List<ProduktBankowy> przygotujRaport(Raport report, List<ProduktBankowy> products)
    {
        List<ProduktBankowy> result = new ArrayList<ProduktBankowy>();
        
        for (ProduktBankowy product : products) { 
            result.add(product.accept(report));
        }
        
        return result;
    }
    
    public static void sprawdzDekorator()
    {
       Klient klient1 = new Klient("imie", "nazwisko", "adres", "pesel", "nip", "numer", BigDecimal.ZERO);
       KontoBankowe konto = new KontoBankowe(new LokataRoczna(), "12345", klient1); 
       KontoBankoweDekorator dekorator = new KontoBankoweDekorator(konto);
       dekorator.wypiszWlascicielaIStanDebetu();
    }

    
    public static void main(String[] args) {
        
        List<ProduktBankowy> result = new ArrayList<ProduktBankowy>();
        List<ProduktBankowy> products = new ArrayList<ProduktBankowy>();
        
        Klient klient1 = new Klient("imie", "nazwisko", "adres", "pesel", "nip", "numer", BigDecimal.ZERO);
        products.add(new Lokata(new LokataRoczna(), "12345", klient1, new BigDecimal("1000")));
        products.add(new Lokata(new LokataRoczna(), "12345", klient1, new BigDecimal("2000")));
        products.add(new Lokata(new LokataRoczna(), "12345", klient1, new BigDecimal("4000")));
        products.add(new Pozyczka(new LokataOptymalna(), "12345", klient1, new BigDecimal("5000")));
        products.add(new KontoBankowe(new LokataRoczna(), "12345", klient1));
        
        Raport report = new RaportStan();
        result = BankController.przygotujRaport(report, products);
        
        report = new RaportKontaTypLokataRoczna();
        result = BankController.przygotujRaport(report, products);
        
        BankController.sprawdzDekorator();
        
        /*Klient krzychu = new Klient("krzychu", "Pawlak", "ccc", "92012812173", "nip", "783874334", BigDecimal.valueOf(4000.00));
        Klient jakub = new Klient("Jakub", "Pawlak", "ccc", "92012812173", "nip", "783874334", BigDecimal.valueOf(4000.00));
        KontoBankowe nadawca = new KontoBankowe(new KontoWygodne(), "1111", krzychu);
        KontoBankowe odbiorca = new KontoBankowe(new KontoWygodne(), "1111", jakub);
        try {
            ManagerKIR managerKIR = new ManagerKIR(new SymulatorZewnetrznegoKIR(), 4, "test");
            OperacjaBankowa.wykonajOperacje(managerKIR,BigDecimal.valueOf(120.10), new PrzelewWychodzacy(), "tt", nadawca, odbiorca);
        } catch (NiewspieranaOperacja ex) {
            ex.printStackTrace();
        }*/
    }
}
