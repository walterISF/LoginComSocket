/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.saladejogo.ui;

import client.socket.Conexao;
import client.socket.Solicitacao;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author vntwafi
 */
public class TelaAguardando extends javax.swing.JPanel {

    private final JFrame frameLayout;
    private ObjectOutputStream transmissor;
    private ObjectInputStream receptor;
    private final String nomePartida;
    private final Socket conexao;
    /**
     * Creates new form TelaAguardando
     * @param framelayout
     * @param nome
     */
    public TelaAguardando(JFrame framelayout, String nome) {
        initComponents();
        this.frameLayout = framelayout;
        this.frameLayout.add(this);
        this.frameLayout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frameLayout.pack();
        this.frameLayout.setLocationRelativeTo(null); 
        this.frameLayout.setResizable(false);
        this.btnOk.setVisible(false);
        this.frameLayout.setVisible(true);
        this.nomePartida = nome;
        this.conexao = Conexao.getSocket();
        atualizarUsuarios(this.nomePartida);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnOk = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblNumJogadores = new javax.swing.JLabel();
        lblValor = new javax.swing.JLabel();

        btnOk.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        btnOk.setForeground(new java.awt.Color(255, 255, 255));
        btnOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/client/saladejogo/ui/btnMais.png"))); // NOI18N
        btnOk.setText("OK");
        btnOk.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        btnSair.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        btnSair.setForeground(new java.awt.Color(255, 255, 255));
        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/client/saladejogo/ui/btnParar.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(248, 23, 23));
        jLabel1.setText("Aguarde até tenha entre 3 a 8 jogadores");

        lblNumJogadores.setText("Numero de jogadores:");

        lblValor.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(lblNumJogadores)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblValor)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumJogadores)
                    .addComponent(lblValor))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        if(Integer.parseInt(this.lblValor.getText()) > 2)
        {
            this.frameLayout.setVisible(false);
            JFrame frame = new JFrame("Partida");
            TelaPartida jogar = new TelaPartida(frame);
        }
    }//GEN-LAST:event_btnOkActionPerformed

    private void atualizarUsuarios(String nomePartida)
    {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                while(true)
                {
                    if(Conexao.getSocket() != null)
                    {
                        Solicitacao solicitacao = new Solicitacao("UUL", nomePartida);
                        Solicitacao retorno;
                        try 
                        {
                            transmissor = Conexao.getOutputStream();
                            receptor = Conexao.getInputStream();
                            transmissor.writeObject(solicitacao);
                            transmissor.flush(); //envio imediato
                            retorno = (Solicitacao) receptor.readObject();
                            System.out.println(retorno.toString());
                            if(retorno.getComando().toUpperCase().equals("SUC"))
                            {
                                lblValor.setText(retorno.getComplemento1());
                                if(Integer.parseInt(retorno.getComplemento1()) > 2)
                                    btnOk.setVisible(true);
                            }
                        } 
                        catch (IOException | ClassNotFoundException ex) 
                        {
                            Logger.getLogger(TelaAguardando.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }                    
                }

            }
        }, 1000);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOk;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblNumJogadores;
    private javax.swing.JLabel lblValor;
    // End of variables declaration//GEN-END:variables
}
