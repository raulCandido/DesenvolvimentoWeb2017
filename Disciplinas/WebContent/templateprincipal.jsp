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
    <link href="resources/css/bootstrap.css" rel="stylesheet">
<!--     <link href="resources/css/bootstrap.min.css" rel="stylesheet"> -->
    <link href="resources/css/bootstrap-theme.css" rel="stylesheet">
    <link href="resources/css/bootstrap-theme.min.css" rel="stylesheet">
    <link href="resources/css/estiloprincipal.css" rel="stylesheet">
    <link href="resources/css/paginalogin.css" rel="stylesheet">
    <link href="resources/css/template.css" rel="stylesheet">
    
    <link href="resources/img/favicon.ico" rel="icon">
    <link href='http://fonts.googleapis.com/css?family=Droid+Serif' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Droid+Sans' rel='stylesheet' type='text/css'>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <title>Disciplinas</title>
</head>

<body>
<div class="bs-example">
<form action="">
    <nav id="myNavbar" class="navbar navbar-default" role="navigation">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#"></a>
            </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li><a href="./menu.jsp">Home</a></li>
                    <li class="dropdown">
                        <a href="#" data-toggle="dropdown" class="dropdown-toggle">Controle de Pessoa<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="./pesquisarFuncionario.jsp">Funcionario</a></li>
                            <li><a href="./pesquisarProfessor.jsp">Professor</a></li>
                            <li><a href="./pesquisarAluno.jsp">Aluno</a></li>
                            <li><a href="./pesquisarUsuario.jsp">Usuario</a></li>
                        </ul>
                    </li>
                    
                     <li class="dropdown">
                        <a href="#" data-toggle="dropdown" class="dropdown-toggle">Controle de Disciplina<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="./pesquisarDisciplina.jsp">Disciplina</a></li>
                            <li><a href="./pesquisarTurma.jsp">Turma</a></li>
                        </ul>
                    </li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
               
                    <li><a href="./index.jsp">Sair</a></li>
                </ul>
            </div><!-- /.navbar-collapse -->
        </div>
    </nav>
    </form>
</div>
    <footer class="panel-footer rodape">
        Fametro &copy
    </footer>
    
</body>
</html>