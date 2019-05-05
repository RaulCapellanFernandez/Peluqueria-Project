package es.peluqueria.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "EMPLEADOS")
public class Empleados {
	
	@Id
	@Column(name = "DNI")
	private String dni;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "APELLIDOS")
	private String apellidos;
	
	@Column(name = "FECHA_CONTRATACION")
	private  Date fechaContra;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "CALLE")
	private String calle;
	
	@Column(name = "PISO")
	private String piso;
	
	@Column(name = "CIUDAD")
	private String ciudad;
	
	@Column(name = "PROVINCIA")
	private String provincia;
	
	@Column(name = "CODIGO_POSTAL")
	private String codPostal;
	
	
	
	
	
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getCodPostal() {
		return codPostal;
	}
	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getPiso() {
		return piso;
	}
	public void setPiso(String piso) {
		this.piso = piso;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getFechaContra() {
		return fechaContra;
	}
	public void setFechaContra(Date fechaContra) {
		this.fechaContra = fechaContra;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	
	
}
