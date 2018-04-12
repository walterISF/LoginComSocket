package logindeusuarios.bd.daos;

import logindeusuarios.bd.core.MeuResultSet;
import java.sql.*;
import logindeusuarios.bd.BD;
import logindeusuarios.bd.dbos.Usuario;

public class Usuarios
{
    public boolean cadastrado (String email) throws Exception
    {
        boolean retorno = false;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM LOGIN " +
                  "WHERE EMAIL = ?";

            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setString (1, email);

            MeuResultSet resultado = (MeuResultSet)BD.COMANDO.executeQuery ();

            retorno = resultado.first(); // pode-se usar resultado.last() ou resultado.next() ou resultado.previous() ou resultado.absotule(numeroDaLinha)

            /* // ou, se preferirmos,

            String sql;

            sql = "SELECT COUNT(*) AS QUANTOS " +
                  "FROM LIVROS " +
                  "WHERE CODIGO = ?";

            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setInt (1, codigo);

            MeuResultSet resultado = (MeuResultSet)BD.COMANDO.executeQuery ();

            resultado.first();

            retorno = resultado.getInt("QUANTOS") != 0;

            */
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar usuario");
        }

        return retorno;
    }

    public void incluir (Usuario usuario) throws Exception
    {
        if (usuario==null)
            throw new Exception ("Usuario nao fornecido");

        try
        {
            String sql;

            sql = "INSERT INTO login " +
                  "(EMAIL,NOME,SENHA) " +
                  "VALUES " +
                  "(?,?,?)";

            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setString (1, usuario.getEmail ());
            BD.COMANDO.setString (2, usuario.getNome  ());
            BD.COMANDO.setString (3, usuario.getSenha ());

            BD.COMANDO.executeUpdate ();
            BD.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao inserir usuario");
        }
    }

    public void excluir (String email) throws Exception
    {
        if (!cadastrado (email))
            throw new Exception ("Nao cadastrado");

        try
        {
            String sql;

            sql = "DELETE FROM login " +
                  "WHERE EMAIL=?";

            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setString (1, email);

            BD.COMANDO.executeUpdate ();
            BD.COMANDO.commit        ();        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao excluir usuario");
        }
    }

    public void alterar (Usuario usuario) throws Exception
    {
        if (usuario==null)
            throw new Exception ("Usuario nao fornecido");

        if (!cadastrado (usuario.getEmail()))
            throw new Exception ("Nao cadastrado");

        try
        {
            String sql;

            sql = "UPDATE login " +
                  "SET NOME=? " +
                  ",SENHA=? " +
                  "WHERE EMAIL=?";

            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setString (1, usuario.getEmail ());
            BD.COMANDO.setString (2, usuario.getNome  ());
            BD.COMANDO.setString (3, usuario.getSenha ());

            BD.COMANDO.executeUpdate ();
            BD.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao atualizar dados de usuario");
        }
    }

    public Usuario getUsuario (String email) throws Exception
    {
        Usuario usuario = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM login " +
                  "WHERE EMAIL = ?";

            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setString (1, email);

            MeuResultSet resultado = (MeuResultSet)BD.COMANDO.executeQuery ();

            if (!resultado.first())
                throw new Exception ("Nao cadastrado");

            usuario = new Usuario ( resultado.getString ("EMAIL"),
                                    resultado.getString ("NOME"),
                                    resultado.getString ("SENHA"));
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar livro");
        }

        return usuario;
    }

    public MeuResultSet getUsuarios () throws Exception
    {
        MeuResultSet resultado = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM login";

            BD.COMANDO.prepareStatement (sql);

            resultado = (MeuResultSet)BD.COMANDO.executeQuery ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao recuperar usuarios");
        }

        return resultado;
    }
}