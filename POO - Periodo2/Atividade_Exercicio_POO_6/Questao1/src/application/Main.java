package application;

import entities.Calculadora;

public class Main {
    public static void main(String[] args) {
        // Testando o construtor padrão
        Calculadora calc1 = new Calculadora();
        System.out.println("--- Testando o construtor padrão ---");
        System.out.println("Soma (default): " + calc1.sum()); // Esperado: 0.0
        System.out.println("Subtração (default): " + calc1.subtraction()); // Esperado: 0.0

        // Testando o construtor parametrizado
        Calculadora calc2 = new Calculadora(10.5f, 5.3f);
        System.out.println("\n--- Testando o construtor parametrizado ---");
        System.out.println("Soma: " + calc2.sum()); // Esperado: 15.8
        System.out.println("Subtração: " + calc2.subtraction()); // Esperado: 5.2

        // Testando os métodos setters
        calc2.setOperation1(20.0f);
        calc2.setOperation2(7.0f);
        System.out.println("\n--- Testando os métodos setters ---");
        System.out.println("Nova soma: " + calc2.sum()); // Esperado: 27.0
        System.out.println("Nova subtração: " + calc2.subtraction()); // Esperado: 13.0
    }
}
