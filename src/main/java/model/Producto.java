package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tb_productos")
//@ToString
//@Getter
//@Setter
//@Data
//@AllArgsConstructor

public class Producto {
	
	 @Id	
	 private String Idprod;	 
	 private String descripcion;	 
	 private int stock;	 
	 private double precio;	 
	 private int idcategoria;	 
	 private int estado;
	 
	public String getIdprod() {
		return Idprod;
	}
	public void setIdprod(String idprod) {
		Idprod = idprod;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getIdcategoria() {
		return idcategoria;
	}
	public void setIdcategoria(int idcategoria) {
		this.idcategoria = idcategoria;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public Producto(String idprod, String descripcion, int stock, double precio, int idcategoria, int estado) {
		super();
		Idprod = idprod;
		this.descripcion = descripcion;
		this.stock = stock;
		this.precio = precio;
		this.idcategoria = idcategoria;
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "Producto [Idprod=" + Idprod + ", descripcion=" + descripcion + ", stock=" + stock + ", precio=" + precio
				+ ", idcategoria=" + idcategoria + ", estado=" + estado + "]";
	}
	public Producto() {
		super();
	}
}
