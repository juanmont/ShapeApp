/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package VentanaGrafica;

import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Control.ControladorUsuarios;
import Daos.Conexion;

/**
 *
 * @author juanjose
 */
public class VentanaInicio extends javax.swing.JPanel {
	
	private JFrame frame;
	ControladorUsuarios control;
	Connection c;
	VentanaPrincipal ventanaPricipal;
    /**
     * Creates new form VentanaInicio
     */
    
    public VentanaInicio(VentanaPrincipal vPrincipal, Connection con, ControladorUsuarios cont) {
    	ventanaPricipal = vPrincipal;
    	this.c = con;
    	control = cont;
        initComponents();
        /*this.frame.add(panelLogin);
        this.frame.setVisible(true);*/
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    	/*this.frame = new JFrame("Ventana Login");
		this.frame.setSize(400, 400);
		this.frame.setResizable(false);*/
        panelLogin = new javax.swing.JPanel();
        jtfNombreUser = new javax.swing.JTextField();
        jlbUsuario = new javax.swing.JLabel();
        jlbContraseña = new javax.swing.JLabel();
        btEntrar = new javax.swing.JButton();
        jtfContraseña = new javax.swing.JPasswordField();

        setBackground(new java.awt.Color(0, 153, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153)));

        panelLogin.setBackground(new java.awt.Color(153, 153, 153));
        panelLogin.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelLogin.setForeground(new java.awt.Color(153, 153, 153));

        //jtfNombreUser.setText("NombreUsuario");
        jtfNombreUser.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jlbUsuario.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jlbUsuario.setText("USUARIO");

        jlbContraseña.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jlbContraseña.setText("CONTRASEÑA");

        btEntrar.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btEntrar.setForeground(new java.awt.Color(0, 102, 255));
        btEntrar.setText("ENTRAR");
        btEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEntrarActionPerformed(evt);
            }
        });

        //jtfContraseña.setText("0dxwauic");

        javax.swing.GroupLayout panelLoginLayout = new javax.swing.GroupLayout(panelLogin);
        panelLogin.setLayout(panelLoginLayout);
        panelLoginLayout.setHorizontalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLoginLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jlbContraseña))
                            .addGroup(panelLoginLayout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jlbUsuario)))
                        .addGap(0, 14, Short.MAX_VALUE))
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jtfNombreUser)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLoginLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btEntrar)
                .addGap(28, 28, 28))
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtfContraseña)
                .addContainerGap())
        );
        panelLoginLayout.setVerticalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jlbUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfNombreUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlbContraseña)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(btEntrar)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(panelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(122, 122, 122))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(panelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(71, 71, 71))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEntrarActionPerformed
        if((!jtfNombreUser.getText().isEmpty()) && (!jtfContraseña.getText().isEmpty())) {
          	control.login(jtfNombreUser.getText(), jtfContraseña.getText());
        	this.setVisible(false);
        }
        else JOptionPane.showMessageDialog(null,  "Error: Tienes que rellenar ambos campos.","", JOptionPane.ERROR_MESSAGE);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEntrar;
    private javax.swing.JLabel jlbContraseña;
    private javax.swing.JLabel jlbUsuario;
    private javax.swing.JPasswordField jtfContraseña;
    private javax.swing.JTextField jtfNombreUser;
    private javax.swing.JPanel panelLogin;
    // End of variables declaration//GEN-END:variables
}
