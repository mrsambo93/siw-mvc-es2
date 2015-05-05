package it.uniroma3.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ProductFacade {
	
	private Map<Long, Product> products;
	
	public ProductFacade()  {
		this.products = new HashMap<Long, Product>();
		Product product = new Product("SDON", "description of SDON", "AA-00-11", new Float(12.1));
		product.setId(new Long(1));
		this.products.put(product.getId(), product);
		
		product = new Product("ADAS", "description of ADAS", "BB-11-22", new Float(10.0));
		product.setId(new Long(2));
		this.products.put(product.getId(), product);

		product = new Product("DANH", "description of DANH", "CC-22-33", new Float(20.5));
		product.setId(new Long(3));
		this.products.put(product.getId(), product);
	}

	public Product createProduct(String name, String code, Float price, String description) {
		// TODO Auto-generated method stub
		Product product = new Product(name, description, code, price);
		this.products.put(new Long(products.size()), product);
		//TO COMPLETE should call a JPA persist method
		return product;
	}
	
	public Product getProduct(Long id) {
		// TODO
		return products.get(id);
	}
	
	public List<Product> getAllProducts() {
		//TODO
		return new LinkedList<Product>(products.values());
	}

	public void updateProduct(Product product) {
		//TODO
		products.put(product.getId(), product);
	}

	public void deleteProduct(Long id) {
		//TODO
		products.remove(id);
	}


}
