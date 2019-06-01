package es.peluqueria.data;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import es.peluqueria.entidades.Empleados;
import es.peluqueria.entidades.Productos;
import es.peluqueria.entidades.Ventas;
import es.peluqueria.persistence.PersistEmpleados;
import es.peluqueria.persistence.PersistProducto;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class VentaController implements Initializable{
	public static List<Ventas> listaVentas = new ArrayList<Ventas>();
	
	String nombre;
	int total = 0;
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
    private Label totalLabel;

    @FXML
    private Label empleadoLabel;
    
    @FXML
    private JFXButton pagarButton;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	empleadoLabel.setText(LogController.empleado.getNombre());
    	
    	PersistProducto persistP = new PersistProducto();
    	listaProducto = persistP.recuperar();
    	}
    
    @FXML
    void eventCorte(ActionEvent event) {
    	total += listaProducto.get(0).getPrecio();
    	totalLabel.setText(Integer.toString(total)+" €");
    	
    	Ventas venta = new Ventas();
    	venta.setEmpleado(LogController.empleado);
    	venta.setTotalVenta(listaProducto.get(0).getPrecio());
    	venta.setFechaVenta(new Date());
    	venta.setProducto(listaProducto.get(0));
    	
    	listaVentas.add(venta);
    }
    @FXML
    void eventBarba(ActionEvent event) {
    	total += listaProducto.get(4).getPrecio();
    	totalLabel.setText(Integer.toString(total)+" €");
    	
    	Ventas venta = new Ventas();
    	venta.setEmpleado(LogController.empleado);
    	venta.setTotalVenta(listaProducto.get(4).getPrecio());
    	venta.setFechaVenta(new Date());
    	venta.setProducto(listaProducto.get(4));
    	
    	listaVentas.add(venta);
    }
    
    @FXML
    void eventDepilacion(ActionEvent event) {
    	total += listaProducto.get(3).getPrecio();
    	totalLabel.setText(Integer.toString(total)+" €");
    	
    	Ventas venta = new Ventas();
    	venta.setEmpleado(LogController.empleado);
    	venta.setTotalVenta(listaProducto.get(3).getPrecio());
    	venta.setFechaVenta(new Date());
    	venta.setProducto(listaProducto.get(3));
    	
    	listaVentas.add(venta);
    }

    @FXML
    void eventLavado(ActionEvent event) {
    	total += listaProducto.get(5).getPrecio();
    	totalLabel.setText(Integer.toString(total)+" €");
    	
    	Ventas venta = new Ventas();
    	venta.setEmpleado(LogController.empleado);
    	venta.setTotalVenta(listaProducto.get(5).getPrecio());
    	venta.setFechaVenta(new Date());
    	venta.setProducto(listaProducto.get(5));
    	
    	listaVentas.add(venta);
    }

    @FXML
    void eventPeinado(ActionEvent event) {
    	total += listaProducto.get(2).getPrecio();
    	totalLabel.setText(Integer.toString(total)+" €");
    	
    	Ventas venta = new Ventas();
    	venta.setEmpleado(LogController.empleado);
    	venta.setTotalVenta(listaProducto.get(2).getPrecio());
    	venta.setFechaVenta(new Date());
    	venta.setProducto(listaProducto.get(2));
    	
    	listaVentas.add(venta);
    }

    @FXML
    void eventTinte(ActionEvent event) {
    	total += listaProducto.get(1).getPrecio();
    	totalLabel.setText(Integer.toString(total)+" €");
    	
    	Ventas venta = new Ventas();
    	venta.setEmpleado(LogController.empleado);
    	venta.setTotalVenta(listaProducto.get(1).getPrecio());
    	venta.setFechaVenta(new Date());
    	venta.setProducto(listaProducto.get(1));
    	
    	listaVentas.add(venta);
    }
    @FXML
    void eventAtras(ActionEvent event) throws IOException {
    	Stage stage = (Stage) atrasButton.getScene().getWindow();
        stage.close();
		Parent root1 = FXMLLoader.load(getClass().getResource("/es/peluqueria/interfaces/log.fxml"));
        Scene scene2 = new Scene(root1);
        Stage satage = new Stage();
        satage.setScene(scene2);
        satage.show();
    }
    
    @FXML
    void eventPagar(ActionEvent event) throws IOException {
    	Stage stage = (Stage) pagarButton.getScene().getWindow();
        stage.close();
        Parent root1 = FXMLLoader.load(getClass().getResource("/es/peluqueria/interfaces/pago.fxml"));
        Scene scene2 = new Scene(root1);
        Stage satage = new Stage();
        satage.setScene(scene2);
        satage.show();
    }

}
