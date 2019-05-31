package es.peluqueria.data;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import es.peluqueria.entidades.Empleados;
import es.peluqueria.persistence.PersistEmpleados;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LogController {

    @FXML
    private JFXTextField idTextField;

    @FXML
    private JFXPasswordField passTextField;

    @FXML
    private JFXButton logButton;

    @FXML
    void eventLog(ActionEvent event) throws IOException {
    	String usuario = idTextField.getText();
    	String password = passTextField.getText();
    	
    	List<Empleados>listaEmpleado  = new ArrayList<Empleados>();
    	if(compruebaEmpleado(listaEmpleado, usuario, password)) {
    		Parent root1 = FXMLLoader.load(getClass().getResource("/es/peluqueria/interfaces/venta.fxml"));
            Scene scene2 = new Scene(root1);
            Stage satage = new Stage();
            satage.setScene(scene2);
            satage.show();
    		logButton.setOnAction(e->Platform.exit());
    	}else {
       		String cadena = "Introduce un usuario o contraseña correctos";
    		JOptionPane.showMessageDialog(null, cadena,"No es correcto el usuario o la contraseña.", 0);
    	}
    }

	private boolean compruebaEmpleado(List<Empleados> listaEmpleados, String dni, String password) {
		for(int i = 0; i < listaEmpleados.size(); i++) {
			if(listaEmpleados.get(i).getDni().equals(dni)) {
				if(listaEmpleados.get(i).getContrasenia().contentEquals(password))
					return true;
			}
		}
		return false;
	}

	private List<Empleados> recuperaListaEmpleados() {
		PersistEmpleados persistE = new PersistEmpleados();
		List<Empleados>listaEmpleados = persistE.recuperar();
		
		return listaEmpleados;
	}
}
