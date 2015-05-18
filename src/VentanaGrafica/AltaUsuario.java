/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package VentanaGrafica;

import javax.swing.JOptionPane;

import enums.SexoEnum;
import Control.ControladorUsuarios;
import transfers.Entrenador;
import transfers.Funcionario;
import transfers.Usuario;

/**
 *
 * @author juanjose
 */
public class AltaUsuario extends javax.swing.JPanel {
	private Usuario socio;
	private ControladorUsuarios control;
    /**
     * Creates new form AltaMaterial
     */
    public AltaUsuario(boolean personal, ControladorUsuarios controlador) {
    	control = controlador;
        initComponents();
        if(!personal){
        	jlTipo.setVisible(false);
        	jcbTipo.setVisible(false);
        }
    }
    
    public AltaUsuario(Usuario socio, ControladorUsuarios controlador){
    	control = controlador;
    	initComponents();
    	jlTipo.setVisible(false);
    	jcbTipo.setVisible(false);
    	rellenaDatos(socio);
    	inhabilitaCampos();
    }

    /**
     * Inhabilita los JTextField de Nombre, Apellidos y DNI para que no puedan ser editados.
     */
    private void inhabilitaCampos() {
    	jtfNombre.setEditable(false);
		jtfApellidos.setEditable(false);
		jtfDNI.setEditable(false);
	}

    /**
     * Rellena los campos del panel con los datos del usuario introducido.
     * @param socio- usuario con los datos a introducir.
     */
	private void rellenaDatos(Usuario socio) {
		jtfNombre.setText(socio.getNombre());
		jtfApellidos.setText(socio.getApellidos());
		jtfUsuario.setText(socio.getNick());
		jtfContraseña.setText(socio.getPass());
		jtfDNI.setText(socio.getDNI());
		jtfEmail.setText(socio.getEmail());
		jtfTelefono.setText(socio.getDireccion());
		jtfDireccion.setText(socio.getDireccion());
		SexoEnum sexo = socio.getSexo();
		if(sexo == SexoEnum.MASCULINO){
			jrMaculino.setSelected(true);
			jrFemenino.setSelected(false);
		}
		else{
			jrMaculino.setSelected(false);
			jrFemenino.setSelected(true);
		}
	}

	/**
     *Crea los componentes y los pone en el sitio indicado
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jlbApellidos = new javax.swing.JLabel();
        jrMaculino = new javax.swing.JRadioButton();
        jlbDNI = new javax.swing.JLabel();
        jtfDireccion = new javax.swing.JTextField();
        jlbTelefono = new javax.swing.JLabel();
        btGuardar = new javax.swing.JButton();
        jlbEmail = new javax.swing.JLabel();
        jlbContraseña = new javax.swing.JLabel();
        jlbSexo = new javax.swing.JLabel();
        jlbDireccion = new javax.swing.JLabel();
        jrFemenino = new javax.swing.JRadioButton();
        jtfNombre = new javax.swing.JTextField();
        jlbUsuario = new javax.swing.JLabel();
        jtfApellidos = new javax.swing.JTextField();
        jlbNombre = new javax.swing.JLabel();
        jlbTitulo = new javax.swing.JLabel();
        jtfDNI = new javax.swing.JTextField();
        jtfContraseña = new javax.swing.JTextField();
        jtfEmail = new javax.swing.JTextField();
        jtfUsuario = new javax.swing.JTextField();
        jtfTelefono = new javax.swing.JTextField();
        jlTipo = new javax.swing.JLabel();
        jcbTipo = new javax.swing.JComboBox();

        setBackground(new java.awt.Color(153, 204, 255));

        jlbApellidos.setText("Apellidos");

        jrMaculino.setBackground(new java.awt.Color(153, 204, 255));
        jrMaculino.setText("Masculino");
        
        jlbDNI.setText("DNI");
        
        jlbTelefono.setText("Telefono");

        btGuardar.setText("GUARDAR");
        btGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGuardarActionPerformed(evt);
            }
        });

        jlbEmail.setText("Email");

        jlbContraseña.setText("Contraseña");

        jlbSexo.setText("Sexo");

        jlbDireccion.setText("Direccion");

        jrFemenino.setBackground(new java.awt.Color(153, 204, 255));
        jrFemenino.setText("Femenino");

        jlbUsuario.setText("Usuario");

        jlbNombre.setText("Nombre");

        jlbTitulo.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jlbTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbTitulo.setText("Usuario");
        jlTipo.setText("Tipo");

        jcbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Entrenador", "Funcionario", "Socio" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jrMaculino)
                                .addGap(18, 18, 18)
                                .addComponent(jrFemenino)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(btGuardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jlbNombre)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jlbDNI)
                                            .addGap(23, 23, 23)
                                            .addComponent(jtfDNI)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jlbUsuario)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jlbApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtfApellidos))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jlbContraseña)
                                            .addComponent(jlbTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jtfTelefono)
                                            .addComponent(jtfContraseña)))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlbDireccion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtfDireccion))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtfEmail))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jlTipo)
                                .addGap(18, 18, 18)
                                .addComponent(jcbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(133, 133, 133)
                                .addComponent(jlbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jlbTitulo)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlTipo)
                    .addComponent(jcbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbNombre)
                    .addComponent(jlbApellidos)
                    .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbDNI)
                    .addComponent(jlbTelefono)
                    .addComponent(jtfDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbSexo)
                    .addComponent(jrMaculino)
                    .addComponent(jrFemenino))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbUsuario)
                    .addComponent(jlbContraseña)
                    .addComponent(jtfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbEmail)
                    .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbDireccion)
                    .addComponent(jtfDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btGuardar))
                .addGap(21, 21, 21))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        // TODO add your handling code here:
    }

    /**
     * boton para guardar un usuario, se comprueba que todos los campos esten introducidos
     * se rellena el usuario con los datos introducidos.
     * @param evt
     */
    private void btGuardarActionPerformed(java.awt.event.ActionEvent evt) {
        if(compruebaDatos()){
        	socio = rellenaUsuario();
        	control.altaUsuario(socio);
        }
        else JOptionPane.showMessageDialog(btGuardar, "Introduce los datos necesarios", "ERROR", ERROR);
    }

    /**
     * rellena los datos del usuario con los parametros introducidos en los JTextField.
     * @return usuario con los datos rellenados.
     */
    private Usuario rellenaUsuario() {
    	String tipo = jcbTipo.getSelectedItem().toString();
    	if(tipo.equalsIgnoreCase("Entrenador"))
    		socio = new Entrenador();
    	if(tipo.equalsIgnoreCase("Funcionario"))
    		socio = new Funcionario();
    	if(tipo.equalsIgnoreCase("Usuario"))
    		socio = new Usuario();
    	socio.setNombre(jtfNombre.getText());
    	socio.setApellidos(jtfApellidos.getText());
    	socio.setDNI(jtfDNI.getText());
		socio.setNick(jtfUsuario.getText());
		socio.setPass(jtfContraseña.getText());
		socio.setTelefono(jtfTelefono.getText());
		socio.setDireccion(jtfDireccion.getText());
		socio.setEmail(jtfEmail.getText());
		if(jrMaculino.isSelected() == true)
			socio.setSexo("Maculino");
		else if(jrFemenino.isSelected() == true)
			socio.setSexo("Femenino");
		return socio;
		
	}

    /**
     * comprueba que todos los campos tengan algo introducido.
     * @return si estan todos los campos ocupados.
     */
	private boolean compruebaDatos() {
		return (!jtfNombre.getText().isEmpty()) && (!jtfApellidos.getText().isEmpty()) && (!jtfDNI.getText().isEmpty())
				&& (!jtfUsuario.getText().isEmpty()) && (!jtfContraseña.getText().isEmpty()) && (!jtfTelefono.getText().isEmpty())
				&& (!jtfEmail.getText().isEmpty()) && (!jtfDireccion.getText().isEmpty());
	}


	// Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btGuardar;
    private javax.swing.JComboBox jcbTipo;
    private javax.swing.JLabel jlTipo;
    private javax.swing.JLabel jlbApellidos;
    private javax.swing.JLabel jlbContraseña;
    private javax.swing.JLabel jlbDNI;
    private javax.swing.JLabel jlbDireccion;
    private javax.swing.JLabel jlbEmail;
    private javax.swing.JLabel jlbNombre;
    private javax.swing.JLabel jlbSexo;
    private javax.swing.JLabel jlbTelefono;
    private javax.swing.JLabel jlbTitulo;
    private javax.swing.JLabel jlbUsuario;
    private javax.swing.JRadioButton jrFemenino;
    private javax.swing.JRadioButton jrMaculino;
    private javax.swing.JTextField jtfApellidos;
    private javax.swing.JTextField jtfContraseña;
    private javax.swing.JTextField jtfDNI;
    private javax.swing.JTextField jtfDireccion;
    private javax.swing.JTextField jtfEmail;
    private javax.swing.JTextField jtfNombre;
    private javax.swing.JTextField jtfTelefono;
    private javax.swing.JTextField jtfUsuario;
    // End of variables declaration//GEN-END:variables
}
