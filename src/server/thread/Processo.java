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
        Lista<Carta> cartasRepassadas = null;
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
                            cartasRepassadas = new Lista<>();
                            Partida partida = DadosBasicos.getUmaPartida(nomePartida);
                            Carta carta = partida.getCarta(partida.getBaralhos().getBaralho(0));
                            cartasRepassadas.inserirNoFim(carta);
                            output.writeObject(new Solicitacao("CAR",carta.getNipe(), carta.getValor()));
                        }
                        else
                        {
                            output.writeObject(new Solicitacao("ERR","Voce nao esta logado em nenhuma partida"));
                        }
                        break;
                    case "APO":
                            if(userPartida.getMoeda() < Float.parseFloat(recebido.getComplemento1()))
                            {
                                output.writeObject(new Solicitacao("ERR", "Saldo insuficiente"));
                            }
                            else
                            {
                                Partida partida = DadosBasicos.getUmaPartida(nomePartida);
                                try 
                                {
                                    partida.addMoedas(Float.parseFloat(recebido.getComplemento1()));
                                    output.writeObject(new Solicitacao("SUC"));
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
                        int somaDasCartas = 0;
                        if(cartasRepassadas!=null)
                        {
                            for(int i=0; i<cartasRepassadas.getQtdElems(); i++)
                            {
                                somaDasCartas+= Integer.parseInt(cartasRepassadas.getProx().getValor());
                            }
                        }
                        break;
                    case "SAI":
                        if(partidas.getQtdElems() > 0)
                        {
                            if(partidas.getPartida(nomePartida).getJogares().tem(userPartida) && userPartida != null)
                            {
                                partidas.getPartida(nomePartida).getJogares().removerJogador(userPartida.getNome());

                            }                            
                        }
                        output.writeObject(new Solicitacao("SUC", "Você saiu do jogo"));
                        receptor.close();
                        output.close();
                        this.conexao.close();
                        this.interrupt();
                        break;
                    case "URL":
                            if(partidas.getQtdElems() > 0)
                            {
                                String partidasCriadas = "";
                                for(int i = 0; i<partidas.getQtdElems(); i++)
                                {
                                    partidasCriadas = partidasCriadas + "," + partidas.getProx().getNome().trim();
                                    
                                    output.writeObject(new Solicitacao("SUC", partidasCriadas));
                                }                                
                            }
                            else
                            {
                                output.writeObject(new Solicitacao("ERR","Não existem partidas a se jogar"));
                            }
                        break;
                    case "UUL":
                            Partida partidaSolicitada = null;
                            if(partidas != null)
                                partidaSolicitada = DadosBasicos.getUmaPartida(recebido.getComplemento1());
                            
                            if(partidaSolicitada != null)
                            output.writeObject(new Solicitacao("SUC", partidaSolicitada.getJogares().getQtdElems() + "", partidaSolicitada.getStatus().toString()));                        
                        break;
                }                
            }
            while(!recebido.getComando().equals(""));
            
        } 
        catch (ClassNotFoundException | IOException ex)  
        {
            Logger.getLogger(Processo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Processo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public synchronized void start() 
    {
        super.start(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
