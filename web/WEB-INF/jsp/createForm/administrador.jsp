<%-- 
    Document   : administrador
    Created on : Nov 19, 2017, 5:28:00 PM
    Author     : edoarda
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../header.jsp" />

<div class='container formy'>
    <form action='AdministradorServlet' method='post' onsubmit='return validarAdministrador()'>
        <div class='form-group'>
            <input type='hidden' class='form-control' name='submitAction' value='criar'>
        </div>
        
        <div class='form-group'>
            <label for="login">Login:</label>
            <input type='text' class='form-control' id='login' name='login' required>
        </div>
        
        <div class='form-group'>
            <label for="senha">Senha:</label>
            <input type='password' class='form-control' id='senha' name='senha' required>
        </div>

        <div class='text-center'>
            <button type='submit' class='btn btn-primary form-btn'>Enviar</button>
        </div>
    
    </form>
</div>

<jsp:include page="../footer.jsp" />