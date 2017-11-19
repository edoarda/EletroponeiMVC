<%-- 
    Document   : categoria
    Created on : Nov 19, 2017, 7:23:52 PM
    Author     : edoarda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="../header.jsp" />

<div class='container formy'>
    <form action='SubmitUpdate' method='post'>

        <div class='form-group'>
            <label for="id">Id:</label>
            <input type='number' class='form-control' name='id' value='${categoria.id }' required>
        </div>

        <div class='form-group'>
            <label for="nome">Nome:</label>
            <input type='text' class='form-control' name='nome' value='${categoria.nome }' required>
        </div>
  
        <div class='form-group'>
            <label for="descricao">Descrição:</label>
            <input type='text' class='form-control' name='descricao' value='${categoria.descricao }' required>
        </div>

        <div class='text-center'>
            <button type='submit' class='btn btn-primary form-btn'>Enviar</button>
        </div>
    
    </form>
</div>

<jsp:include page="../footer.jsp" />
