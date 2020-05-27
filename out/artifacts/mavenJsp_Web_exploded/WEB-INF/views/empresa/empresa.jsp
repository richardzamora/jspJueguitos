<%@include file="../../commons/header.jspf" %>
<div class="d-flex">

    <div class="table-responsive col-sm-8 text-light bg-dark">

        <table class="table table-hover text-light bg-dark">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Name</th>
                <th scope="col">Eliminar</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${empresas}" var="empresa">
                <tr>
                    <td>${empresa.id}</td>
                    <td>${empresa.name}</td>
                    <td>
                        <a class="btn btn-outline-success" href="empresa.do?action=Update&value=${empresa.id}">Update</a>
                        <a class="btn btn-outline-danger" href="empresa.do?action=Delete&value=${empresa.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <%--For displaying Previous link except for the 1st page --%>
        <c:if test="${currentPage != 1}">
            <td><a href="empresa.do?action=Listar&page=${currentPage - 1}">Previous</a></td>
        </c:if>

        <%--For displaying Page numbers.
        The when condition does not display a link for the current page--%>
        <table border="1" cellpadding="5" cellspacing="5">
            <tr>
                <c:forEach begin="1" end="${noOfPages}" var="i">
                    <c:choose>
                        <c:when test="${currentPage eq i}">
                            <td>${i}</td>
                        </c:when>
                        <c:otherwise>
                            <td><a href="empresa.do?action=Listar&page=${i}">${i}</a></td>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </tr>
        </table>

        <%--For displaying Next link --%>
        <c:if test="${currentPage lt noOfPages}">
            <td><a href="empresa.do?action=Listar&page=${currentPage + 1}">Next</a></td>
        </c:if>
    </div>

    <div class="card mt-4 col-lg-4 text-light bg-secondary">
        <div class="card card-title text-light bg-dark" style="margin-top: 40px;text-align: center">
            <h2>${title}</h2>
        </div>
        <div class="card card-body mb-4 text-light bg-dark">
            <form action="/empresa.do" method="post">
                <div class="form-group text-light bg-dark">
                    <label>Id</label>
                    <input type="text" value="${empresa.id}" name="id" class="form-control" readonly>
                </div>

                <div class="form-group text-light bg-dark">
                    <label>Name</label>
                    <input type="text" value="${empresa.name}" name="name" class="form-control">
                </div>
                <c:if test = "${title == 'Add Empresas'}">
                    <input type="submit" name="action" value="Add" class="btn btn-success">
                </c:if>
                <c:if test = "${title == 'Update Empresas'}">
                    <input type="submit" name="action" value="Update" class="btn btn-success">
                </c:if>

            </form>
        </div>
    </div>

</div>
<%@include file="../../commons/footer.jspf" %>

