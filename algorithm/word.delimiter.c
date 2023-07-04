/******************************************************************************
Pedro Biagi Dias 12221BSI200
*******************************************************************************/
#include <stdio.h>

int main()
{
    char str[100];
    int i,j,cont,x;

    printf("escreva a sua palavra\n");
    gets(str);
    for(cont=0 ; cont<1 ; cont++){

        printf("Escreva por onde quer comecar:\n");
        scanf("%d",&i);
        printf("escreva ate aonde quer escrever\n");
        scanf("%d" ,&j);
            if(i<0 || j<0){
                printf("numero negativo encontrado digite outros dois\n");
                cont--;
            }
    }


    if(i<j){
        x=j-i;
        for(cont=0 ; cont<=x ; cont++){
            printf("%c",str[i+cont]);
        }
    }
    if(i>j){
        x=i-j;
        for(cont=0 ; cont<=x ; cont++){
            printf("%c",str[i-cont]);
        }
    }

}