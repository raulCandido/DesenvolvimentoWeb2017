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
		<h3 class="page-header">Cadastro de funcionario</h3>
		<c:out value="${msg}" default="false"></c:out>
		<form action="CadastrarFuncionarioServelet" method="post">
				
			<div class="row">

				<div class="form-group col-md-4">
					<label for="nome">Nome</label> <input type="text"
						class="form-control" id="nome" name="nome" required>
				</div>

				<div class="form-group col-md-2">
					<label for="senha">Senha</label> <input type="text"
						class="form-control" id="senha" name="senha" required>
				</div>
				<div class="form-group col-md-4">
					<label for="email">Email</label> <input type="email"
						class="form-control" id="email" name="email" required>
				</div>
				<div class="form-group col-md-4">
					<label for="matricula">Matricula</label> <input type="text"
						class="form-control" id="matricula" name="matricula" required>
				</div>
				<div class="form-group col-md-3">
					<label for="cargo">Cargo</label> <input type="text"
						class="form-control" id="cargo" name="cargo" required>
				</div>
			</div>
			<hr />
			
			<div id="actions" class="row">
				<div class="col-md-12">
					<button type="submit" class="btn btn-primary">Salvar</button>
					<a href="./CadastrarFuncionario.jsp" class="btn btn-default">Limpar</a>
				</div>
			</div>
		</form>
	</div>

</body>
</html>