package it.uniroma3.action;

import javax.servlet.http.HttpServletRequest;

public class HelperProduct {

	private HttpServletRequest request;
	
	public HelperProduct(HttpServletRequest request) {
		this.request = request;
	}
	
	public boolean validate() {
		boolean isCorrect = true;
		if(request.getParameter("code") == null || request.getParameter("code").isEmpty()) {
			isCorrect = false;
			request.setAttribute("codeError", "Campo obbligatorio");
		}
		if(request.getParameter("name") == null || request.getParameter("name").isEmpty()) {
			isCorrect = false;
			request.setAttribute("nameError", "Campo obbligatorio");
		}
		if(request.getParameter("price") == null || request.getParameter("price").isEmpty()) {
			isCorrect = false;
			request.setAttribute("priceError", "Campo obbligatorio");
		}
		if(!isPositiveFloat(request.getParameter("price"))) {
			isCorrect = false;
			request.setAttribute("codeError", "Deve essere un numero decimale");
		}
		if(request.getParameter("description") == null || request.getParameter("description").isEmpty()) {
			isCorrect = false;
			request.setAttribute("descriptionError", "Campo obbligatorio");
		}
		return isCorrect;
	}
	
	private boolean isPositiveFloat(String s) {
		boolean isFloat = true;
		Float f;
		if(s == null) return false;
		try {
			f = Float.parseFloat(s);
			if(f < 0) {
				isFloat = false;
			}
		} catch(NumberFormatException e) {
			isFloat = false;
		}
		return isFloat;
	}
}
