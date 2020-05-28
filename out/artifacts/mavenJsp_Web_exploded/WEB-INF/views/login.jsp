<%@include file="../commons/header.jspf" %>

<div class="container mt-4 col-lg-4 bg-dark">
    <div class="card col-sm-10 text-light bg-dark">
        <div class="card-body text-light bg-dark">
            <form action="/login.do" method="post">
                <div class="form-group text-center text-light bg-dark">
                    <h3>Welcome to <b>VIDEOGAMES</b></h3>
                    <label>Login</label>
                </div>

                <div class="form-group text-light bg-dark">
                    <label>User:</label>
                    <input  type="text" placeholder="Username" name="user" class="form-control" value="cristiangomez@gmail.com">
                </div>
                <div class="form-group text-light bg-dark">
                    <label>Password:</label>
                    <input type="password" placeholder="Username" name="password" class="form-control" value="UwU">
                </div>
                <div style="text-align: center;"><input type="submit" class="btn btn-dark" name="login" value="Login"></div>
            </form>
        </div>
    </div>

</div>
<%@include file="../commons/footer.jspf" %>


