package entities;

public class Calculadora {
    private double operator1;
    private double operator2;

    public Calculadora(double operator1, double operator2){
        this.operator1 = operator1;
        this.operator2 = operator2;
    }

    public void setOperator1(double operator1) {
        this.operator1 = operator1;
    }
    public void setOperator2(double operator2){
        this.operator2 = operator2;
    }

    public double sumNumber(){
        return operator1 + operator2;
    }
}
