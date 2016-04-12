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

function checkEmptyCheckStockFields() {
    var a = document.forms["Form"]["location"].value;
    var b = document.forms["Form"]["material"].value;
    if (a.length > 0 && b.length > 0)
        document.getElementById("submitButton").disabled = false;
    else
        document.getElementById("submitButton").disabled = true;
}



