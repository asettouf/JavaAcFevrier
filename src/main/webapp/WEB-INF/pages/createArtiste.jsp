<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajout Artiste </title>
</head>
<body>
<form:form method="post" action="addArtiste" modelAttribute="artiste">

 <h2>Artiste</h2>
 <table>
 <tr>
 		
        <td>Nom</td>
        <td><form:input path="nom" /></td> 
    </tr>
    <tr>
        <td>Code</td>
        <td><form:input path="codeArtiste" /></td>
    </tr>
 <tr>
        <td colspan="2">
            <input type="submit" value="submit"/>
        </td>
    </tr>
</table>  
     
</form:form>
</body>
</html>