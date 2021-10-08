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
            <h2>Dodaj nowego klienta</h2>
            <div class="">
                <form:form method="post" modelAttribute="customer">
                    <div class="text-danger">
                        <p><form:errors path="name"/></p>
                        <p><form:errors path="surname"/></p>
                        <p><form:errors path="email"/></p>
                        <p><form:errors path="phone"/></p>
                        <p><form:errors path="city"/></p>
                        <p><form:errors path="postCode"/></p>
                        <p><form:errors path="street"/></p>
                        <p><form:errors path="number"/></p>
                    </div>
                    <div class="row">
                        <div class="form-group col-sm-4">
                            <label for="name">Imię</label>
                            <form:input type="text" path="name" class="form-control" id="name" placeholder="Imię"/>
                        </div>
                        <div class="form-group col-sm-4">
                            <label for="surname">Nazwisko</label>
                            <form:input type="text" path="surname" class="form-control" id="surname" placeholder="Nazwisko"/>
                        </div>
                        <div class="form-group col-sm-4">
                            <label for="surname">Email</label>
                            <form:input path="email" type="email" class="form-control" id="email" placeholder="Email"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-sm-4">
                            <label for="phone">Numer telefonu</label>
                            <form:input type="text" path="phone" class="form-control" id="phone" placeholder="Telefon"/>
                        </div>
                        <div class="form-group col-sm-4">
                            <label for="city">Miasto</label>
                            <form:input type="text" path="city" class="form-control" id="city" placeholder="Miasto"/>
                        </div>
                        <div class="form-group col-sm-4">
                            <label for="postCode">Kod pocztowy</label>
                            <form:input path="postCode" type="text" class="form-control" id="postCode" placeholder="00-000"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-sm-8">
                            <label for="street">Ulica</label>
                            <form:input type="text" path="street" class="form-control" id="street" placeholder="Ulica"/>
                        </div>
                        <div class="form-group col-sm-4">
                            <label for="number">Numer domu</label>
                            <form:input type="text" path="number" class="form-control" id="number" placeholder="Numer domu"/>
                        </div>
                    </div>
                    <div class="btn-group">
                        <input value="Edytuj" type="submit" class="btn btn-primary"></input>
                        <a href="/app/customer" class="btn btn-danger">Anuluj</a>
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