$(document).ready(function () {
    anableOrDisableDeleteAll();
    autoCheckCheckBoxChil();
    autoCheckCheckBoxParent();
});

//change la su kien thay doi lien tuc
//click la su kien chi thay doi mot lan

function anableOrDisableDeleteAll() {
    $('input[type=checkbox]').click(function () {
        if($('input[type=checkbox]').length > 0) {
            $('#btnDelete').prop('disabled', false);
        } else {
            $('#btnDelete').prop('disabled', true);
        }
    })
}

function autoCheckCheckBoxChil() {
    $('#checkAll').change(function () {
        if((this).checked) {
            $(this).closest('table').find('tbody input[type=checkbox]').prop('checked', true);
        } else {
            $(this).closest('table').find('tbody input[type=checkbox]').prop('checked', false);
            $('#btnDelete').prop('disabled', true);
        }
    });
}

function autoCheckCheckBoxParent() {
    var totalCheckBoxChild = $('#checkAll').closest('table').find('tbody input[type=checkbox]').length;
    $('#checkAll').closest('table').find('tbody input[type=checkbox]').on('change', function () {
        var totalCheckBoxChecked = $('#checkAll').closest('table').find('tbody input[type=checkbox]:checked').length;
        if(totalCheckBoxChecked == totalCheckBoxChild) {
            $('#checkAll').prop('checked', true);
        } else {
            $('#checkAll').prop('checked', false);
        }
    })
}

