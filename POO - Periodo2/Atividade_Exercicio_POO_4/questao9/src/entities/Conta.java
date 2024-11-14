package entities;

public class Conta {
    private double saldo;

    // Construtor para inicializar o saldo
    public Conta(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            return true;
        }
        return false; // Saldo insuficiente ou valor inválido
    }

    public boolean depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            return true;
        }
        return false; // Valor inválido
    }

    public boolean transferir(Conta contaDestino, double valor) {
        if (this.sacar(valor)) { // Verifica se o saque na conta origem é bem-sucedido
            contaDestino.depositar(valor);
            return true;
        }
        return false; // Transferência falhou (saque na conta origem não foi satisfeito)
    }
}
