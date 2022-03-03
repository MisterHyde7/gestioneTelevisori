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

@WebServlet("/ExecuteDeleteServlet")
public class ExecuteDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Long idDaRimuovere = (Long) request.getAttribute("idTelevisore");

		try {

			TelevisoreService televisoreService = MyServiceFactory.getTelevisoreServiceInstance();
			Televisore televisoreDaRimuovere = televisoreService.cercaPerId(idDaRimuovere);
			televisoreService.deleteTelevisore(televisoreDaRimuovere);
			List<Televisore> listaAggiornata = televisoreService.listAll();
			request.setAttribute("televisori", listaAggiornata);

		} catch (Exception e) {
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("risultati.jsp");
		rd.forward(request, response);
	}

}
