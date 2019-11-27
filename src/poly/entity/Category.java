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
@Table(name = "CATEGORY")
public class Category {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int CategoryID;
	private String categoryName;
	public int getCategoryID() {
		return CategoryID;
	}
	public void setCategoryID(int categoryID) {
		CategoryID = categoryID;
	}
	private String description;	
	@OneToMany(mappedBy="category", fetch = FetchType.EAGER)
	private Collection<Product> product;
	public Category() {
		super();
	
	}
	public int getCategoryid() {
		return CategoryID;
	}
	public void setCategoryid(int categoryID) {
		this.CategoryID = categoryID;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	private String photo;
	
	public Collection<Product> getProduct()
	{
		return product;
	}
	public void  setProduct(Collection<Product> product) {
		this.product=product;
	}
}
