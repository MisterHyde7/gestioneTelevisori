package it.prova.gestioneTelevisori.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestioneTelevisori.model.Televisore;
import it.prova.gestioneTelevisori.service.MyServiceFactory;
import it.prova.gestioneTelevisori.service.televisore.TelevisoreService;
import it.prova.gestioneTelevisori.utility.NumberUtility;

@WebServlet("/ExecuteModificaServlet")
public class ExecuteModificaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idParam = request.getParameter("idTelevisore");
		String marcaParam = request.getParameter("nuovaMarca");
		String modelloParam = request.getParameter("nuovoModello");
		String prezzoParam = request.getParameter("nuovoPrezzo");
		String polliciParam = request.getParameter("nuovoNumeroPollici");
		String codiceParam = request.getParameter("nuovoCodice");

		try {

			if (marcaParam == null || marcaParam.isEmpty() || modelloParam == null || modelloParam.isEmpty()
					|| NumberUtility.verificaSeInteroValido(prezzoParam) == null
					|| NumberUtility.verificaSeInteroValido(prezzoParam) < 0
					|| NumberUtility.verificaSeInteroValido(polliciParam) < 0
					|| NumberUtility.verificaSeInteroValido(polliciParam) == null || codiceParam == null
					|| codiceParam.isEmpty()) {
				request.setAttribute("modificaErrata", 0);
				request.getRequestDispatcher("modifica.jsp").forward(request, response);
			}

			Televisore televisoreDaModificare = new Televisore(marcaParam, modelloParam,
					NumberUtility.verificaSeInteroValido(prezzoParam),
					NumberUtility.verificaSeInteroValido(polliciParam), codiceParam);
			televisoreDaModificare.setId(Long.parseLong(idParam));

			TelevisoreService televisoreInstance = MyServiceFactory.getTelevisoreServiceInstance();
			televisoreInstance.updateTelevisore(televisoreDaModificare);
			request.setAttribute("televisori", televisoreInstance.listAll());

		} catch (Exception e) {

			e.printStackTrace();
		}

		request.getRequestDispatcher("risultati.jsp").forward(request, response);

	}

}
