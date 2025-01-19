package entities;

public class Imposto extends Conta{
    private double taxaImposto = 0.5;

    public Imposto(String numero, double saldo, int id){
        super(numero, saldo, id);
    }

    public double getTaxaImposto(){
        return this.taxaImposto;
    }
}
