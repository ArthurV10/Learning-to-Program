public class Main {

    public String toString(int parameter) {
        return String.valueOf(parameter);
    }

    public String colocarTraco(int[] listaNumeros) {
        StringBuilder newList = new StringBuilder();
        for (int i = 0; i < listaNumeros.length; i++) {
            if (i == listaNumeros.length - 1) {
                newList.append(toString(listaNumeros[i]));
            } else {
                newList.append(toString(listaNumeros[i])).append("-");
            }
        }
        return newList.toString();
    }

    public static void main(String[] args) {
        Main main = new Main();
        int[] list = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println("Colocando traços entre os números");
        String listComTracos = main.colocarTraco(list);
        System.out.printf("Lista com traços: %s%n", listComTracos);
    }
}
