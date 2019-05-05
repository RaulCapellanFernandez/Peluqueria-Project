package es.peluqueria.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="PRODUCTOS")
public class Productos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_PRODUCTO")
	private Integer idProd;
	
	@Column(name = "NOMBRE_PRODUCTO")
	private String nameProd;
	
	@Column(name = "CANTIDAD")
	private Integer precio;

	
	public Integer getIdProd() {
		return idProd;
	}

	public void setIdProd(Integer idProd) {
		this.idProd = idProd;
	}

	public String getNombre() {
		return nameProd;
	}

	public void setNombre(String nombreProd) {
		this.nameProd = nombreProd;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}	
	
}
