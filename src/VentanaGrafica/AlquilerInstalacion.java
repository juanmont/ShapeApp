/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package VentanaGrafica;

import java.sql.Date;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import transfers.Clases;
import transfers.Instalaciones;
import transfers.Material;
import transfers.Socio;
import Control.ControladorAlquilerCompra;
import Control.ControladorClases;
import Control.ControladorInstalaciones;
import Control.ControladorUsuarios;


/**
 *
 * @author Cristina
 */
public class AlquilerInstalacion extends javax.swing.JPanel implements ListSelectionListener{

	private ControladorAlquilerCompra controlAlq;
	private ControladorInstalaciones controlInst;
	private ControladorUsuarios controlUsuario;
	private ControladorClases controlClase;
	private ArrayList<Socio> listaSocios;
	private ArrayList<Clases> listaClase;
	boolean muestraLista;
	private ArrayList<Instalaciones> lista;
	private boolean[] horas;
	
    /**
     * Creates new form AlquilerMaterial
     * @param controlInstalaciones 
     * @param controlAlquilerCompra 
     */
    public AlquilerInstalacion(ControladorUsuarios controlUSuario,ControladorClases controlClase, ControladorAlquilerCompra controlAlquilerCompra, ControladorInstalaciones controlInstalaciones, boolean muestraLista) {
        this.controlUsuario = controlUSuario;
    	this.controlAlq = controlAlquilerCompra;
    	this.controlClase = controlClase;
        this.controlInst = controlInstalaciones;
        this.muestraLista = muestraLista;
    	initComponents();
    	etiquetaUsuarios.setVisible(muestraLista);
    	listaUsuarios.setVisible(muestraLista);
    	jScrollPane3.setVisible(muestraLista);
    	etiquetaClases.setVisible(muestraLista);
        jScrollPane4.setVisible(muestraLista);
        listaClases.setVisible(muestraLista);
    	
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

    	jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        tituloAlqInst = new javax.swing.JLabel();
        etiquetaInst = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaInstalaciones = new javax.swing.JList();
        etiquetaHoras = new javax.swing.JLabel();
        botonAlqu = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        listaHoras = new javax.swing.JList();
        etiquetaUsuarios = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaUsuarios = new javax.swing.JList();
        etiquetaClases = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        listaClases = new javax.swing.JList();

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setBackground(new java.awt.Color(153, 204, 255));

        tituloAlqInst.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        tituloAlqInst.setText("ALQUILER INSTALACION");

        etiquetaInst.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        etiquetaInst.setText("Deportes");

        jScrollPane2.setViewportView(listaInstalaciones);

        etiquetaHoras.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        etiquetaHoras.setText("Horas");

        botonAlqu.setText("Alquiler Instalacion");
        botonAlqu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAlquActionPerformed(evt);
            }
        });

        DefaultListModel<Clases> modeloClase = new DefaultListModel<Clases>();
    	listaClase = this.controlClase.listaClasesAll();
    	if(!listaClase.isEmpty()){
    		for(int i = 0; i < listaClase.size(); i++){
    			modeloClase.add(i, listaClase.get(i));
        	}
    	}
    	this.listaClases.removeAll();
    	this.listaClases.setModel(modeloClase);
        
        DefaultListModel<Instalaciones> modeloInstalacion = new DefaultListModel<Instalaciones>();
        lista = this.controlInst.listaInstalaciones();
    	if(!lista.isEmpty()){
    		for(int i = 0; i < lista.size(); i++){
    			modeloInstalacion.add(i, lista.get(i));
        	}
    	}
    	this.listaInstalaciones.removeAll();
    	this.listaInstalaciones.setModel(modeloInstalacion);
    	this.listaInstalaciones.addListSelectionListener(this);
        
        DefaultListModel<Socio> modeloLista = new DefaultListModel<Socio>();
    	listaSocios = controlUsuario.listaSocios();
    	if(!listaSocios.isEmpty()){
    		for(int i = 0; i < listaSocios.size(); i++){
        		modeloLista.add(i, listaSocios.get(i));
        	}
    	}
       
    	listaUsuarios.removeAll();
        listaUsuarios.setModel(modeloLista);
        jScrollPane5.setViewportView(listaHoras);

        etiquetaUsuarios.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        etiquetaUsuarios.setText("Usuarios");

        jScrollPane3.setViewportView(listaUsuarios);

        etiquetaClases.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        etiquetaClases.setText("Clases");

        jScrollPane4.setViewportView(listaClases);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(etiquetaClases)
                        .addGap(11, 11, 11)
                        .addComponent(tituloAlqInst))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(etiquetaInst)
                                .addGap(34, 34, 34)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(etiquetaHoras)
                                .addGap(46, 46, 46)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(etiquetaUsuarios)))))
                .addGap(60, 60, 60))
            .addGroup(layout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addComponent(botonAlqu)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloAlqInst)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaInst)
                    .addComponent(etiquetaHoras)
                    .addComponent(etiquetaUsuarios)
                    .addComponent(etiquetaClases))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(botonAlqu)
                .addContainerGap())
        );
    }// </editor-fold>                        

    private void botonAlquActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    	if(!this.listaInstalaciones.isSelectionEmpty() && !this.listaHoras.isSelectionEmpty()
    			/*&& !this.listaUsuarios.isSelectionEmpty() && this.listaClases.isSelectionEmpty()*/){
    		
    		if(muestraLista == true && !this.listaUsuarios.isSelectionEmpty() && !this.listaClases.isSelectionEmpty()){
    			Instalaciones mat = this.lista.get(listaInstalaciones.getSelectedIndex());
    	    	java.util.Date fecha1 = new java.util.Date();
    	    	long date = fecha1.getTime();
    	    	Date fecha = new Date(date);
    	    	//Date fecha = new Date(fecha1.getYear(), fecha1.getMonth(), fecha1.getDate());
    	    	int hora =  Integer.parseInt((String) listaHoras.getSelectedValue());
    	    	String socio = listaSocios.get(listaUsuarios.getSelectedIndex()).getNick();
    	    	if(controlAlq.alquilarInstalacion(mat.getNumero(), socio, hora, fecha, -1)){
    				DefaultListModel<String> modeloListaHoras = new DefaultListModel<String>();
    				horas = controlInst.verHoras(mat);
    		    	if(horas.length != 0){
    		    		int a = 0;
    		    		for(int i = 0; i < horas.length; i++){
    		    			if(horas[i]){
    		    				modeloListaHoras.add(a, Integer.toString(i + 9));
    		    				a++;
    		    			}
    		    		}
    		    	}
    		    	listaHoras.removeAll();
    		    	listaHoras.setModel(modeloListaHoras);
    		    	JOptionPane.showMessageDialog(null,  "Instalacion Alquilada","EXITO", JOptionPane.INFORMATION_MESSAGE);
    	    	}
    	    	else
    	    		JOptionPane.showConfirmDialog(null, "Error al alquilar la instalacion", "ERROR", JOptionPane.INFORMATION_MESSAGE);
    		}else if(muestraLista == false){
    			Instalaciones mat = this.lista.get(listaInstalaciones.getSelectedIndex());
    	    	java.util.Date fecha1 = new java.util.Date();
    	    	long date = fecha1.getTime();
    	    	Date fecha = new Date(date);
    	    	//Date fecha = new Date(fecha1.getYear(), fecha1.getMonth(), fecha1.getDate());
    	    	int hora =  Integer.parseInt((String) listaHoras.getSelectedValue());
    	    	String socio = controlUsuario.getNick();
    	    	if(controlAlq.alquilarInstalacion(mat.getNumero(), socio, hora, fecha, -1)){
    				DefaultListModel<String> modeloListaHoras = new DefaultListModel<String>();
    				horas = controlInst.verHoras(mat);
    		    	if(horas.length != 0){
    		    		int a = 0;
    		    		for(int i = 0; i < horas.length; i++){
    		    			if(horas[i]){
    		    				modeloListaHoras.add(a, Integer.toString(i + 9));
    		    				a++;
    		    			}
    		    		}
    		    	}
    		    	listaHoras.removeAll();
    		    	listaHoras.setModel(modeloListaHoras);
    		    	JOptionPane.showMessageDialog(null,  "Instalacion Alquilada","EXITO", JOptionPane.INFORMATION_MESSAGE);
    	    	}
    	    	else
    	    		JOptionPane.showConfirmDialog(null, "Error al alquilar la instalacion", "ERROR", JOptionPane.INFORMATION_MESSAGE);
    		}
    		
	    
    	}else if(!this.listaInstalaciones.isSelectionEmpty() && !this.listaHoras.isSelectionEmpty() 
    			&& this.listaUsuarios.isSelectionEmpty() && !this.listaClases.isSelectionEmpty()){
    		Instalaciones mat = this.lista.get(listaInstalaciones.getSelectedIndex());
	    	java.util.Date fecha1 = new java.util.Date();
	    	long date = fecha1.getTime();
	    	Date fecha = new Date(date);
	    	//Date fecha = new Date(fecha1.getYear(), fecha1.getMonth(), fecha1.getDate());
	    	int hora =  Integer.parseInt((String) listaHoras.getSelectedValue());
	    	Clases clas = listaClase.get(this.listaClases.getSelectedIndex());
	    	if(controlAlq.alquilarInstalacion(mat.getNumero(), clas.getIdEntrenador(), hora, fecha, clas.getId())){
				DefaultListModel<String> modeloListaHoras = new DefaultListModel<String>();
				horas = controlInst.verHoras(mat);
		    	if(horas.length != 0){
		    		int a = 0;
		    		for(int i = 0; i < horas.length; i++){
		    			if(horas[i]){
		    				modeloListaHoras.add(a, Integer.toString(i + 9));
		    				a++;
		    			}
		    		}
		    	}
		    	listaHoras.removeAll();
		    	listaHoras.setModel(modeloListaHoras);
		    	JOptionPane.showMessageDialog(null,  "Instalacion Alquilada","EXITO", JOptionPane.INFORMATION_MESSAGE);
	    	}
	    	else
	    		JOptionPane.showConfirmDialog(null, "Error al alquilar el material", "ERROR", JOptionPane.INFORMATION_MESSAGE);
    	}else if(!this.listaClases.isSelectionEmpty() && !this.listaUsuarios.isSelectionEmpty())
    		JOptionPane.showConfirmDialog(null, "No puedes coger los campos Usuarios y Clases a la vez.", "ERROR", JOptionPane.INFORMATION_MESSAGE);
    	else
    		JOptionPane.showConfirmDialog(null, "Todos los campos deben ser seleccionados", "ERROR", JOptionPane.INFORMATION_MESSAGE);
    }                                        


    // Variables declaration - do not modify                     
    private javax.swing.JButton botonAlqu;
    private javax.swing.JLabel etiquetaHoras;
    private javax.swing.JLabel etiquetaInst;
    private javax.swing.JLabel etiquetaUsuarios;
    private javax.swing.JLabel etiquetaClases;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JList listaClases;
    private javax.swing.JList listaHoras;
    private javax.swing.JList listaInstalaciones;
    private javax.swing.JList listaUsuarios;
    private javax.swing.JLabel tituloAlqInst;
    // End of variables declaration                   

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		if(this.listaInstalaciones.getSelectedIndex() >= 0){
			Instalaciones ins = this.lista.get(listaInstalaciones.getSelectedIndex());
			DefaultListModel<String> modeloListaHoras = new DefaultListModel<String>();
			horas = controlInst.verHoras(ins);
	    	if(horas.length != 0){
	    		int a = 0;
	    		for(int i = 0; i < horas.length; i++){
	    			if(horas[i]){
	    				modeloListaHoras.add(a, Integer.toString(i + 9));
	    				a++;
	    			}
	    		}
	    	}
	    	listaHoras.removeAll();
	    	listaHoras.setModel(modeloListaHoras);
		}
	}
}
