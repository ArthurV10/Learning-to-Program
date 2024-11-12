package Entities;

public class Circulo {
    private double raio;
    private final double Pi = 3.14159;

    public Circulo(double raio) {
        this.raio = raio;
    }

    public Circulo() {
        this.raio = 1.0; // Valor padrão para raio
    }

    public double CalcularPerimetro() {
        return (2 * Pi * raio);
    }

    public double CalcularArea() {
        return (Math.pow(raio, 2.0) * Pi);
    }
}
