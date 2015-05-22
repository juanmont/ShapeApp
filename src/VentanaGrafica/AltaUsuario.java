/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package VentanaGrafica;

import javax.swing.JOptionPane;

import enums.SexoEnum;
import enums.UsuarioEnum;
import Control.ControladorUsuarios;
import transfers.Entrenador;
import transfers.Funcionario;
import transfers.Socio;
import transfers.Usuario;

/**
 *
 * @author juanjose
 */
public class AltaUsuario extends javax.swing.JPanel {
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
        	jtSueldo.setVisible(false);
        	jlSueldo.setVisible(false);
        	jtHoraEntrada.setVisible(false);
        	jlHoraEntrada.setVisible(false);
        	jtHoraSalida.setVisible(false);
        	jlHoraSalida.setVisible(false);
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
        jlSueldo = new javax.swing.JLabel();
        jtSueldo = new javax.swing.JTextField();
        jlHoraEntrada = new javax.swing.JLabel();
        jtHoraEntrada = new javax.swing.JTextField();
        jlHoraSalida = new javax.swing.JLabel();
        jtHoraSalida = new javax.swing.JTextField();

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

        jcbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Entrenador", "Funcionario" }));

        jlSueldo.setText("Sueldo");

        jlHoraEntrada.setText("Hora entrada:");

        jlHoraSalida.setText("Hora salida:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                .addComponent(jlbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtfEmail))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlbDireccion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtfDireccion))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jrMaculino)
                                .addGap(18, 18, 18)
                                .addComponent(jrFemenino))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlSueldo)
                                .addGap(18, 18, 18)
                                .addComponent(jtSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jlHoraEntrada)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtHoraEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btGuardar))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                                .addComponent(jlHoraSalida)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtHoraSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbDireccion)
                    .addComponent(jtfDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlSueldo)
                    .addComponent(jtSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlHoraEntrada)
                    .addComponent(jtHoraEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtHoraSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlHoraSalida))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btGuardar)
                .addContainerGap(42, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    /**
     * boton para guardar un usuario, se comprueba que todos los campos esten introducidos
     * se rellena el usuario con los datos introducidos.
     * @param evt
     */
    private void btGuardarActionPerformed(java.awt.event.ActionEvent evt) {
        if(compruebaDatos()){
        	UsuarioEnum tipoU = null;
        	if(jcbTipo.isVisible()){
        	String tipo = jcbTipo.getSelectedItem().toString();
        	if(tipo.equalsIgnoreCase("Entrenador")){
        		Entrenador ent = new Entrenador();
        		ent.rellenaDatos(rellenaUsuario());
        		if(compruebaDatosPersona()){
        			ent = rellenaEntrenador(ent);
        			if(control.altaUsuario(null, null, null, ent))
        				JOptionPane.showConfirmDialog(btGuardar, "Guardado Correctamente", "OK", JOptionPane.OK_OPTION);
        			else
            			JOptionPane.showConfirmDialog(btGuardar, "Error al guardar el entrenador", "ERROR", JOptionPane.ERROR_MESSAGE);
        			}
        		else
        			JOptionPane.showMessageDialog(btGuardar, "Debe asignar datos especificos de personal", "ERROR", ERROR);
        	}
        	if(tipo.equalsIgnoreCase("Funcionario")){
        		Funcionario func = new Funcionario();
        		func.rellenaDatos(rellenaUsuario());
        		if(compruebaDatosPersona()){
        			func = rellenaFuncionario(func);
        			if(control.altaUsuario(null, null ,func, null))
        				JOptionPane.showConfirmDialog(btGuardar, "Guardado Correctamente", "OK", JOptionPane.OK_OPTION);
        			else
            			JOptionPane.showConfirmDialog(btGuardar, "Error al guardar el funcionario", "ERROR", JOptionPane.ERROR_MESSAGE);
        			
        			}
        		else
        			JOptionPane.showMessageDialog(btGuardar, "Debe asignar datos especificos de personal", "ERROR", ERROR);
        		
        	}
        	}
        	else{
        		Socio socio = new Socio();
        		socio.rellenaDatos(rellenaUsuario());
        		if(control.altaUsuario(socio, null, null, null))
        			JOptionPane.showConfirmDialog(btGuardar, "Guardado Correctamente", "OK", JOptionPane.OK_OPTION);
        		else
        			JOptionPane.showConfirmDialog(btGuardar, "Error al guardar el socio", "ERROR", JOptionPane.ERROR_MESSAGE);
        	}
        	
        }
        else JOptionPane.showMessageDialog(btGuardar, "Introduce los datos necesarios", "ERROR", ERROR);
    }

    /**
     * rellena los datos del usuario con los parametros introducidos en los JTextField.
     * @return usuario con los datos rellenados.
     */
    private Usuario rellenaUsuario() {
    	Usuario socio = new Usuario();
    	socio.setNombre(jtfNombre.getText());
    	socio.setApellidos(jtfApellidos.getText());
    	socio.setDNI(jtfDNI.getText());
		socio.setNick(jtfUsuario.getText());
		socio.setPass(jtfContraseña.getText());
		socio.setTelefono(jtfTelefono.getText());
		socio.setDireccion(jtfDireccion.getText());
		socio.setEmail(jtfEmail.getText());
		if(jrMaculino.isSelected() == true)
			socio.setSexo("MASCULINO");
		else if(jrFemenino.isSelected() == true)
			socio.setSexo("FEMENINO");
		return socio;
		
	}
    
   private Funcionario rellenaFuncionario(Funcionario func){
	   func.setSueldo(Integer.parseInt(jtSueldo.getText()));
	   func.setHoraEntrada(jtHoraEntrada.getText());
	   func.setHoraSalida(jtHoraSalida.getText());
	   return func;
   }
   
   private boolean compruebaDatosPersona(){
	   return jtSueldo.getText() != "" && jtHoraEntrada.getText() != "" && jtHoraSalida.getText() != "";
   }
   
   private Entrenador rellenaEntrenador(Entrenador ent){
	   ent.setSueldo(Integer.parseInt(jtSueldo.getText()));
	   ent.setHoraEntrada(jtHoraEntrada.getText());
	   ent.setHoraSalida(jtHoraSalida.getText());
	   return ent;
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
    private javax.swing.JLabel jlHoraEntrada;
    private javax.swing.JLabel jlHoraSalida;
    private javax.swing.JLabel jlSueldo;
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
    private javax.swing.JTextField jtHoraEntrada;
    private javax.swing.JTextField jtHoraSalida;
    private javax.swing.JTextField jtSueldo;
    private javax.swing.JTextField jtfApellidos;
    private javax.swing.JTextField jtfContraseña;
    private javax.swing.JTextField jtfDNI;
    private javax.swing.JTextField jtfDireccion;
    private javax.swing.JTextField jtfEmail;
    private javax.swing.JTextField jtfNombre;
    private javax.swing.JTextField jtfTelefono;
    private javax.swing.JTextField jtfUsuario;
    private Usuario socio;
    // End of variables declaration//GEN-END:variables
}
