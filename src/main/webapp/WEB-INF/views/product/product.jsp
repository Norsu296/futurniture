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
                <h1 class="h2">Produkty</h1>
                <div class="btn-group me-2">
                    <a href="/app/product/add" class="btn btn-sm btn-outline-secondary">Nowy produkt</a>
                </div>
            </div>
            <div class="text-danger">
                ${errorMessage}
            </div>
            <div class="col-md-9 d-flex align-item-center">
                <form method="get" action="/app/product/search">
                    <div class="input-group rounded">
                        <input type="search" class="form-control rounded" name="keyword" placeholder="Szukaj"/>
                        <button type="submit" class="input-group-text border-0" id="search-addon">
                        <i class="fas fa-search"></i>
                    </button>
                    </div>
                </form>
                <div class="btn-group mb-5" role="group">
                    <button id="btnGroupDrop1" type="button" class="btn btn-outline-secondary dropdown-toggle"
                            data-bs-toggle="dropdown" aria-expanded="false">
                        Filtruj
                    </button>
                    <ul class="dropdown-menu" aria-labelledby="btnGroupDrop1">
                        <li><a class="dropdown-item" href="/app/product">Wszystkie</a></li>
                        <li><a class="dropdown-item" href="/app/product/available">Dostępne</a></li>
                        <li><a class="dropdown-item" href="/app/product/unavailable">Niedostępne</a></li>
                        <c:forEach items="${categories}" var="category">
                            <li><a class="dropdown-item" href="/app/product/filter/${category.id}">${category.name}</a>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>

            <div class="table-responsive">
                <table class="table table-striped table-sm">

                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Nazwa</th>
                        <th scope="col">Opis</th>
                        <th scope="col">Status</th>
                        <th scope="col">Kategoria</th>
                        <th scope="col">Akcja</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${products}" var="product" varStatus="status">
                        <tr>
                            <td>${status.count}</td>
                            <td>${product.name}</td>
                            <td>${product.description}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${product.available == true}">
                                        Dostępny
                                    </c:when>
                                    <c:otherwise>
                                        Niedostępny
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td>${product.category.name}</td>
                            <td>
                                <div class="btn-group">
                                    <a href="/app/product/edit/${product.id}" class="btn btn-info">Edytuj</a>
                                    <a href="/app/product/available/${product.id}" class="btn btn-warning">Zmień
                                        status</a>
                                    <a href="/app/product/delete/${product.id}"
                                       onclick="return confirm('Czy na pewno usunąć? Operacja jest nieodwracalna!');"
                                       class="btn btn-danger">Usuń</a>
                                </div>

                            </td>

                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </main>
    </div>

</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>


<script src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js"
        integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js"
        integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha"
        crossorigin="anonymous"></script>
<script src="/dashboard.js"></script>
</body>
</html>
