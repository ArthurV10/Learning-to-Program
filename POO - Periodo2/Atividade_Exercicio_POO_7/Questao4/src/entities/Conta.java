package entities;

public class Conta {
    private String numero;
    private double saldo;
    private int id;
    private Cliente cliente;

    public Conta(String numero, double saldo, int id) {
        this.numero = numero;
        this.saldo = saldo;
        this.id = id;
    }

    public Conta(String numero, double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public int getId(){
        return this.id;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void sacar(double valor) {
        if (valor > 0 && this.saldo >= valor) {
            this.saldo -= valor;
        } else {
            System.out.println("Saque inválido.");
        }
    }

    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
        } else {
            System.out.println("Depósito inválido.");
        }
    }

    public double consultarSaldo() {
        return this.saldo;
    }

    public void transferir(Conta contaDestino, double valor) {
        if (valor > 0 && this.saldo >= valor) {
            this.sacar(valor);
            contaDestino.depositar(valor);
        } else {
            System.out.println("Transferência inválida: saldo insuficiente ou valor negativo.");
        }
    }
}
