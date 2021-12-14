function validateUserForm() {
    return validateFields(['username','Имя'], ['password', 'Пароль']);
}

function validatePostForm() {
    return validateFields(['name','Имя'], ['description', 'Описание']);
}

function validateCommentForm() {
    return validateFields(['description', 'Описание']);
}

function validateFields(...args) {
    return args.every(arg => {
        return validateField(arg[0], arg[1]);
    });
}

function validateField(fieldId, fieldName) {
    let value = document.getElementById(fieldId).value;
    if (value.trim() === '') {
        alert("Пожалуйста заполните поле \"" + fieldName + "\"");
        return false;
    }
    return true;
}