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
					<label for="idFuncionario">Código</label> <input type="number"
						class="form-control" id="idUsuario">
				</div>
				<div class="form-group col-md-1">
					<label for="numeroMatricula">Matricula</label> <input type="text"
						class="form-control" id="numeroMatricula">
				</div>

				<div class="form-group col-md-3">
					<label for="nomeFuncionario">Nome</label> <input type="text"
						class="form-control" id="nomeFuncionario">
				</div>

				<div class="form-group col-md-2">
					<label for="nomeCargo">Cargo</label> <input type="text"
						class="form-control" id="nomeCargo">
				</div>

			</div>
		</form>
		<hr />
		<div id="list" class="row">

			<div class="table-responsive col-md-13">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Código</th>
							<th>Nome</th>
							<th>Cargo</th>
							<th>Matricula</th>
							<th>Email</th>
							<th class="actions">Ações</th>
						</tr>
					</thead>
					<tbody>

						<tr>
							<td>01</td>
							<td>Joao da Silva</td>
							<td>Secretaria</td>
							<td>123212</td>
							<td>joao.silva@gmail.com</td>
							<td class="actions"><a class="btn btn-success btn-xs"
								href="view.html">Visualizar</a> <a
								class="btn btn-warning btn-xs" href="edit.html">Editar</a></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div class="col-md-9">
			<button type="submit" class="btn btn-primary">Pesquisar</button>
			<form action="ControleFuncionario">
				<button type="submit" class="btn btn-primary" name="novo" value="novo">Novo</button>
				<button type="submit" class="btn btn-default" name="limpar" value="limpar">Limpar</button>
			</form>

		</div>
	</div>
</body>
</html>