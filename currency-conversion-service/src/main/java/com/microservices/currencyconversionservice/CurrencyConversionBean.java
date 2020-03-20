package com.microservices.currencyconversionservice;

public class CurrencyConversionBean {

	private Long id;

	private String from;

	private String to;

	private Long convertCurrency;

	private int quantity;
	
	private Long totalCalculatedAmount;
	
	private int port;
	
	public CurrencyConversionBean() {
		
	}

	public CurrencyConversionBean(Long id, String from, String to, Long convertCurrency, int quantity,
			Long totalCalculatedAmount) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.convertCurrency = convertCurrency;
		this.quantity = quantity;
		this.totalCalculatedAmount = totalCalculatedAmount;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Long getTotalCalculatedAmount() {
		return totalCalculatedAmount;
	}

	public void setTotalCalculatedAmount(Long totalCalculatedAmount) {
		this.totalCalculatedAmount = totalCalculatedAmount;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
}
