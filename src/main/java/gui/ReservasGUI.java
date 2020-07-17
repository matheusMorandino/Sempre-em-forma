/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.FabricaConexao;
import dao.ReservasDAO;
import dao.ReservasSocioDAO;
import dao.SalaSquashDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Reserva;
import modelo.Reservas_Nomes;
import modelo.Sala;
import modelo.SalaSquash;
import modelo.Socio;

/**
 *
 * @author acere
 */
public class ReservasGUI extends javax.swing.JFrame {

    /**
     * Creates new form ReservasGUI
     */
    public ReservasGUI() {
        initComponents();
        fillComboBoxSalas();
        atualizaEstadoComboBox();
        mostra_reserva();
    }    
    
    private void mostra_reserva() {
        try{
            ReservasSocioDAO bd = new ReservasSocioDAO();
            ArrayList<Reservas_Nomes> lista = bd.listarReservasSocio();
            DefaultTableModel model = (DefaultTableModel)tabelaReservas.getModel();
            Object[] row = new Object[4];
            for(int i = 0; i < lista.size(); i++) {
                row[0] = lista.get(i).getNome();
                row[1] = lista.get(i).getNroSocio();
                row[2] = lista.get(i).getNroSala();
                row[3] = lista.get(i).getDataReserva();
                model.addRow(row);
            }
        }
        catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void recarrega_tabela_reservas() {
        DefaultTableModel model = (DefaultTableModel)tabelaReservas.getModel();
        model.setRowCount(0);
        mostra_reserva();
    }
    
    protected void atualizaEstadoComboBox() {
        boolean ativaNome = cBBuscaForma.getSelectedItem().equals("Nome");
        if(ativaNome) {
            tFNome.setEnabled(true);
            tFNroSocio.setEnabled(false);
        } 
        else {
            tFNome.setEnabled(false);
            tFNroSocio.setEnabled(true);
        }
    }
    
    private void fillComboBoxSalas() {
        try{
            SalaSquashDAO bd = new SalaSquashDAO();
            ArrayList<SalaSquash> NumerosSalaSquash = bd.listarSalas();
            
            cBSalas.removeAllItems();
            for(int i = 0; i < NumerosSalaSquash.size(); i++) {
                cBSalas.addItem(NumerosSalaSquash.get(i).getNroSala()+"");
            }
        }
        catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private boolean ehSalaOcupada(String nroSala, String data) throws SQLException {

        ReservasDAO bd = new ReservasDAO();
        Sala sala = new Sala(Integer.parseInt(nroSala));
        ArrayList<Reserva> datasSala = bd.listarReservasPeloNroSala(sala);
        
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        for(int i = 0; i < datasSala.size(); i++) {
            if(df.format(datasSala.get(i).getDataReserva()).equals(data))
                return true;
        }
        return false;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cBSalas = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaReservas = new javax.swing.JTable();
        bReserva = new javax.swing.JButton();
        bTRemover = new javax.swing.JButton();
        cBBuscaForma = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tFNome = new javax.swing.JTextField();
        tFNroSocio = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        dCData = new com.toedter.calendar.JDateChooser();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Sala:");

        tabelaReservas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Socio", "NroSocio", "NroSala", "Data reserva"
            }
        ));
        tabelaReservas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaReservasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaReservas);

        bReserva.setText("Reservar");
        bReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bReservaActionPerformed(evt);
            }
        });

        bTRemover.setText("Remover");
        bTRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTRemoverActionPerformed(evt);
            }
        });

        cBBuscaForma.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome", "Número" }));
        cBBuscaForma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cBBuscaFormaActionPerformed(evt);
            }
        });

        jLabel3.setText("Identificação de socio: ");

        jLabel4.setText("Nome:");

        tFNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tFNomeActionPerformed(evt);
            }
        });

        tFNroSocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tFNroSocioActionPerformed(evt);
            }
        });

        jLabel2.setText("Número Socio:");

        jLabel5.setText("Data:");

        dCData.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(bReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(bTRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(99, 99, 99)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tFNome)
                                    .addComponent(dCData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(76, 76, 76)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cBSalas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cBBuscaForma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tFNroSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addGap(43, 43, 43)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cBSalas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cBBuscaForma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tFNroSocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tFNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(dCData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bTRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cBBuscaFormaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cBBuscaFormaActionPerformed
        atualizaEstadoComboBox();
    }//GEN-LAST:event_cBBuscaFormaActionPerformed

    private void tFNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tFNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tFNomeActionPerformed

    private void tFNroSocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tFNroSocioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tFNroSocioActionPerformed

    private void bReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bReservaActionPerformed
        try{
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            
            if((tFNroSocio.getText().equals("") && cBBuscaForma.getSelectedItem().equals("Número")) || (tFNome.getText().equals("") && cBBuscaForma.getSelectedItem().equals("Nome") )) {
                JOptionPane.showMessageDialog(null, "Preencha o campo da identificação do socio para adicionar uma reserva");
                return;
            }
                
            if(dCData.getDate() == null) {
                JOptionPane.showMessageDialog(null, "Preencha o campo da data para adicionar uma reserva");
                return;
            }
        
            if(ehSalaOcupada((String)cBSalas.getSelectedItem(), df.format(dCData.getDate()))) {
                JOptionPane.showMessageDialog(null, "A sala desejada já está ocupada nesse horário");
                return;
            }
            
            ReservasDAO bd = new ReservasDAO();
            
            if(cBBuscaForma.getSelectedItem().equals("Número")) {
                Reserva reserva = new Reserva(Integer.parseInt(tFNroSocio.getText()), Integer.parseInt(cBSalas.getSelectedItem().toString()), dCData.getDate());
                bd.inserirReservaPeloNroSocio(reserva);
            }
            else {
                Socio socio = new Socio(tFNome.getText());
                Reserva reserva = new Reserva(Integer.parseInt(cBSalas.getSelectedItem().toString()), dCData.getDate());
                bd.inserirReservaPeloNomeSocio(reserva, socio);
            }
            
            recarrega_tabela_reservas();
            JOptionPane.showMessageDialog(null, "Operação feita com sucesso!");
        }
        catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_bReservaActionPerformed

    private void bTRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTRemoverActionPerformed
        try{
            if((tFNroSocio.getText().equals("") && cBBuscaForma.getSelectedItem().equals("Número")) || (tFNome.getText().equals("") && cBBuscaForma.getSelectedItem().equals("Nome") )) {
                JOptionPane.showMessageDialog(null, "Preencha o campo da identificação do socio para remover essa reserva");
                return;
            }
                
            if(dCData.getDate() == null) {
                JOptionPane.showMessageDialog(null, "Preencha o campo da data para remover essa reserva");
                return;
            }
            
            int response = JOptionPane.showConfirmDialog(null, "You tem certeza que deseja deletar essa reserva?", "WARNING", JOptionPane.YES_NO_OPTION);
            if(response == JOptionPane.YES_OPTION) {            
                ReservasDAO bd = new ReservasDAO();
            
                 if(cBBuscaForma.getSelectedItem().equals("Número")) {                
                    Reserva reserva = new Reserva(Integer.parseInt(tFNroSocio.getText()), Integer.parseInt(cBSalas.getSelectedItem().toString()), dCData.getDate());
                    bd.deletarReservaPeloNroSocio(reserva);
                }
                else{
                    Socio socio = new Socio(tFNome.getText());
                    Reserva reserva = new Reserva(Integer.parseInt(cBSalas.getSelectedItem().toString()), dCData.getDate());
                    bd.deletarReservaPeloNomeSocio(reserva, socio);
                }
                recarrega_tabela_reservas();
                JOptionPane.showMessageDialog(null, "Operação feita com sucesso!");
            }
        }
        catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_bTRemoverActionPerformed

    private void tabelaReservasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaReservasMouseClicked
        DefaultTableModel model = (DefaultTableModel)tabelaReservas.getModel();
        int tableRowIndex = tabelaReservas.getSelectedRow();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        
        tFNome.setText(model.getValueAt(tableRowIndex, 0).toString());
        tFNroSocio.setText(model.getValueAt(tableRowIndex, 1).toString());
        cBSalas.setSelectedItem(model.getValueAt(tableRowIndex, 2).toString());
        try {
            dCData.setDate((Date)df.parse(model.getValueAt(tableRowIndex, 3).toString()));
        } catch (ParseException ex) {
            Logger.getLogger(ReservasGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tabelaReservasMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ReservasGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReservasGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReservasGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReservasGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReservasGUI().setVisible(true);
            }
        });
    }

    //Objeto de conexão ao BD
    private final FabricaConexao conObj = new FabricaConexao();
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bReserva;
    private javax.swing.JButton bTRemover;
    private javax.swing.JComboBox<String> cBBuscaForma;
    private javax.swing.JComboBox<String> cBSalas;
    private com.toedter.calendar.JDateChooser dCData;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tFNome;
    private javax.swing.JTextField tFNroSocio;
    private javax.swing.JTable tabelaReservas;
    // End of variables declaration//GEN-END:variables
}