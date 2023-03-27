function deleteTournoi(id, row) {
    let formData = new FormData();
    formData.append("id", id);
    formData.append("login", login);
    fetch('ServletDeleteTournoi', {
        method: "POST",
        body: formData
    }).then(response => response.json())
        .then(data => {
            if (data.updated) {
                row.parentNode.removeChild(row);
        }else{
            console.log("Erreur lors de la suppression du tournoi");
        }
    });
}