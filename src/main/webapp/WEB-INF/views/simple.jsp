<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> CRUD </title>
<style>
table, th, td {
    border: 1px solid black;
}
</style>
</head>
<body>
    <h2>Simple CRUD</h2>
    <form action="/index.html">
        <input type="text" name="search">
        <input type="submit" value="search"><br>
        <table border-width="1px">
    	    <thead>
    	    	<tr>
    	    		<th>First name</th>
    	    		<th>Last name</th>
    	    		<th>Date of birth</th>
    	    		<th>email</th>
    	    		<th>Phone number</th>
    	    		<th>edit</th>
    	    		<th>delete</th>
    	    	</tr>
    	    </thead>
        	<tbody>
        	   <c:forEach var="person" items="${tableContent}">
        	       ${person}
               </c:forEach>
        		
        	</tbody>
        </table>
    
        <fieldset>
            <legend>People's information:</legend>
            <p style="color:red">${errMsg}</p>
            First name:<br>
            <input type="text" name="firstname" value=${firstname}><br>
            Last name:<br>
            <input type="text" name="lastname" value=${lastname}><br>
            Date of Birth (YYYY-MM-DD):<br>
            <input type="date" name="birthdate" value=${birthdate}><br>
            E-mail Address:<br>
            <input type="email" name="email" value=${email}><br>
            Phone Number:<br>
            <input type="text" name="number" value=${number}><br><br>
            <input type="submit" value=${addEditValue} name=${addEditName}>
        </fieldset>
    </form> 
</body>
</html>