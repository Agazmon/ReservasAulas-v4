package org.iesalandalus.programacion.reservasaulas.vista.iugrafica.controladoresvistas.controladoresAulas;

import org.iesalandalus.programacion.reservasaulas.controlador.IControladorReservasAulas;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.vista.iugrafica.utilidades.Dialogos;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControladorBorrarAula {

		@FXML private Button btAceptar;
	    @FXML private TextField tfNombre;
	    @FXML private Button btCancelar;

	    private IControladorReservasAulas controladorMVC;
	    
	    public void setControlador(IControladorReservasAulas modelo) {
	    	this.controladorMVC=modelo;
	    }
	    
	    @FXML
	    void cancelar() {
	    	Stage ventana = (Stage) btCancelar.getScene().getWindow();
	    	ventana.close();
	    }

	    @FXML
	    void aceptar() {
	    	try {
	    		String nombre = tfNombre.getText();
		    	if(nombre == null || nombre.trim().equals("")) {
					tfNombre.setStyle("-fx-border-color: red");
				} else {
					tfNombre.setStyle("fx-border-color: green");
				}
		    	if (nombre != null || !nombre.trim().equals("")) {
		    		Aula aulaBorrar = new Aula(nombre, 15);
		    		controladorMVC.borrarAula(controladorMVC.buscarAula(aulaBorrar));
		    		Dialogos.mostrarDialogoInformacion("Accion realizada", "Usted ha borrado el aula: " + nombre);
		    		Stage stage = (Stage) btAceptar.getScene().getWindow();
		    		stage.close();
		    	}
			} catch (Exception e) {
				Dialogos.mostrarDialogoError("Error", e.getMessage(), null);
			}
	    	
	    }

}
