<%-- 
    Document   : index
    Created on : 05/11/2017, 19:34:57
    Author     : Edoarda
--%>

<jsp:include page="header.jsp" />
<h1 class="george"> Isso é um index.</h1>
<div class="pudim">
    <!--<input type="text" class="form-control" name="Pesquisar" placeholder="Pesquisar"> -->
    <a href='search?id=1'>Eletrodomestico</a>
    <form class="form-inline my-2 my-lg-0" action='search'>
      <input class="form-control" type="text" placeholder="Pesquisar" name="item" label="Pesquisar">
      <button type="submit">Pesquisar</button>
    </form>
</div>
<jsp:include page="footer.jsp" />