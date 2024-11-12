package Application;

import Entities.Circulo;

public class Main {
    public static void main(String[] args) {
        Circulo circulo = new Circulo(5);

        double area = circulo.CalcularArea();
        double perimetro = circulo.CalcularPerimetro(); // Corrigido para chamar CalcularPerimetro()

        System.out.printf("Área do Círculo: %.2f\nPerímetro do Círculo: %.2f\n", area, perimetro);
    }
}
