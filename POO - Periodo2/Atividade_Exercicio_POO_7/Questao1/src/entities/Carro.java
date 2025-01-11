package entities;

import java.util.Date;

public class Carro extends Veiculo {
    private String modelo;

    public Carro (String numeroPlaca, int numeroAno, String nomeModelo){
        super(numeroPlaca, numeroAno);
        this.modelo = nomeModelo;
    }
}
