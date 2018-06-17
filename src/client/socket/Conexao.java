/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.DefaultListModel;

/**
 *
 * @author vntwafi
 */
public class Conexao 
{
    private volatile static Conexao INSTANCE = null;
    private static Socket socket = null;
    private static ObjectOutputStream out = null;
    private static ObjectInputStream in = null;
    private static final String ip = "127.0.0.1";
    private static final Integer port = 1234;
    private static DefaultListModel model = new DefaultListModel();
    private Conexao()
    {
        
    }
    
    public static synchronized Conexao getInstance()
    {
        if(INSTANCE == null)
            INSTANCE = new Conexao();
        
        return INSTANCE;
    }
    
    public static void startConnection() throws IOException
    {
        if(socket == null)
        {
            socket = new Socket(ip, port);
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
            System.out.println("Uma conexão foi estabelecida");
        }
    }
    
    public static void closeConnection() throws IOException
    {
        out.close();
        out = null;
        in.close();
        in = null;
        socket.close();
        socket = null;
        INSTANCE = null;
        System.out.println("Sua conexão foi encerrada");
        
    }

    public static synchronized ObjectOutputStream getOutputStream()
    {
        return out;
    }
    
    public static synchronized ObjectInputStream getInputStream()
    {
        return in;
    }
    
    public static synchronized Socket getSocket()
    {
        return socket;
    }

    public static DefaultListModel getModel() {
        return model;
    }

    public static void setModel(DefaultListModel model) {
        Conexao.model = model;
    }
    
}
