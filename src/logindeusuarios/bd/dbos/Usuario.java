package logindeusuarios.bd.dbos;

import java.util.Objects;

public class Usuario
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

    /**
     * @param email the email to set
     * @throws java.lang.Exception
     */
    public void setEmail(String email) throws Exception
    {
        if(email.equals(""))
            throw new Exception("Insira um email válido");
        this.email = email;
    }    

    /**
     * @param nome the nome to set
     * @throws java.lang.Exception
     */
    public void setNome(String nome) throws Exception 
    {
        if(nome.equals(""))
            throw new Exception("Insira um nome válido");
        this.nome = nome;
    }

    /**
     * @param senha the senha to set
     * @throws java.lang.Exception
     */
    public void setSenha(String senha) throws Exception 
    {
        if(senha.equals(""))
            throw new Exception("Insira uma senha válida");
        this.senha = senha;
    }
    
    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }
}