package poly.controller.admin;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import poly.entity.Shipper;

@Controller
@RequestMapping("/homeAdmin/employe")
public class manage_employe {

//	@RequestMapping(value = "", method = RequestMethod.GET)
//	public ModelAndView homePage() {
//		ModelAndView mav = new ModelAndView("admin/manage_employe");
//		return mav;
//	}
	
	@Autowired
	SessionFactory factory;
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String shipper(ModelMap model) {
		Session session = factory.openSession();
		String hql = "FROM Staff WHERE status = 1";
		Query query = session.createQuery(hql);
		List<Shipper> list = query.list();
		model.addAttribute("staff", list);
		session.close();
		return "admin/manage_employe";
	}
}
