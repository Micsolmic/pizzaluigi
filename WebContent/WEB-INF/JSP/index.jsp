<%--Een werlkom pagina --%>

 
<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@page import='java.io.PrintWriter'%>
<%@page import='java.time.LocalDateTime'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:import url="/WEB-INF/JSP/menu.jsp">
</c:import>

<hr>

 <script type="text/javascript">
 
               alert("deze script werd toegevoegd in github");
               
 </script>
 
 
<h1>
<%

int uur = LocalDateTime.now().getHour();
out.print(uur>=6 && uur< 12 ? "Goeiemorgen" : uur>=12 && uur<6 ? "goekmiddatrg" : "goeiavkjend");
%>

</h1>

<h1 style="color:red">

${aantalKeerBekeken}

</h1>

<a href='mailto:${emailWebMaster}'>${emailWebMaster}</a>

</body>
</html>
