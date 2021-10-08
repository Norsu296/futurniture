<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">


<jsp:include page="../header.jsp"/>
<body>

<div class="container-fluid">
    <div class="row">
        <jsp:include page="../nav.jsp"/>
        <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                <h1 class="h2">Szczegóły zamówienia</h1>
                <div class="btn-group me-2">
                    <a href="/app/order" class="btn btn-sm btn-outline-secondary">Powrót</a>
                </div>
            </div>
            <div class="orderDetails">
                <p><span class="title bg-secondary text-light mx-5 px-5">Klient </span><span class="content bg-light text-dark">${order.customer.fullName}</span></p>
                <p><span class="title bg-secondary text-light mx-5 px-5">Kontakt </span><span class="content bg-light text-dark">Telefon: ${order.customer.phone} Email: ${order.customer.email}</span></p>
                <p><span class="title bg-secondary text-light mx-5 px-5">Adres dostawy </span>
                    <span class="content">
                        ${order.customer.address} ${order.customer.number}
                    </span>
                </p>
                <p><span class="title bg-secondary text-light mx-5 px-5">Termin realizacji: </span><span class="content bg-light text-dark">${order.shipDate}</span></p>
                <p><span class="title bg-secondary text-light mx-5 px-5">Dodatkowe informacje: </span><span class="content bg-light text-dark">${order.description}</span></p>

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
        </main>
    </div>

</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>


<script src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js" integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE" crossorigin="anonymous"></script><script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js" integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha" crossorigin="anonymous"></script><script src="dashboard.js"></script>
</body>
</html>
