package it.uniroma3.validator;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import it.uniroma3.model.Product;

public class ValidatorProduct {
	public boolean validate(HttpServletRequest request){
		boolean tuttoOk = true;
		String nome = request.getParameter("nome");
		String descrizione = request.getParameter("descrizione");
		String dataScadenza = request.getParameter("dataScadenza");
		String prezzo = request.getParameter("prezzo");
		
		Product prodotto=(Product) request.getAttribute("prodotto");
		
		if(nome == null || nome.equals("")) {
			request.setAttribute("errNome", "Campo obbligatorio");
			tuttoOk = false;
		}
		else 
			prodotto.setNome(nome);
		
		if(descrizione == null || descrizione.equals("")) {
			request.setAttribute("errDescrizione", "Campo obbligatorio");
			tuttoOk = false;
		}
		else
			prodotto.setDescrizione(descrizione);
		
		if(prezzo == null || prezzo.equals("")) {
			request.setAttribute("errPrezzo", "Campo obbligatorio");
			tuttoOk = false;
		}
		else {
			try {
				prodotto.setPrezzo(Float.parseFloat(prezzo));
			}
			catch (NumberFormatException e) {
				request.setAttribute("errPrezzo", "Deve essere un numero!");
				tuttoOk = false;
			}
		}
		
		if(dataScadenza == null || dataScadenza.equals("")) {
			request.setAttribute("errDataScadenza", "Campo obbligatorio");
			tuttoOk = false;
		}
		else {
			try {
				DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				prodotto.setDataScadenza(df.parse(dataScadenza));
				if(df.parse(dataScadenza).compareTo(new Date()) < 0) {
					request.setAttribute("errDataScadenza", "Deve essere successiva alla data di oggi!");
					tuttoOk = false;
				}
			} catch (ParseException e) {
				request.setAttribute("errDataScadenza", "Deve essere una data valida!");
				tuttoOk = false;
			}
		}
		
		return tuttoOk;
	}
}
