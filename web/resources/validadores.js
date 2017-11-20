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