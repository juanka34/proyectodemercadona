<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet" href="../css/estilos.css">

<script src="https://code.jquery.com/jquery-3.1.1.js"
	integrity="sha256-16cdPddA6VdVInumRGo6IbivbERE8p7CQR3HzTBuELA="
	crossorigin="anonymous"></script>
<script type="text/javascript" src="../js/miscript.js"></script>
</head>
<body>
<h3><%= session.getAttribute("usuario") %> ha iniciado sesión</h3>
<h3>Listado de productos</h3>
	<div class="container-fluid">
		<div class="row">
<% ResultSet rs=(ResultSet)(request.getAttribute("resultados"));//aqui se trae el request.setAttribute("resultados", rs); de el controlador Productos
	while(rs.next()){
%>

			<div class="col-md-4 text-center">
			<a href="Pedidos" class="btn btn-lg btn-info">añadir</a>
				<p><%= rs.getString("nombre") %></p>//aqui se trae el nombre 
				<p><a href='Productosdetalles?id=<%=rs.getString("id")%>'><img  width="200" height="200" src='<%= rs.getString("imagen")%>'></a></p>//aqui se trae la imagen
			</div>

<%}
%>
		</div>
	</div>
</body>
</html>