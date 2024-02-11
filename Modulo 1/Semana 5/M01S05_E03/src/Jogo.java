import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Jogo {
    ArrayList<Jogador> listaJogadoresRegistrados = new ArrayList<>();
    Scanner scn = new Scanner(System.in);

    public void criarNovoJogador() {
        System.out.println("**CRIANDO NOVO JOGADOR** \n");

        //RECEBENDO INFORMAÇÕES
        System.out.print("Qual seu nome? ");
        String nomeNovoJogador = scn.nextLine();

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

        System.out.println("---------------------------- \n " +
                "**RANKING DE JOGADORES** \n");
        for (int i = 0; i < rankingJogadores.size(); i++) {
            System.out.println((i+1) + " - " + rankingJogadores.get(i));
        }
        System.out.println("----------------------");
    }

    public void exibirListaRegistrados() {
        System.out.println("---------------------------- \n " +
                "**LISTA DE JOGADORES REGISTRADOS** \n");
        for (int i = 0; i < listaJogadoresRegistrados.size(); i++) {
            System.out.println("Registro num. " + i + ": " + listaJogadoresRegistrados.get(i));
        }
        System.out.println("----------------------");
    }

    //EXPERIMENTAL
    /*public Jogador apontarJogadorRegistrado() {
        System.out.print("Qual o índice do jogador que deseja apontar? ");
        int indiceJogador = scn.nextInt();
        return listaJogadoresRegistrados.get(indiceJogador);
    }*/
}
