<%-- 
    Document   : indexAdmin
    Created on : Nov 17, 2017, 3:17:58 AM
    Author     : edoarda
--%>

<jsp:include page="header.jsp" />
        <h1 class="formy">Vc entrou seu bosta</h1>
        <c:forEach var="Adm" items="${Administrador}">
            <tr>
                <td>${Administrador.login }</td>
                <td>*****</td>
            </tr>
      <!-- some code here -->
</c:forEach>
<jsp:include page="footer.jsp" />
