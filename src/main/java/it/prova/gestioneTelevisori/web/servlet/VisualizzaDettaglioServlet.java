package it.prova.gestioneTelevisori.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestioneTelevisori.model.Televisore;
import it.prova.gestioneTelevisori.service.MyServiceFactory;
import it.prova.gestioneTelevisori.service.televisore.TelevisoreService;

@WebServlet("/VisualizzaDettaglioServlet")
public class VisualizzaDettaglioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String parametroIdDelTelevisoreDiCuiVoglioIlDettaglio = request.getParameter("idDaInviareComeParametro");

		try {

			TelevisoreService televisoreServiceInstance = MyServiceFactory.getTelevisoreServiceInstance();
			Televisore risultato = televisoreServiceInstance
					.cercaPerId(Long.parseLong(parametroIdDelTelevisoreDiCuiVoglioIlDettaglio));

			request.setAttribute("marca", risultato.getMarca());
			request.setAttribute("modello", risultato.getModello());
			request.setAttribute("prezzo", risultato.getPrezzo());
			request.setAttribute("numeroPollici", risultato.getNumeroPollici());
			request.setAttribute("codice", risultato.getCodice());

		} catch (Exception e) {

			e.printStackTrace();

		}
		RequestDispatcher rd = request.getRequestDispatcher("dettaglio.jsp");
		rd.forward(request, response);
	}

}
