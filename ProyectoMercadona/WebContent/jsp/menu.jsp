<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
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
	
	
	<div class="container-fluid">
		<div class="row text-center">
			<div class="col-md-6">
				<a href="Productos" class="btn btn-lg btn-info">Productos</a>
			</div>
			<div class="col-md-6">
				<a href="Pedidos" class="btn btn-lg btn-info">Pedidos</a>
			</div>
		</div>
	</div>
	
</body>
</html>