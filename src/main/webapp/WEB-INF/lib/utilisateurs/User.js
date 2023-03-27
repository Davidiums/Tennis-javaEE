

const modifyButtons = document.querySelectorAll('.modify');
const deleteButtons = document.querySelectorAll('.delete');
const createButton = document.querySelector('#create');
const researchArea = document.querySelector('#researchArea');

modifyButtons.forEach(function(button) {
    let id = button.getAttribute('data-id');
    let row = button.parentNode.parentNode;
    button.addEventListener('click', () => update(id, row));
});

deleteButtons.forEach(function(button) {
    button.addEventListener('click', () => {
        let id = button.getAttribute('data-id');
        let row = button.parentNode.parentNode;
        remove(id, row);
    });
});


createButton.addEventListener('click', () => create());

researchArea.addEventListener('keyup', () => read());