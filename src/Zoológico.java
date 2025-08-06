
// a clase zoológico é uma composição, uma classe composta por outras, na logica um zoologico tem animais.

import java.util.ArrayList;
import java.util.List;

public class  Zoológico {

    // nossa lista guarda qualquer item que seja um animal
    private List<Animal> animais;

    public Zoológico(){
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
            System.out.println("nome" + animal.getNome() + ", Idade" + animal.getIdade());
            // faz o som baseado no anima que for indicado
            animal.emitirSom();
        }

    }

}
