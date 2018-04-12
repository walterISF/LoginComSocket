package logindeusuarios.programa;

import logindeusuarios.bd.*;
import logindeusuarios.bd.dbos.*;

public class Programa
{
    public static void main(String[] args)
    {
        try
        {
            Usuario usuario = new Usuario ("walter@mail.com","Walter","123");
//            BD.USUARIOS.incluir (usuario);
            
            if(!BD.USUARIOS.cadastrado("walter@mail.com"));
            {
                usuario.setNome("Romeu");
                usuario.setSenha("romeu123");
                BD.USUARIOS.alterar(usuario);
            }
            
        }
        catch (Exception erro)
        {
            System.err.println (erro);
        }
    } 
}