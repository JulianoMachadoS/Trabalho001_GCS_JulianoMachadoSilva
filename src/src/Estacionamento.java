/**
 * Classe Estacionamento: Gerencia a alocacao das vagas (matriz).
 * Implementa as funcionalidades basicas de estacionar e exibir.
 */
public class Estacionamento{
    private int fila, vaga;
    private Carro [][] estacionamento;

    public Estacionamento(int fila, int vaga){
        this.fila = fila;
        this.vaga = vaga;
        this.estacionamento = new Carro[fila][vaga];
    }

    public void exibirEstacionamento() {
        System.out.println("\n--- MAPA DO ESTACIONAMENTO (" + fila + "x" + vaga + ") ---");

        for (int i = 0; i < estacionamento.length; i++) {
            System.out.print("Fila " + (i + 1) + ": ");

            for (int j = 0; j < estacionamento[i].length; j++) {

                if (estacionamento[i][j] == null) {
                    System.out.print("[ VAZIO ] ");
                } else {
                    System.out.print("[ " + estacionamento[i][j].getPlaca() + " ] ");
                }
            }
            System.out.println();
        }
        System.out.println("----------------------------------------");
    }

    public void estacionar(int linha, int coluna, Carro carro) {
        // Checagem de limites deve ser implementada para robustez, mas focaremos no requisito principal:
        if (estacionamento[linha][coluna] == null) {
            estacionamento[linha][coluna] = carro;
            System.out.println("Sucesso: " + carro.getNome() + " estacionado na fila " + (linha + 1 ) + ", vaga " + (coluna + 1) + ".");
        } else {
            System.out.println("Erro: a vaga " + (coluna + 1) + " da fila "+ (linha + 1) + " já está ocupada pelo carro " + estacionamento[linha][coluna].getPlaca() + "!");
        }
    }

    public String toString(){
        return "Estacionamento de " + fila + " linhas e " + vaga + " colunas, totalizando " + (vaga * fila) + " vagas.";
    }
    public boolean checkout(String placa) {
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < vaga; j++) {
                if (estacionamento[i][j] != null && estacionamento[i][j].getPlaca().equalsIgnoreCase(placa)) {

                    // Encontrado! Remove e informa.
                    String carroRemovido = estacionamento[i][j].getNome();
                    estacionamento[i][j] = null;

                    // *MENSAGEM DE SUCESSO MODIFICADA* - Ponto onde o conflito será criado depois
                    System.out.println("SUCESSO CHECKOUT: O carro " + carroRemovido + " de placa " + placa + " LIBEROU a vaga [" + (i + 1) + "][" + (j + 1) + "]");

                    return true;
                }
            }
        }
        System.out.println("ERRO CHECKOUT: Carro com placa " + placa + " nao encontrado no estacionamento.");
        return false;
    }
}