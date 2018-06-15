/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.ui;

import java.awt.Color;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.border.Border;
import client.socket.Conexao;
import client.socket.Solicitacao;

/**
 *
 * @author vntwafi
 */
public class TelaCadastro extends javax.swing.JPanel {

    JFrame frameLayout;
    Socket conexao = Conexao.getSocket();
    ObjectOutputStream out;
    ObjectInputStream in;
    /**
     * Creates new form TelaCadastro
     * @param frameLayout
     */
    public TelaCadastro(JFrame frameLayout) {
        initComponents();
        this.frameLayout = frameLayout;
        this.frameLayout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frameLayout.add(this);
        this.frameLayout.pack();
        this.frameLayout.setLocationRelativeTo(null);
        this.frameLayout.setResizable(false);
        this.frameLayout.setVisible(true);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordField1 = new javax.swing.JPasswordField();
        btnOk = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtSenha = new javax.swing.JPasswordField();
        txtConfirmacao = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        lblError = new javax.swing.JLabel();

        jPasswordField1.setText("jPasswordField1");

        setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20))));
        setSize(new java.awt.Dimension(462, 171));

        btnOk.setText("OK");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome");

        jLabel2.setText("Email");

        jLabel3.setText("Senha");

        jLabel4.setText("Confirmação");

        txtNome.setToolTipText("");

        txtEmail.setToolTipText("");
        txtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmailFocusLost(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(13, 13, 13)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addGap(16, 16, 16)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addGap(13, 13, 13)
                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel4)
                .addGap(10, 10, 10)
                .addComponent(txtConfirmacao, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(172, 172, 172)
                .addComponent(btnCancelar))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtConfirmacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.frameLayout.setVisible(false);
        JFrame frame = new JFrame("Login");
        TelaLogin loginPanel = new TelaLogin(frame);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        String nome = this.txtNome.getText();
        String email = this.txtEmail.getText();
        String senha = String.valueOf(this.txtSenha.getPassword());
        String confirmacao = String.valueOf(this.txtConfirmacao.getPassword());
        try 
        {
            Conexao.getInstance();
            Conexao.startConnection();
            this.conexao = Conexao.getSocket();
            this.in = Conexao.getInputStream();
            this.out = Conexao.getOutputStream();
            
            if(!nome.isEmpty() && !email.isEmpty() && !senha.isEmpty() && !confirmacao.isEmpty())
            {
                if(!validarEmail(email))
                {
                    Border borderRed = BorderFactory.createLineBorder(Color.red, 1);
                    this.txtEmail.setBorder(borderRed);
                }
                if(!senha.equals(confirmacao))
                {
                    this.lblError.setText("Senhas não coincidem");
                    this.lblError.setForeground(Color.red);
                    this.lblError.setVisible(true);
                }
                else
                {
                    Solicitacao retorno, cadastro;
                    this.out = Conexao.getOutputStream();
                    this.in = Conexao.getInputStream();
                    cadastro = new Solicitacao("CAD", this.txtEmail.getText(), this.txtNome.getText(), String.valueOf(this.txtSenha.getPassword()));
                    try 
                    {
                        this.out.writeObject(cadastro);
                        this.out.flush(); //envio imediato
                        retorno = (Solicitacao) in.readObject();
                        System.out.println(retorno.toString());
                        if(retorno.getComando().toUpperCase().equals("SUC"))
                        {
                            Conexao.closeConnection();
                            this.frameLayout.setVisible(false);
                            JFrame frame = new JFrame("Login");
                            TelaLogin loginPanel = new TelaLogin(frame);                             
                        }
                        else
                        {
                            this.lblError.setText(retorno.getComplemento1());
                            this.lblError.setVisible(true);
                            this.lblError.setForeground(Color.red);
                        }
                    } 
                    catch (IOException | ClassNotFoundException ex) 
                    {
                        Logger.getLogger(TelaCadastro.class.getName()).log(Level.SEVERE, null, ex);
                    }
               
                }

            }
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(TelaCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnOkActionPerformed

    private void txtEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusLost
        if(!validarEmail(this.txtEmail.getText()))
        {
            Border border = BorderFactory.createLineBorder(Color.red, 1);
            this.txtEmail.setBorder(border);

        }        
    }//GEN-LAST:event_txtEmailFocusLost

    private void txtEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusGained
        this.txtEmail.setBorder(UIManager.getBorder("TextField.border"));
    }//GEN-LAST:event_txtEmailFocusGained

    public static boolean validarEmail(String email)
    {
        boolean isEmailIdValid = false;
        if (email != null && email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                isEmailIdValid = true;
            }
        }
        return isEmailIdValid;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnOk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblError;
    private javax.swing.JPasswordField txtConfirmacao;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNome;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}
