<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> CRUB </title>
</head>
<body>
    <h2>Simple CRUD</h2>
    
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