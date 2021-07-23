package com.tcs.customer.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tcs.customer.form.CustomerForm;


public class TestCustomer extends CustomerFormTests {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testGetAllCustomers() throws Exception {
		MvcResult result=mockMvc.perform(get("/retrievecustomerdata")).andExpect(status().isOk()).andReturn();
		String res=result.getResponse().getContentAsString();
		System.out.println(res);
	}
	@Test
	public void testCustomerDataInsert() throws Exception {
		ObjectMapper mapper=new ObjectMapper();
		CustomerForm req=new CustomerForm();
		req.setName("Lokesh");
		req.setPin(516267);
		req.setCity("kdp");
		req.setPrice(2030);
		req.setState("AP");
		req.setCountitems(2);
		String request=mapper.writeValueAsString(req);
		MvcResult result=mockMvc.perform(post("/insertcustomer").contentType(MediaType.APPLICATION_JSON).content(request)).andExpect(status().isOk()).andReturn();
		String res=result.getResponse().getContentAsString();
		System.out.println(res);
	}
	
	@Test
	public void testGetCustomerDataById() throws Exception {
		MvcResult result=mockMvc.perform(get("/retrivecustomerdata/{id}","2")).andExpect(status().isOk()).andReturn();
		String res=result.getResponse().getContentAsString();
		System.out.println(res);
	}
}
