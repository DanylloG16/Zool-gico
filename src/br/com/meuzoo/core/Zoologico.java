package br.com.meuzoo.core;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import br.com.meuzoo.model.Animal;
import br.com.meuzoo.model.Aguia;
import br.com.meuzoo.model.Leao;
import br.com.meuzoo.model.Voavel;
import br.com.meuzoo.model.Serpente;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// a clase zoológico é uma composição, uma classe composta por outras, na logica um zoologico tem animais.

public class Zoologico {

    // nossa lista guarda qualquer item que seja um animal
    private List<Animal> animais;

    public Zoologico(){
        // sempre que um zoologico for criado, iniciamos com a lista vazia.
        this.animais = new ArrayList<>();
        System.out.println("está aberto");
        carregarAnimais();
    }

    //recebe qualque objeto que seja um filho de animal
    public void adicionarAnimal( Animal animal ){
        this.animais.add(animal);
        System.out.println(animal.getNome() + "foi adicionado ao zoológico");
    }

    public void listarAnimais(){
        System.out.println("-----animais do zoologico------");
        // passa por cada animal guardado na lista animal
        for(Animal animal : this.animais){
            System.out.println("nome=" + animal.getNome() + ", Idade=" + animal.getIdade());
            // faz o som baseado no anima que for indicado
            animal.emitirSom();
        }
    }

    // esse metodo verifica na nossa lista, todos os animais capazes de voar
    // se for capaz faz ele voar
    public void iniciarShowAereo(){
        System.out.println("-----------iniciando show aereo------------");
        for(Animal animal : this.animais){
            // aqui usei um conceito que testa se um objeto é uma instancia de um classe ou se ela implementa uma interface, nesse caso implementa a interface br.com.meuzoo.model.Voavel
            if(animal instanceof Voavel){
                // usamos o instanceof para verificar qual animal pode voar, se o animal puder, convertemos a variavel animal que é do tipo animal para o tipo voavel
                Voavel voador = (Voavel) animal;
                voador.voar();
            }
        }
        System.out.println("--- show aereo terminou! ---");
    }

    public void salvarAnimais(){
        //FileWriter cria o arquivo txt, se ele não existir ele cria,se existir ele prepara para ser sobrescrito.
        //o prinwriter "envelopa" o file Whiter e nos da ferramentas mais sofisticadas.
        // o try é responsavel por fechar todas as conexões, ele garante que assim que o bloco de codigo do try for executado, ele fechara automaticamente o writer
    try(PrintWriter writer = new PrintWriter(new FileWriter("animais.txt"))) {
        // passando por cada animal da lista
        for (Animal animal : this.animais) {
        //aqui verificamos se o animal é uma instancia das classes que herdam de "animal" e escrevemos a strig correta "LEAO","AGUIA"
            String tipo = "";
            if (animal instanceof Leao) tipo = "LEAO";
            else if (animal instanceof Aguia) tipo = "AGUIA";
            else if (animal instanceof Serpente) tipo = "SERPENTE";
            String linha = tipo + "," + animal.getNome() + "," + animal.getIdade();
            // o writer pega a linha que montamos e escreve no arquivo, pulando para a linha seguinte separando por virgulas
            writer.println(linha);
        }
            System.out.println("Animais salvos com sucesso!");
        // aqui criamos uma exceção para caso aconteça algum erro no salvamento e o catch é o nosso plano de contigencia
        } catch (IOException e) {
        // IOException pode acontecer se não tivermos permissão para escrever o arquivo, por exemplo.
        System.err.println("Erro ao salvar os animais: " + e.getMessage());
         }
    }


    public void carregarAnimais() {
        // aqui criamos uma conexão com nosso arquivo que criamos para ler o arquivo usando filereader
        //"envelopamos" o filereader com o bufferedreader
        // o try garante que a linha tudo seja finalizado apos a excecução do bloco de codigo inteiro dentro do try
        try (BufferedReader reader = new BufferedReader(new FileReader("animais.txt"))) {
            String linha;
            System.out.println("Carregando animais existentes...");
            // Lê o arquivo linha por linha
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(","); // Divide a linha pela vírgula
                if (partes.length == 3) {
                    String tipo = partes[0];
                    String nome = partes[1];
                    int idade = Integer.parseInt(partes[2]); // Converte o texto da idade para número

                    Animal animal = null;
                    // Usa o 'switch' para criar o objeto do tipo correto
                    switch (tipo) {
                        case "LEAO":
                            animal = new Leao(nome, idade);
                            break;
                        case "AGUIA":
                            animal = new Aguia(nome, idade);
                            break;
                        case "SERPENTE":
                            animal = new Serpente(nome, idade);
                            break;
                    }
                    if (animal != null) {
                        this.animais.add(animal); // Adiciona o animal carregado à lista
                    }
                }
            }
            System.out.println("Animais carregados.");
        } catch (IOException e) {
            // Se o arquivo ainda não existe, isso é normal na primeira vez que rodamos.
            System.out.println("Nenhum arquivo de animais encontrado. Começando um novo zoológico.");
        } catch (NumberFormatException e) {
            // Caso a idade no arquivo não seja um número válido.
            System.err.println("Erro ao ler a idade de um animal no arquivo.");
        }
    }
}
