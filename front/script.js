const formulario = document.querySelector("form");
const Inome = document.querySelector(".nome")
const Iemail = document.querySelector(".email")
const Isenha = document.querySelector(".senha")
const Itel = document.querySelector(".tel")

function cadastrar() {
    fetch("http://localhost:8080/cadastrar",
    {
        headers: {
            'Accept': 'application/json',
            'Contente-Type': 'application/json'
        },
        method: "POST",
        body: JSON.stringify({
            nome: Inomne.value,
            email: Iemail.value,
            senha: Isenha.value,
            telefone: Itel.value
        })
    })
    .then(function (res) {
        console.log(res)
    })
    .catch(function (res) {
        console.log(res)
    })
};

function limpar() {
    nome: Inomne.value ="";
            Iemail.value ="";
            Isenha.value ="";
            Itel.value ="";
};

formulario.addEventListener('submit', function (event) {
    event.preventDefault();
    cadastrar(); 
    limpar();
});
