package entities;

public class CarroEletrico extends Carro {
    private int autonomiaBateria;

    public CarroEletrico (String numeroPlaca, int numeroAno, String nomeModelo, int numeroAutonomiaBateria){
        super(numeroPlaca, numeroAno,nomeModelo);
        this.autonomiaBateria = numeroAutonomiaBateria;
    }
}
