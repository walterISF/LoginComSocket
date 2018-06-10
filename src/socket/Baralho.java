/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;
/**
 *
 * @author vntwafi
 */
public class Baralho 
{
    Lista<Carta> cartas;
    
    public Baralho(Lista<Carta> cartas)
    {
        this.cartas = cartas;
    }

    public Lista<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(Lista<Carta> cartas) {
        this.cartas = cartas;
    }
  
}