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
		<form action="VisualizarTurma" method="post">
			<div class="row">
				<div class="form-group col-md-1">
					<label for="codTurma">Codigo Turma</label> <input type="number"
						class="form-control" id="codTurma" name="codTurma">
				</div>

			</div>
			<div id="list" class="row">
				<div class="table-responsive col-md-13">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>Codigo turma</th>
								<th>Ano</th>
								<th>Semestre</th>
								<th>Observacao</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listaTurma}" var="itens">
								<tr>
									<td><c:out value="${itens.id}"></c:out></td>
									<td><c:out value="${itens.ano}"></c:out></td>
									<td><c:out value="${itens.semestre}"></c:out></td>
									<td><c:out value="${itens.obersevacao}"></c:out></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<button type="submit" class="btn btn-primary">Pesquisar</button>
		</form>
		<hr />
		<div id="actions" class="row">
			<div class="col-md-12">
				<form action="ControleTurma">
					<button type="submit" class="btn btn-primary" name="novo">Novo</button>
					<button type="submit" class="btn btn-default" name="limpar">Limpar</button>
				</form>
			</div>
		</div>
	</div>

</body>
</html>