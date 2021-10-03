<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
    <div class="position-sticky pt-3">
        <ul class="nav flex-column">
            <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="/app">
                    <i class="fas fa-home"></i>
                    Start
                </a>
            </li>
            <hr>
            <li class="nav-item" data-bs-toggle="collapse" href="#collapseOrders" role="button">
                <a class="nav-link" href="#">
                    <i class="fas fa-dolly-flatbed"></i>
                    Zamówienia
                </a>
            </li>
            <div class="collapse" id="collapseOrders">
                <div class="card card-body">
                    <li class="nav-item">
                        <a class="nav-link" href="#">
                            <i class="fas fa-angle-right"></i>
                            Pilne
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">
                            <i class="fas fa-angle-right"></i>
                            W realizacji
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">
                            <i class="fas fa-angle-right"></i>
                            Wszystkie
                        </a>
                    </li>
                </div>
            </div>
            <hr>
            <li class="nav-item" data-bs-toggle="collapse" href="#collapseProducts" role="button">
                <a class="nav-link" href="#">
                    <i class="fas fa-shopping-cart"></i>
                    Produkty
                </a>
            </li>
            <div class="collapse" id="collapseProducts">
                <div class="card card-body">
                    <li class="nav-item">
                        <a class="nav-link" href="#">
                            <i class="fas fa-angle-right"></i>
                            Wszystkie
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/app/category">
                            <i class="fas fa-angle-right"></i>
                            Kategorie
                        </a>
                    </li>
                </div>
            </div>
            <hr>
            <li class="nav-item">
                <a class="nav-link" href="#">
                    <i class="fas fa-users"></i>
                    Klienci
                </a>
            </li>
            <hr>
            <li class="nav-item">
                <a class="nav-link" href="#">
                    <i class="fas fa-users-cog"></i>
                    Użytkownicy
                </a>
            </li>
            <hr>
            <li class="nav-item">
                <a class="nav-link" href="#">
                    <i class="fas fa-user-cog"></i>
                    Konto
                </a>
            </li>
            <hr>
        </ul>
</nav>