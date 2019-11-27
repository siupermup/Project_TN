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
@RequestMapping("/product")
public class ProductController {

	@Autowired
	SessionFactory factory;
	@RequestMapping(value = "/{id}")
	public String detailProduct(ModelMap model, @PathVariable("id") String idPro) {
		Session session = factory.openSession();
		String hql = "from Product where productID = :spid ";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Product> list = query.setString("spid", idPro).list();
		Product sp = list.get(0);
		model.addAttribute("detail", sp);
		String keyProduct = "product";
		model.addAttribute("keyProduct", keyProduct);
		return "web/product";
	}
}
