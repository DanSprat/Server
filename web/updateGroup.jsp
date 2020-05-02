<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Изменить данные пользователя</title>
</head>
<body>

Редактировать группу

<form action="/unnApp_war_exploded/groups/${param.id}" method="post">
    <input type="hidden" name = "id" value="${param.id}">
    <input type="text" name="gName" value="${param.name}" placeholder=${param.name}>
    <input type="hidden" name="_method" value="put">
    <input type="submit" value="Обновить">
</form>

</body>
</html>