/**
 * Classe Carro: Representa um veículo no sistema de estacionamento.
 * Contém os dados essenciais do veículo.
 */
public class Carro {
    private String nome; // Mudado de 'modelo' para 'nome' para bater com a App.java
    private String placa;
    private int ano;

    public Carro(String nome, String placa, int ano) {
        this.nome = nome;
        this.placa = placa;
        this.ano = ano;
    }

    // Getters essenciais
    public String getNome() {
        return nome;
    }

    public String getPlaca() {
        return placa;
    }

    // Representação do objeto para exibicao
    @Override
    public String toString() {
        return nome + " (" + placa + ")";
    }
}