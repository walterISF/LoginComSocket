/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logindeusuarios.socket;

import java.io.*;
import java.net.*;



public class Receptora 
{

	public static void main(String[] args) 
        {
		
		try{
			//*****RECEPTORA*****
			ServerSocket pedido = new ServerSocket(2222);
			Socket conexao = pedido.accept(); //accept retorna o socket da transmissora											//por isso n„o È instanciada
			ObjectInputStream receptor = 
			new ObjectInputStream(conexao.getInputStream());
			
			Solicitacao recebido;
			do
			{
			    recebido = (Solicitacao) receptor.readObject();
			}										
			while(recebido.getComando().equals("FIM"));										
		}
		catch (IOException | ClassNotFoundException erro)
		{
			System.err.println(erro.getMessage());
		}

	}

}



