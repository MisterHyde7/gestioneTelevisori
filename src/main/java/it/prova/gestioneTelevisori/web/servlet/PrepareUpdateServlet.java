package it.prova.gestioneTelevisori.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PrepareUpdateServlet")
public class PrepareUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String parametroIdDelTelevisoreDiCuiVoglioIlDettaglio = request.getParameter("idDaInviareComeParametro");
		Long idTelevisore = Long.parseLong(parametroIdDelTelevisoreDiCuiVoglioIlDettaglio);
		request.setAttribute("idDaModificare", idTelevisore);

		RequestDispatcher rd = request.getRequestDispatcher("modifica.jsp");
		rd.forward(request, response);
		
	}

}
