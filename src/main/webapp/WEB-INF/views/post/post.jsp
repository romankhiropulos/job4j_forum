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

    <title>Форум</title>

    <style>
        .header {
            display: inline;
            float: right;
        }
        .btn-outline-danger {
            margin-left: 15px;
        }
        .card {
            margin-top: 25px;
        }
    </style>

    <link href="<c:url value="/static/css/style.css"/>" rel="stylesheet" type="text/css" media="all">
</head>
<body>
<div class="container">
    <form style="margin-top: 15px; margin-bottom: 30px">
        <h3>Форум
            <a class="header" style="font-size: medium" href="<c:url value='/index'/>">Вернуться на главную </a>
        </h3>
    </form>
    <form>
        <c:if test="${curuser.username == post.user.username}">
            <a class="btn btn-outline-secondary" href="<c:url value='/load?id=${post.id}'/>">Редактировать тему</a>
            <a class="btn btn-outline-danger" href="<c:url value='/delete?id=${post.id}'/>">Удалить тему</a>
        </c:if>
    </form>
    <form>
        <div class="card">
            <div class="card-header">
                <h5 style="float: left"><h5 style="float: left">Тема: <c:out value="${post.name}"/> </h5></h5>
                <h5 style="float: right; ">Дата изменения: <c:out value="${post.created}"/> <br> Автор: <c:out value="${post.user.username}"/></h5>
            </div>
            <div class="card-body">
                <h4>Описание:</h4>
                <c:out value="${post.description}"/>
            </div>
        </div>
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