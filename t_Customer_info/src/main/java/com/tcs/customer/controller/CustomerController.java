package com.tcs.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tcs.customer.facade.CustomerFacade;
import com.tcs.customer.form.CustomerForm;
import com.tcs.customer.outdto.CustomerOutDto;

@RestController
public class CustomerController {

	@Autowired
	private CustomerFacade customerFacade;

	@PostMapping(value = "/insertcustomer")
	public ResponseEntity<String> insertingCustomerData(@RequestBody @Validated CustomerForm customerForm)
			throws JsonProcessingException {

		ResponseEntity<String> custRecordStatus = customerFacade.insertCustomerDataInFacade(customerForm);
		return custRecordStatus;

	}

	@GetMapping(value = "/retrivecustomerdata/{id}")
	public ResponseEntity<String> retrivingCustomerDataById(@PathVariable("id") String customerId)
			throws JsonProcessingException {

		CustomerOutDto custRecordId = customerFacade.retriveCustomerDataInFacade(Integer.valueOf(customerId));
		ObjectMapper obj = new ObjectMapper();
		String custo = obj.writeValueAsString(custRecordId);

		return new ResponseEntity<String>(custo, HttpStatus.OK);

	}

	@GetMapping(value = "/retrievecustomerdata")
	public ResponseEntity<String> retriveCustomerData() throws JsonProcessingException {

		ObjectMapper obj = new ObjectMapper();
		List<CustomerOutDto> custList = (List<CustomerOutDto>) customerFacade.retriveCustoDataInFacade();
		String str = obj.writeValueAsString(custList);
		return new ResponseEntity<String>(str, HttpStatus.OK);
	}

	@GetMapping(value = "/retrivecustomerpartialdata")
	public ResponseEntity<String> retrivePartialCustomerData() throws JsonProcessingException {

		ObjectMapper obj = new ObjectMapper();
		List<CustomerOutDto> cuspartial = (List<CustomerOutDto>) customerFacade.retrieveCustomerPartialDatainFacade();
		String str = obj.writeValueAsString(cuspartial);
		return new ResponseEntity<String>(str, HttpStatus.OK);
	}

}
