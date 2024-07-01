//EXERCÍCIO 1
let arrayDeNumeros = [4, 7, 1, 9, 12, 16];

let soma = arrayDeNumeros.reduce((acumulador, valorAtual) => acumulador + valorAtual, 0);

console.log("A soma de todos os elementos do array é: ", soma);


//EXERCÍCIO 2
let pares = arrayDeNumeros.filter(numero => numero % 2 === 0);

console.log("Os números pares do array são: ", pares);


//EXERCÍCIO 3
let quadrados= arrayDeNumeros.map(numero => numero * numero);

console.log("Os quadrados dos números do array são: ", quadrados);


//EXERCÍCIO 4
class Produto {
    constructor(nome, preco, quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    //EXERCÍCIO 5
    vender(quantidadeVendida) {
        if (quantidadeVendida > this.quantidade) {
            console.log("Estoque insuficiente.");
        } else {
            this.quantidade -= quantidadeVendida;
            
            console.log("Venda realizada: " + quantidadeVendida + " unidade(s) de " + this.nome + ".");
        }
    }

    //EXERCÍCIO 6
    repor(quantidadeReposta) {
        this.quantidade += quantidadeReposta;

        console.log("Reposição realizada: " + quantidadeReposta + " unidade(s) adicionada(s) ao estoque de " + this.nome + ".");
    }

    //EXERCÍCIO 7
    mostrarEstoque() {
        console.log("O produto " + this.nome.toUpperCase() + " possui " + this.quantidade + "unidade(s) em estoque.")
    }

    //EXERCÍCIO 8
    atualizarPreco(novoPreco) {
        this.preco = novoPreco;

        console.log("Preço atualizado: o produto " + this.nome + " teve seu valor alterado para " + this.preco.toFixed(2) + ".");
    }
}
