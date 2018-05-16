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
public class Jogada 
{
    float aposta;
    Carta[] cartas;
    boolean comprar, parar;
    
    public Jogada()
    {
        this.aposta = 0;
        this.comprar = false;
        this.parar = false;
        this.cartas = new Carta[2];
    }
    
    /**
     * @return Retorna um valor da aposta da jogada
     */
    public float getAposta() {
        return aposta;
    }

    /**
     * @param aposta Insira um valor de aposta do tipo float primitivo
     */
    public void setAposta(float aposta) {
        this.aposta = aposta;
    }

    /**
     * @return Retorna um Array de cartas da joagada
     */
    public Carta[] getCartas() {
        return cartas;
    }

    /**
     * @param cartas Insira um array de cartas
     */
    public void setCartas(Carta[] cartas) {
        this.cartas = cartas;
    }

    /**
     * @return Retorna um boolean da compra de castras da jogada
     */
    public boolean isComprar() {
        return comprar;
    }

    /**
     * @param comprar Insira um valor boolean para comprar ou nao uma carta
     */
    public void setComprar(boolean comprar) {
        this.comprar = comprar;
    }

    /**
     * @return Retorna um boolean para parar ou nao de jogar
     */
    public boolean isParar() {
        return parar;
    }

    /**
     * @param parar Inserir um boolean sendo true ou false para parar de jogar
     */
    public void setParar(boolean parar) {
        this.parar = parar;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Float.floatToIntBits(this.aposta);
        hash = 53 * hash + Arrays.deepHashCode(this.cartas);
        hash = 53 * hash + (this.comprar ? 1 : 0);
        hash = 53 * hash + (this.parar ? 1 : 0);
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
        final Jogada other = (Jogada) obj;
        if (Float.floatToIntBits(this.aposta) != Float.floatToIntBits(other.aposta)) {
            return false;
        }
        if (this.comprar != other.comprar) {
            return false;
        }
        if (this.parar != other.parar) {
            return false;
        }
        if (!Arrays.deepEquals(this.cartas, other.cartas)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Jogada{" + "aposta=" + aposta + ", cartas=" + cartas.toString() + ", comprar=" + comprar + ", parar=" + parar + '}';
    }
    
    
}
