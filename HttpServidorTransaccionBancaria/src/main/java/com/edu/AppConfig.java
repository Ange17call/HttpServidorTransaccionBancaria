package com.edu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;


@Configuration
@ComponentScan("com.edu")
public class AppConfig {
	
	@Bean("/transaccionBancaria")
	public HttpInvokerServiceExporter HttpOperaciones(TransaccionBancaria transaccionBancaria) {
		HttpInvokerServiceExporter exporter = new HttpInvokerServiceExporter();
		exporter.setService(transaccionBancaria);
		exporter.setServiceInterface(TransaccionBancaria.class);
		return exporter;
	}
	
}