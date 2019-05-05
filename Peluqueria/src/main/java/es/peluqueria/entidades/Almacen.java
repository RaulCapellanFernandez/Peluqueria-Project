package es.peluqueria.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ALMACEN")
public class Almacen {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_ALMACEN")
	private Integer idAlmacen;
	
	@Column(name = "NOMBRE_ALMACEN")
	private String nombre;
	
	@Column(name = "CANTIDAD")
	private Integer cantidad;
	
	
	public Integer getIdAlmacen() {
		return idAlmacen;
	}
	public void setIdAlmacen(Integer idAlmacen) {
		this.idAlmacen = idAlmacen;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
}
