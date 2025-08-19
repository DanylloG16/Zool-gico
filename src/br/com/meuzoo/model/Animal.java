package br.com.meuzoo.model;

public abstract class Animal {

    //variaveis que guardamos os valores
    private String nome;
    private int idade;

    //contrutor que criei para definir como o objeto deve ser instanciado, porem poderia ter colocado mais de um construtor caso tivesse necessidade
    public Animal(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome(){
        return nome;
    }

    public int getIdade(){
        return idade;
    }

    // metodo abastrato, não pode ter parametros e nem logica, ele será chamado na classe filha e receberá parametros e uma instrução,
    // na verdade deve receber instrução pois senão vira um metodo abstrato
    public abstract void emitirSom();










}
