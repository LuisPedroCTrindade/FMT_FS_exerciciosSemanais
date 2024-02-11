public class Jogador {

    //ATRIBUTOS
    private String nome;
    private int idade;
    private int pontuacao;
    private int numeroTentativas;

    //CONSTRUTOR
    Jogador(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
        pontuacao = 0;
        numeroTentativas = 0;
    }

    //MÉTODOS
    public void adicionaPontos(int numPontos) {
        pontuacao = this.pontuacao + numPontos;
    }

    public void perdePontos() {
    }

    public void adicionaTentativa() {
        this.numeroTentativas++;
    }

    //GETTERS e SETTERS
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public int getNumeroTentativas() {
        return numeroTentativas;
    }

    public void setNumeroTentativas(int numeroTentativas) {
        this.numeroTentativas = numeroTentativas;
    }

    //SOBRESCRITAS
    @Override
    public String toString(){
        return (this.nome + " (" + this.idade + ")" + " ---- " + this.pontuacao + "pts.");
    }
}
