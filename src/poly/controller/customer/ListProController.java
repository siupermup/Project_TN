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
@RequestMapping("/listproduct")
public class ListProController {
	@Autowired
	SessionFactory factory;
	@RequestMapping(value ="")
	public String detailProduct(ModelMap model) {
		Session session = factory.openSession();
		String hql = "from Product";
		Query query = session.createQuery(hql);
		List<Product> list = query.list();
		model.addAttribute("data", list);
		String keyProduct = "product";
		model.addAttribute("keyProduct", keyProduct);
		return "web/listproduct";
	}
}
