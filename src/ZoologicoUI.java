// A única responsabilidade dela será gerenciar a tela, o menu e a comunicação com o usuário.

import java.util.Scanner;

public class ZoologicoUI {

    private Zoologico zoologico;
    private Scanner scanner;


    public ZoologicoUI(Zoologico zoologico){
        this.zoologico = zoologico;
        this.scanner = new Scanner(System.in);
    }


    // metodo responsavel por "inicar" toda nosso menu
    public void iniciar(){
        popularZoologico(zoologico);
        while (true){
            exibirMenu();
            int opcao = lerOpcao();
            processarOpcao(opcao);
            if (opcao==3){
                break;
            }
        }

    }

    //recebe os inputs
    private int lerOpcao() {
        return scanner.nextInt();
    }

    //metodo responsavel por gerenciar os inputs do usuario que ele ve no exibir menu
    private void processarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                zoologico.listarAnimais();
                break;
            case 2:
                zoologico.iniciarShowAereo();
                break;
            case 3:
                System.out.println("Obrigado por visitar o zoológico!");
                scanner.close(); // Fecha o scanner
                break;
            case 4:
                criarAnimalPeloUsuario();
                break;
            default:
                System.out.println("Opção inválida! Tente novamente.");
                break;
        }
    }


     // cria o menu visual
    public void exibirMenu(){

        System.out.println("========= MENU DO ZOOLÓGICO =========");
        System.out.println("1: Listar todos os animais");
        System.out.println("2: Iniciar Show Aéreo (apenas voadores)");
        System.out.println("3: Sair do programa");
        System.out.println("4: Adicionar um animal");

        System.out.print("Escolha uma opção: ");
    }


    // instancia os objetos e cria os animais usando o metodo adicionarAnimal
    private void popularZoologico(Zoologico zoologico) {
        System.out.println("Populando o zoológico com os animais iniciais...");

        Leao mufasa = new Leao("Mufasa", 8);
        Aguia falcao = new Aguia("Falcão", 3);
        Serpente jarara = new Serpente("Jarara", 2);

        this.zoologico.adicionarAnimal(mufasa);
        this.zoologico.adicionarAnimal(falcao);
        this.zoologico.adicionarAnimal(jarara);
        System.out.println("--------------------------------------------------");
    }


    // metodo que recebe os inputs do usuario e cria os animais de forma dinamica
    public void criarAnimalPeloUsuario(){
        System.out.println("\n--- Adicionar Novo Animal ---");
        System.out.print("Qual tipo de animal? (1-Leão, 2-Águia, 3-Serpente): ");
        int tipo = scanner.nextInt();

        System.out.print("Qual o nome do animal? ");
        String nome = scanner.next();

        System.out.print("Qual a idade do animal? ");
        int idade = scanner.nextInt();

        switch (tipo) {
            case 1:
                Leao novoLeao = new Leao(nome, idade);
                this.zoologico.adicionarAnimal(novoLeao);
                break;
            case 2 : Aguia novaAguia = new Aguia(nome, idade);
                    this.zoologico.adicionarAnimal(novaAguia);
                    break;
            case 3: Serpente novaSerpente = new Serpente(nome, idade);
                this.zoologico.adicionarAnimal(novaSerpente);
                break;
            default:
                System.out.println("Opção inválida! Tente novamente.");
                break;
        }
    }
}
