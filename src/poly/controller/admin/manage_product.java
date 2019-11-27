
package poly.controller.admin;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import poly.entity.Category;
import poly.entity.Manufacturer;
import poly.entity.Product;
import poly.entity.Supplier;

@Transactional
@Controller
@RequestMapping("/homeAdmin/product")

public class manage_product {
	@Autowired
	SessionFactory factory;
	ServletContext context;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String homePage(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Product where status=1";
		Query query = session.createQuery(hql);
		List<Product> list = query.list();	
		model.addAttribute("products", list);
		return "admin/manage_product";
	}
	@RequestMapping(value="/insertProduct", method = RequestMethod.GET)
	public String insertProduct(ModelMap model) {
		
		model.addAttribute("product", new Product());
		return "admin/insertProduct";
	}
	@RequestMapping(value = "/insertProduct", method = RequestMethod.POST)
	public String insertProduct(ModelMap model, @ModelAttribute("product") Product product) {
		
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			product.setStatus(1);
			session.save(product);
			t.commit();
			model.addAttribute("message", "Insert Successful !");
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "Insert Failed !");
		} finally {
			session.close();
		}
		return "admin/manage_product";
	}
	@ModelAttribute("category")
	public List<Category> getCategories() {
		Session session = factory.openSession();
		String hql = "FROM Category";
		Query query = session.createQuery(hql);
		List<Category> list = query.list();
		session.close();
		return list;
	}
	@ModelAttribute("manufacturer")
	public List<Manufacturer> getManufacturers() {
		Session session = factory.openSession();
		String hql = "FROM Manufacturer";
		Query query = session.createQuery(hql);
		List<Manufacturer> list = query.list();
		session.close();
		return list;
	}

	@ModelAttribute("supplier")
	public List<Supplier> geSuppliers() {
		Session session = factory.openSession();
		String hql = "FROM Supplier";
		Query query = session.createQuery(hql);
		List<Supplier> list = query.list();
		session.close();
		return list;
	}
	public Product getPro_ByProID(int ProID) {
		Session session = factory.openSession();
		try {
			session.beginTransaction();
			Product nv = (Product) session.get(Product.class, ProID);
			return nv;
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			return null;
		} finally {
			session.close();
		}
	}
	@RequestMapping(value = "/delProduct/{proid}", method = RequestMethod.GET)
	public String delete(ModelMap model, @PathVariable("proid") int ProID) {
		Product sp = getPro_ByProID(ProID);

		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			sp.setStatus(2);
			session.update(sp);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		} finally {
			session.close();
		}
		return "admin/manage_product";
	}
	@RequestMapping(value = "editProduct/{proid}", method = RequestMethod.GET)
	public String update(ModelMap model, @PathVariable("proid") int proid) {
		
		Session session = factory.openSession();
		String hql = "FROM Product WHERE ProductID = :proid";
		Query query = session.createQuery(hql);
		query.setInteger("proid", proid);
		Product sp = (Product) query.uniqueResult();
		model.addAttribute("product", sp);
		session.close();
		return "admin/editProduct";
	}

	@RequestMapping(value = "editProduct", method = RequestMethod.POST)
	public String update(ModelMap model, @ModelAttribute("product") Product product) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			product.setStatus(1);;
			session.update(product);
			t.commit();
			model.addAttribute("message", "Update Successful !");
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "Update Failed !");
		} finally {
			session.close();
		}
		return "admin/manage_product";
	}

	
}
