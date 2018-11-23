package com.sergiorosa.domain;

import javax.persistence.Entity;
import javax.persistence.criteria.Order;

@Entity
public class PaymentWithCreditCard extends Payment {

	private static final long serialVersionUID = 1L;

	private Integer numberOfInstallments;

	public PaymentWithCreditCard() {

	}

	public PaymentWithCreditCard(Integer id, Integer state, Order order, Integer numberOfInstallments) {
		super(id, state, order);
		this.numberOfInstallments = numberOfInstallments;
	}

	public Integer getNumberOfInstallments() {
		return numberOfInstallments;
	}

	public void setNumberOfInstallments(Integer numberOfInstallments) {
		this.numberOfInstallments = numberOfInstallments;
	}

}
