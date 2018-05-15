/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logindeusuarios.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

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
    private static final String ip = "172.16.13.80";
    private static final Integer port = 55555;
    
    
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
    
}
