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
            <h2>Dodaj nowe zamówienie</h2>
            <div class="">
                <a href="/app/customer/add" class="btn btn-sm btn-warning">Nowy klient</a>
            </div>
            <div class="mt-4">
                <form:form method="post" modelAttribute="order">
                    <p><form:errors path="customer"/></p>
                    <p><form:errors path="shipDate"/></p>
                    <p><form:errors path="important"/></p>
                    <p><form:errors path="price"/></p>
                    <p><form:errors path="paid"/></p>
                    <p><form:errors path="products"/></p>
                    <label for="customer">Klient</label>
                    <form:select path="customer" items="${customers}" itemLabel="customerInformation" itemValue="id" />
                    <label for="shipDate">Planowana data dostawy</label>
                    <form:input path="shipDate" id="shipDate" type="date"/>
                    <label for="important">Zamówienie priorytetowe</label>
                    <form:checkbox path="important" id="important"/>
                    <p></p>
                    <label for="price">Wartość zamówienia</label>
                    <form:input path="price" id="price" type="text"/>
                    <label for="paid">Opłacone</label>
                    <form:checkbox path="paid" id="paid"/>
                    <h4>Produkty</h4>
                    <div id="select">
                        <form:select path="products" items="${products}" itemLabel="productInformation" itemValue="id" size="10"/>
                    </div>
                    <label for="description">Dodatkowe informacje</label>
                    <form:input type="text" path="description" id="description"/>
                    <div class="btn-group">
                        <input value="Dodaj" type="submit" class="btn btn-primary"></input>
                        <a href="/app/order" class="btn btn-danger">Anuluj</a>
                    </div>
                </form:form>
            </div>

        </main>
    </div>

</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>


<script src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js" integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE" crossorigin="anonymous"></script><script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js" integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha" crossorigin="anonymous"></script><script src="dashboard.js"></script>
</body>
</html>