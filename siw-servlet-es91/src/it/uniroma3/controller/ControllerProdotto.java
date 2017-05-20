package it.uniroma3.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma3.model.Product;
import it.uniroma3.service.ProductService;
import it.uniroma3.validator.ValidatorProduct;

@WebServlet("/prodotto")
public class ControllerProdotto extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage;
		if(!request.getParameter("command").equals("remove")){
			Product prodotto = new Product();
			request.setAttribute("prodotto", prodotto);
			ValidatorProduct validator= new ValidatorProduct();
			if(validator.validate(request)){
				ProductService service = new ProductService();
				service.inserisciProdotto(prodotto);
				nextPage="/prodotto.jsp";
			}else{
				nextPage="/index.jsp";
			}
		}else{

			nextPage="/prodotti.jsp";
		}
		ServletContext application  = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);
		rd.forward(request, response);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage;
		ProductService service = new ProductService();

		if(request.getParameter("id")!=null){ //se nella richiesto ho l'id faccio questo
			Long id= Long.parseLong(request.getParameter("id"));
			Product one = service.getOnePrduct(id);
			request.setAttribute("prodotto", one);
			nextPage="/prodotto.jsp";
		}else{		
			List<Product> prodotti=service.getProducts();
			request.setAttribute("prodotti",prodotti);
			nextPage="/prodotti.jsp";			
		}		

		ServletContext application  = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}

}
