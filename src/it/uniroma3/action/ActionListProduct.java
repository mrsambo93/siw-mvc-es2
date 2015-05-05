package it.uniroma3.action;

import it.uniroma3.model.ProductFacade;

import javax.servlet.http.HttpServletRequest;

public class ActionListProduct implements Action {

	@Override
	public String perform(HttpServletRequest request) {
		ProductFacade facade = new ProductFacade();
		request.setAttribute("products", facade.getAllProducts());
		return "/products.jsp";
	}

}
