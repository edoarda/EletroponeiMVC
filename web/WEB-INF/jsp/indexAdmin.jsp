<%-- 
    Document   : indexAdmin
    Created on : Nov 17, 2017, 3:17:58 AM
    Author     : edoarda
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp" />
<div class='container'>
    <h1 class="formy">Vc entrou seu bosta</h1>
    
    <!--ADMINISTRADOR -->
    <h5><a href="">Adicionar � Administrador</a></h5>
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
        
    <!--CATEGORIA-->
    <h5><a href="">Adicionar � Categoria</a></h5>
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
        

        <!--PRODUTO-->
    <h5><a href="">Adicionar � Produto</a></h5>
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
        
        <!--CLIENTE-->
    <h5><a href="">Adicionar � Cliente</a></h5>
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
        
        <!--COMPRA-->
    <h5><a href="">Adicionar � Compra</a></h5>
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
</div>
        
<jsp:include page="footer.jsp" />
