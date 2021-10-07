<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">


<jsp:include page="header.jsp"/>
<body>

<div class="container-fluid">
    <div class="row">
        <jsp:include page="nav.jsp"/>
        <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                <h1 class="h2">Podsumowanie</h1>
                <div class="btn-toolbar mb-2 mb-md-0">
                    <div class="btn-group me-2">
                        <a href="/app/order/add" class="btn btn-sm btn-outline-secondary">Nowe zamówienie</a>
                        <a href="/app/product/add" class="btn btn-sm btn-outline-secondary">Nowy produkt</a>
                        <a href="app/customer/add" class="btn btn-sm btn-outline-secondary">Nowy klient</a>
                    </div>

                </div>
            </div>
            <div class="details">
                <div class="row">
                    <div class="col-sm-4">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title text-success">${numberOfActiveOrders}</h5>
                                <p class="card-text">Zamówienia w realizacji</p>
                                <a href="/app/order/active" class="btn btn-success">Podgląd</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title text-danger">${numberOfDelayedOrders}</h5>
                                <p class="card-text">Zamówienia po terminie</p>
                                <a href="/app/order/delay" class="btn btn-danger">Podgląd</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">${numberOfAllOrders}</h5>
                                <p class="card-text">Wszystkie zamówienia</p>
                                <a href="/app/order" class="btn btn-primary">Podgląd</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="table-responsive">
                <table class="table table-striped table-sm">

                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Imię</th>
                        <th scope="col">Nazwisko</th>
                        <th scope="col">Płatność</th>
                        <th scope="col">Dodano</th>
                        <th scope="col">Planowana data dostawy</th>
                        <th scope="col">Wartość zamówienia</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${lastOrders}" var="order" varStatus="status">
                        <tr>
                            <td>${status.count}</td>
                            <td>${order.customer.name}</td>
                            <td>${order.customer.surname}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${order.paid == true}">
                                        Opłacone
                                    </c:when>
                                    <c:otherwise>
                                        Płatne przy odbiorze
                                    </c:otherwise>
                                </c:choose>

                            </td>
                            <td>${order.startDate}</td>
                            <td>${order.shipDate}</td>
                            <td>${order.price}</td>

                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </main>
    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>


<script src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js" integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE" crossorigin="anonymous"></script><script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js" integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha" crossorigin="anonymous"></script><script src="dashboard.js"></script>
</body>
</html>
