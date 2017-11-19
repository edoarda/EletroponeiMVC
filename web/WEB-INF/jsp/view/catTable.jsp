<%-- 
    Document   : ctgTable
    Created on : Nov 18, 2017, 12:55:43 AM
    Author     : edoarda
--%>

<div class='table-responsive'>
    <table class="table">
        <thead>
            <tr>
               <c:forEach var="catH" items="${catHead}">
                   <th>${catH }</th>
               </c:forEach>
                   <th>Editar</th>
                   <th>Deletar</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="cat" items="${categoria }">
                <tr>
                <td>${cat.id }</td>
                <td>${cat.nome }</td>
                <td>${cat.descricao }</td>
                <td><a href='CategoriaServlet?opcao=editar&id=${cat.id }'>EDITAR</a></td>
                <td><a href='CategoriaServlet?opcao=deletar&id=${cat.id }'>DELETAR</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>