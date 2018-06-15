/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.socket;

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
    
    public static Partida getUmaPartida(String nomePartida)
    {     
        return DadosBasicos.partidas.getPartida(nomePartida);
    }
    
    public static void setUmaPartida(Partida partida) throws Exception
    {
        DadosBasicos.partidas.inserirNoFim(partida);
    }
    
    
}
