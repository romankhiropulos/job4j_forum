function validateUserForm() {
    let name = document.getElementById('username').value;
    let password = document.getElementById('password').value;
    if (name === '') {
        alert("Пожалуйста заполните поле \"Название\"");
        return false;
    }
    if (password === '') {
        alert("Пожалуйста заполните поле \"Пароль\"");
        return false;
    }
    return true;
}

function validatePostForm() {
    let name = document.getElementById('name').value;
    let password = document.getElementById('description').value;
    if (name === '') {
        alert("Пожалуйста заполните поле \"Название\"");
        return false;
    }
    if (password === '') {
        alert("Пожалуйста заполните поле \"Описание\"");
        return false;
    }
    return true;
}
