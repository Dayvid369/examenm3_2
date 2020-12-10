package curso.examen.m3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import curso.examen.m3.libreria.Util;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controlador() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO: completar
		
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO: completar
		
		

		String emailDestinatario=request.getParameter("emaildestino");
		String nombre=request.getParameter("nombre");
		String provincia=request.getParameter("provincia");
		String asunto=nombre+" - "+provincia;
		String mensajeDestinatario=request.getParameter("mensaje");
		String emaildeOrigen=request.getParameter("emaildeorigen");
		String pass=request.getParameter("clavemail");
		
		
		Util.enviarEmail(emaildeOrigen, pass, emailDestinatario, asunto, mensajeDestinatario);
		//Util.enviarEmail(emailUser, passUser, emailDestino, asuntoEmail, cuerpoEmail);
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

	private void almacenarDatos(String nombre, String emailDestinatario, String provincia, String mensajeDestinatario) {
		// TODO Auto-generated method stub
		
	}

}
