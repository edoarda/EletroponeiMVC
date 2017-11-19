<%-- 
    Document   : pdtTable
    Created on : Nov 18, 2017, 12:58:52 AM
    Author     : edoarda
--%>

<div class='table-responsive'>
    <table class="table">
        <thead>
            <tr>
               <c:forEach var="pdtH" items="${pdtHead}">
                   <th>${pdtH }</th>
               </c:forEach>
                   <th>Editar</th>
                   <th>Deletar</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="pdt" items="${produto }">
                <tr>
                <td>${pdt.id }</td>
                <td>${pdt.idCategoria }</td>
                <td>${pdt.nome }</td>
                <td>${pdt.descricao }</td>
                <td>${pdt.valor }</td>
                <td><a href='ProdutoServlet?opcao=editar&id=${pdt.id }'>EDITAR</a></td>
                <td><a href='ProdutoServlet?opcao=deletar&id=${pdt.id }'>DELETAR</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table> 
</div>