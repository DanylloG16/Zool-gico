package br.com.meuzoo.model;//nossa clase herda os comportamentos da classe animal e "é capaz de" voar pois ele é uma ave assim implementando/assinando o contrato da interface br.com.meuzoo.model.Voavel.

public class Aguia extends Animal implements Voavel {
    public Aguia
            (String nome, int idade){
        super (nome, idade);
    }

    @Override
    public void emitirSom(){
        System.out.println(getNome()+ "o aguia faz skeerr");
    }


    @Override
    public void voar() {
        System.out.println("A aguia" + getNome() + "esta voando");
    }




}
//a