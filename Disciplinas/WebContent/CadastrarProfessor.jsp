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
<title>Controle de Professor</title>
</head>
<body>
	<div id="main" class="container-fluid">
		<h3 class="page-header">Cadastro de Professor</h3>
		<form action="CadastrarProfessorServelet" method="post">
			<c:out value="${msg}"></c:out>
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
					<label for="formacao">Formacao</label> <input type="text"
						class="form-control" id="formacao" name="formacao" required>
				</div>
			</div>
			<hr />
			<div id="actions" class="row">
				<div class="col-md-12">
					<button type="submit" class="btn btn-primary">Salvar</button>
					<a href="./CadastrarProfessor.jsp" class="btn btn-default">Limpar</a>
				</div>
			</div>
		</form>
	</div>

</body>
</html>