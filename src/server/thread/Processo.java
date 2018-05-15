/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import socket.Solicitacao;
import bd.BD;
import bd.dbos.Usuario;

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
        ObjectOutputStream output;
        try 
        {
            receptor = new ObjectInputStream(this.conexao.getInputStream());
            output = new ObjectOutputStream(this.conexao.getOutputStream());
            Solicitacao recebido;
            do
            {
                recebido = (Solicitacao) receptor.readObject();
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
                                    output.writeObject(new Solicitacao("ERR", "Não encontramos o seu cadastro em nossa base."));
                                }
                                else
                                {
                                    Usuario userTest = BD.USUARIOS.getUsuario(recebido.getComplemento1());
                                    if(userTest.getSenha().equals(recebido.getComplemento2()))
                                        output.writeObject(new Solicitacao("SUC", "Login efetuado com sucesso!"));
                                    else
                                        output.writeObject(new Solicitacao("ERR", "email e ou senha incorretos"));
                                }
                            } 
                            catch (Exception ex) 
                            {
                                Logger.getLogger(Processo.class.getName()).log(Level.SEVERE, null, ex);
                            }

                         }
                         else
                         {
                             output.writeObject(new Solicitacao("ERR", "Você não preencheu todos os campos!"));
                         }
                         break;
                    case "TEST":
                        output.writeObject(new Solicitacao("SUCC", "Você agora consegue falar a vontade!"));
                        break;
                }                
            }
            while(!recebido.getComando().equals(""));
            
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
