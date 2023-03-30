document.querySelectorAll('input[type=radio][name=sexe]').forEach(function(radio) {
    radio.addEventListener('change', function() {
        document.getElementById('myForm').submit();
    });
});