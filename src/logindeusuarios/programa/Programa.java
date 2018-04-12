package logindeusuarios.programa;

import logindeusuarios.bd.*;
import logindeusuarios.bd.dbos.*;

public class Programa
{
    public static void main(String[] args)
    {
        try
        {
            Usuario usuario = new Usuario ("teste@mail.com","Walter","123");
            BD.USUARIOS.incluir (usuario);
        }
        catch (Exception erro)
        {
            System.err.println (erro);
        }
    } 
}