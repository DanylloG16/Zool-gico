public class Main {
    public static void main(String[] args) {


        Zoológico zoológico = new Zoológico();
        Leao mufasa = new Leao("mufasa", 8);
        Aguia falcao = new Aguia("Falcão", 3);
        Serpente jarara = new Serpente("jarara", 8);



        zoológico.adicionarAnimal(mufasa);
        zoológico.adicionarAnimal(falcao);
        zoológico.adicionarAnimal(jarara);

        zoológico.listarAnimais();


    }
}
