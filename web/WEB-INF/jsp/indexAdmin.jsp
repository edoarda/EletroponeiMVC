<%-- 
    Document   : indexAdmin
    Created on : Nov 17, 2017, 3:17:58 AM
    Author     : edoarda
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp" />
<div class='container'>
    <h1 class="formy">Vc entrou seu bosta</h1>
    <div class='table-responsive'>
        
        <!--ADMINISTRADOR -->
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
                    <td><a href='/Eletroponei/AdministradorServlet?id=${adm.id }'>EDITAR</a></td>
                    <td><a href='/Eletroponei/AdministradorServlet?id=${adm.id }'>DELETAR</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        

        
    </div>
</div>
        
<jsp:include page="footer.jsp" />
