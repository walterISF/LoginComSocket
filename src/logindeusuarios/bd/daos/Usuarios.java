package logindeusuarios.bd.daos;

import java.io.Serializable;
import logindeusuarios.bd.core.MeuResultSet;
import java.sql.*;
import logindeusuarios.bd.BD;
import logindeusuarios.bd.dbos.Usuario;

public class Usuarios implements Serializable
{
    /**
     * Utilize esta função para verificar se um usuario ja foi ou não cadastrado
     * @param email Insira um email quer servira como chave de acesso por exemplo 
     * "seunome@email.com"
     * @return Em caso de excessão o chamante deve tratar
     * @throws Exception  Retorna Excessão caso uma das operações falharem
     */
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

            retorno = resultado.first();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar usuario");
        }

        return retorno;
    }
    
    /**
     * Método responsável em incluir um novo Usuario à base de dados
     * @param usuario Objeto Usuario à ser passado para o método
     * @throws Exception Retorna Excessão caso objeto for nulo ou as operações de inserção
     * falharem
     */
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

    /**
     * Método responsável em excluir um usuário específico
     * @param email Email do usuário que deseja excluir
     * @throws Exception Em caso de excessâo o chamante deve tratar
     */
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

    /**
     * Método responsável em alterar os dados de um Usuario
     * @param usuario Objeto de Usuario a ser alterado
     * @throws Exception Em caso de excessão o chamante deve tratar
     */
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

            BD.COMANDO.setString (3, usuario.getEmail ());
            BD.COMANDO.setString (1, usuario.getNome  ());
            BD.COMANDO.setString (2, usuario.getSenha ());

            BD.COMANDO.executeUpdate ();
            BD.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao atualizar dados de usuario");
        }
    }

    /**
     * Função responsável por retornar os dados de um único Usuario
     * @param email Email do usuário que quer saber os dados
     * @return Retorna um objeto Usuario com os dados obtidos
     * @throws Exception Em caso de excessão o chamante deve tratar
     */
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

    /**
     * Função que retorna todos os Usuarios cadastrados na base 
     * @return tipo MeuResultSet
     * @throws Exception Em caso de excessão o chamante deve tratar
     */
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