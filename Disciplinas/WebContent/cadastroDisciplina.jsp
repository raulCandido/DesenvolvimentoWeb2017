<%@ page language="java" pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@ include file="templateprincipal.jsp"%>

<!DOCTYPE html >

<html>
<head>
<title>Controle de Disciplina</title>
</head>
<body>
	<div id="main" class="container-fluid">
		<h3 class="page-header">Pesquisar Disciplina</h3>
		<form action="CadastrarDisciplinas">
			<div class="row">

				<div class="form-group col-md-4">
					<label for="nomeDisciplina">Nome da disciplina</label> <input
						type="text" class="form-control" id="nomeDisciplina">
				</div>


				<div class="form-group col-md-4">
					<label for="ementa">Ementa</label> <input type="text"
						class="form-control" id="ementa">
				</div>

				<div class="form-group col-md-1">
					<label for="cargaHoraria">Carga Horaria</label> <input
						type="number" class="form-control" id="cargaHoraria">
				</div>
			</div>
			<hr />
			<div id="actions" class="row">
				<div class="col-md-12">
					<button type="submit" class="btn btn-primary">Salvar</button>
					<a href="index.html" class="btn btn-default">Limpar</a>
				</div>
			</div>
		</form>
	</div>

</body>
</html>