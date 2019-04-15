package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Vai processar a validação do usuário e senha
	 *
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// por default chamarei a pagina index e passarei o parametro erro=1
		String pagina = "index.jsp?erro=1";

		// Validando se o usuário é igual a admin e senha = banana
		// Nunca se coloca usuário e senha na classe java! (hardcode)
		// normalmente se busca usuário e senha no banco de dados ou arquivos XML
		if (request.getParameter("acao").equals("login")) {
			if (request.getParameter("login").equals("admin")) {
				if (request.getParameter("senha").equals("banana")) {
					HttpSession sessao = request.getSession();
					// setando um atributo da sessao
					sessao.setAttribute("login", request.getParameter("login"));
					// como obtive sucesso, chamo a página principal
					pagina = "principal.jsp";
				}
			}
		} else if (request.getParameter("acao").equals("logout")) {
			// no logout invalido a sessao
			HttpSession sessao = request.getSession();
			sessao.invalidate();
			// chamo novamente a pagina principal, que deve chamar a página index
			// que ira mostrar o formulario para o usuário logar
			pagina = "principal.jsp";
		}

		response.sendRedirect(pagina);

	}

}
