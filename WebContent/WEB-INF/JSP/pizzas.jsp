<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!doctype html>
<html lang='nl'>
<head>
<title>Pizza's</title>
<link rel='icon' href='images/favicon.ico'>
<link rel=stylesheet href='styles/default.css'>
<meta name='viewport' content='width=device-width, initial-scale=1'>

</head>
<body>



	<c:forEach var='pizza' items='${pizzas}'>
		<li>${pizza.id}:<c:out value='${pizza.naam}' /> ${pizza.prijs}
			&euro; ${pizza.pikant ? "pikant" : "niet pikant"} <c:url
				value='/pizzas/detail.htm' var='detailURL'>
				<c:param name='id' value="${pizza.id}" />
				
			</c:url> <a href="<c:out value='${detailURL}'/>">Detaill</a> 
			
	
			<c:if test='${pizzaIdsMetFoto.contains(pizza.id)}'>
				<c:url value='/pizzafotos/${pizza.id}.jpg' var='fotoURL' />
				<a href='${fotoURL}'>FOTO</a>				
	       </c:if>
		</li>
	</c:forEach>



</body>
</html>