package com.enset;

import org.springframework.context.ApplicationContext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;
import org.springframework.remoting.rmi.RmiServiceExporter;


@Configuration
public class MyConfig {
	
	@Bean
	public SimpleJaxWsServiceExporter getJaxWs(){
		SimpleJaxWsServiceExporter jax=new SimpleJaxWsServiceExporter();
		jax.setBaseAddress("http://localhost:8271/SocieteOrdre");
		return jax;
	}
	
	@Bean
	public RmiServiceExporter getRmiService(ApplicationContext contexte){
		
		RmiServiceExporter rmiService=new RmiServiceExporter();
		rmiService.setService(contexte.getBean("OrdreSocieteRmiService"));
		rmiService.setRegistryPort(1099);
		rmiService.setServiceName("SocieteOrdre");
		rmiService.setServiceInterface(com.enset.rmi.SocieteOrdreRmiService.class);
		return rmiService;
		
	}

}
