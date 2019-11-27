
package poly.controller.admin;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import poly.entity.Order;
import poly.entity.OrderDetail;
import poly.entity.Product;
import poly.entity.Shipper;
import poly.entity.Staff;

@Controller
@RequestMapping("/homeAdmin/order")
public class manage_order {

	@Autowired
	SessionFactory factory;
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String listOrder(ModelMap model) {
		List<Order> list1 = uncomfirmed();
		model.addAttribute("list1", list1);
		List<Order> list2 = comfirmed();
		model.addAttribute("list2", list2);
		List<Order> list3 = completed();
		model.addAttribute("list3", list3);
		return "admin/manage_order";
	}
	
	public List<Order> uncomfirmed() {
		Session session = factory.openSession();
		String hql ="SELECT t1.OrderID, t2.customerName, t2.phone, t1.OrderDate, t1.description "
				+ "FROM Order t1 "
				+ "INNER JOIN Customer t2 ON t1.customer.CustomerID = t2.CustomerID "
				+ "WHERE t1.status = 1 "
				+ "GROUP BY t1.OrderID, t2.customerName, t2.phone, t1.OrderDate, t1.description";
		Query query = session.createQuery(hql);
		List<Order> list = query.list();
		return list;
	}
	
	public List<Order> comfirmed() {
		Session session = factory.openSession();
		String hql ="SELECT t1.OrderID, t2.customerName, t2.phone, t3.staffName, t4.shipperName, t1.OrderDate, t1.description "
				+ "FROM Order t1 "
				+ "INNER JOIN Customer t2 ON t1.customer.CustomerID = t2.CustomerID "
				+ "INNER JOIN Staff t3 ON t1.staff.staffID = t3.staffID "
				+ "INNER JOIN Shipper t4 ON t1.shipper.shipperID = t4.shipperID "
				+ "WHERE t1.status = 2 "
				+ "GROUP BY t1.OrderID, t2.customerName, t2.phone, t3.staffName, t4.shipperName, t1.OrderDate, t1.description";
		Query query = session.createQuery(hql);
		List<Order> list = query.list();
		return list;
	}
	
	public List<Order> completed() {
		Session session = factory.openSession();
		String hql ="SELECT t1.OrderID, t2.customerName, t2.phone, t3.staffName, t1.OrderDate, t4.shipperName, t1.description "
				+ "FROM Order t1 "
				+ "INNER JOIN Customer t2 ON t1.customer.CustomerID = t2.CustomerID "
				+ "INNER JOIN Staff t3 ON t1.staff.staffID = t3.staffID "
				+ "INNER JOIN Shipper t4 ON t1.shipper.shipperID = t4.shipperID "
				+ "WHERE t1.status = 3 "
				+ "GROUP BY t1.OrderID, t2.customerName, t2.phone, t3.staffName, t4.shipperName, t1.OrderDate, t1.description";
		Query query = session.createQuery(hql);
		List<Order> list = query.list();
		return list;
	}
	
	@ModelAttribute("staff")
	public List<Staff> getStaff() {
		Session session = factory.openSession();
		String hql = "FROM Staff WHERE role = 3";
		Query query = session.createQuery(hql);
		List<Staff> list = query.list();
		session.close();
		return list;
	}
	
	@ModelAttribute("shipper")
	public List<Shipper> getShipper() {
		Session session = factory.openSession();
		String hql = "FROM Shipper";
		Query query = session.createQuery(hql);
		List<Shipper> list = query.list();
		session.close();
		return list;
	}
	
	// Xác nhận - Xuất Kho - Giao Hàng
	@RequestMapping(value = "/comfirm/{id}", method = RequestMethod.GET)
	public String comfirm(ModelMap model, @PathVariable("id") int id) {
		Order od = getOrder_ById(id);
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			od.setStatus(2);
			session.update(od);
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
		} finally {
			session.close();
		}
		return "admin/manage_order";
	}
	
	// Hoàn tất giao dịch
	@RequestMapping(value = "/finish/{id}", method = RequestMethod.GET)
	public String finish(ModelMap model, @PathVariable("id") int id) {
		Order od = getOrder_ById(id);
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			od.setStatus(3);
			od.setPayment(true);
			setQuantity(session, id);
			session.update(od);
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
		} 
		finally {
			session.close();
		}
		return "admin/manage_order";
	}
	
	public void setQuantity(Session ss, int id){
		List<OrderDetail> list = viewPro(id);
		int sl = 0;
		for(OrderDetail od : list) {
			int ID = od.getProduct().getProductID();
			String hql = "FROM Product WHERE ProductID = :id ";
			Query query = ss.createQuery(hql);
			query.setInteger("id", ID);
			System.out.println(query.getResultList());
			Product l1 = (Product) query.getResultList().get(0);		
			sl = l1.getQuantity() - od.getQuantity();
			l1.setQuantity(sl);
			ss.update(l1);
		}
	}
	
//	public Product inventory(int id) {
//		Session session = factory.openSession();
//		String hql = "SELECT quantity FROM Product WHERE ProductID = :id ";
//		Query query = session.createQuery(hql);
//		query.setInteger("id", id);
//		Product inv = (Product) query.getResultList();
//		return inv;
//	}
	
	public List<OrderDetail> viewPro (int id){
		Session session = factory.openSession();
		String hql ="FROM OrderDetail WHERE order.OrderID = :id";
		Query query = session.createQuery(hql);
		query.setInteger("id", id);
		List<OrderDetail> list = query.list();
		return list;
	}
	
	public Order getOrder_ById(int id) {
		Session session = factory.openSession();
		try {
			session.beginTransaction();
			Order dh = (Order) session.get(Order.class, id);
			return dh;
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			return null;
		} finally {
			session.close();
		}
	}
	
//	public Shipper getShipper_ById(int id) {
//		Session session = factory.openSession();
//		try {
//			session.beginTransaction();
//			Shipper s = (Shipper) session.get(Shipper.class, id);
//			return s;
//		} catch (HibernateException e) {
//			System.out.println(e.getMessage());
//			return null;
//		} finally {
//			session.close();
//		}
//	}
	
	@RequestMapping(value = "/order_detail/{id}", method = RequestMethod.GET)
	public String listOrderDetail(ModelMap model, @PathVariable("id") int id) {
		Session session = factory.openSession();
		String hql ="SELECT t1.OrderDetailID, t2.OrderID, t3.productName, t1.Price "
				+ "FROM OrderDetail t1 "
				+ "INNER JOIN Order t2 ON t2.OrderID = t1.order.OrderID "
				+ "INNER JOIN Product t3 ON t3.ProductID = t1.product.ProductID "
				+ "WHERE t2.OrderID = :id "
				+ "GROUP BY t1.OrderDetailID, t2.OrderID, t3.productName, t1.Price";
		Query query = session.createQuery(hql);
		query.setInteger("id", id);
		List<OrderDetail> list = query.list();
		model.addAttribute("list", list);
		session.close();
		return "admin/order_detail";
	}
}
