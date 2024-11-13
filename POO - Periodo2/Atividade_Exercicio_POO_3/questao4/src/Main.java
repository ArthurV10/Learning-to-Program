public class Main {
    public int soma(int number, Object randomParameter) {
        if (randomParameter instanceof Integer) {
            return number + (Integer) randomParameter;
        } else if (randomParameter instanceof String) {
            try {
                return number + Integer.parseInt((String) randomParameter);
            } catch (NumberFormatException e) {
                System.out.println("O parâmetro String não é um número válido.");
                return number;
            }
        } else if (randomParameter == null) {
            return number;
        } else {
            System.out.println("Tipo de parâmetro não suportado.");
            return number;
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.soma(1, 2));
        System.out.println(main.soma(1, "2"));
        System.out.println(main.soma(1, null));
    }
}
