/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

import bd.dbos.Usuario;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vntwafi
 */
public class Partida 
{

    public enum Status { INICIADA, JOGANDO };
    private String nome;
    private Status status;
    private Float valorMesa;
    private Lista<Usuario> jogares;
    private Lista<Baralho> baralhos;

    
    public Partida(String nome)
    {
        this.setNome(nome);
        this.setValorMesa(0.0F);
        initBaralho(this.baralhos);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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
    
    public void initBaralho(Lista<Baralho> baralhos)
    {
        try 
        {
            Lista<Carta> cartas = new Lista<>();
            baralhos.inserirNoFim(new Baralho(cartas));
            String[] nipes = {"copas", "espadas", "paus", "ouro"};
            String valor;
            for (String nipe : nipes) 
            {
                for (int j = 1; j<=13; j++) 
                {
                    valor = j+"";
                    if(j==11)
                        valor = "dama";
                    if(j==12)
                        valor = "valete";
                    if(j==13)
                        valor = "rei";
                    Carta carta = new Carta(valor, nipe);
                    cartas.inserirNoFim(carta);
                }
            }  
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(Partida.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public Carta getCarta(Baralho baralho)
    {
        Lista<Carta> cartas = baralho.getCartas();
        Random r = new Random();
        int Low = 1;
        int High = cartas.getQtdElems();
        int Result = r.nextInt(High-Low) + Low;
        try 
        {
            return cartas.removerDoMeio(Result);
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(Partida.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public void addJogador(Usuario user) throws Exception
    {
        if(this.jogares == null)
            throw new Exception("Lista não existe");
        
        this.jogares.inserirNoFim(user);
        
    }
    public void addMoedas(Float valor) throws Exception
    {
        if(valor == null)
            throw new Exception("valor invalido");
        
        this.valorMesa+= valor;
    }
}
