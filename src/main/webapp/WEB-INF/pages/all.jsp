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

<h2>Artistes</h2>
<c:if test="${not empty aList}">
	<ul>
	<c:forEach var="listValue" items="${aList}">
		<li>Name: <c:out value="${listValue.nom }"/> , code : <c:out value="${listValue.codeArtiste}"/></li>
		<c:if test="${not empty listValue.albums}">
			<ul>
			<c:forEach var="alistValue" items="${listValue.albums}">
				<li>Name: <c:out value="${alistValue.nom }"/>  code : <c:out value="${alistValue.codeAlbum}"/></li>
				<c:if test="${not empty alistValue.chansons}">
					<ul>
					<c:forEach var="clistValue" items="${alistValue.chansons}">
						<li>Name: <c:out value="${clistValue.nom }"/> duree <c:out value="${clistValue.duree}"/> code : <c:out value="${clistValue.codeChanson}"/></li>
					</c:forEach>
					</ul>
				</c:if>
			
			</c:forEach>
			</ul>	
		</c:if>

</c:forEach>
</ul>
</c:if>

</body>
</html>