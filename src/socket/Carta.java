/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

import java.util.Objects;

/**
 *
 * @author vntwafi
 */
public class Carta 
{
    String valor;
    String nipe;
    
    public Carta(String valor, String nipe)
    {
        this.valor = valor;
        this.nipe = nipe;
    }

    /**
     * @return Retona numero ou letra da carta
     */
    public String getValor() 
    {
        return valor;
    }

    /**
     * @param valor recebe uma String do tipo valor para a carta
     */
    public void setValor(String valor) 
    {
        this.valor = valor;
    }

    /**
     * @return Retorna o nipe da carta sendo ele ouros, copas, espada e paus
     */
    public String getNipe() 
    {
        return nipe;
    }

    /**
     * @param nipe String que seja ela um nipe de baralho comum: ouros, copas, espada e paus
     */
    public void setNipe(String nipe) 
    {
        this.nipe = nipe;
    }

    @Override
    public int hashCode() 
    {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.valor);
        hash = 17 * hash + Objects.hashCode(this.nipe);
        return hash;
    }

    @Override
    public boolean equals(Object obj) 
    {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Carta other = (Carta) obj;
        if (!Objects.equals(this.valor, other.valor)) {
            return false;
        }
        if (!Objects.equals(this.nipe, other.nipe)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() 
    {
        return "Carta{" + "valor=" + valor + ", nipe=" + nipe + '}';
    }
 
}
