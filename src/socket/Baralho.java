/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

import java.util.Arrays;

/**
 *
 * @author vntwafi
 */
public class Baralho 
{
    Carta[] item = new Carta[52];
    
    public Baralho()
    {
        
    }

    /**
     * @return Retorna um baralho
     */
    public Carta[] getItem() {
        return item;
    }

    /**
     * @param item Insira uma lista de Cartas para o baralho
     */
    public void setItem(Carta[] item) {
        this.item = item;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Arrays.deepHashCode(this.item);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Baralho other = (Baralho) obj;
        if (!Arrays.deepEquals(this.item, other.item)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Baralho{" + "item=" + item.toString() + '}';
    }
    
    
}
