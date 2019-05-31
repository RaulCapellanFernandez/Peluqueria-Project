package es.peluqueria.data;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import es.peluqueria.entidades.Empleados;
import es.peluqueria.entidades.Productos;
import es.peluqueria.entidades.Ventas;
import es.peluqueria.persistence.PersistEmpleados;
import es.peluqueria.persistence.PersistProducto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class VentaController implements Initializable{
	String nombre;
	int price;
	int id;
	int cantidad = 1;
	int total = 0;
	List<Ventas> listaVentas = new ArrayList<Ventas>();
	List<Productos> listaProducto = new ArrayList<Productos>();
	
    @FXML
    private JFXButton depilacionButton;

    @FXML
    private JFXButton lavadoButton;

    @FXML
    private JFXButton barbaButton;

    @FXML
    private JFXButton corteButton;

    @FXML
    private JFXButton tinteButton;

    @FXML
    private JFXButton peinadoButton;

    @FXML
    private JFXButton atrasButton;

    @FXML
    private JFXButton pagarButton;

    @FXML
    private Label totalLabel;

    @FXML
    private Label empleadoLabel;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	empleadoLabel.setText(LogController.nombre);
    	
    	PersistProducto persistP = new PersistProducto();
    	listaProducto = persistP.recuperar();
    	}
    
    @FXML
    void eventCorte(ActionEvent event) {
    	total += listaProducto.get(0).getPrecio();
    	totalLabel.setText(Integer.toString(total)+" €");
    }
    @FXML
    void eventBarba(ActionEvent event) {
    	total += listaProducto.get(4).getPrecio();
    	totalLabel.setText(Integer.toString(total)+" €");
    }
    
    @FXML
    void eventDepilacion(ActionEvent event) {
    	total += listaProducto.get(3).getPrecio();
    	totalLabel.setText(Integer.toString(total)+" €");
    }

    @FXML
    void eventLavado(ActionEvent event) {
    	total += listaProducto.get(5).getPrecio();
    	totalLabel.setText(Integer.toString(total)+" €");
    }

    @FXML
    void eventPeinado(ActionEvent event) {
    	total += listaProducto.get(2).getPrecio();
    	totalLabel.setText(Integer.toString(total)+" €");
    }

    @FXML
    void eventTinte(ActionEvent event) {
    	total += listaProducto.get(1).getPrecio();
    	totalLabel.setText(Integer.toString(total)+" €");
    }
    
}
