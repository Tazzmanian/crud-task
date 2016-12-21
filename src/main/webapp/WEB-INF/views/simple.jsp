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
    		<tr>
    			<td>1</td>
    			<td>2</td>
    			<td>3</td>
    			<td>4</td>
    			<td>5</td>
    			<td>6</td>
    			<td>7</td>
    		</tr>
    		${tableContent}
    	</tbody>
    </table>
    
    <form action="/index.html">
        <fieldset>
            <legend>Personal information:</legend>
            First name:<br>
            <input type="text" name="firstname" value=""><br>
            Last name:<br>
            <input type="text" name="lastname" value=""><br>
            Date of Birth (YYYY-MM-DD):<br>
            <input type="date" name="birthdate" value=""><br>
            E-mail Address:<br>
            <input type="email" name="email" value=""><br>
            Phone Number:<br>
            <input type="text" name="number" value=""><br>
            <input type="submit" value="Add">
        </fieldset>
    </form> 
</body>
</html>