package com.tcs.customer.service;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.tcs.customer.indto.CustomerInDto;
import com.tcs.customer.model.Customer;
import com.tcs.customer.outdto.CustomerOutDto;

@Service
public class CustomerService {

	@PersistenceContext(unitName = "mySqlDb")
	@Qualifier("mySqlEntityManagerFactory")
	private EntityManager entityManager;

	public static String insertCustomerQry = "insert into customer(name,city,state,country,pin,date_registration,price,countitems) values(?,?,?,?,?,CURRENT_TIMESTAMP,?,?)";

	@Transactional(value = "transactionManager", readOnly = false, isolation = Isolation.SERIALIZABLE)
	public String insertCustomerData(CustomerInDto cust) {

		Query qry = entityManager.createNativeQuery(insertCustomerQry, Customer.class);

		// qry.setParameter(1, cust.getId());
		qry.setParameter(1, cust.getName());
		qry.setParameter(2, cust.getCity());
		qry.setParameter(3, cust.getState());
		qry.setParameter(4, cust.getCountry());
		qry.setParameter(5, cust.getPin());
		// qry.setParameter(6, cust.getDate_registration());
		qry.setParameter(6, cust.getPrice());
		qry.setParameter(7, cust.getCountitems());

		int status = qry.executeUpdate();
		if (status == 1) {
			return cust.getId() + "Record Inserted Successfully";

		} else {
			return cust.getId() + "Record Unsuccessfully Inserted";
		}

	}

	public static String retriveCustomerDataById = "select * from customer where id = ?";

	public CustomerOutDto getCustomerData(Integer custoid) {

		Query qry = entityManager.createNativeQuery(retriveCustomerDataById, Customer.class);
		qry.setParameter(1, custoid);
		Customer custo = (Customer) qry.getSingleResult();
		System.out.println(custo);
		CustomerOutDto outDto = new CustomerOutDto();
		outDto.setId(custo.getId());
		outDto.setName(custo.getName());
		outDto.setCity(custo.getCity());
		outDto.setCountry(custo.getCountry());
		outDto.setPin(custo.getPin());
		outDto.setState(custo.getState());
		outDto.setPrice(custo.getPrice());
		outDto.setCountitems(custo.getCountItems());
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/YYYY");
		String newDt = format.format(custo.getDate_registration());
		outDto.setDate_registration(newDt);
		return outDto;
	}

	public static String retriveCustomerData = "select * from customer";

	public List<Customer> retriveData() {

		Query qry = entityManager.createNativeQuery(retriveCustomerData, Customer.class);
		@SuppressWarnings("unchecked")
		List<Customer> custom = (List<Customer>) qry.getResultList();
		System.out.println(custom);
		return custom;
	}

	public static String retrieveCustomerPartialData = " select id,name,city from customer";

	public List<Object[]> retrivePartialData() {

		Query qry = entityManager.createNativeQuery(retrieveCustomerPartialData);
		@SuppressWarnings("unchecked")
		List<Object[]> custompartial = (List<Object[]>) qry.getResultList();
		System.out.println(custompartial);

		return custompartial;
	}
}
