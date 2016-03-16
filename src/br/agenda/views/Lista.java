package br.agenda.views;

import br.agenda.entidades.Contato;
import br.agenda.utils.ReadFile;
import br.agenda.utils.WriteFile;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

/**
 * @author Isael Sousa <faelp22@hotmail.com>
 */
public class Lista extends javax.swing.JFrame {
    
    private static WriteFile writeFile;
    private static ReadFile readFile;
    private static ArrayList<Contato> pesquisa;
    private final DefaultTableModel model;
    
    public Lista(String msg) {
        super(msg);
        this.initComponents();
        model = (DefaultTableModel) tabela.getModel();
        this.table();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Email", "Tell"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);
        if (tabela.getColumnModel().getColumnCount() > 0) {
            tabela.getColumnModel().getColumn(0).setResizable(false);
            tabela.getColumnModel().getColumn(1).setResizable(false);
            tabela.getColumnModel().getColumn(2).setResizable(false);
            tabela.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        
        if(evt.getClickCount() == 2){
            Integer b = (Integer) model.getValueAt(tabela.getSelectedRow(), NORMAL);
            Contato c = readFile.getContatos().get(b);
            EditContato.main(writeFile, c, readFile);
            this.dispose();
        }
    }//GEN-LAST:event_tabelaMouseClicked

    public static void main(WriteFile writeFile, ReadFile readFile, ArrayList<Contato> pesquisa) {
        Lista.readFile = readFile;
        Lista.writeFile = writeFile;
        Lista.pesquisa = pesquisa;
        
        java.awt.EventQueue.invokeLater(() -> {
            
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
                System.out.println("Analise - " + e.getMessage());
            }

            Lista lis = new Lista("Lista de Contatos");

            int width = 400;
            int height = 300;
            Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
            int x = (screen.width - width) / 2;
            int y = (screen.height - height) / 2;
            lis.setBounds(x, y, width, height);
            
            lis.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            lis.setVisible(true);
        });
    }

    private void table() {
        Integer i = 0;
        
        ArrayList<Contato> show = readFile.getContatos();
        
        if(pesquisa != null && pesquisa.size() >= 1){
            show = pesquisa;
        }
        
        for (Contato contato : show) {
            model.addRow(new Object[]{i, contato.getNome(), contato.getEmail(), contato.getTell()});
            i++;
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
