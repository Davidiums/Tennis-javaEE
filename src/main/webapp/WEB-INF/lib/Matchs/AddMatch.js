// // Ajoutez une classe CSS unique aux options de type de tournoi
// <c:forEach var="type" items="${types}">
//     <option value="${type}" class="type-option">${type}</option>
// </c:forEach>
//
// // Ajoutez une classe CSS unique aux options de joueur
// <c:forEach var="joueur" items="${joueurs}">
//     <option value="${joueur.getId()}" class="joueur-option">${joueur.getFullname()}</option>
// </c:forEach>
//
// // Ajoutez un gestionnaire d'événements change à la liste déroulante de type de tournoi
// $('#type').on('change', function() {
//     var selectedType = $(this).val();
//     if (selectedType) {
//         // Parcourez toutes les options de joueur et cachez celles qui ne correspondent pas au type sélectionné
//         $('.joueur-option').each(function() {
//             var joueurType = $(this).data('type');
//             if (joueurType != selectedType) {
//                 $(this).addClass('hidden');
//             } else {
//                 $(this).removeClass('hidden');
//             }
//         });
//     } else {
//         // Si aucun type n'est sélectionné, affichez toutes les options de joueur
//         $('.joueur-option').removeClass('hidden');
//     }
// });
//
// // Ajoutez la propriété data-type aux options de joueur pour stocker leur type correspondant
// <c:forEach var="joueur" items="${joueurs}">
//     <option value="${joueur.getId()}" class="joueur-option" data-type="${joueur.getType()}">${joueur.getFullname()}</option>
// </c:forEach>
