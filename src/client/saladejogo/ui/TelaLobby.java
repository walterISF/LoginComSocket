/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.saladejogo.ui;

import client.socket.Conexao;
import client.socket.Solicitacao;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author vntwafi
 */
public class TelaLobby extends javax.swing.JPanel {

    private ObjectOutputStream transmissor;
    private ObjectInputStream receptor;
    private Socket conexao;
    private JFrame frameLayout;
    private DefaultListModel model;
    private Timer timer = null;
    /**
     * Creates new form TelaLobby
     * @param framelayout
     */
    public TelaLobby(JFrame framelayout) {
        initComponents();
        this.frameLayout = framelayout;
        this.frameLayout.add(this);
        this.frameLayout.addWindowListener(exitListener);
        this.frameLayout.pack();
        this.frameLayout.setLocationRelativeTo(null); 
        this.frameLayout.setResizable(false);
        this.frameLayout.setVisible(true);
        this.model = Conexao.getModel();
        this.model.removeAllElements();
        this.lstAberta.setModel(model);
        Conexao.getInstance();
        this.conexao = Conexao.getSocket();
        updateListaSalas();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        btnEntrarSala = new javax.swing.JButton();
        btnNovaPartida = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstAberta = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel2.setText("Salas Abertas");

        btnEntrarSala.setBackground(new java.awt.Color(255, 255, 255));
        btnEntrarSala.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        btnEntrarSala.setForeground(new java.awt.Color(255, 255, 255));
        btnEntrarSala.setIcon(new javax.swing.ImageIcon(getClass().getResource("/client/saladejogo/ui/btnMais.png"))); // NOI18N
        btnEntrarSala.setText("Iniciar");
        btnEntrarSala.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEntrarSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarSalaActionPerformed(evt);
            }
        });

        btnNovaPartida.setBackground(new java.awt.Color(255, 255, 255));
        btnNovaPartida.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        btnNovaPartida.setForeground(new java.awt.Color(255, 255, 255));
        btnNovaPartida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/client/saladejogo/ui/btnParar.png"))); // NOI18N
        btnNovaPartida.setText("Novo Jogo");
        btnNovaPartida.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNovaPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovaPartidaActionPerformed(evt);
            }
        });

        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList1.setToolTipText("");
        jList1.setDoubleBuffered(true);
        jScrollPane1.setViewportView(jList1);

        lstAberta.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstAberta.setToolTipText("");
        jScrollPane2.setViewportView(lstAberta);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(237, 0, 0));
        jLabel1.setText("Salas Fechadas");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/client/saladejogo/ui/logo.png"))); // NOI18N

        btnUpdate.setBackground(new java.awt.Color(255, 255, 255));
        btnUpdate.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/client/saladejogo/ui/btnMais.png"))); // NOI18N
        btnUpdate.setText("Atualiza Listas");
        btnUpdate.setToolTipText("");
        btnUpdate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEntrarSala, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNovaPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))))
                .addGap(51, 51, 51))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovaPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEntrarSala, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEntrarSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarSalaActionPerformed
        String selected = this.lstAberta.getSelectedValue();
        
        if(this.conexao != null)
        {
            this.transmissor = Conexao.getOutputStream();
            this.receptor = Conexao.getInputStream();
            try 
            {
                transmissor.writeObject(new Solicitacao("ENT", selected));
                Solicitacao retorno = (Solicitacao)receptor.readObject();
                if(retorno.getComando().toUpperCase().equals("SUC"))
                {
                    JFrame frame = new JFrame("Aguarde");
                    TelaAguardando tela = new TelaAguardando(frame, selected);                    
                }
            } 
            catch (IOException | ClassNotFoundException ex) 
            {
                Logger.getLogger(TelaLobby.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnEntrarSalaActionPerformed

    private void btnNovaPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovaPartidaActionPerformed
        if(this.timer != null)
            timer.cancel();
        
        String nome = JOptionPane.showInputDialog(null, "Insira o nome da sala");
        Solicitacao novaPartida = new Solicitacao("CRI", nome);
        Solicitacao retorno;
        try 
        {
            if(this.conexao != null)
            {
                transmissor = Conexao.getOutputStream();
                receptor = Conexao.getInputStream();
                transmissor.writeObject(novaPartida);
                retorno = (Solicitacao) receptor.readObject();
                System.out.println(retorno.toString());
                if(retorno.getComando().toUpperCase().equals("SUC"))
                {
                    this.model.addElement(nome);
                    JFrame frame = new JFrame("Aguarde");
                    TelaAguardando tela = new TelaAguardando(frame, nome);
                }
            }

        } 
        catch (IOException | ClassNotFoundException ex) 
        {
            Logger.getLogger(TelaLobby.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_btnNovaPartidaActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        updateListaSalas();
    }//GEN-LAST:event_btnUpdateActionPerformed
    private void updateListaSalas()
    {
        if(Conexao.getSocket() != null)
        {
            Solicitacao solicitacao = new Solicitacao("URL");
            Solicitacao retorno;
            String[] listaDeSalas;
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
                    listaDeSalas = retorno.getComplemento1().split(",");
                    for(int i=0; i<listaDeSalas.length; i++)
                        this.model.addElement(listaDeSalas[i]);

                }
            } 
            catch (IOException | ClassNotFoundException ex) 
            {
                Logger.getLogger(TelaAguardando.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
    WindowListener exitListener = new WindowAdapter() {

        @Override
        public void windowClosing(WindowEvent e) {
            int confirm = JOptionPane.showOptionDialog(
                 null, "Tem certeza que deseja fechar o jogo?", 
                 "Exit Confirmation", JOptionPane.YES_NO_OPTION, 
                 JOptionPane.QUESTION_MESSAGE, null, null, null);
            if (confirm == 0) 
            {
                Solicitacao retorno;
                try 
                {
                    transmissor = Conexao.getOutputStream();
                    receptor = Conexao.getInputStream();
                    transmissor.writeObject(new Solicitacao("SAI"));
                    transmissor.flush(); //envio imediato
                    retorno = (Solicitacao) receptor.readObject();
                    System.out.println(retorno.toString());
                    if(retorno.getComando().toUpperCase().equals("SUC"))
                    {
                        System.exit(0);
                    }
                }
                catch (IOException | ClassNotFoundException ex) 
                {
                    Logger.getLogger(TelaAguardando.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    };
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrarSala;
    private javax.swing.JButton btnNovaPartida;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> lstAberta;
    // End of variables declaration//GEN-END:variables
}
