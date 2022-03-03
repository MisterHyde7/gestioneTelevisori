package it.prova.gestioneTelevisori.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestioneTelevisori.model.Televisore;
import it.prova.gestioneTelevisori.service.MyServiceFactory;
import it.prova.gestioneTelevisori.service.televisore.TelevisoreService;
import it.prova.gestioneTelevisori.utility.NumberUtility;

@WebServlet("/ExecuteUpdateServlet")
public class ExecuteUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String destinazione = null;
		String marcaInputForm = request.getParameter("marcaTelevisore");
		String modelloInputForm = request.getParameter("modelloTelevisore");
		String prezzoInputForm = request.getParameter("prezzoTelevisore");
		String numeroPolliciInputForm = request.getParameter("numeroPolliciTelevisore");
		String codiceInputForm = request.getParameter("codiceTelevisore");

		try {

			if (marcaInputForm.isEmpty() || marcaInputForm == null || modelloInputForm.isEmpty()
					|| modelloInputForm == null || NumberUtility.verificaSeInteroValido(prezzoInputForm) < 0
					|| NumberUtility.verificaSeInteroValido(numeroPolliciInputForm) < 0 || codiceInputForm.isEmpty()
					|| codiceInputForm == null) {
				destinazione = "inserimento.jsp";
			} else {
				destinazione = "risultati.jsp";
			}
			
			TelevisoreService televisoreService = MyServiceFactory.getTelevisoreServiceInstance();
			Televisore televisoreDaInserire = new Televisore(marcaInputForm, modelloInputForm,
					NumberUtility.verificaSeInteroValido(prezzoInputForm),
					NumberUtility.verificaSeInteroValido(numeroPolliciInputForm), codiceInputForm);
			televisoreService.inserisciNuovo(televisoreDaInserire);
			List<Televisore> nuovaLista = televisoreService.listAll();
			request.setAttribute("televisori", nuovaLista);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher(destinazione);
		rd.forward(request, response);
	}

}
