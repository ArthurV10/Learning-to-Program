package entities;

public class CalculadoraCientifica extends Calculadora{

    public CalculadoraCientifica(double operator1, double operator2){
        super(operator1, operator2);
    }

    public double exponentiate(){
        return Math.pow(getOperator1(), 2);
    }
}
