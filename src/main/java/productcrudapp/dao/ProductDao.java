package productcrudapp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import productcrudapp.model.Product;

@Component
public class ProductDao {
	
	@Autowired
	private HibernateTemplate hbmTemp;
	
	//create
	@Transactional
	public void createProduct(Product product)
	{
		this.hbmTemp.saveOrUpdate(product);
	}
	
	//get all products
	public List<Product> getAllProducts()
	{
		List<Product> products = this.hbmTemp.loadAll(Product.class);
		return products;
	}
	
	//delete the single product
	@Transactional
	public void deleteProduct(int pid)
	{
		Product p = this.hbmTemp.load(Product.class, pid);
		this.hbmTemp.delete(p);
	}
	
	//get single product
	public Product getProduct(int pid)
	{
		return this.hbmTemp.get(Product.class, pid);

	}
	

}












