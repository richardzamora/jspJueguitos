<%@include file="../commons/header.jspf" %>

<div class="container-md">
<p>Welcome ${user}</p>
<ol>
    <c:forEach items="${todos}" var="todo">
        <li><a href="delete-todo.do?todo=${todo.name}">
            Delete
        </a>
                ${todo.name}
        </li>
    </c:forEach>
</ol>

<form action="todo.do" method="post">
    <label>New Todo</label>
    <input type="text" name="newTodo">
    <button type="submit">Add</button>
</form>
</div>
<%@include file="../commons/footer.jspf" %>

