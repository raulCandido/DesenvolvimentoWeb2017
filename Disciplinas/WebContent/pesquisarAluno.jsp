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
		<h3 class="page-header">Pesquisar Aluno</h3>
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
		</form>
		<hr />
		<div id="actions" class="row">
			<div class="col-md-12">
				<button type="submit" class="btn btn-primary" name="pesquisar">Pesquisar</button>
				<form action="ControleAluno">
					<button type="submit" class="btn btn-primary" name="novo">Novo</button>
					<button type="submit" class="btn btn-default" name="limpar">Limpar</button>
				</form>

			</div>
		</div>
	</div>

</body>
</html>