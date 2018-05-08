package logindeusuarios.programa;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.JFrame;
import logindeusuarios.socket.Conexao;
import logindeusuarios.ui.TelaLogin;

public class Transmissora
{
    public static void main(String[] args) throws IOException
    {
        JFrame frame = new JFrame("Login");
        TelaLogin loginPanel = new TelaLogin(frame);
        
          
    } 
}