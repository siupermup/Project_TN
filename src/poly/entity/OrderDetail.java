package poly.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ORDERDETAIL")
public class OrderDetail {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int OrderDetailID;
	private float Price;
	private int Discount;
	private int Quantity;
	@ManyToOne
	@JoinColumn(name="ProductID")
	private Product product;
	@ManyToOne
	@JoinColumn(name="OrderID")
	private Order order;
	public Product getProduct() 
	{
		return product;
	}
	public void setProduct(Product product) 
	{
		this.product=product;
	}
	
	public int getOrderDetailID() {
		return OrderDetailID;
	}
	public void setOrderDetailID(int orderDetailID) {
		OrderDetailID = orderDetailID;
	}
	
	public float getPrice() {
		return Price;
	}
	public void setPrice(float price) {
		Price = price;
	}
	public int getDiscount() {
		return Discount;
	}
	public void setDiscount(int discount) {
		Discount = discount;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order getOrder() 
	{
		return order;
	}
	public void setOrder(Order order) 
	{
		this.order=order;
	}
}
