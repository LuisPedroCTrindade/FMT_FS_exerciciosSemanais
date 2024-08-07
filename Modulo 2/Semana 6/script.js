function pedirInformacoes() {
    let nome = prompt("Qual o nome do aluno?", "Digite o nome.");
    let idade = prompt("Qual a idade do aluno?", "Digite a idade.");
    let serie = prompt("Qual a série do aluno?", "Digite a série.");
    let escola = prompt("Qual a escola do aluno?", "Digite o nome da escola.");
    let materiaFav = prompt("Qual sua matéria favorita?", "Digite o nome da matéria");

    let msgConfirm = "Os dados informados estão corretos?\n" +
        "Nome: " + nome + "\n" +
        "Idade: " + idade + "\n" +
        "Série: " + serie + "\n" +
        "Escola: " + escola + "\n" +
        "Matéria favorita: " + materiaFav;

    let confirmar = confirm(msgConfirm);

    if (confirmar) {
        let informacoesAlunoDiv = document.getElementById('informacoesAluno');
        informacoesAlunoDiv.innerHTML = `
        <h4>Informações do Aluno</h4>
        <p><strong>Nome:</strong> ${nome}</p>
        <p><strong>Idade:</strong> ${idade} anos</p>
        <p><strong>Série:</strong> ${serie}</p>
        <p><strong>Escola:</strong> ${escola}</p>
        <p><strong>Matéria Favorita:</strong> ${materiaFav}</p>
        `;

    } else {
        document.write("Os dados não foram confirmados. Por favor, preencha as informações novamente.")
    }
}


function maiorNumero(listaNumeros) {
    let maiorNumero = -Infinity

    for (let i = 0; i < listaNumeros.length; i++) {
        if (listaNumeros[i] > maiorNumero) {
            maiorNumero = listaNumeros[i]
        }
    }
    return maiorNumero;
}


function calcularMediaListaNumeros(listaNumeros) {
    let soma = 0;

    for (numero of listaNumeros) {
        soma += numero;
    }
    // Calcular a média
    let media = soma / listaNumeros.length;
    return media;
}

var medias = [];

function submitForm(event) {
    event.preventDefault();

    var materia = document.getElementById('materia').value;
    let notas = []


    for(valueInput of document.getElementsByClassName('notas')){
        notas.push(parseFloat(valueInput.value));
    }
    

    var mediaNumerica = calcularMediaListaNumeros(notas)
    var media = mediaNumerica.toFixed(1);

    medias.push(mediaNumerica)

    var newRow = '<tr>' +
        '<td>' + materia + '</td>';

        for (let nota of notas) {
            newRow += '<td>' + nota + '</td>';
        }
        
        newRow += '<td>' + media + '</td></tr>';


    document.getElementById('notasTabela').innerHTML += newRow;
    document.getElementById('closeModal').click()
    document.getElementById('form-notas-materia').reset();

    let mediaGeral = document.getElementById('mediaGeralAluno');
    mediaGeral.innerText = 'A média geral do aluno é: ' + calcularMediaListaNumeros(medias).toFixed(1);

    let maiorMedia = maiorNumero(medias)
    document.getElementById('maiorMedia').innerHTML = maiorMedia

}


document.getElementById('form-notas-materia').addEventListener('submit', this.submitForm)


window.addEventListener('load', function (event) {
    this.pedirInformacoes();
});



//EXERCÍCIOS SEMANA 6
async function buscarEndereco() {
    const cep = document.getElementById('cep').value;
    if (cep.length === 8) {
        try {
            const response = await fetch(`https://viacep.com.br/ws/${cep}/json/`);
            if (!response.ok) throw new Error('CEP não encontrado');
            const data = await response.json();
            if (data.erro) throw new Error('CEP não encontrado');
            
            document.getElementById('rua').value = data.logradouro;
            document.getElementById('cidade').value = data.localidade;
            document.getElementById('estado').value = data.uf;
        } catch (error) {
            alert(error.message);
            document.getElementById('rua').value = '';
            document.getElementById('cidade').value = '';
            document.getElementById('estado').value = '';
        }
    }
}

function salvarCadastro(event) {
    event.preventDefault();
    
    const nome = document.getElementById('nome').value;
    const idade = document.getElementById('idade').value;
    const serie = document.getElementById('serie').value;
    const escola = document.getElementById('escola').value;
    const materia = document.getElementById('materia').value;
    const cep = document.getElementById('cep').value;
    const rua = document.getElementById('rua').value;
    const cidade = document.getElementById('cidade').value;
    const estado = document.getElementById('estado').value;

    const cadastro = {
        nome,
        idade,
        serie,
        escola,
        materia,
        endereco: {
            cep,
            rua,
            cidade,
            estado
        }
    };

    localStorage.setItem('cadastroAluno', JSON.stringify(cadastro));

    window.location.href = 'http://127.0.0.1:5500/index.html';
}