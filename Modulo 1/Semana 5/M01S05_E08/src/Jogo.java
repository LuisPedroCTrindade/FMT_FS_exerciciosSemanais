import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class Jogo {
    ArrayList<Jogador> listaJogadoresRegistrados = new ArrayList<>();
    Jogador jogadorAtual = null;
    Scanner scn = new Scanner(System.in);

    //ATRIBUTOS DO JOGO
    Jogador melhorJogador = null;
    int numeroJogosTotais = 0;


    public void criarNovoJogador() {
        System.out.println("**CRIANDO NOVO JOGADOR** \n");

        //RECEBENDO INFORMAÇÕES E VALIDANDO NOME
        System.out.print("Qual seu nome? ");
        String nomeNovoJogador = scn.nextLine();

        while (nomeJaRegistrado(nomeNovoJogador)) {
            System.out.println("Este nome já está em uso. Por favor, escolha outro nome.");
            System.out.print("Qual seu nome? ");
            nomeNovoJogador = scn.nextLine();
        }

        System.out.print("Qual a sua idade? ");
        int idadeNovoJogador = scn.nextInt();
        scn.nextLine(); //CONSOME A LINHA

        //INTANCIANDO E ADICIONANDO À LISTA
        listaJogadoresRegistrados.add(new Jogador(nomeNovoJogador, idadeNovoJogador));

        jogadorAtual = listaJogadoresRegistrados.get(listaJogadoresRegistrados.size() - 1);

        System.out.println("**BEM VINDO(A), " + nomeNovoJogador.toUpperCase() + "!** \n");
    }

    public void logarJogadorExistente(String nomeJogador) {
        melhorJogador = listaJogadoresRegistrados.get(listaJogadoresRegistrados.indexOf(nomeJogador));

        System.out.println("**BEM VINDO(A), " + nomeJogador.toUpperCase() + "!** \n");
    }

    public void jogar() {
        do {
            apresentarOpcoes();
            int inputJogada = scn.nextInt();
            int jogadaComp = gerarJogadaComputador();

            if (inputJogada > 0 && inputJogada <= 3) {
                adicionarJogada();
                jogadorAtual.adicionaTentativa();

                switch (compararJogadas(inputJogada, jogadaComp)) {
                    case 2:
                        System.out.println("Você jogou *" + nomeJogada(inputJogada).toUpperCase() + "*...");
                        System.out.println("O computador jogou *" + nomeJogada(jogadaComp).toUpperCase() + "*...");
                        System.out.println("EMPATOU! \n");
                        break;

                    case 1:
                        System.out.println("Você jogou *" + nomeJogada(inputJogada).toUpperCase() + "*...");
                        System.out.println("O computador jogou *" + nomeJogada(jogadaComp).toUpperCase() + "*...");
                        System.out.println("VOCÊ VENCEU! :) \n");
                        jogadorAtual.adicionaPontos(1);
                        break;

                    case 0:
                        System.out.println("Você jogou *" + nomeJogada(inputJogada).toUpperCase() + "*...");
                        System.out.println("O computador jogou *" + nomeJogada(jogadaComp).toUpperCase() + "*...");
                        System.out.println("VOCÊ PERDEU! :( \n");
                        break;

                    default:
                        break;
                }
                break;
            } else {
                informarOpcaoInvalida();
                scn.nextLine(); //consume o inválido
            }
        } while (true);
    }

    public void jogar(int num) {
        adicionarJogada();

        int numeroMisterioso = gerarNumeroAleatorio();

        System.out.println("Você chutou o número " + num + ".");
        System.out.println("O número misterioso era " + numeroMisterioso + ". \n");

        if (num == numeroMisterioso) {
            jogadorAtual.adicionaPontos(1);
            System.out.println("VOCÊ ACERTOU! :) \n");
        } else {
            System.out.println("Você errou... :( \n");
        }
    }

    private int gerarNumeroAleatorio() {
        Random numeroAleatorioGerado = new Random();

        return (int) numeroAleatorioGerado.nextInt(10) + 1;
    }

    private void adicionarJogada() {
        numeroJogosTotais++;
    }

    private void apresentarOpcoes() {
        System.out.println("SELECIONE SUA JOGADA: \n" +
                "- (1) - Pedra \n" +
                "- (2) - Papel \n" +
                "- (3) - Tesoura \n");
    }

    private int gerarJogadaComputador() {
        Random jogadaComputador = new Random();

        return (int) jogadaComputador.nextInt(3) + 1;
    }

    private String nomeJogada(int jogada) {
        String nomeJogada = "";

        switch (jogada) {
            case 1:
                nomeJogada = "Pedra";
                break;
            case 2:
                nomeJogada = "Papel";
                break;
            case 3:
                nomeJogada = "Tesoura";
                break;
        }
        return nomeJogada;
    }

    private int compararJogadas(int jogadaUsuario, int jogadaComputador) {
        if ((jogadaUsuario - jogadaComputador) == 0) {
            return 2;
        } else if (((jogadaUsuario - jogadaComputador) == 1) || (jogadaUsuario - jogadaComputador) == -2) {
            return 1;
        }
        return 0;
    }

    private ArrayList<Jogador> gerarRanking() {
        ArrayList<Jogador> rankingJogadores = new ArrayList<>();

        //COPIANDO A LISTA DE REGISTRADOS E REORDENANDO PARA GERAR O RANKING
        rankingJogadores.addAll(listaJogadoresRegistrados);
        rankingJogadores.sort(Comparator.comparingInt(Jogador::getPontuacao).reversed());

        if (rankingJogadores.isEmpty()) {
            melhorJogador = null;
        } else {
            melhorJogador = rankingJogadores.get(0);
        }
        return rankingJogadores;
    }

    public void exibirRankingTop10() {

        //PRINTANDO O RANKING
        System.out.println("---------------------------- \n " +
                "**TOP 10 JOGADORES** \n");
        for (int i = 0; i < gerarRanking().size(); i++) {
            if (i == 10) {
                break;
            }
            System.out.println((i + 1) + "º lugar - " + gerarRanking().get(i) + " (" + jogadorAtual.getPontuacao() + " pts.)");
        }
        System.out.println("----------------------");

        //PEGANDO INFORMAÇÕES DO JOGADOR ATUAL (ÚLTIMO JOGADOR REGISTRADO)
        String nomeJogadorAtual = jogadorAtual.getNome();
        int rankingJogadorAtual = gerarRanking().indexOf(jogadorAtual);

        //PRINTANDO INFORMAÇÕES DO JOGADOR ATUAL DEPOIS DO TOP 10
        System.out.println(nomeJogadorAtual + ", você está em " + (rankingJogadorAtual + 1) + "º lugar no ranking! \n");
    }

    public void exibirRankingCompleto() {

        //PRINTANDO O RANKING
        System.out.println("---------------------------- \n " +
                "**RANKING COMPLETO DE JOGADORES** \n");
        for (int i = 0; i < gerarRanking().size(); i++) {
            System.out.println((i + 1) + "º lugar - " + gerarRanking().get(i) + " (" + jogadorAtual.getPontuacao() + " pts.)");
        }
        System.out.println("----------------------");

        //PEGANDO INFORMAÇÕES DO JOGADOR ATUAL (ÚLTIMO JOGADOR REGISTRADO)
        String nomeJogadorAtual = jogadorAtual.getNome();
        int rankingJogadorAtual = gerarRanking().indexOf(jogadorAtual);

        //PRINTANDO INFORMAÇÕES DO JOGADOR ATUAL DEPOIS DO TOP 10
        System.out.println(nomeJogadorAtual + ", você está em " + (rankingJogadorAtual + 1) + "º lugar no ranking! \n");
    }

    public void exibirListaRegistrados() {
        System.out.println("---------------------------- \n " +
                "**LISTA DE JOGADORES REGISTRADOS** \n");
        for (int i = 0; i < listaJogadoresRegistrados.size(); i++) {
            System.out.println("Registro num. " + i + ": " + listaJogadoresRegistrados.get(i));
        }
        System.out.println("----------------------");
    }

    public boolean nomeJaRegistrado(String nome) {
        for (Jogador jogador : listaJogadoresRegistrados) {
            if (jogador.getNome().equalsIgnoreCase(nome)) {
                return true;
            }
        }
        return false;
    }

    private void informarOpcaoInvalida() {
        System.out.println("**OPÇÃO INVÁLIDA**");
    }
}
