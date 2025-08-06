public class Leao extends Animal{



    //aqui o construtor dessa classe pega como parametro os paramentros do outro construtor para instanciar o objeto
    public Leao(String nome, int idade){
        super( nome, idade);
    }


    // aqui fiquei com duvida pois no site da devmedia eles deram o exemplo chamando o override dentro do metodo, mas pedi ajuda para o gemini e ele
    // me explicou que overried é uma anotação


    @Override
    public void emitirSom(){
        System.out.println(getNome() + "o leão urge");
    }

}
