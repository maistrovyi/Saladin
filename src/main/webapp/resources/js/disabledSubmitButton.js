function checkEmptyField(text) {
    if (text.length > 0)
        document.getElementById("submitButton").disabled = false;
    else
        document.getElementById("submitButton").disabled = true;
}

function checkEmptyFieldMaterial(text) {
    if (text.length > 0)
        document.getElementById("button_mat_doc").disabled = false;
    else
        document.getElementById("button_mat_doc").disabled = true;
}

function checkEmptyLocationField() {
    return document.getElementById('button_check_stock_m').value;
}


