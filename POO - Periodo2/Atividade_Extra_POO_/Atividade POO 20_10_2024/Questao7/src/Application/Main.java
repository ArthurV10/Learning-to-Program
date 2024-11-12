package Application;
import entities.Retangulo;

public class Main {
    public static void main(String[] args) {

        Retangulo retangulo = new Retangulo(5.0, 3.0);

        double area = retangulo.calcularArea();
        System.out.println("Área do retângulo: " + area);

        double perimetro = retangulo.calcularPerimetro();
        System.out.println("Perímetro do retângulo: " + perimetro);
    }
}
