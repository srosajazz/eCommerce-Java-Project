package com.sergiorosa.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.criteria.Order;

@Entity
public class PaymentWithInvoice extends Payment {

	private static final long serialVersionUID = 1L;

	private Date dueDate;
	private Date paymentDue;

	public PaymentWithInvoice() {

	}

	public PaymentWithInvoice(Integer id, Integer state, Order order, Date dueDate, Date paymentDue) {
		super(id, state, order);
		this.dueDate = dueDate;
		this.paymentDue = paymentDue;

	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getPaymentDue() {
		return paymentDue;
	}

	public void setPaymentDue(Date paymentDue) {
		this.paymentDue = paymentDue;
	}

}
