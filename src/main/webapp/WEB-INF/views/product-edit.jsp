<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">


<jsp:include page="header.jsp"/>
<body>

<div class="container-fluid">
    <div class="row">
        <jsp:include page="nav.jsp"/>
        <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
            <h2>Edytuj produkt</h2>
            <form:form method="post" modelAttribute="product">
                <div class="form-group">
                    <label for="name">Nazwa produktu</label>
                    <form:input path="name" type="text" class="form-control" id="name" placeholder="Nazwa produktu" />
                    <div class="text-danger">
                        <form:errors path="name"/>
                    </div>
                    <label for="name">Opis produktu</label>
                    <form:input path="description" type="text" class="form-control" id="name" placeholder="Opis produktu" />
                    <form:select path="category" items="${categories}" itemLabel="name" itemValue="id" />


                </div>
                <div class="btn-group">
                    <input value="Edytuj" type="submit" class="btn btn-primary"></input>
                    <a href="/app/order" class="btn btn-danger">Anuluj</a>
                </div>
            </form:form>
        </main>
    </div>

</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>


<script src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js" integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE" crossorigin="anonymous"></script><script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js" integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha" crossorigin="anonymous"></script><script src="dashboard.js"></script>
</body>
</html>