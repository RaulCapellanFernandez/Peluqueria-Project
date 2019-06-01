package es.peluqueria.data;

import java.awt.Label;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXListView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class PagoController implements Initializable{
    @FXML
    private JFXListView<String> listView;
    int total = 0;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		listView.getItems().add("TOTAL VENTA");
		int tam = VentaController.listaVentas.size();
		for(int i =0; i < tam; i++) {
			String imprimir =i+1 +" "+  VentaController.listaVentas.get(i).getProducto().getNombre()+" "+VentaController.listaVentas.get(i).getProducto().getPrecio()+"€";
			total += VentaController.listaVentas.get(i).getProducto().getPrecio();
			listView.getItems().add(imprimir);
		}
		String imprimir = "Total: "+total+"€";
		listView.getItems().add(imprimir);
		
		
	}

}
