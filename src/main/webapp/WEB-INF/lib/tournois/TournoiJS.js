const modifyButtons = document.querySelectorAll('.modify');
const deleteButtons = document.querySelectorAll('.delete');

modifyButtons.forEach(function(button) {
    let id = button.getAttribute('data-id');
    let row = button.parentNode.parentNode;
    button.addEventListener('click', () => modifyStart(id, row));
});

deleteButtons.forEach(function(button) {
    let id = button.getAttribute('data-id');
    let row = button.parentNode.parentNode;
    button.addEventListener('click', () => deleteTournoi(id, row));
});
