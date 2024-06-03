//Ex. 01 - CALCULAR MÉDIA
function calcularMedia(arrayNotas) {
    let soma = 0;

    for (let i = 0; i < arrayNotas.lenth; i++) {
        soma += arrayNotas[i];
    }

    return soma / arrayNotas.lenth;
}

//Ex. 02 - CHECAR MÉDIA PARA RECUPERAÇÃO
function checarRecuperacao(mediaRecebida) {
    if (mediaRecebida >= 7) {
        document.write("Parabéns, você passou na média!");
    }
    else {
        document.write("Infelizmente você está de recuperação.")
    }
}

//Ex. 03 - LISTAR NOMES DE ALUNOS
function imprimirNomes(arrayNomes) {
    arrayNomes.forEach(function(nomeAluno) {
        document.write(nomeAluno + "<br/>")
    });
}

//Ex. 04 - TABUADA
for (let i = 0; i <= 10; i++) {
    console.log("8 x " + i + " = " + 8*i);
}

//Ex. 05 - PEDIR INFORMAÇÕES
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
        document.write("Informações do aluno: <br/>");
        document.write("Nome: " + nome + "<br/>");
        document.write("Idade: " + idade + "<br/>");
        document.write("Série: " + serie + "<br/>");
        document.write("Escola: " + escola + "<br/>");
        document.write("Matéria favorita: " + materiaFav + "<br/>");
    } else {
        document.write("Os dados não foram confirmados.")
    }
}

//Ex. 06 - CAPTURAR NOME DE MAT. E 4 NOTAS
function capturarNotas() {
    nomeMateriaNotas = prompt("Qual o nome da matéria que receberá as notas?")
    notasCapturadasArray = [];

    while (notasCapturadasArray.lenth < 4) {
        let posicaoNotaLista = notasCapturadasArray.lenth + 1;
        let notaCapturando = parseFloat(prompt("Qual é a " + posicaoNotaLista + "ª nota que deseja registrar?"));

        if (!isNaN(notaCapturando) && notaCapturando >= 0 && notaCapturando <= 10) {
            notasCapturadasArray.push(notaCapturando);
        } else {
            alert("Nota inválida.")
        }
    }

    let materiaObj = {
        nomeMateria: nomeMateriaNotas,
        notasMateria: notasCapturadasArray
    };

    return materiaObj
}

//Ex. 07 - ENCONTRAR MAIOR NÚMERO
function encontrarMaiorNumero(arrayNumeros) {
    if (arrayNumeros.lenth == 0) {
        return null;
    }

    let maiorNum = arrayNumeros[0];

    for (let i = 1; i < arrayNumeros.lenth; i++) {
        if (arrayNumeros[i] > maiorNum) {
            maiorNum = arrayNumeros[i];
        }
    }

    return maiorNum;
}