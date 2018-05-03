/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logindeusuarios.socket;

import java.io.Serializable;

/**
 *
 * @author vntwafi
 */
public class Solicitacao implements Serializable 
{
    //TIPOS DE COMANDO
    //"CAD" -> complemento1: email, complemento2: nome, complemento3: senha;
    //"LOG" -> complemento1: email, complemento2: senha;
    //"SUC" -> sem complemento
    //"ERR" -> sem complemento
    
    private String comando, complemento1, complemento2, complemento3;

    public String getComando() {
        return comando;
    }
    //GETTERS
    public String getComplemento1() {return complemento1;}
    public String getComplemento2() {return complemento2;}
    public String getComplemento3() {return complemento3;}

    //SETTERS
    public void setComando(String comando) {this.comando = comando;}
    public void setComplemento1(String complemento1) {this.complemento1 = complemento1;}
    public void setComplemento2(String complemento2) {this.complemento2 = complemento2;}
    public void setComplemento3(String complemento3) {this.complemento3 = complemento3;}
    
    public Solicitacao (String cmd)
    {this.comando = cmd;}
    
    public Solicitacao (String cmd, String comp1)
    {this.comando = cmd; this.complemento1 = comp1;}
    
    public Solicitacao (String cmd, String comp1, String comp2)
    {this.comando = cmd; this.complemento1 = comp1; this.complemento1 = comp2;}

    public Solicitacao (String cmd, String comp1, String comp2, String comp3)
    {this.comando = cmd; this.complemento1 = comp1; this.complemento1 = comp2; this.complemento1 = comp3;}
    
}
