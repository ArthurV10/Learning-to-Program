package entities;

public class Hora {
    private int hora;
    private int minuto;
    private int segundo;

    public Hora(int hora, int minuto, int segundo){
        if (segundo >= 60){
            minuto += segundo / 60;
            segundo = segundo % 60;
        }
        if (minuto >= 60){
            hora += minuto / 60;
            minuto = minuto % 60;
        }
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
    }

    public int getHora(){
        return hora;
    }

    public int getMinuto(){
        return minuto;
    }

    public int getSegundo(){
        return segundo;
    }

    public String formatHours(){
        return String.format("%02d:%02d:%02d", hora, minuto, segundo);
    }
}
