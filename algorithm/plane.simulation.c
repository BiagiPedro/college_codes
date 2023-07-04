/******************************************************************************

Pedro Biagi Dias 12221BSI200

*******************************************************************************/
#include <stdio.h>
#include <stdlib.h>

int main()
{

    struct aviao{
    char nome[20];
    int pot;
    int num;
    int peso;

    };
    struct aviao A[10],B,C;

    for(int i=0 ; i<10 ; i++){
      printf("\n\nInformacoes do aviao %d\n\n",(i+1));
      printf("Digite o nome do aviao:\n");
      gets(A[i].nome);setbuf(stdin,NULL);
      printf("Digite a potencia do aviao(em Kgf):\n");
      scanf("%d",&A[i].pot);setbuf(stdin,NULL);
      printf("Escreva a quantidade de passageiros\n");
      scanf("%d",&A[i].num);setbuf(stdin,NULL);
      printf("Escreva a capacidade de carga (em toneladas) do aviao\n");
      scanf("%d",&A[i].peso);setbuf(stdin,NULL);
    }

    for(int i=0 ; i<10 ; i++){
        for(int j=0 ; j<10 ; j++){
            if(A[j].peso > A[i].peso){
                B= A[i];
                A[i] = A[j];
                A[j] = B;
            }
        }
    }

    for(int i=0 ; i<10 ; i++){
        if(i==0){
           C = A[i];
        }
        if(A[i+1].num < A[i].num){
            C= A[i+1];
        }
    }

     for(int i=0 ; i<10 ; i++){
        printf("%s",A[i].nome);setbuf(stdin,NULL);
        printf(" %d %d %d\n",A[i].pot,A[i].num,A[i].peso);
    }

    printf("O aviao com o menor numero de passageiro eh:%s",C.nome);
};
