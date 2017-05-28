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
<title>Controle de Turma</title>
</head>
<body>
	<div id="main" class="container-fluid">
		<h3 class="page-header">Cadastrar Turma</h3>

		<form action="CadastrarTurmaServelet" method="post">
			<c:out value="${msg}"></c:out>
			<div class="row">
				<div class="form-group col-md-1">
					<label for="ano">Ano da turma</label> <input type="number"
						class="form-control" id="ano" name="ano" maxlength="4" required>
				</div>
				<div class="form-group col-md-1">
					<label for="semestre">Semestre</label> <input type="number"
						class="form-control" id="semestre" name="semestre" required>
				</div>
				<div class="form-group col-md-3">
					<label for="diaSemana">Dia da semana</label> <input type="text"
						class="form-control" id="diaSemana" name="diaSemana" required>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-5">
					<label for="observacao">Descricao detalhada</label>
					<textarea rows="5" class="form-control" id="observacao"
						name="observacao" required></textarea>
				</div>
			</div>
			<hr />
			<div id="actions" class="row">
				<div class="col-md-12">
					<button type="submit" class="btn btn-primary">Salvar</button>
					<a href="./CadastrarTurma.jsp" class="btn btn-default">Limpar</a>
				</div>
			</div>
		</form>
	</div>

</body>
</html>