package bd;

import bd.core.MeuPreparedStatement;
import bd.daos.Usuarios;

public class BD
{
    public static final MeuPreparedStatement COMANDO;
    public static final Usuarios USUARIOS; //um como esse para cada classe DAO

    static
    {
    	MeuPreparedStatement comando = null;
     	Usuarios           usuarios  = null; //um como esse para cada classe DAO

    	try
        {
            comando =
            new MeuPreparedStatement (
            "com.microsoft.sqlserver.jdbc.SQLServerDriver",
            "jdbc:sqlserver://172.16.12.12:1433;databasename=poo201840",
            "poo201840", "Npech7");
//            new MeuPreparedStatement (
//            "com.mysql.jdbc.Driver",
//            "jdbc:mysql://localhost:3306/poo201840",
//            "root", "");
            

            usuarios = new Usuarios (); //um como esse para cada classe DAO
        }
        catch (Exception erro)
        {
            System.err.println ("Problemas de conexao com o BD: " + erro);
            System.exit(0); // aborta o programa
        }
        
        COMANDO = comando;
        USUARIOS  = usuarios; //um como esse para cada classe DAO
    }
}