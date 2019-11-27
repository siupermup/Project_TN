package poly.entity;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="STAFF")
public class Staff {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int staffID;
	private String staffName;
	private String suserID;
	private String password;
	private Date birthday;
	private String address;
	private String phone;
	private String email;
	private String photo;
	private int role;
	private String description;
	private int status;
	@OneToMany(mappedBy="staff", fetch = FetchType.LAZY)
	private Collection<Order> order;
	@OneToMany(mappedBy="staff", fetch = FetchType.LAZY)
	private Collection<ImportCoupon> importCoupon;
	public int getStaffID() {
		return staffID;
	}
	public void setStaffID(int staffID) {
		this.staffID = staffID;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getSuserID() {
		return suserID;
	}
	public void setSuserID(String suserID) {
		this.suserID = suserID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
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
	public Staff() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Collection<Order> getOrder()
	{
		return order;
	}
	public void setOrder(Collection<Order> order) 
	{
		this.order=order;
	}
	
	public Collection<ImportCoupon> getImportCoupon() {
		return importCoupon;
	}
	public void setImportCoupon(Collection<ImportCoupon> importCoupon) {
		this.importCoupon = importCoupon;
	}
	
}
