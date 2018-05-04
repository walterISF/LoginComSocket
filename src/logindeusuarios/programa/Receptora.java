package logindeusuarios.programa;

import java.net.ServerSocket;
import java.net.Socket;
import logindeusuarios.thread.Processo;

public class Receptora
{
    public static void main(String[] args)
    {

        try{
                //*****RECEPTORA*****
                ServerSocket pedido = new ServerSocket(33333);
                while(true)
                {
                    Socket conexao = pedido.accept();
                    Processo procThread = new Processo(conexao);
                }

        }
        catch (Exception erro)
        {
            System.err.println(erro.getMessage());
        }

    }
}