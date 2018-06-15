package client.programa;

import java.io.IOException;
import javax.swing.JFrame;
import client.ui.TelaLogin;
import client.saladejogo.ui.TelaPartida;

public class Transmissora
{
    public static void main(String[] args) throws IOException
    {
        JFrame frame = new JFrame("Login");
        TelaLogin loginPanel = new TelaLogin(frame);
    } 
}