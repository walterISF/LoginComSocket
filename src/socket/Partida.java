/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

import bd.dbos.Usuario;

/**
 *
 * @author vntwafi
 */
public class Partida 
{
    private String nome;
    private enum status { INICIADA, JOGANDO };
    private Float valorMesa;
    private Lista<Usuario> jogares;
    private Lista<Baralho> baralhos;

    public Partida(String nome)
    {
        this.setNome(nome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getValorMesa() {
        return valorMesa;
    }

    public void setValorMesa(Float valorMesa) {
        this.valorMesa = valorMesa;
    }

    public Lista<Usuario> getJogares() {
        return jogares;
    }

    public void setJogares(Lista<Usuario> jogares) {
        this.jogares = jogares;
    }

    public Lista<Baralho> getBaralhos() {
        return baralhos;
    }

    public void setBaralhos(Lista<Baralho> baralhos) {
        this.baralhos = baralhos;
    }

}
