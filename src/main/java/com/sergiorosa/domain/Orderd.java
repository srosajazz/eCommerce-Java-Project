package com.sergiorosa.domain;



import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

import org.apache.tomcat.jni.Address;

@Entity
public class Orderd implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private  Date instant;
	private  Payment payment;
	private  Client client;
	private  Address deliveryOfAdddres;
	
	public Orderd() {
		
	}

	public Orderd(Integer id, Date instant, Payment payment, Client client, Address deliveryOfAdddres) {
		super();
		this.id = id;
		this.instant = instant;
		this.payment = payment;
		this.client = client;
		this.deliveryOfAdddres = deliveryOfAdddres;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getInstant() {
		return instant;
	}

	public void setInstant(Date instant) {
		this.instant = instant;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Address getDeliveryOfAdddres() {
		return deliveryOfAdddres;
	}

	public void setDeliveryOfAdddres(Address deliveryOfAdddres) {
		this.deliveryOfAdddres = deliveryOfAdddres;
	}
	

}
