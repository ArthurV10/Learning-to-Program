package application;
import entities.Calculadora;

public class Main {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora(1.3, 4);
        double resultSum = calculadora.sumNumber();
        System.out.println("O resultado da soma é: " + resultSum);
    }
}