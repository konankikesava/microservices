package com.microservices.currencyexchangeservice;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private Environment environment;

	@Autowired
	private ExchangeValueRepository repository;

	private Logger log=LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to) {
		ExchangeValue findByFromAndTo = repository.findByFromAndTo(from, to);
		findByFromAndTo.setPort(Integer.parseInt(environment.getProperty("server.port")));
		log.info("CurrencyExchangeController :"+findByFromAndTo);
		return findByFromAndTo;

	}

}
