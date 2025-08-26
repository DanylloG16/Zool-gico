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
import java.io.IOException;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;


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

    public void salvarAnimais() {
        String nomeArquivo = "animais.json";
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("[\n");
        for (int i = 0; i < this.animais.size(); i++) {
            Animal animal = this.animais.get(i);
            String tipo = "";
            if (animal instanceof Leao) tipo = "LEAO";
            else if (animal instanceof Aguia) tipo = "AGUIA";
            else if (animal instanceof Serpente) tipo = "SERPENTE";
            jsonBuilder.append("\t{\n");
            jsonBuilder.append("\t\t\"tipo\": \"" + tipo + "\",\n");
            jsonBuilder.append("\t\t\"nome\": \"" + animal.getNome() + "\",\n");
            jsonBuilder.append("\t\t\"idade\": " + animal.getIdade() + "\n");
            jsonBuilder.append("\t}");
            //  aqui eu add uma vírgula depois do objeto caso n for o último da lista
            if (i < this.animais.size() - 1) {
                jsonBuilder.append(",\n");
            } else {
                jsonBuilder.append("\n");
            }
        }
        jsonBuilder.append("]");
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo))) {
            writer.print(jsonBuilder.toString());
            System.out.println("Animais salvos com sucesso");
        } catch (IOException e) {
            System.err.println("Erro ao salvar os animais " + e.getMessage());
        }
    }


    // No arquivo Zoologico.java
// Não se esqueça das importações no topo do arquivo!


    public void carregarAnimais() {
        String nomeArquivo = "animais.json";
        File arquivo = new File(nomeArquivo);
        if (!arquivo.exists()) {
            System.out.println("Arquivo 'animais.json' não encontrado. Começando um novo zoológico.");
            return;
        }
        try {
            String jsonCompleto = new String(Files.readAllBytes(Paths.get(nomeArquivo)));

            if (jsonCompleto.trim().isEmpty() || jsonCompleto.trim().equals("[]")) {
                return;
            }
            String conteudo = jsonCompleto.replace("\n", "").replace("\t", "");
            conteudo = conteudo.substring(1, conteudo.length() - 1).trim();

            String[] objetosAnimais = conteudo.split("\\},\\{");
            for (String animalJson : objetosAnimais) {
                String tipo = "";
                String nome = "";
                int idade = 0;
                animalJson = animalJson.replace("{", "").replace("}", "").trim();

                String[] atributos = animalJson.split(",");
                for (String atributo : atributos) {
                    String[] par = atributo.split(":");
                    String chave = par[0].trim().replace("\"", "");
                    String valor = par[1].trim().replace("\"", "");

                    if (chave.equals("tipo")) {
                        tipo = valor;
                    } else if (chave.equals("nome")) {
                        nome = valor;
                    } else if (chave.equals("idade")) {
                        idade = Integer.parseInt(valor);
                    }
                }
                Animal animal = null;
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
                    this.animais.add(animal);
                }
            }

            System.out.println("Animais carregados do arquivo JSON.");

        } catch (Exception e) {
            System.err.println("Erro ao carregar o arquivo : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
