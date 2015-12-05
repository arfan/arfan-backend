package backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import backend.models.OrderLine;
import backend.models.OrderLineDao;
import backend.models.Product;
import backend.models.ProductDao;
import backend.models.SalesOrder;
import backend.models.SalesOrderDao;

@Controller
public class OrderLineController {

	@RequestMapping("/orderline/create")
	@ResponseBody
	public String create(long productCode, int quantity, long salesOrderNum) {
		OrderLine orderLine = null;
		try {
			orderLine = new OrderLine();
			
			orderLine.setProductCode(productCode);

			orderLine.setSalesOrderNum(salesOrderNum);

			orderLineDao.create(orderLine);

		} catch (Exception ex) {
			return "Error creating the orderlline: " + ex.toString();
		}
		return "OrderLine succesfully created! (id = " + orderLine.getId() + ")";
	}

	@RequestMapping("/orderline/update")
	@ResponseBody
	public String update(long productCode, int quantity, long salesOrderNum) {
		OrderLine orderLine = null;
		try {
			orderLine = new OrderLine();

			orderLine.setProductCode(productCode);

			orderLine.setSalesOrderNum(salesOrderNum);

			orderLineDao.update(orderLine);

		} catch (Exception ex) {
			return "Error updating the OrderLine: " + ex.toString();
		}
		return "OrderLine succesfully updated! (id = " + orderLine.getId() + ")";
	}

	@RequestMapping("/orderline/list")
	@ResponseBody
	public String list() {

		List<OrderLine> c = orderLineDao.getAll();

		try {
			return mapper.writeValueAsString(c);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "Error listing the SalesOrder";
	}

	@RequestMapping("/orderline/delete")
	@ResponseBody
	public String delete(long id) {

		OrderLine o = new OrderLine();
		o.setId(id);
		orderLineDao.delete(o);
		return "Succesfully delete the OrderLine";

	}

	@Autowired
	private SalesOrderDao salesOrderDao;

	@Autowired
	private ProductDao productDao;

	@Autowired
	private OrderLineDao orderLineDao;

	private ObjectMapper mapper = new ObjectMapper();
}
