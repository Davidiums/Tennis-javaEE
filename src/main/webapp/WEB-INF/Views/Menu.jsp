<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
  <a class="navbar-brand" href="#">Menu</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarsExampleDefault">
    <ul class="navbar-nav mr-auto">

      <li>
        <a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Onglet</a>
        <div class="dropdown-menu" aria-labelledby="dropdown01">
          <c:if test="${not empty sessionScope.user and sessionScope.user.getProfil() == 1}">
            <a class="dropdown-item" href="Utilisateurs">Liste des utilisateurs</a>
          </c:if>
          <a class="dropdown-item" href="ListJoueur">Liste des joueurs</a>
          <a class="dropdown-item" href="Tournois">Liste des tournois</a>
            <a class="dropdown-item" href="Matchs">Liste des matchs</a>
          <a class="dropdown-item" href="Epreuves">Liste des epreuves</a>


        </div>
      </li>



      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="dropdown02" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Ajouter</a>
        <div class="dropdown-menu" aria-labelledby="dropdown02">
          <a class="dropdown-item" href="AjouterJoueur">Ajouter joueur</a>
          <a class="dropdown-item" href="AjoutTournoi">Ajouter tournoi</a>
          <a class="dropdown-item" href="AjoutMatch">Ajouter match</a>
        </div>
      </li>


      <li class="nav-item">
        <a class="nav-link" href="Logout">Deconnexion</a>
      </li>
    </ul>
<%--    <form class="form-inline my-2 my-lg-0">--%>
<%--      <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">--%>
<%--      <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>--%>
<%--    </form>--%>
  </div>
</nav>
