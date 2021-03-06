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
                <h1 class="h2">Zamówienia</h1>
                <div class="btn-group me-2">
                    <a href="/app/order/add" class="btn btn-sm btn-outline-secondary">Nowe zamówienie</a>
                </div>
            </div>
            <div class="btn-group mb-5" role="group">
                <button id="btnGroupDrop1" type="button" class="btn btn-outline-secondary dropdown-toggle"
                        data-bs-toggle="dropdown" aria-expanded="false">
                    Filtruj
                </button>
                <ul class="dropdown-menu" aria-labelledby="btnGroupDrop1">
                    <li><a class="dropdown-item" href="/app/order">Wszystkie</a></li>
                    <li><a class="dropdown-item" href="/app/order/important">Pilne</a></li>
                    <li><a class="dropdown-item" href="/app/order/inprogress">Realizowane</a></li>
                    <li><a class="dropdown-item" href="/app/order/accepted">Oczekujące</a></li>
                    <li><a class="dropdown-item" href="/app/order/ended">Zakończone</a></li>
                    <li><a class="dropdown-item" href="/app/order/delayed">Opóźnione</a></li>
                </ul>
            </div>
            <div class="text-danger">
                ${errorMessage}
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
                        <th scope="col">Status</th>
                        <th scope="col">Akcja</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${orders}" var="order" varStatus="status">
                        <c:if test="${order.deleted == false}">
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
                            <td>
                                <c:choose>
                                    <c:when test="${order.orderStatus == 'accepted'}">
                                        Przyjęte
                                    </c:when>
                                    <c:when test="${order.orderStatus == 'inProgress'}">
                                        W trakcie realizacji
                                    </c:when>
                                    <c:otherwise>
                                        Zakończone
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td>
                                <div class="btn-group">
                                    <c:choose>
                                        <c:when test="${order.orderStatus == 'accepted'}">
                                            <a href="/app/order/details/${order.id}" class="btn btn-warning">Szczegóły</a>
                                            <a href="/app/order/delete/${order.id}" onclick="return confirm('Czy na pewno usunąć? Operacja jest nieodwracalna!');" class="btn btn-danger">Usuń</a>
                                        </c:when>
                                        <c:when test="${order.orderStatus == 'inProgress'}">
                                            <a href="/app/order/end/${order.id}" class="btn btn-success">Zakończ</a>
                                            <a href="/app/order/edit/${order.id}" class="btn btn-info">Edytuj</a>
                                            <a href="/app/order/details/${order.id}" class="btn btn-warning">Szczegóły</a>
                                            <a href="/app/order/delete/${order.id}" onclick="return confirm('Czy na pewno usunąć? Operacja jest nieodwracalna!');" class="btn btn-danger">Usuń</a>
                                        </c:when>
                                        <c:otherwise>
                                            <a href="/app/order/details/${order.id}" class="btn btn-warning">Szczegóły</a>
                                            <a href="/app/order/delete/${order.id}" onclick="return confirm('Czy na pewno usunąć? Operacja jest nieodwracalna!');" class="btn btn-danger">Usuń</a>
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                            </td>

                        </tr>
                    </c:if>
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
<script src="dashboard.js"></script>
</body>
</html>
