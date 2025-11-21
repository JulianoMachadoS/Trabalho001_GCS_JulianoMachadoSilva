public class App {
    public static void main(String[] args) {

        System.out.println("Bem-vindo ao Sistema de Estacionamento!");

        Carro c1 = new Carro("Fusca", "ABC-1234", 1981);
        Carro c2 = new Carro("Civic", "QWE-9876", 2020);
        Carro c3 = new Carro("Gol", "RTY-5555", 2015);

        Estacionamento e1 = new Estacionamento(3,4);
        System.out.println(e1.toString());

        e1.estacionar(0, 0, c1);
        e1.estacionar(1, 2, c2);
        e1.estacionar(2, 3, c3);

        e1.exibirEstacionamento();

        Carro c4 = new Carro("Uno", "XYZ-1111", 2000);
        e1.estacionar(0, 0, c4); // Tentativa em vaga ocupada
        e1.checkout("QWE-9876");
    }
}