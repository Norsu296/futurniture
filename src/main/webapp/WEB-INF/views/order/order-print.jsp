<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<jsp:include page="../header.jsp"/>
<body>

<div class="container-fluid">
    <div class="row">
        <jsp:include page="../nav.jsp"/>
        <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                <h1 class="h2">Podsumowanie zamówienia</h1>
                <div class="btn-group me-2">
                    <a href="/app/order" class="btn btn-sm btn-outline-secondary">Powrót</a>
                </div>
            </div>
            <div class="orderConfirmation">
                <div class="container-fluid d-flex flex-wrap justify-content-between" id="orderHeader">
                    <div class="h4">Potwierdzenie zamówienia</div><div class="h5">Zamówienie numer ${order.id}/2021</div>
                </div>
                <hr>
                <div class="customer container-fluid">
                    <div class="information">Dane klienta</div><span class="content">${order.customer.fullName}</span>
                    <p><div class="information">Adres dostawy</div><span class="content">${order.customer.address}<p>${order.customer.phone} ${order.customer.email}</p></span></p>
                    <p><div class="information">Dodatkowe informacje</div><span class="content">${order.description}</span></p>
                </div>

                <h3>Zamówione produkty</h3>
                <div class="table-responsive">
                    <table class="table table-striped table-sm">

                        <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Nazwa</th>
                            <th scope="col">Opis</th>
                            <th scope="col">Kategoria</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${order.products}" var="product" varStatus="status">
                            <tr>
                                <td>${status.count}</td>
                                <td>${product.name}</td>
                                <td>${product.description}</td>
                                <td>${product.category.name}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="customer container-fluid d-flex flex-wrap justify-content-between">
                    <div class="information">Wartość zamówienia</div><span class="content">${order.price} zł</span>
                    <div class="information">Status płatności</div>
                    <span class="content">
                    <c:choose>
                        <c:when test="${order.paid == true}">
                            Opłacone
                        </c:when>
                        <c:otherwise>
                            Płatne przy odbiorze
                        </c:otherwise>
                    </c:choose>
                </span>
                </div>
                <div class="container-fluid d-flex flex-wrap justify-content-between">
                    <div id="stamp"></div><div id="customerSign"></div>
                </div>
                <div class="container-fluid d-flex flex-wrap justify-content-between">
                    <p>Pieczątka i podpis</p><p>Podpis klienta</p>
                </div>

            </div>
            <button href="/app/order/finish/${order.id}" onclick="window.print();" class="noPrint btn btn-primary">Drukuj</button>
        </main>
    </div>
</div>

</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>


<script src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js" integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE" crossorigin="anonymous"></script><script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js" integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha" crossorigin="anonymous"></script><script src="dashboard.js"></script>
</body>
</html>