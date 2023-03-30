function update(id, row) {
    let modifyButton = row.querySelector('.modify');
    let deleteButton = row.querySelector('.delete');
    let oldButtons = [modifyButton,deleteButton]
    showModifyOption(id, row, oldButtons);

}

function showModifyOption(id, row, oldButtons) {
    let login = row.cells[1].textContent;
    let role = row.cells[3].textContent;
    row.cells[1].innerHTML = '<input type="text" name="login" value="' + login + '">';
    row.cells[2].innerHTML = '<input type="text" name="mdp" value="">';
    row.cells[3].innerHTML = '<label><input type="radio" name="role" value="1"> Admin</label><br><label><input type="radio" name="role" value="2"> Utilisateur</label>';
    if (role == "admin") {
        row.cells[3].querySelector('input[value="1"]').checked = true;
    } else if (role == "utilisateur") {
        row.cells[3].querySelector('input[value="2"]').checked = true;
    }
    row.cells[4].innerHTML = '<button type="button" class="btn btn-outline-success save" data-id="' + id + '">Enregistrer</button>';
    let saveButton = row.cells[4].querySelector('.save');
    saveButton.addEventListener('click', () => saveModification(id, row, oldButtons));
}
function saveModification(id, row, oldButtons) {
    // Récupérer les nouvelles valeurs des champs "login", "mdp" et "role"
    let newlogin = row.cells[1].querySelector('input[name=login]').value;
    let mdp = row.cells[2].querySelector('input[name=mdp]').value;
    let role = row.cells[3].querySelector('input[name=role]:checked').value;
    let formData = new FormData();
    formData.append("id", id);
    formData.append("newlogin", newlogin);
    formData.append("mdp", mdp);
    formData.append("role", role);
    formData.append("login", login);

    fetch('ServletUpdateUser', {
        method: "POST",
        body: formData
    })
        .then(response => response.json())
        .then(data => {
            if (data.updated) {
                endModify(newlogin, role, row, oldButtons);
            } else {
                console.log("Erreur lors de la modification de l'utilisateur");
            }
        })
        .catch(error => console.log(error));
}

function endModify(login, role, row, oldButtons) {
    row.cells[1].innerHTML = login;
    row.cells[2].innerHTML = '';
    if (role == 1) {
        row.cells[3].textContent = 'Admin';
    } else if (role == 2) {
        row.cells[3].textContent = 'Utilisateur';
    }
    row.cells[2].innerHTML = '*********';
    row.cells[4].innerHTML = '';
    oldButtons.forEach((button, index) => {
        if (index > 0) {
            row.cells[4].insertAdjacentHTML('beforeend', ' ');
        }
        row.cells[4].appendChild(button);
    });
}
