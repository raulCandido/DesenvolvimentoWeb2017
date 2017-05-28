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
<title>Controle de usuário</title>
</head>
<body>
	<div id="main" class="container-fluid">
		<h3 class="page-header">Pesquisar Turma</h3>
		<form action="">
			<div class="row">
				<div class="form-group col-md-4">
					<label for="idusuario">Id usuario</label> <input type="number"
						class="form-control" id="idUsuario">
				</div>

				<div class="form-group col-md-4">
					<label for="idpessoa">id pessoa</label> <input type="number"
						class="form-control" id="idpessoa">
				</div>

				<div class="form-group col-md-4">
					<label for="senha">senha</label> <input type="text"
						class="form-control" id="senha">
				</div>
			</div>
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
		</form>
		<hr />
		<div id="actions" class="row">
			<div class="col-md-12">
				<button type="submit" class="btn btn-primary">Pesquisar</button>
				<form action="ControleTurma">
					<button type="submit" class="btn btn-primary" name="novo">Novo</button>
					<button type="submit" class="btn btn-default" name="limpar">Limpar</button>
				</form>
			</div>
		</div>
	</div>

</body>
</html>