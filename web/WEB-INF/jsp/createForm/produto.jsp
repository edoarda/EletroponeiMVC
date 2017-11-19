<%-- 
    Document   : produto
    Created on : 19/11/2017, 18:17:35
    Author     : Thales
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../header.jsp" />

<div class='container formy'>
    <form action='ProdutoServlet' method='post'>
        <div class='form-group'>
            <input type='hidden' class='form-control' name='submitAction' value='criar'>
        </div>
    
        
        <div class='form-group'>
            <label for="idCategoria">IdCategoria:</label>
            <input type='number' class='form-control' name='idCategoria' required>
        </div>
        
        <div class='form-group'>
            <label for="nome">Nome:</label>
            <input type='text' class='form-control' name='nome' required>
        </div>
        
        <div class='form-group'>
            <label for="descricao">Descição:</label>
            <input type='text' class='form-control' name='descricao' required>
        </div>
        
        <div class='form-group'>
            <label for="valor">Valor:</label>
            <input type='number' class='form-control' name='valor' required>
        </div>

        <div class='text-center'>
            <button type='submit' class='btn btn-primary form-btn'>Enviar</button>
        </div>
    
    </form>
</div>

<jsp:include page="../footer.jsp" />
