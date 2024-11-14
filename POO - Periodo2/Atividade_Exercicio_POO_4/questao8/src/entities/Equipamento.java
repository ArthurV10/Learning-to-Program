package entities;

public class Equipamento {
    private boolean ligado;

    public Equipamento(boolean modo){
         this.ligado = modo;
    }
    public void liga(){
        if (this.ligado == true){
            ;
        }
        this.ligado = true;
    }

    public void desliga(){
        if (this.ligado == false){
            ;
        }
        this.ligado = false;
    }

    public void inverte(){
        this.ligado = !this.ligado;
    }

    public boolean estaLigado(){
        return this.ligado;
    }
}
