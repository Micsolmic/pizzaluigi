<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!doctype html>
<html lang='nl'>
<head>
<title>saus's</title>
<link rel='icon' href='images/favicon.ico'>
<link rel=stylesheet href='styles/default.css'>
<meta name='viewport' content='width=device-width, initial-scale=1'>

</head>
<body>

<h1>SAUZEN:</h1>

<ul>

<c:forEach var='saus' items='${sauzen}'>
<li>${saus.nummer}:
<c:out value='${saus.naam}'/> 

<c:forEach var='ingred' items='${saus.ingredienten}' varStatus='status' >

${ingred}

<c:if test='${status.last != true }'>

,

</c:if>


</c:forEach>

<c:url value='/sauzen/detail.htm' var='detailURL'>
<c:param name='id' value="${saus.nummer}"/>
</c:url>

<a href="<c:out value='${detailURL}'/>">Detail</a>
</li>
</c:forEach>

</ul>





</body>
</html>