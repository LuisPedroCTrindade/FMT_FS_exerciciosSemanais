import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Jogo {
    ArrayList<Jogador> listaJogadoresRegistrados = new ArrayList<>();
    Scanner scn = new Scanner(System.in);

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

        System.out.println("**BEM VINDO(A), " + nomeNovoJogador.toUpperCase() + "!** \n");
    }

    public void exibirRanking() {

        ArrayList<Jogador> rankingJogadores = new ArrayList<>();

        //COPIANDO A LISTA DE REGISTRADOS E REORDENANDO
        rankingJogadores.addAll(listaJogadoresRegistrados);
        rankingJogadores.sort(Comparator.comparingInt(Jogador::getPontuacao).reversed());

        //PRINTANDO O RANKING
        System.out.println("---------------------------- \n " +
                "**RANKING DE JOGADORES** \n");
        for (int i = 0; i < rankingJogadores.size(); i++) {
            if (i == 10) {
                break;
            }
            System.out.println(rankingJogadores.get(i) + " - " + (i + 1) + "º lugar");
        }
        System.out.println("----------------------");

        //PEGANDO INFORMAÇÕES DO JOGADOR ATUAL (ÚLTIMO JOGADOR REGISTRADO)
        String nomeJogadorAtual = listaJogadoresRegistrados.get(listaJogadoresRegistrados.size() - 1).getNome();
        int rankingJogadorAtual = rankingJogadores.indexOf(listaJogadoresRegistrados.get(listaJogadoresRegistrados.size() - 1));

        //PRINTANDO INFORMAÇÕES DO JOGADOR ATUAL DEPOIS DO TOP 10
        System.out.println(nomeJogadorAtual + ", você ficou em " + (rankingJogadorAtual + 1) + "º lugar no ranking!");
    }

    public void exibirListaRegistrados() {
        System.out.println("---------------------------- \n " +
                "**LISTA DE JOGADORES REGISTRADOS** \n");
        for (int i = 0; i < listaJogadoresRegistrados.size(); i++) {
            System.out.println("Registro num. " + i + ": " + listaJogadoresRegistrados.get(i));
        }
        System.out.println("----------------------");
    }

    private boolean nomeJaRegistrado(String nome) {
        for (Jogador jogador : listaJogadoresRegistrados) {
            if (jogador.getNome().equalsIgnoreCase(nome)) {
                return true;
            }
        }
        return false;
    }

    //EXPERIMENTAL
    /*public Jogador apontarJogadorRegistrado() {
        System.out.print("Qual o índice do jogador que deseja apontar? ");
        int indiceJogador = scn.nextInt();
        return listaJogadoresRegistrados.get(indiceJogador);
    }*/
}
