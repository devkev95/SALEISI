<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link href="<c:url value="/resources/css/login.css" />" rel="stylesheet">
<link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/myButton.css"/>" />
<title>Login</title>
<style type="text/css">
</style>
</head>
<body>
	<div class="container">
  	<header>
	<div id="head">
    	<img src="<c:url value='/resources/img/eisi.PNG'/>" class="logo" name="Insert_logo"  id="Insert_logo" style="display: block;" />
    </div>
    <div id="head">
    	<h1 class="titHead">Escuela de Ingenieria de Sistemas</h1> 
    </div>
  </header>
  
  <div class="centro">
      <div id="bloque" class="divLogin">
      	<h1 class="titLogin">Entrar</h1>
        <form action="/saleisi" method="post">
        	<label for="nombre">Nombre de usuario:</label>
            <input class="nombre" type="text" name="nomUsuario" id="nombre"/>
            <label for="password">Password:</label>
            <input class="password" type="password" name="password" id="password" />
            <input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" />
            <div class="boton">
            	<input type="submit" class="myButton" value ="Entrar">
           	</div>
        </form>
       
      </div>
      <div id="bloque" class="divImg">  <img class="lab" src="<c:url value='/resources/img/lab.jpg'/>" name="Insert_lab"  id="Insert_logo"   /></div>
  </div>
  <footer>
    <p>Sistema para la Administracion de Laboratorios de la Escuela de Ingenieria de Sistemas Informaticos</p>
    <address>
      CC13026, GJ13004, MM13014, GM13015, LM10002
    </address>
  </footer>
	
</div>
</body>
</html>