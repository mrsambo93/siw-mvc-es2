package it.uniroma3.action;

import it.uniroma3.model.ProductFacade;
import it.uniroma3.model.Product;

import javax.servlet.http.HttpServletRequest;

public class ActionCreateProduct implements Action{
	
	public String perform(HttpServletRequest request) {
		HelperProduct helper = new HelperProduct(request);
		if(helper.validate()) {
			ProductFacade facade = new ProductFacade();
			Product product;
			product = facade.createProduct(request.getParameter("name"), request.getParameter("code"), 
					Float.parseFloat(request.getParameter("price")), request.getParameter("description"));
			if(product != null) {
				request.setAttribute("product", product);
				return "/product.jsp";
			}
			return "/error.jsp";
		} else {
			return "/newProduct.jsp";
		}
	}
}
