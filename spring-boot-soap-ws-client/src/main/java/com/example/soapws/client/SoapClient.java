package com.example.soapws.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.example.soapws.loaneligiblity.Acknowledgement;
import com.example.soapws.loaneligiblity.CustomerRequest;

@Service
public class SoapClient {
	
	@Autowired
	private Jaxb2Marshaller marshaller;
	
	private WebServiceTemplate template;
	
	public SoapClient() {
		System.out.println("SoapClient called");
	}
	
	public Acknowledgement getLoanStatus(CustomerRequest request) {
		template = new WebServiceTemplate(marshaller);
		Acknowledgement acknowledgement = 
				(Acknowledgement) template.marshalSendAndReceive("http://localhost:8080/ws", request);
		return acknowledgement;
	}

}
