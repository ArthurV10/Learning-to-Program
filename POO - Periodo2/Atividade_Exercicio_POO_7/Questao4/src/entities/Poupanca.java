package entities;

public class Poupanca extends Conta {

    public Poupanca(String numero, double saldo, int id) {
        super(numero, saldo, id);
    }

    public void renderJuros(){
        double juros = getSaldo() * 0.01f;
        depositar(juros);
        System.out.println("Juros de R$" + juros + " aplicados à poupança " + getNumero());
    }
}
