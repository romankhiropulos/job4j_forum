<%@ page import="ru.job4j.forum.model.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <title>Форум job4j</title>

    <style>
        .header {
            display: inline;
            float: right;
        }
    </style>

    <link href="<c:url value="/static/css/style.css"/>" rel="stylesheet" type="text/css" media="all">

</head>
<body>
<div class="container">
    <div style="margin-top: 15px; margin-bottom: 50px">
        <h3 >Форум
            <c:if test="${not empty curuser.username}">
                <a class="header" style="font-size: medium">Текущий пользователь: ${curuser.username}</a>
            </c:if>
            <c:if test="${empty curuser.username}">
                <a class="header" href="<c:url value="/login"/>" style="font-size: medium">Войти</a>
            </c:if>
        </h3>
        <c:if test="${not empty curuser.username}">
            <a class="header" href="<c:url value="/logout"/>" style="font-size: medium">Сменить пользователя</a>
        </c:if>
        <c:if test="${empty curuser.username}">
            <a class="header" href="<c:url value="/reg"/>" style="font-size: medium">Зарегистрироваться</a>
        </c:if>
    </div>
    <c:if test="${not empty curuser.username}">
        <form action="<c:url value='/create'/>">
            <button class="btn btn-outline-secondary">Создать тему</button>
        </form>
    </c:if>
    <form style="margin-top: 15px">
        <table class="table table-bordered">
            <thead  class="titleColor">
            <tr>
                <th scope="col">Тема</th>
                <th scope="col" style="width: 100px;">Автор</th>
                <th scope="col" style="width: 250px">Дата изменения</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${posts}" var="post">
                <tr>
                    <td>
                        <a href="<c:url value='/post?id=${post.id}'/>"><c:out value="${post.name}"/></a>
                    </td>
                    <td><c:out value="${post.user.username}"/></td>
                    <td><c:out value="${post.created}"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </form>
</div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>
</body>
</html>