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
<title>Controle de Funcionario</title>
</head>
<body>
	<div id="main" class="container-fluid">
		<h3 class="page-header">Pesquisar Funcionario</h3>
		<form action="">
			<div class="row">
				<div class="form-group col-md-1">
					<label for="idusuario">Código</label> <input type="number"
						class="form-control" id="idUsuario">
				</div>

				<div class="form-group col-md-3">
					<label for="nomeDisciplina">Nome disciplina</label> <input
						type="text" class="form-control" id="idpessoa">
				</div>
			</div>
			<hr />
			<div id="list" class="row">

				<div class="table-responsive col-md-13">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>Código</th>
								<th>Nome</th>
								<th>Material</th>
								<th>Livros</th>
								<th>Ementa</th>
								<th class="actions">Ações</th>
							</tr>
						</thead>
						<tbody>

							<tr>
								<td>01</td>
								<td>Matematica Discreta</td>
								<td>Material matematica discreta</td>
								<td>Livro matematica discreta</td>
								<td>Ementa</td>
								<td class="actions"><a class="btn btn-success btn-xs"
									href="view.html">Visualizar</a> <a
									class="btn btn-warning btn-xs" href="edit.html">Editar</a></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="col-md-12 ">
				<button type="submit" class="btn btn-primary">Pesquisar</button>
				<button type="submit" class="btn btn-primary">Novo</button>
				<a href="#" class="btn btn-default">Limpar</a>
			</div>
	</div>
</body>
</html>