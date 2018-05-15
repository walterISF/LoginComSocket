/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logindeusuario.socket;
/**
 *
 * @author Calebe
 */
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Cliente implements Runnable{
    
    private Socket cliente;
    private final BlockingQueue<String> outputQueue;
    
    public Cliente(Socket cliente){
        this.cliente = cliente;
        this.outputQueue = new LinkedBlockingDeque<>();
    }
    void start(){
    new Thread(this).start();
    }
    void send(String data, ObjectOutputStream output) {
      if (data == null) {
         throw new NullPointerException("Data cannot be null");
    }
    }
    @Override
    public void run(){
        ObjectOutputStream output = null;
            try {
                output = new ObjectOutputStream(cliente.getOutputStream());

                while (true) {
                    send(outputQueue.take(), output);
                }
            } 
            catch (IOException ex){
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            } 
            catch (InterruptedException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            } 
            finally {
                
            }
    }
    @Override
    public int hashCode() {
        int r = super.hashCode();
        r = r * 7 + this.cliente.hashCode();
        return r;
    }
    @Override
    public String toString() {
        String str = "Socket: " + this.cliente.toString();
        return str;
}
}