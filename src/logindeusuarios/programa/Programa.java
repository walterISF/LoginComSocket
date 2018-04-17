package logindeusuarios.programa;

import logindeusuarios.bd.*;
import logindeusuarios.bd.dbos.*;

public class Programa
{
    public static void main(String[] args)
    {
        try
        {
            Usuario usuario = new Usuario ("inacio@mail.com","Inacio","123");
//            BD.USUARIOS.incluir (usuario);
            //BD.USUARIOS.excluir(usuario.getEmail());
            
            if(BD.USUARIOS.cadastrado("inacio@mail.com"))
            {
                usuario.setNome("mario");
                usuario.setSenha("july123");
                BD.USUARIOS.alterar(usuario);
            }
            else
            {
                BD.USUARIOS.incluir (usuario);
            }
            System.out.println(usuario.toString());
            
        }
        catch (Exception erro)
        {
            System.err.println (erro);
        }
    } 
}