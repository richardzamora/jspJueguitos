<%@include file="../../commons/header.jspf" %>
<div class="d-flex">

    <div class="table-responsive col-sm-8">

        <table class="table table-hover">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Brand Name</th>
                <th scope="col">Create At</th>
                <th scope="col">Update At</th>
                <th scope="col">Eliminar</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${brands}" var="brand">
                <tr>
                    <td>${brand.id}</td>
                    <td>${brand.name}</td>
                    <td>${brand.createdAt}</td>
                    <td>${brand.updatedAt}</td>
                    <td>
                        <a class="btn btn-outline-success" href="vehiclesbrands.do?action=Update&value=${brand.id}">Update</a>
                        <a class="btn btn-outline-danger" href="vehiclesbrands.do?action=Delete&value=${brand.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <%--For displaying Previous link except for the 1st page --%>
        <c:if test="${currentPage != 1}">
            <td><a href="vehiclesbrands.do?action=Listar&page=${currentPage - 1}">Previous</a></td>
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
                            <td><a href="vehiclesbrands.do?action=Listar&page=${i}">${i}</a></td>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </tr>
        </table>

        <%--For displaying Next link --%>
        <c:if test="${currentPage lt noOfPages}">
            <td><a href="vehiclesbrands.do?action=Listar&page=${currentPage + 1}">Next</a></td>
        </c:if>
    </div>

    <div class="card col-sm-4">
        <div class="card card-title" style="margin-top: 40px;text-align: center">
            <h2>${title}</h2>
        </div>
        <div class="card card-body">
            <form action="/vehiclesbrands.do" method="post">
                <div class="form-group">
                    <label>Id</label>
                    <input type="text" value="${brand.id}" name="id" class="form-control" readonly>
                </div>

                <div class="form-group">
                    <label>Name</label>
                    <input type="text" value="${brand.name}" name="name" class="form-control">
                </div>

                <div class="form-group">
                    <label>Create At</label>
                    <input type="text" value="${brand.createdAt}" name="createdAt" class="form-control" disabled>
                </div>

                <div class="form-group">
                    <label>Last Update</label>
                    <input type="text" value="${brand.updatedAt}" name="updatedAt" class="form-control" disabled>
                </div>
                <c:if test = "${title == 'List Brands'}">
                    <input type="submit" name="action" value="Add" class="btn btn-success">
                </c:if>
                <c:if test = "${title == 'Update Brands'}">
                    <input type="submit" name="action" value="Update" class="btn btn-success">
                </c:if>

         </form>
        </div>
    </div>

</div>
<%@include file="../../commons/footer.jspf" %>

