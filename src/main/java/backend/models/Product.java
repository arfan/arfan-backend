package backend.models;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "product")
public class Product {

	@Id
	private long code;

	@NotNull
	private String description;

	@NotNull
	private BigDecimal price;

	@NotNull
	private int quantity;

	// ------------------------
	// PUBLIC METHODS
	// ------------------------

	public Product() {
	}

	public Product(long code) {
		this.code = code;
	}

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product(long code, String description, BigDecimal price, int quantity) {
		this.code = code;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}
}