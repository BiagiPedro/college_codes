/******************************************************************************
Pedro Biagi Dias 12221BSI200
*******************************************************************************/
#include <stdio.h>
#include <stdlib.h>

int main()
{
    int x=10,i,aux,j;


    int vetor[10];

    for(i=0 ; i<x ;i++ ){
        printf("Digite um numero[%d]:",i+1);
        scanf("%d" , &vetor[i]);
            for(j=0; j<i ; j++){
                if(vetor[j] == vetor[i]){
                printf("Numero já escrito! Digite outro numero.\n");
                i--;
            }
        }
    }

    printf("Os numeros escritos foram\n");

    for(i=0 ; i<x ;i++){
    printf("%d ,",vetor[i]);
    }
    printf("\nOs numeros ordenados foram\n");

    for(i=0 ; i<x ; i++){
        for(j=i+1 ; j<x ; j++){
            if(vetor[j]<vetor[i]){
                aux = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = aux;
            }
        }

        printf("%d ,",vetor[i]);
    }

}
