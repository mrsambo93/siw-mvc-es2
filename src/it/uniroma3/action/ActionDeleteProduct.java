package it.uniroma3.action;

import it.uniroma3.model.ProductFacade;

import javax.servlet.http.HttpServletRequest;

public class ActionDeleteProduct implements Action{

	@Override
	public String perform(HttpServletRequest request) {
		HelperProduct helper = new HelperProduct(request);
		if(helper.validate()) {
			ProductFacade facade = new ProductFacade();
			facade.deleteProduct(Long.parseLong(request.getParameter("ID")));
		}
		return "/index.jsp";
	}

}