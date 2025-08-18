
// a clase zoológico é uma composição, uma classe composta por outras, na logica um zoologico tem animais.

import java.util.ArrayList;
import java.util.List;

public class Zoologico {

    // nossa lista guarda qualquer item que seja um animal
    private List<Animal> animais;

    public Zoologico(){
        // sempre que um zoologico for criado, iniciamos com a lista vazia.
        this.animais = new ArrayList<>();
        System.out.println("está aberto");
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
            // aqui usei um conceito que testa se um objeto é uma instancia de um classe ou se ela implementa uma interface, nesse caso implementa a interface Voavel
            if(animal instanceof Voavel){
                // usamos o instanceof para verificar qual animal pode voar, se o animal puder, convertemos a variavel animal que é do tipo animal para o tipo voavel
                Voavel voador = (Voavel) animal;
                voador.voar();
            }
        }
        System.out.println("--- show aereo terminou! ---");
    }

}
//a