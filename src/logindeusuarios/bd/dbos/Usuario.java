package logindeusuarios.bd.dbos;

import java.io.Serializable;
import java.util.Objects;

public class Usuario implements Serializable
{
    private String email;
    private String nome;
    private String  senha;

    public Usuario (String email, String nome, String senha) throws Exception
    {
        this.setEmail  (email);
        this.setNome   (nome);
        this.setSenha  (senha);
    }
    
    //################### Métodos Obrigatórios (Canônicos) #####################//

    @Override
    public String toString()
    {
        String ret = "";
        ret = "Usuario [Nome: " + this.getNome() + ", "
                    + "Email: " + this.getEmail() + ", "
                    + "Senha: " + this.getSenha() + "]";
        return ret;
    }
    
    @Override
    public int hashCode() 
    {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.email);
        hash = 89 * hash + Objects.hashCode(this.nome);
        hash = 89 * hash + Objects.hashCode(this.senha);
        return hash;
    }

    @Override
    public boolean equals(Object obj) 
    {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        return true;
    }

    //################ Guetters e Setters #####################//
    /**
     * @param email Email a ser inserido
     * @throws java.lang.Exception
     */
    public void setEmail(String email) throws Exception
    {
        if(email.equals(""))
            throw new Exception("Insira um email válido");
        this.email = email;
    }    

    /**
     * @param nome Nome a ser inserido
     * @throws java.lang.Exception
     */
    public void setNome(String nome) throws Exception 
    {
        if(nome.equals(""))
            throw new Exception("Insira um nome válido");
        this.nome = nome;
    }

    /**
     * @param senha Senha a ser inserida
     * @throws java.lang.Exception
     */
    public void setSenha(String senha) throws Exception 
    {
        if(senha.equals(""))
            throw new Exception("Insira uma senha válida");
        this.senha = senha;
    }
    
    /**
     * @return Retorna o email do Usuario
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return Retorna o nome do Usuario
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return Retorna a senha do Usuario
     */
    public String getSenha() {
        return senha;
    }
}