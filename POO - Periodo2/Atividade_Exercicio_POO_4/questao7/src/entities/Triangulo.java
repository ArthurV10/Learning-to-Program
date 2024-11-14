package entities;

public class Triangulo {
    private int lado1;
    private int lado2;
    private int lado3;

    // Construtor para inicializar os lados do triângulo
    public Triangulo(int lado1, int lado2, int lado3) {
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }

    // Método que verifica se os lados formam um triângulo
    public boolean ehTriangulo() {
        return (Math.abs(this.lado2 - this.lado3) < this.lado1) && (this.lado1 < (this.lado2 + this.lado3)) &&
                (Math.abs(this.lado1 - this.lado3) < this.lado2) && (this.lado2 < (this.lado1 + this.lado3)) &&
                (Math.abs(this.lado1 - this.lado2) < this.lado3) && (this.lado3 < (this.lado1 + this.lado2));
    }

    // Método que verifica se o triângulo é isósceles
    public boolean ehIsoceles() {
        if (!ehTriangulo()) {
            return false;
        }
        return (lado1 == lado2 && lado1 != lado3) ||
                (lado1 == lado3 && lado1 != lado2) ||
                (lado2 == lado3 && lado2 != lado1);
    }

    // Método que verifica se o triângulo é equilátero
    public boolean ehEquilatero() {
        if (!ehTriangulo()) {
            return false;
        }
        return lado1 == lado2 && lado2 == lado3;
    }

    // Método que verifica se o triângulo é escaleno
    public boolean ehEscaleno() {
        if (!ehTriangulo()) {
            return false;
        }
        return lado1 != lado2 && lado1 != lado3 && lado2 != lado3;
    }
}
