 package Ponto;

public class Ponto {
     private float x , y;

     public Ponto(float x , float y){
         this.x = x;
         this.y = y;
     }
     public void setX(float x){
         this.x = x;
         if(this.x < 0){
            System.out.println("numero x menor que 0,numero foi substituido");
            this.x = 0;
        }
     }

    public void setY( float y){
        this.y = y;
        if(this.y < 0){
            System.out.println("numero y menor que 0,numero foi substituido");
            this.y = 0;
        }
    }

     public void printarPontos(){
         System.out.println(this.x);
         System.out.println(this.y);

     }

    float distanciaEuclidiana(Ponto p){
        return (float) Math.sqrt(Math.pow((this.x - p.x), 2) + Math.pow((this.y - p.y), 2));
    }

}

