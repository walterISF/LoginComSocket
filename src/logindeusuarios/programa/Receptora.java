package logindeusuarios.programa;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import logindeusuarios.socket.Solicitacao;

public class Receptora
{
    public static void main(String[] args)
    {

        try{
                //*****RECEPTORA*****
                ServerSocket pedido = new ServerSocket(33333);
                Socket conexao = pedido.accept();											//por isso n„o È instanciada
                ObjectInputStream receptor = 
                new ObjectInputStream(conexao.getInputStream());

                Solicitacao recebido;
                recebido = (Solicitacao) receptor.readObject();
                System.out.println(recebido.toString());
        }
        catch (IOException | ClassNotFoundException erro)
        {
                System.err.println(erro.getMessage());
        }

    }
}