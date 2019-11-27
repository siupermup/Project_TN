package poly.controller.admin;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import poly.entity.Product;

@Controller
@RequestMapping("/homeAdmin")
public class HomeADController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("admin/login");
		return mav;
	}
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register() {
		ModelAndView mav = new ModelAndView("admin/register");
		return mav;
	}
	
	@Autowired
	SessionFactory factory;
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String report1(ModelMap model) throws Exception {
		Session session = factory.openSession();
		
		Date date = new Date();
		Double s = sumPrice(date, 7);
		model.addAttribute("rp2", s);
		
		int c = countOrder(date, 7);
		model.addAttribute("rp3", c);
		
		Date date1 = subDays(date, 7);
		List<Product> result = countPro(session, date1, date);
		model.addAttribute("data", result);
		session.close();
		return "admin/homeAD";
	}
	
	@RequestMapping(value = "/report", method = RequestMethod.GET)
	public ModelAndView report(@RequestParam String start, @RequestParam String end) throws Exception {
		Session session = factory.openSession();
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
		Date dateFrom = df1.parse(start);
		Date dateTo = df1.parse(end);
		List<Product> result = countPro(session, dateFrom, dateTo);
		Double s = sum(dateFrom, dateTo);
		int c = count(dateFrom, dateTo);
		ModelAndView mav = new ModelAndView("admin/report");
		mav.addObject("sta", start);
		mav.addObject("end", end);
		mav.addObject("sum", s);
		mav.addObject("count", c);
		mav.addObject("result", result);
		return mav;
	}
	
	public List<Product> countPro(Session ss,Date start, Date end ){
		try {
			String hql ="SELECT COUNT(t3.ProductID) AS SL, t4.categoryName "
					+ "FROM OrderDetail t1 "
					+ "INNER JOIN Order t2 ON (t1.order.OrderID = t2.OrderID) "
					+ "INNER JOIN Product t3 ON (t1.product.ProductID = t3.ProductID) "
					+ "INNER JOIN Category t4 ON t3.category.CategoryID = t4.CategoryID "
					+ "WHERE t2.OrderDate BETWEEN :start and :end "
					+ "GROUP BY t4.categoryName "
					+ "ORDER BY SL DESC";
			Query query = ss.createQuery(hql);
			query.setParameter("start", start);
			query.setParameter("end", end);
			List<Product> kq = query.list();
			return kq;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Double sumPrice(Date date, int days){
		Date d = subDays(date, days);
        Double price =sum(d, date);
        return price;
	}
	
	public int countOrder(Date date, int days){
		Date d = subDays(date, days);
        int order =count(d, date);
        return order;
    }
	
	private Double sum(Date start, Date end){
		Session session = factory.openSession();
		Date dateTo = end;
		Date dateFrom = start;
		Query query = session.createQuery("SELECT SUM(t1.Price) "
				+ "FROM OrderDetail t1 "
				+ "INNER JOIN Order t2 ON t1.order.OrderID = t2.OrderID "
				+ "WHERE t2.OrderDate BETWEEN :since AND :now");
		query.setParameter("since", dateFrom);
		query.setParameter("now", dateTo);
		Double obj = (Double)query.uniqueResult();
		return obj;
	}
	
	private int count(Date start, Date end){
		 Session session = factory.openSession();
		 Query query = session.createQuery("SELECT count(t1.OrderID) FROM Order t1 WHERE OrderDate BETWEEN :since AND :now");
		 Date dateFrom = start;
		 Date dateTo = end;
		 query.setParameter("since", dateFrom);
		 query.setParameter("now", dateTo);
		 Long obj = (Long) query.uniqueResult();
		 return obj.intValue();
	}

	public int compare() {
		return 0;
	}
	
	public static Date subDays(Date date, int days) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.add(Calendar.DATE, -days);
        return cal.getTime();
    }
 
}
