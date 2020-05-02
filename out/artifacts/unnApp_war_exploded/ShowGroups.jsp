<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Список пользователей</title>
</head>
<body>
<table border="2">
    <tr>
        <td>ID</td>
        <td>Имя</td>
        <td>Действия</td>
    </tr>
    <c:forEach items="${groups}" var = "group">
        <tr>
            <td>${group.getId()}</td>
            <td>${group.getgName()}</td>
            <td>
                <form action = "updateGroup.jsp" method="post">
                    <input type="hidden" name="id" value="${group.getId()}">
                    <input type="hidden" name="gName" value="${group.getgName()}">
                    <input type="submit" value="Изменить" style="float:left">
                </form>
                <form action="deleteGroup.jsp" method="post">
                    <input type="hidden" name="id" value="${group.getId()}">
                    <input type="submit" value="Удалить" style="float:left">
                </form></td>
        </tr>
    </c:forEach>
</table>

<form action = "addGroup.jsp">
    <input type="submit" value="Добавить новую группу">
</form>
<form action="showGroup.jsp">
    <input type ="text" name="gName">
    <input type="submit" value="Обновить">
</form>
</body>
</html>