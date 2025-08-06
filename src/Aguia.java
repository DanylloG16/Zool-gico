public class Aguia extends Animal{
    public Aguia(String nome, int idade){
        super (nome, idade);
    }

    @Override
    public void emitirSom(){
        System.out.println(getNome()+ "o aguia faz skeerr");
    }



}
