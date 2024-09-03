import java.util.Scanner;

public class Mainr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pontoX0 , pontoY0 , pontoX1 , pontoY1;
        System.out.println("Escreva as coordenadas do ponto x");
        pontoX0 = sc.nextInt();
        pontoY0 = sc.nextInt();
        System.out.println("Escreva as coordenadas do ponto y");
        pontoX1 = sc.nextInt();
        pontoY1 = sc.nextInt();
        Reta reta1 = new Reta(pontoX0, pontoY0,pontoX1 ,pontoY1);

        System.out.println("Escreva as coordenadas do ponto x");
        pontoX0 = sc.nextInt();
        pontoY0 = sc.nextInt();
        System.out.println("Escreva as coordenadas do ponto y");
        pontoX1 = sc.nextInt();
        pontoY1 = sc.nextInt();
        Reta retaT = new Reta(pontoX0, pontoY0,pontoX1 ,pontoY1);
        
        reta1.stringEq();
        retaT.stringEq();


        System.out.println(reta1.intersecao(retaT));


        pontoX1 = sc.nextInt();
        pontoY1 = sc.nextInt();

        reta1.ehdaReta(pontoX1,pontoY1);




    }
}
