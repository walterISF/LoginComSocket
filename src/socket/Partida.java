/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

import bd.dbos.Usuario;
import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author vntwafi
 */
public class Partida 
{
    Usuario[] jogadores = new Usuario[8];
    Baralho[] baralho = new Baralho[2];
    float apostas;
    
    /**
     * Insira no minimo 3 jogares para iniciar uma partida
     * @param jogadores 
     */
    public Partida(Usuario[] jogadores)
    {
        this.jogadores = jogadores;
    }

    /**
     * @return Retorna os jogadores da partida 
     */
    public Usuario[] getJogadores() {
        return jogadores;
    }

    /**
     * @param jogadores Insere jogadores numa partida
     * @throws java.lang.Exception Excessao é disparada quando o numero de jogadores excede 8
     */
    public void setJogadores(Usuario[] jogadores) throws Exception
    {
        if(jogadores.length == 8)
            throw new Exception("A capacidade máxima de jogadores foi atingida");
        this.jogadores = jogadores;
    }

    /**
     * @return Retorna um Array de baralhos 
     */
    public Baralho[] getBaralho() {
        return baralho;
    }

    /**
     * Insira um ou dois baralhos
     * @param baralho 
     * @throws java.lang.Exception Excessao disparada caso haja uma tentativa de inserir mais de dois baralhos
     */
    public void setBaralho(Baralho[] baralho) throws Exception
    {
        if(this.baralho.length == 2)
            throw new Exception("Somente é permitida a inserção de dois baralhos por partida");
        this.baralho = baralho;
    }

    /**
     * @return Retorna o valor de apostas na partida
     */
    public float getApostas() {
        return apostas;
    }

    /**
     * @param apostas Insere uma aposta na partida
     */
    public void setApostas(float apostas) {
        this.apostas = apostas;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Arrays.deepHashCode(this.jogadores);
        hash = 59 * hash + Arrays.deepHashCode(this.baralho);
        hash = 59 * hash + Objects.hashCode(this.apostas);
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
        final Partida other = (Partida) obj;
        if (!Arrays.deepEquals(this.jogadores, other.jogadores)) {
            return false;
        }
        if (!Arrays.deepEquals(this.baralho, other.baralho)) {
            return false;
        }
        if (!Objects.equals(this.apostas, other.apostas)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Partida{" + "jogadores=" + jogadores + ", baralho=" + baralho + ", apostas=" + apostas + '}';
    }
    
}
