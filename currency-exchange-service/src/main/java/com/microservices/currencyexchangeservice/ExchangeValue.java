package com.microservices.currencyexchangeservice;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="exchange_value")
public class ExchangeValue implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private Long id;
	@Column(name = "currency_from")
	private String from;
	@Column(name = "currency_to")
	private String to;
	@Column(name = "conversion_mulitple")
	private Long convertCurrency;

	@Transient
	private int port;

	public ExchangeValue() {

	}

	public ExchangeValue(Long id, String from, String to, Long convertCurrency) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.convertCurrency = convertCurrency;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public Long getConvertCurrency() {
		return convertCurrency;
	}

	public void setConvertCurrency(Long convertCurrency) {
		this.convertCurrency = convertCurrency;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

}
