<%-- 
    Document   : cmpTable
    Created on : Nov 18, 2017, 12:58:34 AM
    Author     : edoarda
--%>

<div class='table-responsive'>
    <table class="table">
        <thead>
            <tr>
               <c:forEach var="cmpH" items="${cmpHead}">
                   <th>${cmpH }</th>
               </c:forEach>
                   <th>Editar</th>
                   <th>Deletar</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="cmp" items="${compra }">
                <tr>
                <td>${cmp.id }</td>
                <td>${cmp.idCliente }</td>
                <td>${cmp.idProduto }</td>
                <td><a href='CompraServlet?opcao=editar&id=${cmp.id }'>EDITAR</a></td>
                <td><a href='CompraServlet?opcao=deletar&id=${cmp.id }'>DELETAR</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>