package backend.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "customer")
public class Customer {
	
	@Id
	@Column(name = "code")
	private long code;

	@NotNull
	@Column(name = "name")
	private String name;

	@NotNull
	@Column(name = "address")
	private String address;

	@NotNull
	@Column(name = "phone_1")
	private String phone1;

	@Column(name = "phone_2")
	private String phone2;
	
	@NotNull
	@Column(name = "credit_limit")
	private BigDecimal creditLimit;

	@NotNull
	@Column(name = "current_credit")
	private BigDecimal currentCredit;

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public BigDecimal getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(BigDecimal creditLimit) {
		this.creditLimit = creditLimit;
	}

	public BigDecimal getCurrentCredit() {
		return currentCredit;
	}

	public void setCurrentCredit(BigDecimal currentCredit) {
		this.currentCredit = currentCredit;
	}

	
}
