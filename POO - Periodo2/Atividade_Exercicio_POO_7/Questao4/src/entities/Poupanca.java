package entities;

public class Poupanca extends Conta {

    public Poupanca(String numero, float saldo, int id) {
        super(numero, saldo, id);
    }

    public void renderJuros(){
        float juros = getSaldo() * 0.01f;
        depositar(juros);
        System.out.println("Juros de R$" + juros + " aplicados à poupança " + getNumero());
    }
}
