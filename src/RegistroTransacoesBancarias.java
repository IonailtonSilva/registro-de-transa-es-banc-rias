import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegistroTransacoesBancarias {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Lê a entrada que informa o saldo inicial da conta
        double saldo = scanner.nextDouble();

        // Lê a entrada com a quantidade total de transações
        int quantidadeTransacoes = scanner.nextInt();

        // Lista para armazenar as transações
        List<String> transacoes = new ArrayList<>();

        // Loop para iterar sobre as transações
        for (int i = 1; i <= quantidadeTransacoes; i++) {
            // Lê a entrada com o tipo de transação (D para depósito ou S para saque)
            // O método "toUpperCase" padroniza o tipo de transação com a letra maiúscula
            char tipoTransacao = scanner.next().toUpperCase().charAt(0);

            // Lê a entrada com o valor da transação
            double valorTransacao = scanner.nextDouble();

            // Atualiza o saldo da conta e adiciona a transação à lista
            if (tipoTransacao == 'D') {
                saldo += valorTransacao;
                transacoes.add("Deposito de " + valorTransacao);
            } else if (tipoTransacao == 'S') {
                saldo -= valorTransacao;
                transacoes.add("Saque de " + valorTransacao);
            } else {
                System.out.println("Opção inválida. Utilize D para depósito ou S para saque.");
                i--; // Decrementa o índice para repetir a iteração
            }
        }

        // Exibe o saldo final e a lista de transações
        exibirSaldoFinalEListaDeTransacoes(saldo, transacoes);

        // Fecha o scanner para evitar vazamentos de recursos
        scanner.close();
    }

    public static void exibirSaldoFinalEListaDeTransacoes(double saldoFinal, List<String> transacoes) {
        System.out.printf("Saldo: %.1f\n", saldoFinal);
        System.out.println("Transacoes:");
        int contador = 1;
        for (String transacao : transacoes) {
            System.out.printf("%d. %s\n", contador++, transacao);
        }
    }
}