package productcrudapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import productcrudapp.dao.ProductDao;
import productcrudapp.model.Product;

@Controller
public class MainController {
	
	@Autowired
	ProductDao productDao;
	
	@RequestMapping("/")
	public String home(Model m)
	{
		List<Product> products = productDao.getAllProducts();
		m.addAttribute("products", products);
		return "index";
	}
	
	// show add form view
	@RequestMapping("/add-product")
	public String addProduct(Model m)
	{
		m.addAttribute("title", "AddProduct");
		return "add-product-form";
	}
	
	// handle add form from view
	@RequestMapping(value="/handle-product", method=RequestMethod.POST)
	public RedirectView handleProduct(@ModelAttribute Product product, HttpServletRequest request)
	{
		System.out.println(product);
		productDao.createProduct(product);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;
	}
	
	// handle delete
	@RequestMapping("/delete/{productId}")
	public RedirectView deleteProduct(@PathVariable("productId") int productId, HttpServletRequest request)
	{
		this.productDao.deleteProduct(productId);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/");
		return redirectView;
		
	}
	
	// handlr update request
	@RequestMapping("/update/{productId}")
	public String updateProduct(@PathVariable("productId") int pId, Model model)
	{
		Product product = this.productDao.getProduct(pId);
		System.out.println(product);
		model.addAttribute("product", product);
		return "update-product-form";
		
	}
	
}




















