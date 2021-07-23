package com.tcs.customer.facade;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tcs.customer.form.CustomerForm;
import com.tcs.customer.indto.CustomerInDto;
import com.tcs.customer.model.Customer;
import com.tcs.customer.outdto.CustomerOutDto;
import com.tcs.customer.service.CustomerService;

@Service
public class CustomerFacade {

	@Autowired
	private CustomerService customerService;

	public ResponseEntity<String> insertCustomerDataInFacade(CustomerForm customerForm) {

		CustomerInDto customerindto = new CustomerInDto();
		// customerindto.setId(customerForm.getId());
		customerindto.setName(customerForm.getName());
		customerindto.setCity(customerForm.getCity());
		customerindto.setState(customerForm.getState());
		customerindto.setCountry("india");
		customerindto.setPin(customerForm.getPin());
		customerindto.setDate_registration(customerForm.getDate_registration());
		customerindto.setPrice(customerForm.getPrice());
		customerindto.setCountitems(customerForm.getCountitems());

		String custFacadeStatus = customerService.insertCustomerData(customerindto);
		return new ResponseEntity<String>(custFacadeStatus, HttpStatus.OK);

	}

	public CustomerOutDto retriveCustomerDataInFacade(Integer customerId) {

		CustomerOutDto custFacadeid = customerService.getCustomerData(customerId);

		return custFacadeid;

	}

	public List<CustomerOutDto> retriveCustoDataInFacade() {
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/YYYY");
		// String newDt=format.format(custo.getDate_registration());
		List<Customer> custList = customerService.retriveData();
		List<CustomerOutDto> nwCustList = new ArrayList();

		for (Customer custo : custList) {

			CustomerOutDto outDto = new CustomerOutDto();
			outDto.setId(custo.getId());
			outDto.setName(custo.getName());
			outDto.setCity(custo.getCity());
			outDto.setCountry(custo.getCountry());
			outDto.setPin(custo.getPin());
			outDto.setState(custo.getState());
			outDto.setPrice(custo.getPrice());
			outDto.setCountitems(custo.getCountItems());
			String newDt = format.format(custo.getDate_registration());
			outDto.setDate_registration(newDt);
			nwCustList.add(outDto);
		}

		return nwCustList;
	}

	public List<CustomerOutDto> retrieveCustomerPartialDatainFacade() {
		List<Object[]> custpatial = customerService.retrivePartialData();
		List<CustomerOutDto> partialCustList = new ArrayList<>();

		for (Object[] cust : custpatial) {

			CustomerOutDto partialOutDto = new CustomerOutDto();
			partialOutDto.setId((Integer) cust[0]);
			partialOutDto.setName((String) cust[1]);
			partialOutDto.setCity((String) cust[2]);
			partialCustList.add(partialOutDto);
		}

		return partialCustList;

	}

}
