<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <%--    <script src="/static/accident/script/accident.js"></script>--%>
    <script>
        function validate() {
            let valid = true;
            let name = document.getElementById('name').value;
            let address = document.getElementById('address').value;
            let options = document.querySelectorAll('#rules option:checked');
            let rules = Array.from(options).map(option => option.value);
            if (name === '') {
                valid = false;
                alert("Пожалуйста заполните поле \"Название\"");
            }
            if (address === '') {
                valid = false;
                alert("Пожалуйста заполните поле \"Адрес\"");
            }
            if (rules.length === 0) {
                valid = false;
                alert("Пожалуйста заполните поле \"Статьи\"");
            }
            return valid;
        }
    </script>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous"></script>

    <title>Accident edit</title>

</head>
<body>
<jsp:useBean id="post" type="ru.job4j.forum.model.Post" scope="request"/>
<form action="<c:url value='/update?id=${post.id}'/>" method='POST'>
    <table>
        <tr>
            <td>ДТП:</td>
            <td><input type='text' name='name' value="${post.name}" id="name"></td>
            <td><input type='text' name='description' value="${post.description}" id="address"></td>
            <td><input type='text' name='created' value="${post.created}" id="text"></td>
        </tr>
        <tr>
            <td>Тип:</td>
            <td>
                <select name="type.id">
                    <c:forEach var="type" items="${types}">
                        <option value="${type.id}">${type.name}</option>
                    </c:forEach>
                </select>
        </tr>
        <tr>
            <td>Статьи:</td>
            <td>
                <select name="rIds" id="rules" multiple>
                    <c:forEach var="rule" items="${rules}">
                        <option value="${rule.id}">${rule.name}</option>
                    </c:forEach>
                </select>
        </tr>
        <tr>
            <td colspan='2'><input name="submit" type="submit" value="Сохранить" onclick="return validate()"/></td>
        </tr>
    </table>
</form>
</body>
</html>