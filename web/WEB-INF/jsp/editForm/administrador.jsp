<%-- 
    Document   : administrador
    Created on : Nov 19, 2017, 5:28:00 PM
    Author     : edoarda
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../header.jsp" />

<div class='container formy'>
    <form action='SubmitUpdate' method='post'>
    
        <div class='form-group'>
            <label for="id">Id</label>
            <input type='text' class='form-control' name='id' value='${administrador.id}' required>
        </div>
        
        <div class='form-group'>
            <label for="login">Login</label>
            <input type='text' class='form-control' name='login' value='${administrador.login}' required>
        </div>
        
        <div class='form-group'>
            <label for="id">Id</label>
            <input type='password' class='form-control' name='id' value='${administrador.senha}' required>
        </div>

        <div class='text-center'>
            <button type='submit' class='btn btn-primary form-btn'>Enviar</button>
        </div>
    
    </form>
</div>

<jsp:include page="../footer.jsp" />