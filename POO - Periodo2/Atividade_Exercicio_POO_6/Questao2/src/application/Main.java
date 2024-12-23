package application;

import entities.Hora;

public class Main {
    public static void main(String[] args) {
        // Criando uma instância da classe Hora
        Hora horario = new Hora(14, 5, 9);

        // Exibindo cada parte separadamente
        System.out.println("--- Detalhes do horário ---");
        System.out.println("Hora: " + horario.getHora()); // Esperado: 14
        System.out.println("Minuto: " + horario.getMinuto()); // Esperado: 5
        System.out.println("Segundo: " + horario.getSegundo()); // Esperado: 9

        // Exibindo o horário formatado
        System.out.println("\n--- Horário formatado ---");
        System.out.println("Horário: " + horario.formatHours()); // Esperado: 14:05:09

        // Criando um novo horário com ajustes automáticos
        Hora horarioAjustado = new Hora(23, 75, 3671);
        System.out.println("\n--- Novo Horário com Ajustes ---");
        System.out.println("Hora: " + horarioAjustado.getHora()); // Ajustado automaticamente
        System.out.println("Minuto: " + horarioAjustado.getMinuto()); // Ajustado automaticamente
        System.out.println("Segundo: " + horarioAjustado.getSegundo()); // Ajustado automaticamente
        System.out.println("Horário Ajustado: " + horarioAjustado.formatHours()); // Horário final formatado
    }
}
