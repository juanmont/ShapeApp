/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package VentanaGrafica;

import java.sql.Connection;

import javax.swing.JFrame;

import Control.ControladorAlquilerCompra;
import Control.ControladorClases;
import Control.ControladorInstalaciones;
import Control.ControladorMateriales;
import Control.ControladorUsuarios;

/**
 *
 * @author juanjose
 */
public class VentanaUsuario extends javax.swing.JPanel {

	ControladorAlquilerCompra controlAlquilerCompra;
	ControladorMateriales controlMateriales;
	ControladorClases controlClases;
	ControladorInstalaciones controlInstalaciones;
	ControladorUsuarios controlUsuarios;
	private JFrame frame;
	private Connection con;
	
    /**
     * Creates new form VentanaUsuario
     * @param c 
     */
	public VentanaUsuario(Connection c, ControladorAlquilerCompra controlAlqComp, ControladorMateriales controlMat,
			ControladorClases controlCla, ControladorInstalaciones controlInst, ControladorUsuarios controlUsu) {
    	con = c;
    	controlUsuarios = controlUsu;
    	controlAlquilerCompra = controlAlqComp;
		controlMateriales = controlMat;
		controlClases = controlCla;
		controlInstalaciones = controlInst;
        initComponents();
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btAlquilerPista = new javax.swing.JButton();
        btMaterial = new javax.swing.JButton();
        btContratacionMonitor = new javax.swing.JButton();
        btCompraAbonoPiscina = new javax.swing.JButton();
        btCompraAbonoGym = new javax.swing.JButton();
        btSalir = new javax.swing.JButton();
        jlbDeportes = new javax.swing.JLabel();
        jlbHoras = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listDeportes = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        listHoras = new javax.swing.JList();
        jlbNombreUsuario = new javax.swing.JLabel();
        bVerHoras = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 204, 255));

        btAlquilerPista.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        btAlquilerPista.setForeground(new java.awt.Color(102, 102, 102));
        btAlquilerPista.setText("Alquiler de pista");
        btAlquilerPista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlquilerPistaActionPerformed(evt);
            }
        });

        btMaterial.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        btMaterial.setForeground(new java.awt.Color(102, 102, 102));
        btMaterial.setText("Alquiler Material");

        btContratacionMonitor.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        btContratacionMonitor.setForeground(new java.awt.Color(102, 102, 102));
        btContratacionMonitor.setText("Contratacion Monitor");
        btContratacionMonitor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btContratacionMonitorActionPerformed(evt);
            }
        });

        btCompraAbonoPiscina.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        btCompraAbonoPiscina.setForeground(new java.awt.Color(102, 102, 102));
        btCompraAbonoPiscina.setText("Compra Abono Piscina");
        btCompraAbonoPiscina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCompraAbonoPiscinaActionPerformed(evt);
            }
        });

        btCompraAbonoGym.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        btCompraAbonoGym.setForeground(new java.awt.Color(102, 102, 102));
        btCompraAbonoGym.setText("Compra Abono Gimnasio");
        btCompraAbonoGym.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCompraAbonoGymActionPerformed(evt);
            }
        });

        btSalir.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        btSalir.setForeground(new java.awt.Color(102, 102, 102));
        btSalir.setText("Salir");
        btSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalirActionPerformed(evt);
            }
        });

        jlbDeportes.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jlbDeportes.setForeground(new java.awt.Color(102, 102, 102));
        jlbDeportes.setText("Deportes Ofertados");

        jlbHoras.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jlbHoras.setForeground(new java.awt.Color(102, 102, 102));
        jlbHoras.setText("Horas Libres");

        listDeportes.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Futbol7", "Futbol11", "Baloncesto", "Tenis", "Padel" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listDeportes);

        listHoras.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "11:00", "12:00", "16:00", "18:00" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(listHoras);

        String nombre = controlUsuarios.getNombre();
        
        jlbNombreUsuario.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jlbNombreUsuario.setForeground(new java.awt.Color(102, 102, 102));
        jlbNombreUsuario.setText(nombre);

        bVerHoras.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        bVerHoras.setForeground(new java.awt.Color(102, 102, 102));
        bVerHoras.setText("Ver Horas");
        bVerHoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVerHorasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(jlbNombreUsuario)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btCompraAbonoGym, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btContratacionMonitor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btAlquilerPista, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btMaterial, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btCompraAbonoPiscina, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlbDeportes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bVerHoras)
                    .addComponent(jlbHoras)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(84, 84, 84))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jlbNombreUsuario)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAlquilerPista)
                    .addComponent(jlbDeportes)
                    .addComponent(jlbHoras))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btContratacionMonitor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btMaterial)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCompraAbonoGym)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCompraAbonoPiscina)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btSalir))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bVerHoras)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btContratacionMonitorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btContratacionMonitorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btContratacionMonitorActionPerformed

    private void bVerHorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVerHorasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bVerHorasActionPerformed

    private void btAlquilerPistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlquilerPistaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btAlquilerPistaActionPerformed

    private void btCompraAbonoGymActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCompraAbonoGymActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btCompraAbonoGymActionPerformed

    private void btCompraAbonoPiscinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCompraAbonoPiscinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btCompraAbonoPiscinaActionPerformed

    private void btSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bVerHoras;
    private javax.swing.JButton btAlquilerPista;
    private javax.swing.JButton btCompraAbonoGym;
    private javax.swing.JButton btCompraAbonoPiscina;
    private javax.swing.JButton btContratacionMonitor;
    private javax.swing.JButton btMaterial;
    private javax.swing.JButton btSalir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jlbDeportes;
    private javax.swing.JLabel jlbHoras;
    private javax.swing.JLabel jlbNombreUsuario;
    private javax.swing.JList listDeportes;
    private javax.swing.JList listHoras;
    // End of variables declaration//GEN-END:variables
}
