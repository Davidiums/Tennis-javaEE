function modifyMatch(id, row){
    let modifyButton = row.querySelector('.modify');
    let deleteButton = row.querySelector('.delete');
    let detailsButton = row.querySelector('.details');
    let oldButtons = [detailsButton,modifyButton,deleteButton]
    showModifyOption(id, row, oldButtons);
}

function showModifyOption(id, row, oldButtons){
    let nom = row.cells[1].textContent;
    let code = row.cells[2].textContent;
    row.cells[1].innerHTML = '<input type="text" name="nom" value="' + nom + '">';
    row.cells[2].innerHTML = '<input type="text" name="code" value="' + acode + '">';
    row.cells[3].innerHTML = '<button type="button" class="btn btn-outline-success save" data-id="' + id + '">Enregistrer</button>';
    let saveButton = row.cells[3].querySelector('.save');
    saveButton.addEventListener('click', () => saveModification(id, row, oldButtons));
}

function saveModification(id, row, oldButtons) {
    // Récupérer les nouvelles valeurs des champs "nom" et "code"
    let nom = row.cells[1].querySelector('input[name=nom]').value;
    let code = row.cells[2].querySelector('input[name=code]').value;
    let formData = new FormData();
    formData.append("id", id);
    formData.append("nom", nom);
    formData.append("code", code);
    formData.append("login", login);

    fetch('ServletModifyMatch', {
        method: "POST",
        body: formData
    })
        .then(response => response.json())
        .then(data => {
            if (data.updated){
                endModify(nom, code, row, oldButtons);
            }else{
                console.log("Erreur lors de la modification du Match");
            }
        })
        .catch(error => console.log(error));
}

function endModify(nom, code, row, oldButtons){
    row.cells[1].innerHTML = nom;
    row.cells[2].innerHTML = code;
    row.cells[3].innerHTML = '';
    oldButtons.forEach((button, index) => {
        if (index > 0) {
            row.cells[3].insertAdjacentHTML('beforeend', ' ');
        }
        row.cells[3].appendChild(button);
    });
}