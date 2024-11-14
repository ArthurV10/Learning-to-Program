package entities;

public class Jogador {
    private int forca;
    private int nivel;
    private int pontosAtuais;

    public Jogador(int forca, int nivel, int pontosAtuais){
        this.forca = forca;
        this.nivel = nivel;
        this.pontosAtuais = pontosAtuais;
    }

    public int calcularAtaque(){
        return this.forca * this.nivel;
    }

    public void atacar(Jogador player){
        if (player.estaVivo()){
            player.pontosAtuais -= calcularAtaque();
        }
    }

    public boolean estaVivo(){
        return this.pontosAtuais > 0 ? true:false;
    }

    public String toString() {
        return "Atributos atuais/ Força = " + this.forca +
                " / Nível = " + this.nivel +
                " / Pontos Atuais = " + this.pontosAtuais;
    }

    public int verificarPontos(){
        return this.pontosAtuais;
    }
}
