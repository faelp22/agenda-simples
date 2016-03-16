package br.agenda.views;

import br.agenda.entidades.Contato;
import br.agenda.utils.ReadFile;
import br.agenda.utils.WriteFile;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * @author Isael Sousa <faelp22@hotmail.com>
 */
public class CadContato extends javax.swing.JFrame {

    private static WriteFile writeFile;
    private static ReadFile readFile;

    /**
     * Creates new form CadContato
     *
     * @param msg
     */
    public CadContato(String msg) {
        super(msg);
        this.initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        nome_c = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        email_c = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tell_c = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Salvar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome:");

        nome_c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nome_cActionPerformed(evt);
            }
        });

        jLabel2.setText("Email:");

        email_c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                email_cActionPerformed(evt);
            }
        });

        jLabel3.setText("Tell:");

        tell_c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tell_cActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tell_c)
                    .addComponent(nome_c)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 243, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addComponent(email_c)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nome_c, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(email_c, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(tell_c, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nome_cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nome_cActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nome_cActionPerformed

    private void tell_cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tell_cActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tell_cActionPerformed

    private void email_cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_email_cActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_email_cActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        Contato contato = new Contato(nome_c.getText(), email_c.getText(), tell_c.getText());

        if (!"".equals(contato.getNome()) && ((!"".equals(contato.getEmail())) ? true : (!"".equals(contato.getTell())) ? true : false) != false) {
            
            ArrayList<Contato> contatos = CadContato.readFile.getContatos();
            contatos.add(contato);
            CadContato.writeFile.salve(contatos);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Digite ao menos um contato!");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(WriteFile writeFile, ReadFile readFile) {
        CadContato.writeFile = writeFile;
        CadContato.readFile = readFile;
        
        java.awt.EventQueue.invokeLater(() -> {
            
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
                System.out.println("Analise - " + e.getMessage());
            }
            
            CadContato cad = new CadContato("Cadastro de Contato");
            
            int width = 400;
            int height = 300;
            Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
            int x = (screen.width - width) / 2;
            int y = (screen.height - height) / 2;
            cad.setBounds(x, y, width, height);
            
            cad.setResizable(false);
            cad.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            cad.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField email_c;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField nome_c;
    private javax.swing.JTextField tell_c;
    // End of variables declaration//GEN-END:variables
}
