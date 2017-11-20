function validarTamanho(str, min, max, campo) {
    if ((str.length >= min) && (str.length <= max)) {
        return true;
    } else {
        alert(campo + " " + "invalido");
        return false;
    }
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