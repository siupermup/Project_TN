package poly.controller.customer;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.entity.Product;

@Controller()
@RequestMapping("/listprobycat")
public class ProByCatController {
	@Autowired
	SessionFactory factory;
	@RequestMapping(value ="/{id}")
	public String listProductByCategory(ModelMap model, @PathVariable("id") String idCat) {
		Session session = factory.openSession();
		String hql = "from Product t1 where t1.category.CategoryID = :id";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Product> list = query.setString("id", idCat).list();
		model.addAttribute("probycat", list);
		String keyProduct = "product";
		model.addAttribute("keyProduct", keyProduct);
		return "web/listprobycat";
	}
}
