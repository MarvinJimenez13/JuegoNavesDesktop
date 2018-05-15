package Menu;

import javax.swing.JOptionPane;

public class Menu extends javax.swing.JFrame {

    public Menu() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_salir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btn_jugar = new javax.swing.JButton();
        btn_creditos = new javax.swing.JButton();
        btn_instrucciones = new javax.swing.JButton();
        lb_fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Juego(ProyectoPOO)");
        setFocusable(false);
        setFocusableWindowState(false);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_salir.setBackground(java.awt.Color.black);
        btn_salir.setFont(new java.awt.Font("FrankRuehl", 1, 18)); // NOI18N
        btn_salir.setForeground(new java.awt.Color(204, 204, 204));
        btn_salir.setText("SALIR ");
        btn_salir.setFocusPainted(false);
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });
        getContentPane().add(btn_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 130, 40));

        jLabel1.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("EQUIPO 1 - \"LA ORDEN NEGRA\"");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        btn_jugar.setBackground(java.awt.Color.black);
        btn_jugar.setFont(new java.awt.Font("FrankRuehl", 1, 18)); // NOI18N
        btn_jugar.setForeground(new java.awt.Color(204, 204, 204));
        btn_jugar.setText("JUGAR ");
        btn_jugar.setFocusPainted(false);
        btn_jugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_jugarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_jugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 130, 40));

        btn_creditos.setBackground(new java.awt.Color(0, 0, 0));
        btn_creditos.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_creditos.setForeground(new java.awt.Color(204, 204, 204));
        btn_creditos.setText("CRÉDITOS");
        btn_creditos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_creditosActionPerformed(evt);
            }
        });
        getContentPane().add(btn_creditos, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 130, 40));

        btn_instrucciones.setBackground(java.awt.Color.black);
        btn_instrucciones.setFont(new java.awt.Font("FrankRuehl", 1, 18)); // NOI18N
        btn_instrucciones.setForeground(new java.awt.Color(204, 204, 204));
        btn_instrucciones.setText("INSTRUCCIONES");
        btn_instrucciones.setFocusPainted(false);
        btn_instrucciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_instruccionesActionPerformed(evt);
            }
        });
        getContentPane().add(btn_instrucciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 190, 40));

        lb_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Menu.jpg"))); // NOI18N
        lb_fondo.setText("jLabel1");
        getContentPane().add(lb_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 340));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public boolean juga = true;


    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btn_salirActionPerformed

    private void btn_jugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_jugarActionPerformed
        juga = false;
    }//GEN-LAST:event_btn_jugarActionPerformed

    private void btn_creditosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_creditosActionPerformed
        JOptionPane.showMessageDialog(this, "INTEGRANTES: \n Jimenez Gamboa Marvin Roberto \n "
                + "Alarid Guzmán Abraham \n Vázquez Rangel Erick \n Roa Patlan Brandon Celso ", "CRÉDITOS", 1);
    }//GEN-LAST:event_btn_creditosActionPerformed

    private void btn_instruccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_instruccionesActionPerformed
        JOptionPane.showMessageDialog(this, "-> La nave se mueve con las flechas de izquierda y derecha. \n"
                + "-> Se crea un campo de fuerza con la letra 'Q', pero sólo sirve contra la nave final. \n"
                + "-> Disparas con la letra 'A'.",
                 "INSTRUCCIONES", 1);
    }//GEN-LAST:event_btn_instruccionesActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_creditos;
    private javax.swing.JButton btn_instrucciones;
    private javax.swing.JButton btn_jugar;
    private javax.swing.JButton btn_salir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lb_fondo;
    // End of variables declaration//GEN-END:variables
}
