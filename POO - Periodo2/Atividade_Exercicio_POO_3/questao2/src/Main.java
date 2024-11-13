import java.util.Scanner;

public class Main {

    // Método com dois parâmetros
    public String pronomeTratamento(String nome, String pronome) {
        return pronome + " " + nome;
    }

    // Sobrecarga do método para pronome padrão
    public String pronomeTratamento(String nome) {
        return pronomeTratamento(nome, "Sr");
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Bom dia, como prefere ser chamado, Sr ou Sra: ");
        String pronome = scanner.nextLine();

        // Verifica se o pronome é válido
        if (!pronome.equalsIgnoreCase("Sr") &&
                !pronome.equalsIgnoreCase("Sra") &&
                !pronome.equalsIgnoreCase("senhor") &&
                !pronome.equalsIgnoreCase("senhora")) {
            pronome = null;  // Define pronome como nulo se não for válido
        }

        System.out.print("Além disso, qual seu nome: ");
        String nome = scanner.nextLine();

        // Verifica se o pronome é nulo e aplica o tratamento adequado
        String tratamentoCompleto;
        if (pronome == null) {
            tratamentoCompleto = main.pronomeTratamento(nome);
        } else {
            tratamentoCompleto = main.pronomeTratamento(nome, pronome);
        }

        System.out.printf("Olá, %s%n", tratamentoCompleto);

        scanner.close();
    }
}
