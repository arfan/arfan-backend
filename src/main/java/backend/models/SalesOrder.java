package backend.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "sales_order")
public class SalesOrder {
	
	@Id
	@Column(name="order_number")
	long orderNum;
	
	@NotNull
	@Column(name="customer_code")
	private long customerCode;

	public long getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(long orderNum) {
		this.orderNum = orderNum;
	}

	public long getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(long customer) {
		this.customerCode = customer;
	}
	
}
