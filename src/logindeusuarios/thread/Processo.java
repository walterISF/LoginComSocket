/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logindeusuarios.thread;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import logindeusuarios.socket.Solicitacao;
import logindeusuarios.bd.BD;
import logindeusuarios.bd.dbos.Usuario;

public class Processo extends Thread
{

    Socket conexao;
    public Processo(Socket conexao) 
    {
        this.conexao = conexao;
    }
    

    @Override
    public void run() 
    {
        ObjectInputStream receptor;
        ObjectOutputStream output = null;
        try 
        {
            receptor = new ObjectInputStream(this.conexao.getInputStream());
            output = new ObjectOutputStream(this.conexao.getOutputStream());
            Solicitacao recebido;
            recebido = (Solicitacao) receptor.readObject();
//            Logger.getLogger("Conexão", "Usuário conectado");
            switch(recebido.getComando())
            {
                case "CAD":
                    if(
                        !recebido.getComplemento1().equals("") && 
                        !recebido.getComplemento2().equals("") && 
                        !recebido.getComplemento3().equals("")
                      )
                    {
                        try 
                        {
                            if(!BD.USUARIOS.cadastrado(recebido.getComplemento2()))
                            {
                                BD.USUARIOS.incluir(new Usuario(recebido.getComplemento1(),recebido.getComplemento2(),recebido.getComplemento3()));
                                output.writeObject(new Solicitacao("SUC"));
                            }
                            else
                            {
                                output.writeObject(new Solicitacao("ERR"));
                            }
                        } 
                        catch (Exception ex) 
                        {
                            Logger.getLogger(Processo.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    else
                    {
                        output.writeObject(new Solicitacao("ERR"));
                    }
                    break;
                case "LOG":
                     if(!recebido.getComplemento1().equals("") && !recebido.getComplemento2().equals(""))
                     {
                        try 
                        {
                            if(!BD.USUARIOS.cadastrado(recebido.getComplemento1()))
                            {
                                output.writeObject(new Solicitacao("ERR", "usuario não está cadastrado"));
                            }
                        } 
                        catch (Exception ex) 
                        {
                            Logger.getLogger(Processo.class.getName()).log(Level.SEVERE, null, ex);
                        }
                         
                     }
                     else
                     {
                         output.writeObject(new Solicitacao("ERR", "preencha os campos email e senha"));
                     }
                     break;
            }
            
        } 
        catch (ClassNotFoundException | IOException ex)  
        {
            Logger.getLogger(Processo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public synchronized void start() 
    {
        super.start(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
