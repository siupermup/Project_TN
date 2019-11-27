package poly.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="Icdetail")
public class Icdetail {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iCDetailID;
	private int quantity;
	private Float price;
	@ManyToOne
	@JoinColumn(name="ImportCouponID")
	private ImportCoupon importCoupon;
	@ManyToOne
	@JoinColumn(name="ProductID")
	private Product product;
	public ImportCoupon getImportCoupon() {
		return importCoupon;
	}
	public void setImportCoupon(ImportCoupon importCoupon) {
		this.importCoupon = importCoupon;
	}
	public Icdetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getiCDetailID() {
		return iCDetailID;
	}
	public void setiCDetailID(int iCDetailID) {
		this.iCDetailID = iCDetailID;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public ImportCoupon getImportcoupon() {
		return importCoupon;
	}
	public void setImportcoupon(ImportCoupon importCoupon) 
	{
		this.importCoupon=importCoupon;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) 
	{
		this.product=product;
	}
}
