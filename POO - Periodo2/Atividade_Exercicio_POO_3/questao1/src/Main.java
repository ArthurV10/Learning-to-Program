import java.util.Scanner;

public class Main {

    public boolean VerificarPar(int numero) {
        return numero % 2 == 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main main = new Main();

        System.out.print("Digite o número que deseja verificar se é par: ");
        int numero = scanner.nextInt();

        if (main.VerificarPar(numero)) {
            System.out.println("O número " + numero + " é par.");
        } else {
            System.out.println("O número " + numero + " é ímpar.");
        }
        scanner.close();
    }
}
