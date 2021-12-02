<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous"></script>

    <title>Регистрация</title>

    <style>
        .card {
            margin: 0 auto;
            width: 400px;
            height: 375px
        }

        input {
            width: 300px;
        }
    </style>

    <script src="<c:url value="/static/script/forum.js"/>"></script>
    <link href="<c:url value="/static/css/style.css"/>" rel="stylesheet" type="text/css" media="all">
</head>
<body>
<div class="container pt-3">
    <div class="row">
        <div class="card">
            <div class="card-header">
                <h4>Регистрация</h4>
            </div>
            <div class="card-body">
                <form class="form" name='login' action="<c:url value='/reg'/>" method='POST'>
                    <div class="form-group">
                        <h6>Имя</h6>
                        <input type='text' id='username' name='username' class="form-control"
                               placeholder="Введите ваше имя">
                    </div>
                    <div class="form-group">
                        <h6>Пароль</h6>
                        <input type='password' id='password' name='password' class="form-control"
                               placeholder="Введите ваш пароль"/>
                    </div>
                    <button class="btn btn-primary" type="submit" onclick="return validateUserForm()">Ввод</button>
                    <label class="wrongUser" style="color: red">
                        <c:if test="${not empty errorMessage}">
                            ${errorMessage}
                        </c:if>
                    </label>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>