function validate(element) {
    return $(element).validate({
        errorClass: "error",
        errorPlacement: function (error, element) {
            error.appendTo(element.parent().next());
        }
    });
}