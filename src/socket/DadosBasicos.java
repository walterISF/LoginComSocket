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
public class DadosBasicos 
{
    private static Lista<Partida> partidas;
    
    public static void Init()
    {
        if(partidas == null)
        {
            partidas = new Lista<>();
        }
    }

    public static Lista<Partida> getPartidas() {
        return partidas;
    }

    public static void setPartidas(Lista<Partida> partidas) {
        DadosBasicos.partidas = partidas;
    }
    
    
}
