package backend.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "order_line")
public class OrderLine {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotNull
	@Column(name = "product_code")
	private long productCode;
	
	@NotNull
	@Column(name = "quantity")
	private int quantity;
	
	@NotNull
	@Column(name = "sales_order_num")
	private long salesOrderNum;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getProductCode() {
		return productCode;
	}

	public void setProductCode(long product) {
		this.productCode = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public long getSalesOrderNum() {
		return salesOrderNum;
	}

	public void setSalesOrderNum(long salesOrder) {
		this.salesOrderNum = salesOrder;
	}

	
}
