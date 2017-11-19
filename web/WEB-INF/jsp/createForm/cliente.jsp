<%-- 
    Document   : cliente
    Created on : 19/11/2017, 18:17:12
    Author     : Thales
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../header.jsp" />

<div class='container formy'>
    <form action='ClienteServlet' method='post'>
        <div class='form-group'>
            <input type='hidden' class='form-control' name='submitAction' value='criar'>
        </div>
        
        <div class='form-group'>
            <label for="nome">Nome:</label>
            <input type='text' class='form-control' name='nome' value='${cliente.nome}' required>
        </div>
        
        <div class='form-group'>
            <label for="endereco">Endereço:</label>
            <input type='text' class='form-control' name='endereco' value='${cliente.endereco}' required>
        </div>
        
        <div class='form-group'>
            <label for="bairro">Bairro:</label>
            <input type='text' class='form-control' name='bairro' value='${cliente.bairro}' required>
        </div>
        
        <div class='form-group'>
            <label for="cidade">Cidade:</label>
            <input type='text' class='form-control' name='cidade' value='${cliente.cidade}' required>
        </div>
        
        <div class='form-group'>
            <label for="cep">CEP:</label>
            <input type='number' class='form-control' name='cep' value='${cliente.cep}' required>
        </div>
        
        <div class='form-group'>
            <label for="uf">UF:</label>
            <input type='text' class='form-control' name='uf' value='${cliente.uf}' required>
        </div>
        
        <div class='form-group'>
            <label for="cpf">CPF:</label>
            <input type='number' class='form-control' name='cpf' value='${cliente.cpf}' required>
        </div>
        
        <div class='form-group'>
            <label for="referencia">Referência:</label>
            <input type='text' class='form-control' name='referencia' value='${cliente.referencia}' required>
        </div>
        
        <div class='form-group'>
            <label for="identidade">Identidade:</label>
            <input type='number' class='form-control' name='identidade' value='${cliente.identidade}' required>
        </div>
        
        <div class='form-group'>
            <label for="telefone">Telefone:</label>
            <input type='number' class='form-control' name='telefone' value='${cliente.telefone}' required>
        </div>
        
        <div class='form-group'>
            <label for="celular">Celular:</label>
            <input type='number' class='form-control' name='celular' value='${cliente.celular}' required>
        </div>
        
        <div class='form-group'>
            <label for="cartao">Cartão:</label>
            <input type='number' class='form-control' name='cartao' value='${cliente.cartao}' required>
        </div>
        
        <div class='form-group'>
            <label for="bandeira">Bandeira:</label>
            <input type='text' class='form-control' name='bandeira' value='${cliente.bandeira}' required>
        </div>

        <div class='text-center'>
            <button type='submit' class='btn btn-primary form-btn'>Enviar</button>
        </div>
    
    </form>
</div>

<jsp:include page="../footer.jsp" />
