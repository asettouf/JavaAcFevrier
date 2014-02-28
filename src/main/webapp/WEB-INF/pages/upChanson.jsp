<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Up Chanson test</title>
</head>
<body>
<form:form method="post" action="upChanson" modelAttribute="chanson">
 
    <table>
    <tr>
        <td>ID</td>
        <td><form:input path="id" /></td> 
    </tr>
    <tr>
        <td>Nom</td>
        <td><form:input path="nom" /></td> 
    </tr>
    <tr>
        <td>Duree</td>
        <td><form:input path="duree" /></td>
    </tr>
    <tr>
        <td>Code</td>
        <td><form:input path="codeChanson" /></td>
    </tr>
       <tr>
        <tr>
        <td colspan="2">
            <input type="submit" value="submit"/>
        </td>
    </tr>
</table>  
     
</form:form>
</body>
</html>