package entities;

public class Calculadora {
    private float operating1;
    private float operating2;

    public Calculadora(){
        this.operating1 = 0;
        this.operating2 = 0;
    }

    public Calculadora(float operating1, float operating2){
        this.operating1 = operating1;
        this.operating2 = operating2;
    }

    public void setOperation1(float number){
        this.operating1 = number;
    }

    public void setOperation2(float number){
        this.operating2 = number;
    }

    public float sum(){
        return operating1 + operating2;
    }

    public float subtraction(){
        return operating1 - operating2;
    }	
}
