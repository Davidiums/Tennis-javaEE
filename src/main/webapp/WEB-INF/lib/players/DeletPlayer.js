var deleteButtons = document.querySelectorAll('.delete');
deleteButtons.forEach(function(button) {
    button.addEventListener('click', function() {
        let id = button.getAttribute('data-id');
        let formData = new FormData();
        formData.append("id", id);
        formData.append("login", login);
        console.log(formData);
        fetch('ServletDeletePlayer', {
            method: "POST",
            body: formData
        })
            .then(response => response.json())
            .then(data => {
                if (data.updated) {
                    let row = button.parentNode.parentNode;
                    row.parentNode.removeChild(row);
                } else {
                    console.error('Erreur de suppression');
                }
            })
            .catch(error => {
                console.error('Erreur de connexion', error);
            });
    });
});
