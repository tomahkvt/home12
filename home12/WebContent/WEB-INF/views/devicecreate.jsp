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
<h1>Добавление устройства</h1>
<a href="../../../device/devices">Вернуться</a>
<sf:form method="POST" commandName="device" action="../devices/create">
<table border = "1">
<tr>
<td><sf:label path="deviceType.id">Device Name</sf:label></td> 
<td><sf:select path="deviceType.id">
    	<sf:options items="${mapDeviceType}" />
    </sf:select></td>
</tr>
<tr>
<td>

<sf:label path="deviceName">Device Name</sf:label></td>
 
<td>
<sf:hidden  path="id"  />
<sf:input path="deviceName"  /><br/></td>
</tr>
<tr>
<td><sf:label path="deviceIp">Device IP</sf:label></td> 
<td><sf:input path="deviceIp"  /><br/></td>
</tr>
<tr>
<td><sf:label path="deviceUsername">Device Username</sf:label></td> 
<td><sf:input path="deviceUsername"  /><br/></td>
</tr>
<tr>
<td><sf:label path="devicePassw">Device Password</sf:label></td> 
<td><sf:input path="devicePassw"  /><br/></td>
</tr>
<tr>
<td><sf:label path="switchEnable">Device Enable</sf:label></td> 
<td>
<sf:select path="switchEnable">
    	<sf:options items="${mapDeviceEnable}" />
    </sf:select>
</td>
</tr>



</table>
<input type="submit" value="Сохранить" />
</sf:form>
</body>
</html>