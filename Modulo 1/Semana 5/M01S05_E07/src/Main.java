import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Jogo jogo = new Jogo();


        boasVindas();

        jogo.criarNovoJogador();

        int input;

        do {
            exibirMenu();
            input = entrada.nextInt();

            switch (input) {
                case 1:
                    jogo.jogar();
                    break;

                case 2:
                    int numeroChute;

                    do {
                        System.out.println("Digite um número de 1 a 10 para tentar descobrir o número misterioso.");
                        numeroChute = entrada.nextInt();

                        if (numeroChute <= 0 || numeroChute > 10) {
                            exibirErroOpcaoInvalida();
                        }
                    } while (numeroChute <= 0 || numeroChute > 10);

                    jogo.jogar(numeroChute);
                    break;

                case 3:
                    jogo.exibirRanking();
                    break;

                case 0:
                    break;

                default:
                    exibirErroOpcaoInvalida();

            }
        } while (input != 0);


    }

    private static void boasVindas() {
        System.out.println("Olá, seja bem vindo ao sistema de jogos!");
        System.out.println("Vamos criar seu perfil de jogador para incluir no ranking...");
    }

    private static void exibirMenu() {
        System.out.println("**MENU PRINCIPAL**: \n" +
                "(1) - Jogar 'Pedra, Papel e Tesoura' \n" +
                "(2) - Jogar 'Número Misterioso' \n" +
                "--------------------------------- \n" +
                "(3) - Exibir ranking \n" +
                "(0) - SAIR.");
    }

    private static void exibirErroOpcaoInvalida() {
        System.out.println("**opção inválida** \n" +
                "SELECIONE UMA OPÇÃO VÁLIDA \n");
    }
}