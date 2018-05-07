package logindeusuarios.programa;

import java.io.IOException;
import java.net.Socket;
import javax.swing.JFrame;
import logindeusuarios.ui.TelaLogin;

public class Transmissora
{
    public static void main(String[] args) throws IOException
    {
        JFrame frame = new JFrame("Login");
        Socket conexao = new Socket("192.168.15.19", 2222);
        TelaLogin loginPanel = new TelaLogin(frame, conexao);
        
          
    } 
}