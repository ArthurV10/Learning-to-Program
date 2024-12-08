package entities;

public class Conta {
    private String numero;
    private float saldo;
    private int id;
    private Cliente cliente; // Associar Cliente como objeto

    public Conta(String numero, float saldo, int id) {
        this.numero = numero;
        this.saldo = saldo;
        this.id = id;
    }

    public Conta(String numero, float saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setCliente(Cliente cliente) { // Atualizado para receber um objeto Cliente
        this.cliente = cliente;
    }

    public Cliente getCliente() { // Adicionar método para acessar o cliente
        return this.cliente;
    }

    public void sacar(float valor) {
        if (valor > 0 && this.saldo >= valor) {
            this.saldo -= valor;
        } else {
            System.out.println("Saque inválido.");
        }
    }

    public void depositar(float valor) {
        if (valor > 0) {
            this.saldo += valor;
        } else {
            System.out.println("Depósito inválido.");
        }
    }

    public float consultarSaldo() {
        return this.saldo;
    }

    public void transferir(Conta contaDestino, float valor) {
        if (valor > 0 && this.saldo >= valor) {
            this.sacar(valor);
            contaDestino.depositar(valor);
        } else {
            System.out.println("Transferência inválida: saldo insuficiente ou valor negativo.");
        }
    }
}
