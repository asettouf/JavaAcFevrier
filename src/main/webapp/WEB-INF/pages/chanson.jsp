<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>Chansons</h2>
<c:if test="${not empty cList}">
	<ul>
	<c:forEach var="listValue" items="${cList}">
		<li>Name: <c:out value="${listValue.nom }"/> duree <c:out value="${listValue.duree}"/> code : <c:out value="${listValue.ccodeChanson}"/>
		</li>

</c:forEach>
</ul>
</c:if>

</body>
</html>
</ul>