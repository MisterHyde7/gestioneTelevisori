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

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String marcaDaForm = request.getParameter("marcaTelevisore");
		String modelloDaForm = request.getParameter("modelloTelevisore");
		String prezzoDaForm = request.getParameter("prezzoTelevisore");
		String numeroPolliciDaForm = request.getParameter("numeroPolliciTelevisore");
		String codiceDaForm = request.getParameter("codiceTelevisore");

		try {

			if (marcaDaForm == null)
				marcaDaForm = "";
			if (modelloDaForm == null)
				modelloDaForm = "";
			int prezzo = 0;
			if (NumberUtility.verificaSeInteroValido(prezzoDaForm) != null)
				prezzo = NumberUtility.verificaSeInteroValido(prezzoDaForm);
			int numeroPollici = 0;
			if (NumberUtility.verificaSeInteroValido(numeroPolliciDaForm) != null)
				numeroPollici = NumberUtility.verificaSeInteroValido(numeroPolliciDaForm);
			if (codiceDaForm == null)
				codiceDaForm = "";

			TelevisoreService televisoreService = MyServiceFactory.getTelevisoreServiceInstance();
			Televisore televisoreExample = new Televisore(marcaDaForm, modelloDaForm, prezzo, numeroPollici,
					codiceDaForm);
			List<Televisore> listaDiTelevisori = televisoreService.findByExample(televisoreExample);
			request.setAttribute("televisori", listaDiTelevisori);

		} catch (Exception e) {

		}

		RequestDispatcher rd = request.getRequestDispatcher("risultati.jsp");
		rd.forward(request, response);

	}

}
