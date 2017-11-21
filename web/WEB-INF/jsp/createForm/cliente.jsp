<%-- 
    Document   : cliente
    Created on : 19/11/2017, 18:17:12
    Author     : Thales
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../header.jsp" />

<div class='container formy'>
    <form action='ClienteServlet' method='post' onsubmit='return validarCliente()'>
        <div class='form-group'>
            <input type='hidden' class='form-control' name='submitAction' value='criar'>
        </div>
        
        <div class='form-group'>
            <label for="nome">Nome:</label>
            <input type='text' class='form-control' id='nome' name='nome' value='${cliente.nome}' required>
        </div>
        
        <div class='form-group'>
            <label for="endereco">Endereço:</label>
            <input type='text' class='form-control' id='endereco' name='endereco' value='${cliente.endereco}' required>
        </div>
        
        <div class='form-group'>
            <label for="bairro">Bairro:</label>
            <input type='text' class='form-control' id='bairro' name='bairro' value='${cliente.bairro}' required>
        </div>
        
        <div class='form-group'>
            <label for="cidade">Cidade:</label>
            <input type='text' class='form-control' id='cidade' name='cidade' value='${cliente.cidade}' required>
        </div>
        
        <div class='form-group'>
            <label for="cep">CEP:</label>
            <input type='number' class='form-control' id='cep' name='cep' value='${cliente.cep}' required>
        </div>
        
        <div class='form-group'>
            <label for="uf">UF:</label>
            <select class="form-control" id='uf' name='uf' required>
                    <option>AC</option>
                    <option>AL</option>
                    <option>AP</option>
                    <option>AM</option>
                    <option>BA</option>
                    <option>CE</option>
                    <option>DF</option>
                    <option>ES</option>
                    <option>GO</option>
                    <option>MA</option>
                    <option>MT</option>
                    <option>MS</option>
                    <option>MG</option>
                    <option>PA</option>
                    <option>PB</option>
                    <option>PR</option>
                    <option>PE</option>
                    <option>PI</option>
                    <option>RJ</option>
                    <option>RN</option>
                    <option>RS</option>
                    <option>RO</option>
                    <option>RR</option>
                    <option>SC</option>
                    <option>SP</option>
                    <option>SE</option>
                    <option>TO</option>                
                </select>
        </div>
        
        <div class='form-group'>
            <label for="cpf">CPF:</label>
            <input type='number' class='form-control' id='cpf' name='cpf' value='${cliente.cpf}' required>
        </div>
        
        <div class='form-group'>
            <label for="referencia">Referência:</label>
            <input type='text' class='form-control' id='referencia' name='referencia' value='${cliente.referencia}'>
        </div>
        
        <div class='form-group'>
            <label for="identidade">Identidade:</label>
            <input type='number' class='form-control' id='identidade' name='identidade' value='${cliente.identidade}' required>
        </div>
        
        <div class='form-group'>
            <label for="telefone">Telefone:</label>
            <input type='number' class='form-control' id='telefone' name='telefone' value='${cliente.telefone}' required>
        </div>
        
        <div class='form-group'>
            <label for="celular">Celular:</label>
            <input type='number' class='form-control' id='celular' name='celular' value='${cliente.celular}' required>
        </div>
        
        <div class='form-group'>
            <label for="cartao">Cartão:</label>
            <input type='number' class='form-control' id='cartao' name='cartao' value='${cliente.cartao}' required>
        </div>
        
        <div class='form-group'>
            <label for="bandeira">Bandeira:</label>
            <input type='text' class='form-control' id='bandeira' name='bandeira' value='${cliente.bandeira}' required>
        </div>

        <div class='text-center'>
            <button type='submit' class='btn btn-primary form-btn'>Enviar</button>
        </div>
    
    </form>
</div>

<jsp:include page="../footer.jsp" />
