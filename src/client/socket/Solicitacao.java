/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.socket;

/**
 *
 * @author vntwafi
 */
import java.io.Serializable;
import java.util.Objects;

public class Solicitacao implements Serializable 
{
    //TIPOS DE COMANDO
    //"CAD" -> complemento1: email, complemento2: nome, complemento3: senha;
    //"LOG" -> complemento1: email, complemento2: senha;
    //"CRI" -> complemento1: nova Partida
    //"PAR" -> complemento1: nome da Partida, complemento 2: Status
    //"APO" -> Valor da Aposta
    //"CAR" -> complemento1: Naipe, complemento2: Valor
    //"COM" -> sem complemento
    //"EOP" -> sem complemento
    //"SUC" -> sem complemento
    //"ERR" -> sem complemento
    //"WIN" -> complemento1: Nome Jogador, complemento2: email Jogador
    //"EOW" -> complemento1: Saldo atualizado do jogador
    //"SAI" -> sem complemento
    
    private String comando, complemento1, complemento2, complemento3;

    public String getComando() 
    {
        return comando;
    }
    //GETTERS
    /**
     * 
     * @return Retorna uma String que pode ser um nome, email ou senha
     */
    public String getComplemento1() {return complemento1;}
    /**
     * 
     * @return Retorna uma String que pode ser um nome, email ou senha
     */
    public String getComplemento2() {return complemento2;}
    /**
     * 
     * @return Retorna uma String que pode ser um nome, email ou senha 
     */
    public String getComplemento3() {return complemento3;}

    //SETTERS
    /**
     * Insira um comando
     * @param comando O comando pode ser do tipo "SUC", "ERR", "CAD", "LOG"
     */
    public void setComando(String comando) {this.comando = comando;}
    /**
     * Insira uma String que pode ser um nome, email ou senha dependendo do construtor
     * @param complemento1 
     */
    public void setComplemento1(String complemento1) {this.complemento1 = complemento1;}
    /**
     * Insira uma String que pode ser um nome, email ou senha dependendo do construtor
     * @param complemento2 
     */
    public void setComplemento2(String complemento2) {this.complemento2 = complemento2;}
    /**
     * Insira uma String que pode ser um nome, email ou senha dependendo do construtor
     * @param complemento3 
     */
    public void setComplemento3(String complemento3) {this.complemento3 = complemento3;}
    
    /**
     * Utilize estre contrutor caso necessite enviar somente um comando do tipo "SUC" e "ERR"
     * @param cmd O comando pode ser do tipo "SUC", "ERR"
     */
    public Solicitacao (String cmd)
    {this.comando = cmd;}
    
    /**
     * Utilize este construtor caso necessite enviar um comando e somente seu nome
     * @param cmd O comando pode ser do tipo "SUC", "ERR", "CAD", "LOG"
     * @param comp1 String nome
     */
    public Solicitacao (String cmd, String comp1)
    {this.comando = cmd; this.complemento1 = comp1;}
    
    /**
     * Utilize este construtor caso necessite enviar dados de login como email e senha
     * @param cmd O comando pode ser do tipo "SUC", "ERR", "CAD", "LOG"
     * @param comp1 String email
     * @param comp2 String senha
     */
    public Solicitacao (String cmd, String comp1, String comp2)
    {this.comando = cmd; this.complemento1 = comp1; this.complemento2 = comp2;}

    /**
     * Utilize este contrutor caso necessite enviar dados de um cadastro
     * @param cmd O comando pode ser do tipo "SUC", "ERR", "CAD", "LOG"
     * @param comp1 String nome
     * @param comp2 String email
     * @param comp3 String senha
     */
    public Solicitacao (String cmd, String comp1, String comp2, String comp3)
    {this.comando = cmd; this.complemento1 = comp1; this.complemento2 = comp2; this.complemento3 = comp3;}

    @Override
    public String toString() 
    {
        return "Solicitacao{" + "comando=" + this.comando + ", complemento1=" + this.complemento1 + ", complemento2=" + this.complemento2 + ", complemento3=" + this.complemento3 + '}';
    }
        
    @Override
    public int hashCode() 
    {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.comando);
        hash = 83 * hash + Objects.hashCode(this.complemento1);
        hash = 83 * hash + Objects.hashCode(this.complemento2);
        hash = 83 * hash + Objects.hashCode(this.complemento3);
        return hash;
    }

    @Override
    public boolean equals(Object obj) 
    {
        if (this == obj) 
        {
            return true;
        }
        if (obj == null) 
        {
            return false;
        }
        if (getClass() != obj.getClass()) 
        {
            return false;
        }
        final Solicitacao other = (Solicitacao) obj;
        if (!Objects.equals(this.comando, other.comando)) 
        {
            return false;
        }
        if (!Objects.equals(this.complemento1, other.complemento1)) 
        {
            return false;
        }
        if (!Objects.equals(this.complemento2, other.complemento2)) 
        {
            return false;
        }
        if (!Objects.equals(this.complemento3, other.complemento3)) 
        {
            return false;
        }
        return true;
    }
    
}
