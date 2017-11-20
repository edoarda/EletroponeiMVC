<%-- 
    Document   : compra
    Created on : 19/11/2017, 18:17:22
    Author     : Thales
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../header.jsp" />

<div class='container formy'>
    <form action='CompraServlet' method='post'>
        <div class='form-group'>
            <input type='hidden' class='form-control' name='submitAction' value='alterar'>
        </div>
    
        <div class='form-group'>
            <input type='hidden' class='form-control' name='id' value='${compra.id}' required>
        </div>
        
        <div class='form-group'>
            <label for="idCliente">IdCliente:</label>
            <input type='number' class='form-control' name='idCliente' value='${compra.idCliente}' required>
        </div>
        
        <div class='form-group'>
            <label for="idProduto">IdProduto:</label>
            <input type='number' class='form-control' name='idProduto' value='${compra.idProduto}' required>
        </div>

        <div class='text-center'>
            <button type='submit' class='btn btn-primary form-btn'>Enviar</button>
        </div>
    
    </form>
</div>

<jsp:include page="../footer.jsp" />
