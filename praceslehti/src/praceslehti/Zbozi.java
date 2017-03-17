/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praceslehti;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 *
 * @author DOMA
 */
public class Zbozi {
    public String jmeno;
   public int pocet;
   public int cena;
    
    
    Zbozi ( String jmeno , int cena , int pocet ){
    this.jmeno =jmeno;
    this.pocet = pocet;
    this.cena= cena;
    
}
     public String getjmeno()
        {
                return jmeno;
        }

        public void setjmeno(String jmeno) {
                this.jmeno = jmeno;
        }

    public String toString() {
        return jmeno;
    }
}
