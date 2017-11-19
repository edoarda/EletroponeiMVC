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
        <h5><a href="">Adicionar à Administrador</a></h5>
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
        
    <!--CATEGORIA-->
    <div class='table-responsive'>
        <h5><a href="">Adicionar à Categoria</a></h5>
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
                    <td><a href='/Eletroponei/CategoriaServlet?id=${cat.id }'>EDITAR</a></td>
                    <td><a href='/Eletroponei/CategoriaServlet?id=${cat.id }'>DELETAR</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
        

        <!--PRODUTO-->
    <div class='table-responsive'>
        <h5><a href="">Adicionar à Produto</a></h5>
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
                    <td><a href='/Eletroponei/ProdutoServlet?id=${pdt.id }'>EDITAR</a></td>
                    <td><a href='/Eletroponei/ProdutoServlet?id=${pdt.id }'>DELETAR</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table> 
    </div>
        
        <!--CLIENTE-->
    <div class='table-responsive'>
        <h5><a href="">Adicionar à Cliente</a></h5>
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
                    <td><a href='/Eletroponei/ClienteServlet?id=${clt.id }'>EDITAR</a></td>
                    <td><a href='/Eletroponei/ClienteServlet?id=${clt.id }'>DELETAR</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
        
        <!--COMPRA-->
    <div class='table-responsive'>
        <h5><a href="">Adicionar à Compra</a></h5>
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
                    <td><a href='/Eletroponei/CompraServlet?id=${cmp.id }'>EDITAR</a></td>
                    <td><a href='/Eletroponei/CompraServlet?id=${cmp.id }'>DELETAR</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>
        
<jsp:include page="footer.jsp" />
