<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!doctype html>
<html lang='nl'>
<head>
<c:import url='/WEB-INF/JSP/head.jsp'>
<c:param name='title' value='${pizza.naam}'/>
</c:import>
</head>
<body>


<c:import url="/WEB-INF/JSP/menu.jsp">
</c:import>
<c:choose>
<c:when test='${not empty fout }'>
<div class='fout'>${fout}</div>
</c:when>
<c:when test="${empty pizza}"> 
<div class='fout'>Pizza niet gevonden</div>
</c:when>
<c:otherwise>
<h1>${pizza.naam}</h1>
<dl>
<dt>Nummer</dt><dd>${pizza.id}</dd>
<dt>Naam</dt><dd>${pizza.id}</dd>
<dt>Prijsd</dt><dd>${pizza.prijs}</dd>
<dt>Pikant</dt><dd>${pizza.pikant ? 'pikant' : 'niet pikant'}</dd>
</dl>


</c:otherwise>
</c:choose>

</body>
</html>