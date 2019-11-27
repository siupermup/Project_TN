
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
import org.springframework.web.servlet.ModelAndView;

import poly.entity.Product;
import poly.entity.Shipper;

@Controller
@RequestMapping("/homeAdmin/shipper")
public class manage_shipper {

//	@RequestMapping(value = "", method = RequestMethod.GET)
//	public ModelAndView homePage() {
//		ModelAndView mav = new ModelAndView("admin/manage_shipper");
//		return mav;
//	}
	
	@Autowired
	SessionFactory factory;
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String shipper(ModelMap model) {
		Session session = factory.openSession();
		String hql = "FROM Shipper";
		Query query = session.createQuery(hql);
		List<Shipper> list = query.list();
		model.addAttribute("shipper", list);
		session.close();
		return "admin/manage_shipper";
	}
	
	@RequestMapping(value="/shipper_form", method = RequestMethod.GET)
	public String insertProduct(ModelMap model) {
		
		model.addAttribute("shipper", new Shipper());
		return "admin/shipper_form";
	}
	@RequestMapping(value = "/shipper_form", method = RequestMethod.POST)
	public String insertProduct(ModelMap model, @ModelAttribute("shipper") Shipper shipper) {
		
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(shipper);
			t.commit();
			model.addAttribute("message", "Insert Successful !");
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "Insert Failed !");
		} finally {
			session.close();
		}
		return "admin/manage_shipper";
	}
	
	@RequestMapping(value = "shipper_edit/{id}", method = RequestMethod.GET)
	public String update(ModelMap model, @PathVariable("id") int id) {
		
		Session session = factory.openSession();
		String hql = "FROM Shipper WHERE shipperID = :id";
		Query query = session.createQuery(hql);
		query.setInteger("id", id);
		Shipper ship = (Shipper) query.uniqueResult();
		model.addAttribute("shipper", ship);
		session.close();
		return "admin/shipper_edit";
	}

	@RequestMapping(value = "shipper_edit", method = RequestMethod.POST)
	public String update(ModelMap model, @ModelAttribute("shipper") Shipper shipper) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(shipper);
			t.commit();
			model.addAttribute("message", "Update Successful !");
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "Update Failed !");
		} finally {
			session.close();
		}
		return "admin/manage_shipper";
	}
	
	public Shipper getShip_ByID(int id) {
		Session session = factory.openSession();
		try {
			session.beginTransaction();
			Shipper nv = (Shipper) session.get(Shipper.class, id);
			return nv;
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			return null;
		} finally {
			session.close();
		}
	}
//	@RequestMapping(value = "/shipper_del/{id}", method = RequestMethod.GET)
//	public String delete(ModelMap model, @PathVariable("id") int id) {
//		Shipper ship = getShip_ByID(id);
//
//		Session session = factory.openSession();
//		Transaction t = session.beginTransaction();
//		try {
//			session.update(ship);
//			t.commit();
//		} catch (Exception e) {
//			t.rollback();
//		} finally {
//			session.close();
//		}
//		return "admin/manage_shipper";
//	}
}
