// Récupérer tous les boutons de modification
var modifyButtons = document.querySelectorAll('.modify');

// Pour chaque bouton de modification
modifyButtons.forEach(function(button) {
    button.addEventListener('click', function() {
        // Récupérer l'ID du joueur
        let id = button.getAttribute('data-id');

        // Récupérer la ligne du tableau correspondante
        let row = button.parentNode.parentNode;
        let modifyButton = row.querySelector('.modify');
        let deleteButton = row.querySelector('.delete');

        // Récupérer les données du joueur
        let nom = row.cells[1].textContent;
        let prenom = row.cells[2].textContent;
        let sexe = row.cells[3].textContent;

        // Ajouter les champs de modification à la ligne du tableau
        row.cells[1].innerHTML = '<input type="text" name="nom" value="' + nom + '">';
        row.cells[2].innerHTML = '<input type="text" name="prenom" value="' + prenom + '">';
        row.cells[3].innerHTML = '<label><input type="radio" name="sexe" value="H"> Homme</label><br><label><input type="radio" name="sexe" value="F"> Femme</label>';
        if (sexe == 'M') {
            row.cells[3].querySelector('input[value=M]').checked = true;
        } else if (sexe == 'F') {
            row.cells[3].querySelector('input[value=F]').checked = true;
        }

        // Ajouter le bouton "Enregistrer"
        row.cells[4].innerHTML = '<button type="button" class="btn btn-outline-success save" data-id="' + id + '">Enregistrer</button>';

        // Récupérer le bouton "Enregistrer"
        let saveButton = row.cells[4].querySelector('.save');

        // Ajouter un écouteur d'événements pour le bouton "Enregistrer"
        saveButton.addEventListener('click', function() {
            let newSexe = "noModify";
            // Récupérer les nouvelles valeurs
            let newNom = row.cells[1].querySelector('input[name=nom]').value;
            let newPrenom = row.cells[2].querySelector('input[name=prenom]').value;
            let radioChecked = row.cells[3].querySelector('input[name=sexe]:checked');
            if (radioChecked != null) {
                newSexe = radioChecked.value;
            }
            // Construire l'objet FormData pour la requête AJAX
            let formData = new FormData();
            formData.append("id", id);
            formData.append("nom", newNom);
            formData.append("prenom", newPrenom);
            formData.append("sexe", newSexe);
            formData.append("login", login);

            console.log(formData);
            // Envoyer la requête AJAX
            fetch('ServletUpdatePlayer', {
                method: "POST",
                body: formData
            })
                .then(response => response.json())
                .then(data => {
                    console.log(data);
                    if (data.updated) {
                        // Mettre à jour les valeurs dans la ligne du tableau
                        row.cells[1].textContent = newNom;
                        row.cells[2].textContent = newPrenom;
                        row.cells[3].textContent = newSexe;
                        // Remettre le bouton "Modifier"
                        row.cells[4].innerHTML = '';
                        row.cells[4].appendChild(modifyButton);
                        row.cells[4].appendChild(deleteButton);
                    } else {
                        console.error('Erreur de mise à jour');
                    }
                })
        })
    })
})