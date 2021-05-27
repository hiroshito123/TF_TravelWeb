package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import pe.edu.upc.entity.Transporte;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Table(name="transporte")
public class Transporte implements Serializable{

private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTransporte;
	
	@Column(name="tipoTransporte",nullable=false,length=20)
	private String tipoTransporte;
	
	@Column(name="nombreEmpresa", nullable=false, length=30)
	private String nombreEmpresa;

	public Transporte() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transporte(int idTransporte, String tipoTransporte, String empresa, int precio) {
		super();
		this.idTransporte = idTransporte;
		this.tipoTransporte = tipoTransporte;
		Empresa = empresa;
		this.precio = precio;
	}

	public int getIdTransporte() {
		return idTransporte;
	}

	public void setIdTransporte(int idTransporte) {
		this.idTransporte = idTransporte;
	}

	public String getTipoTransporte() {
		return tipoTransporte;
	}

	public void setTipoTransporte(String tipoTransporte) {
		this.tipoTransporte = tipoTransporte;
	}

	public String getEmpresa() {
		return Empresa;
	}

	public void setEmpresa(String empresa) {
		Empresa = empresa;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Empresa == null) ? 0 : Empresa.hashCode());
		result = prime * result + idTransporte;
		result = prime * result + precio;
		result = prime * result + ((tipoTransporte == null) ? 0 : tipoTransporte.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transporte other = (Transporte) obj;
		if (Empresa == null) {
			if (other.Empresa != null)
				return false;
		} else if (!Empresa.equals(other.Empresa))
			return false;
		if (idTransporte != other.idTransporte)
			return false;
		if (precio != other.precio)
			return false;
		if (tipoTransporte == null) {
			if (other.tipoTransporte != null)
				return false;
		} else if (!tipoTransporte.equals(other.tipoTransporte))
			return false;
		return true;
	}
	
	
}
