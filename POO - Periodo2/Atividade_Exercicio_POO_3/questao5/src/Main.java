public class Main {
    public void exibir(String... palavra){
        for (String print : palavra){
            System.out.printf("%s ",print);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Main main = new Main();

        main.exibir("a", "b");
        main.exibir("a", "b", "c");
        main.exibir("a", "b", "c", "d");
    }
}