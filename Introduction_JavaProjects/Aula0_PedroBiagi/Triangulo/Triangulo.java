package Triangulo;
public class Triangulo {

    int l1 , l2 , l3;

    public Triangulo(int l1 , int l2 , int l3){
        this.l1 = l1;
        this.l2 = l2;
        this.l3 = l3;
    }

    int calculaPerimetro(){
        return l1 + l2 +l3 ;
    }

    int retornaL1(){
        return l1;
    }

    int retornaL2(){
        return l2;
    }

    int retornaL3(){
        return l3;
    }


    String retornaTipo(){
        if ((l1==l2)&&(l2==l3))
            return "equilatero";
        else if ((l1 == l2) || (l2 == l3) || (l1 == l3))
            return "isosceles";
        return "escaleno";
    }
}

