/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logindeusuario.socket;

import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketTransmissora
{
    
    private final Solicitacao solicitacao;
    private Socket conexao;
    ObjectOutputStream transmissor;
    
    public SocketTransmissora(Solicitacao solicitacao)
    {
        this.solicitacao = solicitacao;
    }
    
    public void novaConexao()
    {
        try
        {
            conexao = new Socket("172.16.14.23", 33333);
            transmissor = new ObjectOutputStream(conexao.getOutputStream());

            do
            {
                    transmissor.writeObject(solicitacao);
                    transmissor.flush(); //envio imediato
            }
            while(!solicitacao.getComando().toUpperCase().equals("FIM"));

            transmissor.close();
            conexao.close();  
        }
        catch(Exception e)
        {
            System.out.println(e.getClass());
        }
    }
    
}
