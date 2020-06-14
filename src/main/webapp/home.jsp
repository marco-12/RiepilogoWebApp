<%@page import="it.dstech.model.Persona"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Homepage</title>
</head>
<body>

<form action="" method="post">

	<input type="text" name="nome" placeholder="Inserisci Nome">
	<input type="text" name="cognome" placeholder="Inserisci Cognome">
	<input type="text" name="eta" placeholder="Inserisci Eta">
	<input type="submit" name="submit" value="Inserisci">
	
	<hr>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Cognome</th>
				<th>Eta</th>
			</tr>
		</thead>
		<c:forEach items="${listaPersone}" var="lista"> 
			<tbody>
				<tr>
					<td><c:out value="${lista.getNome()}" /></td> 
 					<td><c:out value="${lista.getCognome()}" /></td>
 					<td><c:out value="${lista.getEta()}" /></td>
				</tr>
		</c:forEach> 
		</tbody>
	</table>
</form>

</body>
</html>