/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contacto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author santi
 */
public class Borrar extends javax.swing.JInternalFrame {

    /**
     * Creates new form Borrar
     */
    public Borrar() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        jLabel1.setText("Cedula del contacto a borrar");

        jButton1.setText("Borrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(155, 155, 155))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72)
                .addComponent(jButton1)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String Fichero = "C:\\Users\\Public\\Documents/filename.txt";
        String[] help;
        String[] lista = new String [10000];
        BufferedReader Buf = null;
        int cont=0;
        try {
            Buf = new BufferedReader(new FileReader(Fichero));
            String texto = Buf.readLine();
            String cedula = jTextField1.getText();
            while (texto != null) {
                
                help = texto.split(" ");
                if (cedula == null ? help[0] == null : cedula.equals(help[0])) {
                    cont=cont-1;
                }else{
                    lista[cont]=texto;
                }
                texto = Buf.readLine();
                cont=cont+1;
            }
            
        }
        catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error: Fichero no encontrado");
            ex.printStackTrace();
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error de lectura del fichero");
            ex.printStackTrace();
        }
        finally {
            try {
                if (Buf != null) {
                    Buf.close();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error al cerrar el fichero");
                ex.printStackTrace();
            }
        }
        String ruta = "C:\\Users\\Public\\Documents/filename.txt";
        File archivo = new File(ruta);
        archivo.delete();
        for (int i = 0; i < cont; i++) {
        
        try {
            
            // Si el archivo no existe es creado
            FileWriter fw = new FileWriter(archivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(lista[i]+"\n");
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
