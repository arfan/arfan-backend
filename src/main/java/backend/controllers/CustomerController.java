package backend.controllers;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import backend.models.Customer;
import backend.models.CustomerDao;
import backend.models.Product;

@Controller
public class CustomerController {
	
	@RequestMapping("/customer/create")
	@ResponseBody
	public String create(long code, String name, String address, String phone1, String phone2, BigDecimal creditLimit, BigDecimal currentCredit) {
		Customer customer = null;
		try {
			customer = new Customer();
			customer.setCode(code);
			customer.setName(name);
			customer.setAddress(address);
			customer.setPhone1(phone1);
			customer.setPhone2(phone2);
			customer.setCreditLimit(creditLimit);
			customer.setCurrentCredit(currentCredit);
			
			customerDao.create(customer);
			
		} catch (Exception ex) {
			return "Error creating the Product: " + ex.toString();
		}
		return "customer succesfully created! (code = " + customer.getCode() + ")";
	}
	
	@RequestMapping("/customer/update")
	@ResponseBody
	public String update(long code, String name, String address, String phone1, String phone2, BigDecimal creditLimit, BigDecimal currentCredit) {
		Customer customer = null;
		try {
			customer = new Customer();
			customer.setCode(code);
			customer.setName(name);
			customer.setAddress(address);
			customer.setPhone1(phone1);
			customer.setPhone2(phone2);
			customer.setCreditLimit(creditLimit);
			customer.setCurrentCredit(currentCredit);
			customerDao.update(customer);
		} catch (Exception ex) {
			return "Error updating the Customer: " + ex.toString();
		}
		return "Customer succesfully updated! (code = " + customer.getCode() + ")";
	}
	
	@RequestMapping("/customer/list")
	@ResponseBody 
	public String list() {
		
		List<Customer> c = customerDao.getAll();
		
		try {
			return mapper.writeValueAsString(c);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Error listing the Customer";
	}
	
	@RequestMapping("/customer/delete")
	@ResponseBody
	public String delete(long code) {
		
		Customer c = new Customer();
		c.setCode(code);
		customerDao.delete(c);
		return "Succesfully delete the customer";
	
	}
	
	@Autowired
	private CustomerDao customerDao;
	
	private ObjectMapper mapper = new ObjectMapper();
}
