package com.microservices.currencyconversionservice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyExchangeServiceProxy proxy;

	@HystrixCommand(fallbackMethod = "displayMessage")
	@GetMapping("currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean retrieveCurrecnyConversionValue(@PathVariable("from") String from,
			@PathVariable("to") String to, @PathVariable int quantity) {

		Map<String, String> reqVariables = new HashMap<>();
		reqVariables.put("from", from);
		reqVariables.put("to", to);

		ResponseEntity<CurrencyConversionBean> forEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/USD/to/IND", CurrencyConversionBean.class, reqVariables);

		CurrencyConversionBean response = forEntity.getBody();

		CurrencyConversionBean currencyConversionBean = new CurrencyConversionBean(response.getId(), from, to,
				response.getConvertCurrency(), quantity, response.getConvertCurrency() * quantity);

		currencyConversionBean.setPort(response.getPort());
		return currencyConversionBean;
	}
	
	private CurrencyConversionBean displayMessage(String from, String to, int quantity) {
		return null;
	}

	@GetMapping("currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean retrieveCurrecnyConversionFeignValue(@PathVariable("from") String from,
			@PathVariable("to") String to, @PathVariable int quantity) {
		CurrencyConversionBean response = proxy.retrieveExchangeValue(from, to);
		CurrencyConversionBean currencyConversionBean = new CurrencyConversionBean(response.getId(), from, to,
				response.getConvertCurrency(), quantity, response.getConvertCurrency() * quantity);

		currencyConversionBean.setPort(response.getPort());
		return currencyConversionBean;
	}
}
