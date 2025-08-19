package br.com.meuzoo;

import br.com.meuzoo.core.Zoologico;
import br.com.meuzoo.model.Aguia;
import br.com.meuzoo.model.Leao;
import br.com.meuzoo.model.Serpente;
import br.com.meuzoo.ui.ZoologicoUI;

public class Main {

    public static void main(String[] args) {

        //  Cria o objeto da lógica de negócio.
        // é o cerebro do nosso programa, guarda a lista de animais , adiciona os animais, faz todos animais emitirem sons, identifica quais animais podem voar
        // Ele não sabe nada sobre menus, opções ou o que o usuário digita. Ele só executa as ordens que recebe.
        Zoologico zoologico = new Zoologico();

            System.out.println("Populando o zoológico com os animais iniciais...");

            Leao mufasa = new Leao("Mufasa", 8);
            Aguia falcao = new Aguia("Falcão", 3);
            Serpente jarara = new Serpente("Jarara", 2);

            zoologico.adicionarAnimal(mufasa);
            zoologico.adicionarAnimal(falcao);
            zoologico.adicionarAnimal(jarara);
            System.out.println("--------------------------------------------------");


        //  Cria o objeto da interface do usuário, passando o zoológico para ele.
        // estamos conectando nossa UI com o nosso zoologico, é como usar um controle para controlar uma tv, ao inves de criarmos uma regra de negocio nova para o zoologicoui, usamos a logica que já existe
        ZoologicoUI ui = new ZoologicoUI(zoologico);

        // É ele que vai exibir o menu, esperar o usuário digitar, e quando o usuário escolher uma opção (como "Listar animais") o ui vai "apertar o botão" correspondente no zoologico chamando o método listarAnimais
        //  Inicia a interface do usuário. A partir daqui, a classe UI assume o controle.
        ui.iniciar();
    }
}