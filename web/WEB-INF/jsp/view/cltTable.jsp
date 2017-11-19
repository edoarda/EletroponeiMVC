<%-- 
    Document   : cltTable
    Created on : Nov 18, 2017, 12:55:56 AM
    Author     : edoarda
--%>

<div class='table-responsive'>
    <table class="table">
        <thead>
            <tr>
               <c:forEach var="cltH" items="${cltHead}">
                   <th>${cltH }</th>
               </c:forEach>
                   <th>Editar</th>
                   <th>Deletar</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="clt" items="${cliente }">
                <tr>
                <td>${clt.id }</td>
                <td>${clt.nome }</td>
                <td>${clt.endereco }</td>
                <td>${clt.bairro }</td>
                <td>${clt.cidade }</td>
                <td>${clt.cep }</td>
                <td>${clt.uf }</td>
                <td>${clt.cpf }</td>
                <td>${clt.referencia }</td>
                <td>${clt.identidade }</td>
                <td>${clt.telefone }</td>
                <td>${clt.celular }</td>
                <td>${clt.cartao }</td>
                <td>${clt.bandeira }</td>
                <td><a href='ClienteServlet?opcao=editar&id=${clt.id }'>EDITAR</a></td>
                <td><a href='ClienteServlet?opcao=deletar&id=${clt.id }'>DELETAR</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>