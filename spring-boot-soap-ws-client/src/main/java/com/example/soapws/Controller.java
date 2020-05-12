package com.example.soapws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.soapws.client.SoapClient;
import com.example.soapws.loaneligiblity.Acknowledgement;
import com.example.soapws.loaneligiblity.CustomerRequest;

@RestController
public class Controller {

	@Autowired
	private SoapClient client;
	
	@PostMapping("/getLoanStatus")
	public Acknowledgement invokeSoapClient(@RequestBody CustomerRequest request)
	{
		return client.getLoanStatus(request);
	}
	
}
