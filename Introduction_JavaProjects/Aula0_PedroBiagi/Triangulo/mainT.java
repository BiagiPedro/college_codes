package Triangulo;
import java.util.Scanner;

public class mainT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao = -1;
        int contador = 0;
        int indice = 0 ;
        int quantidade = 0;

        Triangulo vetorDeTriangulos[] = new Triangulo[10];
        Triangulo maior = null;

        while (opcao != 0) {
            System.out.println("1- inserir triangulo");
            System.out.println("2- mostrar triangulos cadastrados");
            System.out.println("3- mostrar numero de triangulos equilateros");
            System.out.println("4- MOstrar triangulo com maior perimetro");
            System.out.println("0- SAIR");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    if (contador == 9) {
                        System.out.println("Array cheio");
                        break;
                    }
                    System.out.println("Entre com l1");
                    int x = sc.nextInt();
                    System.out.println("Entre com l2");
                    int y = sc.nextInt();
                    System.out.println("Entre com l3");
                    int z = sc.nextInt();
                    Triangulo t1 = new Triangulo(x, y, z);
                    if(contador == 0) maior = t1;
                    vetorDeTriangulos[contador] = t1;
                    contador++;
                    break;
                case 2:
                    contador = 0;
                    while (vetorDeTriangulos[contador] != null) {
                        System.out.println(vetorDeTriangulos[contador]);
                        contador++;

                    }
                    break;

                case 3:
                    contador = 0;
                    while (vetorDeTriangulos[contador] != null){
                        if(vetorDeTriangulos[contador].retornaTipo() == "equilatero"){
                            quantidade++;
                        }
                    contador++;
                    }
                    System.out.println("----------"+quantidade);
                    break;

                case 4:
                    contador = 0;
                    while (vetorDeTriangulos[contador] != null) {
                        if(maior != null){
                            if (maior.calculaPerimetro() < vetorDeTriangulos[contador].calculaPerimetro()) {
                                maior = vetorDeTriangulos[contador];
                                indice= contador;
                            }
                            contador++;
                        }
                    }
                    System.out.println("triangulo "+(indice+1));
                    System.out.println(maior.calculaPerimetro());
                    break;
            }
        }
    }
}