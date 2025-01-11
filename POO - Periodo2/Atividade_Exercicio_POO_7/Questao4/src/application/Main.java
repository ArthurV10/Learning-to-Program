package application;

import entities.*;

public class Main {
    public static void main(String[] args) {
        App app = new App("Banco Vieira");
        Banco banco = new Banco();
        banco.menuConta(app, banco);
    }
}

