const modifyButtons = document.querySelectorAll('.modify');
const deleteButtons = document.querySelectorAll('.delete');

modifyButtons.forEach(function(button) {
    let id = button.getAttribute('data-id');
    let row = button.parentNode.parentNode;
    button.addEventListener('click', () => modifyMatch(id, row));
});

deleteButtons.forEach(function(button) {
    let id = button.getAttribute('data-id');
    let row = button.parentNode.parentNode;
    button.addEventListener('click', () => deleteMatch(id, row));
});
