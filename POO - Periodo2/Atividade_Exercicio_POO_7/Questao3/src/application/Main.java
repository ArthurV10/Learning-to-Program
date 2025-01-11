package application;
import entities.CalculadoraCientifica;

public class Main {
    public static void main(String[] args) {
        CalculadoraCientifica calculadora = new CalculadoraCientifica(1.3, 4);
        double resultSum = calculadora.sumNumber();
        double exponetiateOperator1 = calculadora.exponentiate();
        System.out.println("O resultado da soma é: " + resultSum);
        System.out.println("O resultado da exponenciação é: " + String.format("%.2f", exponetiateOperator1));
    }
}