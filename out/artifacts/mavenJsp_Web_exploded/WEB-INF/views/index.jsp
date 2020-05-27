<%@include file="../commons/header.jspf" %>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="collapse navbar-collapse " id="navbarNav">
        <ul class="navbar-nav mr-auto ">
            <li class="nav-item active ">
                <a class="nav-link" href="#">Home</a>
            </li>
            <li class="nav-item ">
                <a style="margin-left: 10px; border: none" class="btn btn-dark" href="juego.do?action=Listar" target="mainFrame">Juegos</a>
            </li>
            <li class="nav-item">
                <a style="margin-left: 10px; border: none" class="btn btn-dark" href="empresa.do?action=Listar" target="mainFrame">Empresas</a>
            </li>
            <li class="nav-item">
                <a style="margin-left: 10px; border: none" class="btn btn-dark" href="genero.do?action=Listar" target="mainFrame">Generos</a>
            </li>
           
        </ul>

        <div class="dropdown">
                <button class="btn btn-dark dropdown-toggle my-2 my-sm-0" type="button" id="dropdownMenuButton"
                        data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    ${user}
                </button>
                <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                    <a class="dropdown-item" href="login.do">Login</a>
                </div>
        </div>
    </div>
</nav>
<div class="content bg-dark">
    <div class="container-fluid" style="height: 560px">

        <iframe class="embed-responsive-item" name="mainFrame" style="height: 100%; width: 100%"
                frameborder="0"></iframe>
    </div>
</div>

<%@include file="../commons/footer.jspf" %>

