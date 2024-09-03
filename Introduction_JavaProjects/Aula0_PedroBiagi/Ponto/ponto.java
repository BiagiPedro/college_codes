package Ponto;
public class ponto {
    float x , y;

    public ponto(float x , float y){
        this.x = x;
        this.y = y;
    }

    float DistanciaEuclidiana(float x , float y){
        return (float) Math.sqrt(Math.pow((this.x - x), 2) + Math.pow((this.y - y), 2));
    }
}
