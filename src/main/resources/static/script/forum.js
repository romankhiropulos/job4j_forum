function validateForm(nameAlert, descAlert) {
    let name = document.getElementById('name').value;
    let password = document.getElementById('description').value;
    if (name === '') {
        alert(nameAlert);
        return false;
    }
    if (password === '') {
        alert(descAlert);
        return false;
    }
    return true;
}

function validateUserForm() {
    validateForm(
        "Пожалуйста заполните поле \"Название\"",
        "Пожалуйста заполните поле \"Пароль\""
    );
}

function validatePostForm() {
    validateForm(
        "Пожалуйста заполните поле \"Название\"",
        "Пожалуйста заполните поле \"Описание\""
    );
}

function validateCommentForm() {
    validateForm(
        "fake",
        "Пожалуйста заполните поле \"Текст комментария\""
    );
}
