package backend.controllers;

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
import backend.models.SalesOrder;
import backend.models.SalesOrderDao;

@Controller
public class SalesOrderController {
	
	@RequestMapping("/salesorder/create")
	@ResponseBody
	public String create(long orderNumber, long customerCode) {
		SalesOrder salesOrder = null;
		try {
			salesOrder = new SalesOrder();
			salesOrder.setOrderNum(orderNumber);
			Customer customer = customerDao.getById(customerCode);
			salesOrder.setCustomer(customer);
			
			salesOrderDao.create(salesOrder);
			
		} catch (Exception ex) {
			return "Error creating the Product: " + ex.toString();
		}
		return "salesOrder succesfully created! (code = " + salesOrder.getOrderNum() + ")";
	}
	
	@RequestMapping("/salesorder/update")
	@ResponseBody
	public String update(long orderNumber, long customerCode) {
		SalesOrder salesOrder = null;
		try {
			salesOrder = new SalesOrder();
			salesOrder.setOrderNum(orderNumber);
			Customer customer = customerDao.getById(customerCode);
			salesOrder.setCustomer(customer);

			salesOrderDao.update(salesOrder);
			
		} catch (Exception ex) {
			return "Error updating the Product: " + ex.toString();
		}
		return "salesOrder succesfully updated (code = " + salesOrder.getOrderNum() + ")";
	}
	
	@RequestMapping("/salesorder/list")
	@ResponseBody 
	public String list() {
		
		List<SalesOrder> c = salesOrderDao.getAll();
		
//		try {
//			return mapper.writeValueAsString(c);
//		} catch (JsonProcessingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		return "Error listing the SalesOrder";
	}
	
	@RequestMapping("/salesorder/delete")
	@ResponseBody
	public String delete(long code) {
		
		SalesOrder c = new SalesOrder();
		c.setOrderNum(code);
		salesOrderDao.delete(c);
		return "Succesfully delete the salesOrder";
	
	}
	
	@Autowired
	private SalesOrderDao salesOrderDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	private ObjectMapper mapper = new ObjectMapper();
}
