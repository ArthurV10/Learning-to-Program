package Application;
import Entities.SituacaoFinanceira;

public class Main {
    public static void main(String[] args) {
        SituacaoFinanceira contaAleatoria = new SituacaoFinanceira(200, 100);
        System.out.printf("O saldo da conta é: %.2f", contaAleatoria.calcularSaldo());
    }
}