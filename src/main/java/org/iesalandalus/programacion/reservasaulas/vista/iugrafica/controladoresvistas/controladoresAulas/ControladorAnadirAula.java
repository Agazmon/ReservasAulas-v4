package org.iesalandalus.programacion.reservasaulas.vista.iugrafica.controladoresvistas.controladoresAulas;

import org.iesalandalus.programacion.reservasaulas.controlador.IControladorReservasAulas;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.vista.iugrafica.utilidades.Dialogos;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControladorAnadirAula {

    @FXML private TextField tfCapacidad;
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
    		String capacidad = tfCapacidad.getText();
			if(nombre == null || nombre.trim().equals("")) {
				tfNombre.setStyle("-fx-border-color: red");
			}
			else {
				tfNombre.setStyle("-fx-border-color: green");
			}
			if(!capacidad.matches("[0-9]{1,3}")){
				tfCapacidad.setStyle("-fx-border-color: red");
			} else {
				tfCapacidad.setStyle("-fx-border-color: green");
			}
			if(nombre != null && !nombre.trim().equals("") && capacidad.matches("[0-9]{1,3}")) {
				controladorMVC.insertarAula(new Aula(nombre, Integer.parseInt(capacidad)));
				Stage stage = (Stage) btAceptar.getScene().getWindow();
				stage.close();
			}
		} catch (Exception e) {
			Dialogos.mostrarDialogoError("Error", e.getMessage(), null);
		}
    }

}
