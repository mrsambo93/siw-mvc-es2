package it.uniroma3.controller;

import it.uniroma3.action.Action;

import java.io.IOException;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/controller/*")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Action action;
		String actionName = path2action(request);
		String nextPage = null;
		try {
			action = (Action)Class.forName(actionName).newInstance();
			nextPage = action.perform(request);
		} catch (Exception e) {
			nextPage = "/index.jsp";
		}
		nextPage = response.encodeURL(nextPage);
		ServletContext application = getServletContext();
		String urlNextPage = response.encodeURL(nextPage);
		RequestDispatcher rd = application.getRequestDispatcher(urlNextPage);
		rd.forward(request, response);
		return;
	}
	
	private String path2action(HttpServletRequest request) {
		String path = request.getPathInfo();
		String modelCommand = path.substring(1);
		Scanner scanner = new Scanner(modelCommand).useDelimiter("\\.");
		String model = scanner.next();
		model = model.substring(0,1).toUpperCase() + model.substring(1);
		String action = scanner.next();
		action = action.substring(0,1).toUpperCase() + action.substring(1);
		String actionName = "it.uniroma3.action.Action" + action + model;
		scanner.close();
		return actionName;
	}
}
