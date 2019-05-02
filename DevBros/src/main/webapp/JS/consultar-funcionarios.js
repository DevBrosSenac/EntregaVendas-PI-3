var tabela = document.getElementById("tabelafunc");
var linhas = tabela.getElementsByTagName("tr");

for(var i = 0; i < linhas.length; i++){
    var linha = linhas[i];
    linha.addEventListener("click", function(){
  	//Adicionar ao atual
        setLinha(this, false); //Selecione apenas um
        //selLinha(this, true); //Selecione quantos quiser
    });
}
/**
Caso passe true, você pode selecionar multiplas linhas.
Caso passe false, você só pode selecionar uma linha por vez.
**/
function setLinha(linha, multiplos){
    if(!multiplos){
  	var linhas = linha.parentElement.getElementsByTagName("tr");
        for(var i = 0; i < linhas.length; i++){
          var linha_ = linhas[i];
          linha_.classList.remove("selecionado");    
        }
    }
    linha.classList.toggle("selecionado");
}

/**
Exemplo de como capturar os dados
**/
var btnVisualizar = document.getElementById("visualizarDados");

btnVisualizar.addEventListener("click", function(){
    var selecionados = tabela.getElementsByClassName("selecionado");
    
    //Verificar se eestá selecionado
    if(selecionados.length < 1){
          alert("Selecione pelo menos uma linha");
      return false;
    }
  
  var dados = "";
  
  for(var i = 0; i < selecionados.length; i++){
    var selecionado = selecionados[i];
    selecionado = selecionado.getElementsByTagName("td");
    dados += "ID: " + selecionado[0].innerHTML + " - Nome: " + selecionado[1].innerHTML + " - Idade: " + selecionado[2].innerHTML + "\n";
  }
  
  alert(dados);
});