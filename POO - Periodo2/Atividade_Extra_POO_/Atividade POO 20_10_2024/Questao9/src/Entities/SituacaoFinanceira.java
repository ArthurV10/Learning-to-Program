package Entities;

public class SituacaoFinanceira {
    private double SaldoCreditos;
    private double SaldoDebitos;

    public SituacaoFinanceira(double SaldoCreditos, double SaldoDebito){
        this.SaldoDebitos = SaldoDebito;
        this.SaldoCreditos = SaldoCreditos;
    }

    public double getSaldoCreditos(){
        return SaldoCreditos;
    }

    public double getSaldoDebitos(){
        return SaldoDebitos;
    }

    public void setSaldoCreditos(double CreditoAdiconado){
        this.SaldoCreditos += CreditoAdiconado;
    }

    public void setSaldoDebitos(double DebitoAdiconado){
        this.SaldoDebitos += DebitoAdiconado;
    }

    public double calcularSaldo(){
        return Math.abs(SaldoCreditos - SaldoDebitos);
    }
}
