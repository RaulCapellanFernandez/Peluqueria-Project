package es.peluqueria.entidades;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "VENTAS ")
public class Ventas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="ID_VENTA")
	private Integer idVenta;
	
	@Column(name = "FECHA_VENTA")
	private Date fechaVenta;
	
	@Column(name = "TOTAL_VENTA")
	private Integer totalVenta;
	
	@ManyToOne
	@JoinColumn(name = "DNI")
	private Empleados empleado;
	
	
	@Column(name = "ID_PRODUCTO")
	private Integer idProd;

	
	public Integer getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(Integer idVenta) {
		this.idVenta = idVenta;
	}

	public Date getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public Integer getTotalVenta() {
		return totalVenta;
	}

	public void setTotalVenta(Integer totalVenta) {
		this.totalVenta = totalVenta;
	}

	public Empleados getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleados empleado) {
		this.empleado = empleado;
	}

	public Integer getIdProd() {
		return idProd;
	}

	public void setIdProd(Integer idProd) {
		this.idProd = idProd;
	}	
}
