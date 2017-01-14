<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CRUD</title>
<style>
table, th, td {
	border: 1px solid black;
}
</style>
</head>
<body>
	<h2>Simple CRUD</h2>
	<form action="search">
		<fieldset>
			<legend>Search</legend>
			<input type="text" name="searchTxt" value="${searchTxt}"> <select
				name="sortLastName">
				<option value="non">Sort by last name</option>
				<option value="asc">a-z</option>
				<option value="des">z-a</option>
			</select> <select name="sortDate">
				<option value="non">Sort by date of birth</option>
				<option value="asc">a-z</option>
				<option value="des">z-a</option>
			</select> <input type="submit" value="search" name="searchBtn">
		</fieldset>
	</form>

	<table border-width="1px">
		<thead>
			<tr>
				<th>First name</th>
				<th>Last name</th>
				<th>Date of birth</th>
				<th>Phone number</th>
				<th>email</th>
				<th>edit</th>
				<th>delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="person" items="${people}">
				<tr>
					<td>${person.firstName}</td>
					<td>${person.lastName}</td>
					<td>${person.birthDate}</td>
					<td>${person.phone}</td>
					<td>${person.email}</td>
					<td><a href="edit?id=${person.id}">edit</a></td>
					<td><a href="delete?id=${person.id}">delete</a></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>

	<fieldset>
		<legend>Person's information:</legend>
		<p style="color: red">${errMsg}</p>
		<c:choose>
			<c:when test="${mode == 'ADD'}">
				<form action="add">
					First name:<br> <input type="text" name="firstName" value="${person.firstName}"><br> 
					Last name:<br> <input type="text" name="lastName" value="${person.lastName}"> <br> 
					Date of Birth (YYYY-MM-DD):<br> <input type="text" name="birthDate" value="${person.birthDate}"> <br> 
					E-mail Address:<br> <input type="email" name="email" value="${person.email}"> <br> 
					Phone Number:<br> <input type="text" name="phone" value="${person.phone}"> <br> <br> 
					<input type="submit" value="Add">
				</form>
			</c:when>
			<c:when test="${mode == 'EDIT'}">
                <form action="add">
                    <input type="hidden" name="id" value="${person.id}"/>
                    First name:<br> <input type="text" name="firstName" value="${person.firstName}"><br> 
                    Last name:<br> <input type="text" name="lastName" value="${person.lastName}"> <br> 
                    Date of Birth (YYYY-MM-DD):<br> <input type="text" name="birthDate" value="${person.birthDate}"> <br> 
                    E-mail Address:<br> <input type="email" name="email" value="${person.email}"> <br> 
                    Phone Number:<br> <input type="text" name="phone" value="${person.phone}"> <br> <br> 
                    <input type="submit" value="Update">
                </form>
            </c:when>
		</c:choose>
	</fieldset>
</body>
</html>