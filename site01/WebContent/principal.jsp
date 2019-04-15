<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import=" java.net.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	// verificando se tem um atributo login na sessao
	// se tiver vai continuar e mostrar o menu
	if(session.getAttribute("login") != null) {
%>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Principal</title>
</head>

<body>

	<h1> Bem vindo <% out.print(session.getAttribute("login")); %>! </h1>

		<h2>
		<%

			try {

				out.println(InetAddress.getLocalHost().getHostAddress());

		    } catch (UnknownHostException e) {
		      e.printStackTrace();
		    }

		%>
		</h2>

	</br></br></br>

	<a href="LoginServlet?acao=logout">Logout</a>


</body>

</html>

<%
	// se não existir um login na sessao,
	// vai enviar para a página de login novamente
	} else {
%>
	<jsp:forward page="index.jsp"></jsp:forward>
<%
}
%>