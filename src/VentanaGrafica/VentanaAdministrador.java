/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package VentanaGrafica;

import java.sql.Connection;
import java.util.ArrayList;

import javax.management.InstanceAlreadyExistsException;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import enums.UsuarioEnum;
import transfers.Admin;
import transfers.Instalaciones;
import transfers.Material;
import transfers.Usuario;
import Control.ControladorAlquilerCompra;
import Control.ControladorClases;
import Control.ControladorInstalaciones;
import Control.ControladorMateriales;
import Control.ControladorUsuarios;

/**
 *
 * @author juanjose
 */
public class VentanaAdministrador extends javax.swing.JPanel {

	ControladorAlquilerCompra controlAlquilerCompra;
	ControladorMateriales controlMateriales;
	ControladorClases controlClases;
	ControladorInstalaciones controlInstalaciones;
	ControladorUsuarios controlUsuarios;
	private JFrame frame;
	private Connection con;
	
    /**
     * Creates new form VentanaAdministrador
     */
    public VentanaAdministrador(Connection c, ControladorAlquilerCompra controlAlqComp, ControladorMateriales controlMat,
			ControladorClases controlCla, ControladorInstalaciones controlInst, ControladorUsuarios controlUsu) {
    	con = c;
    	controlAlquilerCompra = controlAlqComp;
		controlMateriales = controlMat;
		controlClases = controlCla;
		controlInstalaciones = controlInst;
		controlUsuarios = controlUsu;
        initComponents();
        /*this.frame.add(this);
        this.frame.setVisible(true);*/
        this.setVisible(true);
    }
    
    public void setFrame(boolean visible){
    	this.setVisible(visible);
    }

	/**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    	
    	panelAdmin = new JPanel();
        jLabel1 = new javax.swing.JLabel();
        jlbAdministrador = new javax.swing.JLabel();
        btVerUsers = new javax.swing.JButton();
        btVerFuncionarios = new javax.swing.JButton();
        btEntrenadores = new javax.swing.JButton();
        btVerMateriales = new javax.swing.JButton();
        btSalir = new javax.swing.JButton();
        btAñadirUsuario = new javax.swing.JButton();
        btAñadirPersonal = new javax.swing.JButton();
        btAñadirInstalacion = new javax.swing.JButton();
        btVerInstalaciones = new javax.swing.JButton();
        btAniadirMaterial = new javax.swing.JButton();
        PanelLista = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Lista = new javax.swing.JList();
        btVer = new javax.swing.JButton();
        btEliminar = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setBackground(new java.awt.Color(153, 204, 255));

        jlbAdministrador.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jlbAdministrador.setForeground(new java.awt.Color(102, 102, 102));
        jlbAdministrador.setText("ADMINISTRADOR");

        btVerUsers.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        btVerUsers.setForeground(new java.awt.Color(102, 102, 102));
        btVerUsers.setText("Ver Usuarios");
        btVerUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVerUsersActionPerformed(evt);
            }
        });

        btVerFuncionarios.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        btVerFuncionarios.setForeground(new java.awt.Color(102, 102, 102));
        btVerFuncionarios.setText("Ver Funcionarios");
        btVerFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVerFuncionariosActionPerformed(evt);
            }
        });

        btEntrenadores.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        btEntrenadores.setForeground(new java.awt.Color(102, 102, 102));
        btEntrenadores.setText("Ver Entrenadores");
        btEntrenadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEntrenadoresActionPerformed(evt);
            }
        });

        btVerMateriales.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        btVerMateriales.setForeground(new java.awt.Color(102, 102, 102));
        btVerMateriales.setText("Ver Materiales");
        btVerMateriales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVerMaterialesActionPerformed(evt);
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

        btAñadirUsuario.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        btAñadirUsuario.setForeground(new java.awt.Color(102, 102, 102));
        btAñadirUsuario.setText("Añadir Usuario");
        btAñadirUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAñadirUsuarioActionPerformed(evt);
            }
        });

        btAñadirPersonal.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        btAñadirPersonal.setForeground(new java.awt.Color(102, 102, 102));
        btAñadirPersonal.setText("Añadir Personal");
        btAñadirPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAñadirPersonalActionPerformed(evt);
            }
        });

        btAñadirInstalacion.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        btAñadirInstalacion.setForeground(new java.awt.Color(102, 102, 102));
        btAñadirInstalacion.setText("Añadir Instalación");
        btAñadirInstalacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAñadirInstalacionActionPerformed(evt);
            }
        });

        btVerInstalaciones.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        btVerInstalaciones.setForeground(new java.awt.Color(102, 102, 102));
        btVerInstalaciones.setText("Ver Instalaciones");
        btVerInstalaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVerInstalacionesActionPerformed(evt);
            }
        });

        btAniadirMaterial.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        btAniadirMaterial.setForeground(new java.awt.Color(102, 102, 102));
        btAniadirMaterial.setText("Añadir Material");
        btAniadirMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAniadirMaterialActionPerformed(evt);
            }
        });

        PanelLista.setBackground(new java.awt.Color(153, 204, 255));

        Lista.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Usuario1", "Usuario2", "Usuario3", "Usuario4" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(Lista);

        btVer.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        btVer.setForeground(new java.awt.Color(102, 102, 102));
        btVer.setText("Ver");
        btVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVerActionPerformed(evt);
            }
        });

        btEliminar.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        btEliminar.setForeground(new java.awt.Color(102, 102, 102));
        btEliminar.setText("Eliminar");
        btEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelListaLayout = new javax.swing.GroupLayout(PanelLista);
        PanelLista.setLayout(PanelListaLayout);
        PanelListaLayout.setHorizontalGroup(
            PanelListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelListaLayout.createSequentialGroup()
                .addContainerGap(117, Short.MAX_VALUE)
                .addComponent(btVer, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(btEliminar)
                .addGap(59, 59, 59))
            .addGroup(PanelListaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        PanelListaLayout.setVerticalGroup(
            PanelListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelListaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btEliminar)
                    .addComponent(btVer))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btAñadirPersonal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btVerMateriales, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btVerFuncionarios, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btEntrenadores, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btAñadirUsuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btVerInstalaciones, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btVerUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAniadirMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAñadirInstalacion, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSalir))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlbAdministrador)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(PanelLista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jlbAdministrador)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btVerUsers)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btVerFuncionarios)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btEntrenadores)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btVerMateriales)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btVerInstalaciones)
                        .addGap(37, 37, 37)
                        .addComponent(btAñadirUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btAniadirMaterial)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btAñadirPersonal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btAñadirInstalacion)
                        .addGap(17, 17, 17)
                        .addComponent(btSalir))
                    .addComponent(PanelLista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btSalirActionPerformed(java.awt.event.ActionEvent evt) {
    	System.exit(0);
    }

    private void btVerActionPerformed(java.awt.event.ActionEvent evt) {
    	 Object o = Lista.getSelectedValue();
         if(o instanceof Usuario){
        	 AltaUsuario panelUsuario = new AltaUsuario((Usuario)o, controlUsuarios);
             Lista.setVisible(false);
             PanelLista.add(panelUsuario);
         }
         else if(o instanceof Material){
        	 AltaMaterial panelMaterial = new AltaMaterial(controlMateriales);
        	 Lista.setVisible(false);
        	 PanelLista.add(panelMaterial);
         }
         else if(o instanceof Instalaciones){
        	 AltaInstalacion panelInstalacion = new AltaInstalacion(controlInstalaciones);
        	 Lista.setVisible(false);
        	 PanelLista.add(panelInstalacion);
         }
         else
      	   JOptionPane.showMessageDialog(Lista, "elemento no reconocido", "ERROR", ERROR);
    }

    private void btEliminarActionPerformed(java.awt.event.ActionEvent evt) {
       Object o = Lista.getSelectedValue();
       if(o instanceof Usuario)
    	   controlUsuarios.borrarUsuario(o);
       else if(o instanceof Material)
    	   controlMateriales.borrarMaterial(o);
       else if(o instanceof Instalaciones)
    	   controlInstalaciones.borrarInstalacion(o);
       else
    	   JOptionPane.showMessageDialog(Lista, "elemento no reconocido", "ERROR", ERROR);
    	   
    }

    private void btVerUsersActionPerformed(java.awt.event.ActionEvent evt) {
    	DefaultListModel<Usuario> modeloLista = new DefaultListModel<Usuario>();
    	ArrayList<Usuario> listaUsuarios = controlUsuarios.listaUsuario(UsuarioEnum.Socio);
    	for(int i = 0; i < listaUsuarios.size(); i++){
    		modeloLista.add(i, listaUsuarios.get(i));
    	}
    	Lista.removeAll();
        Lista.setModel(modeloLista);
    }

    private void btVerFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {
    	DefaultListModel<Usuario> modeloLista = new DefaultListModel<Usuario>();
    	ArrayList<Usuario> listaUsuarios = controlUsuarios.listaUsuario(UsuarioEnum.Funcionario);
    	for(int i = 0; i < listaUsuarios.size(); i++){
    		modeloLista.add(i, listaUsuarios.get(i));
    	}
    	Lista.removeAll();
        Lista.setModel(modeloLista);
    }

    private void btEntrenadoresActionPerformed(java.awt.event.ActionEvent evt) {
    	DefaultListModel<Usuario> modeloLista = new DefaultListModel<Usuario>();
    	ArrayList<Usuario> listaUsuarios = controlUsuarios.listaUsuario(UsuarioEnum.Entrenador);
    	for(int i = 0; i < listaUsuarios.size(); i++){
    		modeloLista.add(i, listaUsuarios.get(i));
    	}
    	Lista.removeAll();
        Lista.setModel(modeloLista);
    }

    private void btVerMaterialesActionPerformed(java.awt.event.ActionEvent evt) {
    	DefaultListModel<Material> modeloLista = new DefaultListModel<Material>();
    	ArrayList<Material> listaMateriales = controlMateriales.listaMateriales();
    	for(int i = 0; i < listaMateriales.size(); i++){
    		modeloLista.add(i, listaMateriales.get(i));
    	}
    	Lista.removeAll();
        Lista.setModel(modeloLista);
    }

    private void btVerInstalacionesActionPerformed(java.awt.event.ActionEvent evt) {
    	String[] s = null;
    	DefaultListModel<String[]> modeloLista = new DefaultListModel<String[]>();
    	ArrayList<Instalaciones> listaInstalaciones = controlInstalaciones.listaInstalaciones();
    	for(int i = 0; i < listaInstalaciones.size(); i++){
    		Instalaciones ist = listaInstalaciones.get(i);
    		s[0] = ist.getPista().toString();
    		s[1] = ist.getTipo().toString();
    		modeloLista.add(i, s);
    	}
    	Lista.removeAll();
        Lista.setModel(modeloLista);
    }

    private void btAñadirUsuarioActionPerformed(java.awt.event.ActionEvent evt) {
    	 AltaUsuario panelUsuario = new AltaUsuario(false, controlUsuarios);
         Lista.setVisible(false);
         PanelLista.add(panelUsuario);
    }

    private void btAniadirMaterialActionPerformed(java.awt.event.ActionEvent evt) {
    	 AltaMaterial panelMaterial = new AltaMaterial(controlMateriales);
         Lista.setVisible(false);
         PanelLista.add(panelMaterial);
    }

    private void btAñadirPersonalActionPerformed(java.awt.event.ActionEvent evt) {
    	  AltaUsuario panelUsuario = new AltaUsuario(true, controlUsuarios);
          Lista.setVisible(false);
          PanelLista.add(panelUsuario);
    }

    private void btAñadirInstalacionActionPerformed(java.awt.event.ActionEvent evt) {
        AltaInstalacion panelInstalacion = new AltaInstalacion(controlInstalaciones);
        Lista.setVisible(false);
        PanelLista.add(panelInstalacion);
        //this.
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList Lista;
    private javax.swing.JPanel PanelLista;
    private javax.swing.JButton btAniadirMaterial;
    private javax.swing.JButton btAñadirPersonal;
    private javax.swing.JButton btAñadirInstalacion;
    private javax.swing.JButton btAñadirUsuario;
    private javax.swing.JButton btEliminar;
    private javax.swing.JButton btEntrenadores;
    private javax.swing.JButton btSalir;
    private javax.swing.JButton btVer;
    private javax.swing.JButton btVerFuncionarios;
    private javax.swing.JButton btVerInstalaciones;
    private javax.swing.JButton btVerMateriales;
    private javax.swing.JButton btVerUsers;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlbAdministrador;
    private JPanel panelAdmin;
    // End of variables declaration//GEN-END:variables
}
