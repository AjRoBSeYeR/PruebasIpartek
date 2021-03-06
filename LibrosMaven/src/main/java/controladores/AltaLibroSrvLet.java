package controladores;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelos.Libro;

@WebServlet("/altalibro")
public class AltaLibroSrvLet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AltaLibroSrvLet() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String isbn = request.getParameter("isbn");
		String titulo = request.getParameter("titulo");
		String autor = request.getParameter("autor");
		String editorial = request.getParameter("editorial");
		String precio = request.getParameter("precio");

		Libro libro;

		try {
			libro = new Libro(Long.parseLong(id), isbn, titulo, autor, editorial, Double.parseDouble(precio));

		} catch (RuntimeException e) {
			request.setAttribute("error", "Error en la lectura de proyectos");
			request.getRequestDispatcher("principal.jsp").forward(request, response);
			return;
		}
		
		PrintWriter escritura =new PrintWriter(new FileWriter(Libro.RUTA_LIBROS,true),true);

		escritura.println(libro.toString());
		escritura.close();

		//request.getRequestDispatcher("principal.jsp").forward(request, response);
		response.sendRedirect("inicio");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
