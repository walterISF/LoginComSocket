package logindeusuarios.bd.dbos;

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

    // � claro que os m�todos obrigat�rios deveriam ser feitos
    // para a implementa��o ficar completa

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