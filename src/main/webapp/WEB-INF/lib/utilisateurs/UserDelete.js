function remove(id, row) {
    let formData = new FormData();
    formData.append("id", id);
    formData.append("login", login);
    fetch('ServletDeleteUser', {
        method: "POST",
        body: formData
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Erreur côté serveur: ' + response.status);
            }
            return response.json();
        })
        .then(data => {
            if (data.updated) {
                row.parentNode.removeChild(row);
            } else {
                console.log("Erreur lors de la suppression de l'utilisateur");
            }
        })
        .catch(error => {
            console.error('Erreur lors de la récupération des données JSON:', error);
        });
    }
