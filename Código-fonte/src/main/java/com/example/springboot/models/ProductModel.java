package com.example.springboot.models;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.*;


import org.springframework.hateoas.RepresentationModel;


@Entity
@Table(name = "TB_PRODUCTS")
public class ProductModel extends RepresentationModel<ProductModel> implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private UUID idProduct;
	private String name;
	private String endpoint;
	private String metodos;
	private String parametros;
	public UUID getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(UUID idProduct) {
		this.idProduct = idProduct;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEndpoint() {
		return endpoint;
	}
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
	public String getMetodos() {
		return metodos;
	}
	public void setMetodos(String metodos) {
		this.metodos = metodos;
	}
	public String getParametros() {
		return parametros;
	}
	public void setParametros(String parametros) {
		this.parametros = parametros;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	/*
	public UUID getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(UUID idProduct) {
		this.idProduct = idProduct;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEndpoint() {
		return endpoint;
	}
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
	public String getMetodos() {
		return metodos;
	}
	public void setMetodos(String metodos) {
		this.metodos = metodos;
	}
	public String getParamentros() {
		return parametros;
	}
	public void setParamentros(String paramentros) {
		this.parametros = parametros;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}	*/
}
