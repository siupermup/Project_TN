package poly.entity;

import java.util.Collection;

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
@Table(name = "PRODUCT")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ProductID;
	private String productName;
	private String photo1;
	private String photo2;
	private String photo3;
	private float price;
	private int quantity;
	private String description;
	private int status;
	
	@ManyToOne
	@JoinColumn(name="supplierID")
	private Supplier supplier;
	
	@ManyToOne
	@JoinColumn(name="manufacturerID")
	private Manufacturer manufacturer;
	
	@ManyToOne
	@JoinColumn(name="CategoryID")
	private Category category;
	@OneToMany(mappedBy="product", fetch = FetchType.LAZY)
	private Collection<Icdetail> icdetail;
	@OneToMany(mappedBy="product", fetch = FetchType.LAZY)
	private Collection<OrderDetail> orderDetail;
	public Manufacturer getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}
	public Collection<Icdetail> getIcdetail() {
		return icdetail;
	}
	public void setIcdetail(Collection<Icdetail> icdetail) {
		this.icdetail = icdetail;
	}
	public Collection<OrderDetail> getOrderDetail() {
		return orderDetail;
	}
	public void setOrderDetail(Collection<OrderDetail> orderDetail) {
		this.orderDetail = orderDetail;
	}
	
	
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Product() {
		super();
	}

	public int getProductID() {
		return ProductID;
	}
	public void setProductID(int productID) {
		ProductID = productID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getPhoto1() {
		return photo1;
	}
	public void setPhoto1(String photo1) {
		this.photo1 = photo1;
	}
	public String getPhoto2() {
		return photo2;
	}
	public void setPhoto2(String photo2) {
		this.photo2 = photo2;
	}
	public String getPhoto3() {
		return photo3;
	}
	public void setPhoto3(String photo3) {
		this.photo3 = photo3;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
	
}
