<%@page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Таблица устройств</h1><br>
<a href="<c:url value="devices/create"/>">Добавить устройство</a>
<table border = "1">

<c:forEach items="${devices}" var="item">
	<tr><td>	${item.deviceType.deviceType}    </td>
	<td>	${item.deviceIp}    </td>
	<td>	${item.deviceName}    </td>
	<c:choose>
	<c:when test="${item.switchEnable == true }">
	<td>	Enable    </td>
	</c:when>
	<c:when test="${item.switchEnable == false }">
	<td>	Disable    </td>
	</c:when>
	</c:choose>
	
	<td>	<a href="<c:url value="devices/delete/${item.id}"/>">Удалить</a> </td>
	<td>	<a href="<c:url value="devices/edit/${item.id}"/>">Редактировать</a> </td></tr>
	
</c:forEach>
</table>
</body>
</html>