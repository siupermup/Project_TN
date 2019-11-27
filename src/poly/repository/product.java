package poly.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
@Transactional
public class product {
	@Autowired
	SessionFactory factory;
	public List<product> views() {
		Session session = factory.getCurrentSession();
		String hql = "FROM product";
		Query query = session.createQuery(hql);
		List<product> list = query.list();	
		return list;
	}
}
