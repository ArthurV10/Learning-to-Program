package application;
import entities.Triangulo;

public class Main {
    public static void main(String[] args) {
        Triangulo triangulo1 = new Triangulo(3, 4, 5);
        System.out.println("Triângulo 1 é triângulo: " + triangulo1.ehTriangulo());
        System.out.println("Triângulo 1 é isósceles: " + triangulo1.ehIsoceles());
        System.out.println("Triângulo 1 é equilátero: " + triangulo1.ehEquilatero());
        System.out.println("Triângulo 1 é escaleno: " + triangulo1.ehEscaleno());
        System.out.println();

        Triangulo triangulo2 = new Triangulo(2, 2, 2);
        System.out.println("Triângulo 2 é triângulo: " + triangulo2.ehTriangulo());
        System.out.println("Triângulo 2 é isósceles: " + triangulo2.ehIsoceles());
        System.out.println("Triângulo 2 é equilátero: " + triangulo2.ehEquilatero());
        System.out.println("Triângulo 2 é escaleno: " + triangulo2.ehEscaleno());
        System.out.println();

        Triangulo triangulo3 = new Triangulo(2, 2, 3);
        System.out.println("Triângulo 3 é triângulo: " + triangulo3.ehTriangulo());
        System.out.println("Triângulo 3 é isósceles: " + triangulo3.ehIsoceles());
        System.out.println("Triângulo 3 é equilátero: " + triangulo3.ehEquilatero());
        System.out.println("Triângulo 3 é escaleno: " + triangulo3.ehEscaleno());
        System.out.println();

    }
}