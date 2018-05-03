package logindeusuarios.programa;

import javax.swing.JFrame;
import logindeusuarios.ui.TelaLogin;

public class Programa
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Login");
        TelaLogin loginPanel = new TelaLogin(frame);  
    } 
}