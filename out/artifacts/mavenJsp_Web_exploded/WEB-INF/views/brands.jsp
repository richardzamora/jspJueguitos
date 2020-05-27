<%@include file="../commons/header.jspf" %>

<h1>Hola estoy funcionando</h1>
<%@include file="../commons/footer.jspf" %>


<%--
<div class ="container-sm">

    <table class="table table-hover">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Brand Name</th>
            <th scope="col">Eliminar</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${brands}" var="brand">
            <tr>
                <td>${brand.id}</td>
                <td>${brand.name}</td>
                <td>
                    <a href="delete-todo.do?todo=${brand.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
--%>
<%--
<div class="container-sm">
<table class="table table-hover">
    <thead>
    <tr>
        <th scope="col">Delete</th>
        <th scope="col">Id</th>
        <th scope="col">Brand Name</th>
    </tr>
    </thead>
    <tbody>
        <c:forEach items="${brands}" var="brand">
        <tr>
            <td>${brand.id}</td>
            <td>${brand.name}</td>
            <td>
                <a href="delete-todo.do?todo=${brand.id}"></a>Delete
            </td>
        </tr>
        </c:forEach>
    </tbody>
</table>
</div>
--%>

