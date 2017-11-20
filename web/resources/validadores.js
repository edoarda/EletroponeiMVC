function validarTamanho(str, min, max, campo, feminino) {
    if ((str.length >= min) && (str.length <= max)) {
        return true;
    } else {
        if(feminino==1)
            alert(campo + " invalida");
        else
            alert(campo + " invalido");
        return false;
    }
}

function validarAdministrador(){
    return validarTamanho(document.getElementById('login').value, 3, 45, "Login", 0) &&
           validarTamanho(document.getElementById('senha').value, 3, 45, "Senha", 1);
}
function validarCategoria(){
    return validarTamanho(document.getElementById('nome').value, 3, 45, "Nome", 0) &&
           validarTamanho(document.getElementById('descricao').value, 3, 200, "Descrição", 0);
}

function validarCliente(){
    return validarTamanho(document.getElementById('nome').value, 3, 45, "Nome", 0) &&
           validarTamanho(document.getElementById('endereco').value, 3, 100, "Endereço", 0)&&
           validarTamanho(document.getElementById('bairro').value, 3, 45, "Bairro", 0)&&
           validarTamanho(document.getElementById('cidade').value, 3, 45, "Cidade", 0)&&
           validarTamanho(document.getElementById('cep').value, 8, 8, "CEP", 0)&&
           validarTamanho(document.getElementById('uf').value, 2, 2, "UF", 0)&&
           validarTamanho(document.getElementById('cpf').value, 11, 11, "CPF", 0)&&
           validarTamanho(document.getElementById('referencia').value, 0, 100, "Referencia", 1)&&
           validarTamanho(document.getElementById('identidade').value, 5, 9, "Identidade", 1)&&
           validarTamanho(document.getElementById('telefone').value, 10, 10, "Telefone", 0)&&
           validarTamanho(document.getElementById('celular').value, 11, 11, "Celular", 0)&&
           validarTamanho(document.getElementById('cartao').value, 16, 16, "Cartão", 0)&&
           validarTamanho(document.getElementById('bandeira').value, 2, 45, "Bandeira", 1);
}

function validarProduto(){
    return validarTamanho(document.getElementById('nome').value, 3, 45, "Nome", 0) &&
           validarTamanho(document.getElementById('descricao').value, 3, 200, "Descrição", 1)&&
           validarTamanho(document.getElementById('valor').value, 1, 10, "Valor", 0);
}

function validarLogin() {
  var login = $("#login").val();
  var senha = $("#password").val();
  if(login == '' || senha == '') {
    $("#login").val("");
    $("#senha").val("");
    alert("Usuário ou senha inválidos");
  }
}

function confirmar(theUrl) {
    var r = confirm("Deseja Mesmo Deletar?")
    if(r){
        var xmlHttp = new XMLHttpRequest();
        xmlHttp.open( "GET", theUrl, false ); // false for synchronous request
        xmlHttp.send( null );
        return xmlHttp.responseText;
    }
    return null;
}