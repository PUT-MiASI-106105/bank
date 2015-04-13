package com.bank.miasi;

import com.bank.miasi.konta.typy.TypKonta;
import java.math.BigDecimal;

public class Odsetki {

   private OdsetkiState odstate;
   public Odsetki(OdsetkiState st)
   {
       setState(st);
   }
   public void setState(final OdsetkiState newState) {
        odstate = newState;
    }
   
    public BigDecimal obliczOdsetki(BigDecimal stanKonta,TypKonta typKonta) {
        return odstate.obliczOdsetki( stanKonta, typKonta);
    }
    

}
