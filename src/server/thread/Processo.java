/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.thread;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import client.socket.Solicitacao;
import bd.BD;
import bd.dbos.Usuario;
import server.socket.Carta;
import server.socket.DadosBasicos;
import server.socket.Lista;
import server.socket.Partida;

public class Processo extends Thread
{

    public Socket conexao;
    private Lista<Partida> partidas;
    public Processo(Socket conexao) 
    {
        this.conexao = conexao;
    }
    

    @Override
    public void run() 
    {
        ObjectInputStream receptor;
        ObjectOutputStream output;
        DadosBasicos.Init();
        partidas = DadosBasicos.getPartidas();
        String nomePartida = null;
        try 
        {
            receptor = new ObjectInputStream(this.conexao.getInputStream());
            output = new ObjectOutputStream(this.conexao.getOutputStream());
            Solicitacao recebido;
            Usuario userPartida = null;
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
                                    Usuario userCadastro = new Usuario(recebido.getComplemento1(),recebido.getComplemento2(),recebido.getComplemento3());
                                    userCadastro.setMoeda(1000.0F);
                                    BD.USUARIOS.incluir(userCadastro);
                                    
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
                                    userPartida = BD.USUARIOS.getUsuario(recebido.getComplemento1());
                                    if(userPartida.getSenha().equals(recebido.getComplemento2()))
                                    {
                                        
                                        output.writeObject(new Solicitacao("SUC", "Login efetuado com sucesso!"));
                                    }
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
                    case "CRI":
                        try 
                        {
                            Partida nova = new Partida(recebido.getComplemento1());
                            nomePartida = recebido.getComplemento1();
                            Lista<Usuario> jogadores = new Lista<>();
                            jogadores.inserirNoFim(userPartida);
                            nova.setJogares(jogadores);
                            
                            if(!partidas.tem(nova))
                            {
                                nova.setStatus(Partida.Status.INICIADA);
                                if(DadosBasicos.getPartidas() == null)
                                    DadosBasicos.Init();
                                partidas.inserirNoFim(nova);
                                DadosBasicos.setUmaPartida(nova);
                                output.writeObject(new Solicitacao("SUC", "Seu saldo atual: " + userPartida.getMoeda() + "moedas"));
                                
                            }
                            else
                            {
                                output.writeObject(new Solicitacao("ERR", "Não foi possível criar sua partida: Partida já existe!"));
                            }
                        } 
                        catch (Exception ex) 
                        {
                            Logger.getLogger(Processo.class.getName()).log(Level.SEVERE, null, ex);
                            output.writeObject(new Solicitacao("ERR", "Não foi possível criar sua partida"));
                        }                   
                        break;
                    case "COM":
                        if(nomePartida != null)
                        {
                            Partida partida = DadosBasicos.getUmaPartida(nomePartida);
                            Carta carta = partida.getCarta(partida.getBaralhos().getBaralho(0));
                            output.writeObject(new Solicitacao("CAR",carta.getNipe(), carta.getValor()));
                        }
                        else
                        {
                            output.writeObject(new Solicitacao("ERR","Voce nao esta logado em neuma partida"));
                        }
                        break;
                    case "APO":
                            if(userPartida.getMoeda() < Float.valueOf(recebido.getComplemento1()))
                            {
                                output.writeObject(new Solicitacao("ERR", "Saldo insuficiente"));
                            }
                            else
                            {
                                Partida partida = DadosBasicos.getUmaPartida(nomePartida);
                                try 
                                {
                                    partida.addMoedas(Float.valueOf(recebido.getComplemento1()));
                                } 
                                catch (Exception ex) 
                                {
                                    Logger.getLogger(Processo.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        break;
                    case "ENT":
                            nomePartida = recebido.getComplemento1();
                            Partida partidaEntrar = DadosBasicos.getUmaPartida(nomePartida);
                
                            try 
                            {
                                partidaEntrar.addJogador(userPartida);
                            } 
                            catch (Exception ex) 
                            {
                                Logger.getLogger(Processo.class.getName()).log(Level.SEVERE, null, ex);
                            }
                
                        break;
                    case "EOC":
                        
                        break;
                    case "SAI":
                        output.writeObject(new Solicitacao("SUC", "Você saiu do jogo"));
                        break;
                    case "CONT":
                        Partida partidaSolicitada = DadosBasicos.getUmaPartida(recebido.getComplemento1());
                        output.writeObject(new Solicitacao("SUC", partidaSolicitada.getJogares().getQtdElems() + ""));
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
