<%@ page language="java" pageEncoding="UTF-8" session="false"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<!DOCTYPE html>

<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="resources/css/bootstrap.min.css" rel="stylesheet">
	<link href="resources/css/estiloprincipal.css" rel="stylesheet">
	<link href="resources/css/paginalogin.css" rel="stylesheet">
	<link href="resources/img/favicon.ico" rel="icon">
	<link href='http://fonts.googleapis.com/css?family=Droid+Serif' rel='stylesheet' type='text/css'>
	<link href='http://fonts.googleapis.com/css?family=Droid+Sans' rel='stylesheet' type='text/css'>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	<title>Disciplinas</title>
</head>

<body>

	<img class="localizacaologofamentro" src="resources/img/logo_fametro.png"	alt="Foto logo da Fametro">
	<form  action="ControleUsuario" method="post">
	
	
		<div class="formulariodelogin">
			<div class="form-group labelsadireta">
				<label for="matricula">Matricula </label> 
				<input type="number" class="form-control" id="matricula" name="matricula" placeholder="Digite sua matricula" required>
			</div>
			<div class="form-group labelsadireta">
				<label for="matricula">Senha </label>
				<input type="password" class="form-control " id="senha" name="senha" placeholder="Digite sua senha" required>
			</div>
		</div>
		<div class="formulariodelogin">
			<button type="submit" class="btn btn-default">Entrar</button>
		</div>
	</form>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>

</html>