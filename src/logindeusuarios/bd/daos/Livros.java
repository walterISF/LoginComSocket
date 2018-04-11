package bd.daos;

import java.sql.*;
import bd.*;
import bd.core.*;
import bd.dbos.*;

public class Livros
{
    public boolean cadastrado (int codigo) throws Exception
    {
        boolean retorno = false;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM LIVROS " +
                  "WHERE CODIGO = ?";

            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setInt (1, codigo);

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
            throw new Exception ("Erro ao procurar livro");
        }

        return retorno;
    }

    public void incluir (Livro livro) throws Exception
    {
        if (livro==null)
            throw new Exception ("Livro nao fornecido");

        try
        {
            String sql;

            sql = "INSERT INTO LIVROS " +
                  "(CODIGO,NOME,PRECO) " +
                  "VALUES " +
                  "(?,?,?)";

            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setInt    (1, livro.getCodigo ());
            BD.COMANDO.setString (2, livro.getNome ());
            BD.COMANDO.setFloat  (3, livro.getPreco ());

            BD.COMANDO.executeUpdate ();
            BD.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao inserir livro");
        }
    }

    public void excluir (int codigo) throws Exception
    {
        if (!cadastrado (codigo))
            throw new Exception ("Nao cadastrado");

        try
        {
            String sql;

            sql = "DELETE FROM LIVROS " +
                  "WHERE CODIGO=?";

            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setInt (1, codigo);

            BD.COMANDO.executeUpdate ();
            BD.COMANDO.commit        ();        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao excluir livro");
        }
    }

    public void alterar (Livro livro) throws Exception
    {
        if (livro==null)
            throw new Exception ("Livro nao fornecido");

        if (!cadastrado (livro.getCodigo()))
            throw new Exception ("Nao cadastrado");

        try
        {
            String sql;

            sql = "UPDATE LIVROS " +
                  "SET NOME=? " +
                  "SET PRECO=? " +
                  "WHERE CODIGO = ?";

            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setString (1, livro.getNome ());
            BD.COMANDO.setFloat  (2, livro.getPreco ());
            BD.COMANDO.setInt    (3, livro.getCodigo ());

            BD.COMANDO.executeUpdate ();
            BD.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao atualizar dados de livro");
        }
    }

    public Livro getLivro (int codigo) throws Exception
    {
        Livro livro = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM LIVROS " +
                  "WHERE CODIGO = ?";

            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setInt (1, codigo);

            MeuResultSet resultado = (MeuResultSet)BD.COMANDO.executeQuery ();

            if (!resultado.first())
                throw new Exception ("Nao cadastrado");

            livro = new Livro (resultado.getInt   ("CODIGO"),
                               resultado.getString("NOME"),
                               resultado.getFloat ("PRECO"));
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar livro");
        }

        return livro;
    }

    public MeuResultSet getLivros () throws Exception
    {
        MeuResultSet resultado = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM LIVROS";

            BD.COMANDO.prepareStatement (sql);

            resultado = (MeuResultSet)BD.COMANDO.executeQuery ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao recuperar livros");
        }

        return resultado;
    }
}