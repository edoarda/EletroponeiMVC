<%-- 
    Document   : admTable
    Created on : Nov 18, 2017, 12:55:23 AM
    Author     : edoarda
--%>

<div class='table-responsive'>
    <table class="table">
        <thead>
            <tr>
               <c:forEach var="admH" items="${admHead}">
                   <th>${admH }</th>
               </c:forEach>
                   <th>Editar</th>
                   <th>Deletar</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="adm" items="${administrador }">
                <tr>
                <td>${adm.id }</td>
                <td>${adm.login }</td>
                <td>*****</td>
                <td><a href='AdministradorServlet?opcao=editar&id=${adm.id }'>EDITAR</a></td>
                <td><a href='AdministradorServlet?opcao=deletar&id=${adm.id }'>DELETAR</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
