package backend.controllers;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import backend.models.Product;
import backend.models.ProductDao;

@Controller
public class ProductController {
	
	@RequestMapping("/product/create")
	@ResponseBody
	public String create(long code, String description, BigDecimal price, int quantity) {
		Product product = null;
		try {
			product = new Product(code, description, price, quantity);
			productDao.create(product);
		} catch (Exception ex) {
			return "Error creating the Product: " + ex.toString();
		}
		return "Product succesfully created! (code = " + product.getCode() + ")";
	}
	
	@RequestMapping("/product/update")
	@ResponseBody
	public String update(long code, String description, BigDecimal price, int quantity) {
		Product product = null;
		try {
			product = new Product(code, description, price, quantity);
			productDao.update(product);
		} catch (Exception ex) {
			return "Error updating the Product: " + ex.toString();
		}
		return "Product succesfully updated! (code = " + product.getCode() + ")";
	}
	
	@RequestMapping("/product/list")
	@ResponseBody 
	public String list() {
		
		List<Product> p = productDao.getAll();
		
		try {
			return mapper.writeValueAsString(p);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Error listing the Product";
	}
	
	@RequestMapping("/product/delete")
	@ResponseBody
	public String delete(long code) {
		
		productDao.delete(new Product(code));
		return "Succesfully delete the product";
	
	}
	
	@Autowired
	private ProductDao productDao;
	
	private ObjectMapper mapper = new ObjectMapper();
}
