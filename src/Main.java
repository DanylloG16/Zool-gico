import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Zoologico zoologico = new Zoologico();

        //método auxiliar que está declarado FORA do main.
        popularZoologico(zoologico);

        Scanner scanner = new Scanner(System.in);

        //aqui temos o menu que recebe a entrada dos dados e tratamos essa entrada com o switch case, uma estrutura de decisão.
        while (true) {
            System.out.println("========= MENU DO ZOOLÓGICO =========");
            System.out.println("1: Listar todos os animais");
            System.out.println("2: Iniciar Show Aéreo (apenas voadores)");
            System.out.println("3: Sair do programa");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    zoologico.listarAnimais();
                    break;
                case 2:
                    zoologico.iniciarShowAereo();
                    break;
                case 3:
                    System.out.println("Obrigado por visitar o zoológico!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
            System.out.println();
        }
    }


    //metodo responsavel por instanciar os objetos e criar os animais
    private static void popularZoologico(Zoologico zoologico) {
        System.out.println("Populando o zoológico com os animais iniciais...");

        Leao mufasa = new Leao("Mufasa", 8);
        Aguia falcao = new Aguia("Falcão", 3);
        Serpente jarara = new Serpente("Jarara", 2);

        zoologico.adicionarAnimal(mufasa);
        zoologico.adicionarAnimal(falcao);
        zoologico.adicionarAnimal(jarara);

        System.out.println("--------------------------------------------------");
    }
}