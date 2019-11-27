package poly.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "`ORDER`")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int OrderID;
	private Date OrderDate;
	private String description;
	private int status;
	private boolean payment;
	@OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
	private Collection<OrderDetail> orderDetail;
	public Collection<OrderDetail> getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(Collection<OrderDetail> orderDetail) {
		this.orderDetail = orderDetail;
	}

	@ManyToOne
	@JoinColumn(name = "staffID")
	private Staff staff;
	
	@ManyToOne
	@JoinColumn(name = "CustomerID")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name = "shipperID")
	private Shipper shipper;

	public Order() {
		super();
	}

	public int getOrderID() {
		return OrderID;
	}

	public void setOrderID(int orderID) {
		this.OrderID = orderID;
	}

	public Date getOrderDate() {
		return OrderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.OrderDate = orderDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public boolean isPayment() {
		return payment;
	}

	public void setPayment(boolean payment) {
		this.payment = payment;
	}

	public Customer getCustomer() {
		return customer;
	}
	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Shipper getShipper() {
		return shipper;
	}

	public void setShipper(Shipper shipper) {
		this.shipper = shipper;
	}

	public Collection<OrderDetail> getOrderdetail() {
		return orderDetail;
	}

	public void setOrderdetail(Collection<OrderDetail> orderDetail) {
		this.orderDetail = orderDetail;
	}
}
