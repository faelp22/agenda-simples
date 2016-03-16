package br.agenda.views;

import br.agenda.entidades.Banco;
import br.agenda.entidades.Contato;
import br.agenda.utils.ReadFile;
import br.agenda.utils.WriteFile;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Isael Sousa <faelp22@hotmail.com>
 */
public class Principal extends javax.swing.JFrame {

    private static Banco b;
    private static ReadFile r;
    private static WriteFile s;

    public Principal(String msg) {
        super(msg);
        this.load();
        this.initComponents();
        this.setarIconeNoTitulo();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        pesquisa = new javax.swing.JTextField();
        bpesquisa = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu1 = new javax.swing.JMenu();
        listContatos = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        sobre = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Agenda de Contatos v 1.1");

        bpesquisa.setText("Pesquisar");
        bpesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bpesquisaActionPerformed(evt);
            }
        });

        jLabel2.setText("Trabalho GQ1 2016.1 Faculdade Integra da Grande Fortaleza");

        jLabel3.setText("Ciência da Computação 3º Semestre");

        jLabel4.setText("Digite um Nome, E-mail ou Tell.");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/agenda/img/94px-Lambda_lc.svg.png"))); // NOI18N

        menu1.setText("Contato");

        listContatos.setText("Adicionar");
        listContatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listContatosActionPerformed(evt);
            }
        });
        menu1.add(listContatos);

        jMenuItem2.setText("Listar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menu1.add(jMenuItem2);

        jMenuBar1.add(menu1);

        sobre.setText("Sobre");

        jMenuItem3.setText("Sobre");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        sobre.add(jMenuItem3);

        jMenuBar1.add(sobre);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 92, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(pesquisa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bpesquisa))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel3))
                    .addComponent(jLabel5))
                .addGap(13, 13, 13)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bpesquisa))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listContatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listContatosActionPerformed
        CadContato.main(Principal.s, Principal.r);
    }//GEN-LAST:event_listContatosActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        JOptionPane.showMessageDialog(null, "Agenda V-1.1");
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Lista.main(Principal.s, r, null);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    @SuppressWarnings("empty-statement")
    private void bpesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bpesquisaActionPerformed

        ArrayList<Contato> achados = new ArrayList<>();

        if (!"".equals(pesquisa.getText().trim())) {
            r.getContatos().stream().filter((contato) -> (contato.getNome().contains(pesquisa.getText().trim())
                    || contato.getEmail().contains(pesquisa.getText().trim())
                    || contato.getTell().contains(pesquisa.getText().trim()))
            ).forEach((contato) -> {
                achados.add(contato);
            });
        }
        
        pesquisa.setText("");

        if (achados.size() >= 1) {
            Lista.main(s, r, achados);
        } else {
            JOptionPane.showMessageDialog(null, "Não encontramos nada :(");
        }
    }//GEN-LAST:event_bpesquisaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {

            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
                System.out.println("Analise - " + e.getMessage());
            }

            Principal a = new Principal("Agenda v 1.1");

            int width = 622;
            int height = 353;
            Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
            int x = (screen.width - width) / 2;
            int y = (screen.height - height) / 2;
            a.setBounds(x, y, width, height);

            a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            a.setResizable(false);
            a.setVisible(true);
        });
    }

    private void load() {
        b = Banco.getInstance("banco.db");
        s = WriteFile.getInstance(b);
        r = ReadFile.getInstance(b, s);
    }

    private void setarIconeNoTitulo() {
        try {
            this.setIconImage(new ImageIcon(getClass().getResource("/br/agenda/img/1up.png")).getImage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error n foi possivel encontrar o icone" + ex.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bpesquisa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem listContatos;
    private javax.swing.JMenu menu1;
    private javax.swing.JTextField pesquisa;
    private javax.swing.JMenu sobre;
    // End of variables declaration//GEN-END:variables
}
