<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import=" java.net.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Index</title>
</head>

<body>
	<center>
		<h1>Você esta no IP:</h1>
		<table border=1>
			<tr>
				<td colspan="2">
					<h2>
					<%

					try {

				      out.println(InetAddress.getLocalHost().getHostAddress());

				    } catch (UnknownHostException e) {
				      e.printStackTrace();
				    }

					%>
					</h2>
				</td>
			</tr>
		</table>
	</center>

</body>

</html>