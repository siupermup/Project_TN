package poly.entity;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="MANUFACTURER")
public class Manufacturer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int manufacturerID;
	private String manufacturerName;
	private String description;
	@OneToMany(mappedBy="manufacturer", fetch = FetchType.LAZY)
	private Collection<Product> product;
	
	public void setProduct(Collection<Product> product) {
		this.product = product;
	}
	public int getManufacturerID() {
		return manufacturerID;
	}
	public void setManufacturerID(int manufacturerID) {
		this.manufacturerID = manufacturerID;
	}
	public String getManufacturerName() {
		return manufacturerName;
	}
	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Manufacturer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Collection<Product> getProduct()
	{
		return product;
	}
	public void setProducts(Collection<Product> product) 
	{
		this.product=product;
	}
}
