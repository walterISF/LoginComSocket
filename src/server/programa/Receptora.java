package server.programa;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import server.socket.DadosBasicos;
import thread.Processo;

public class Receptora
{
    public static void main(String[] args)
    {
        DadosBasicos.Init();

        try{
                //*****RECEPTORA*****
                ServerSocket pedido = new ServerSocket(12346);
                System.out.println("Servidor online!");
                while(true)
                {
                    Socket conexao = pedido.accept();
                    Processo procThread = new Processo(conexao);
                    procThread.start();
                }

        }
        catch (IOException erro)
        {
            System.err.println(erro.getMessage());
        }

    }
}