/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanaGrafica;

import Control.ControladorAlquilerCompra;
import Control.ControladorInstalaciones;

/**
 *
 * @author Cristina
 */
public class ContratacionEntrenador extends javax.swing.JPanel {

	ControladorAlquilerCompra controlCompra;
	ControladorInstalaciones controlInstalaciones;
	
    /**
     * Creates new form ContratacionEntrenador
     */
    public ContratacionEntrenador(ControladorAlquilerCompra controlComp, ControladorInstalaciones controlInst) {
    	controlCompra = controlComp;
    	controlInstalaciones = controlInst;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        TituloEntrenador = new java.awt.Label();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaEntrenador = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaHoras = new javax.swing.JList();
        entrenador = new javax.swing.JLabel();
        horasLibres = new javax.swing.JLabel();
        contratar = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 204, 255));

        TituloEntrenador.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TituloEntrenador.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        TituloEntrenador.setText("CONTRATACION ENTRENADOR");

        jScrollPane1.setViewportView(listaEntrenador);

        jScrollPane2.setViewportView(listaHoras);

        entrenador.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        entrenador.setForeground(new java.awt.Color(102, 102, 102));
        entrenador.setText("Entrenador");

        horasLibres.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        horasLibres.setForeground(new java.awt.Color(102, 102, 102));
        horasLibres.setText("Horas Libres");

        contratar.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        contratar.setForeground(new java.awt.Color(102, 102, 102));
        contratar.setText("Contratar Entrenador");
        contratar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contratarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TituloEntrenador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(entrenador)
                        .addGap(103, 103, 103)
                        .addComponent(horasLibres)))
                .addGap(29, 29, 29))
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(contratar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(TituloEntrenador, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(entrenador)
                    .addComponent(horasLibres))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(contratar)
                .addContainerGap(21, Short.MAX_VALUE))
        );
    }// </editor-fold>                        

    private void contratarActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         


    // Variables declaration - do not modify                     
    private java.awt.Label TituloEntrenador;
    private javax.swing.JButton contratar;
    private javax.swing.JLabel entrenador;
    private javax.swing.JLabel horasLibres;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList listaEntrenador;
    private javax.swing.JList listaHoras;
    // End of variables declaration                   
}