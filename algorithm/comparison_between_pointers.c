#include <stdio.h>
#include <stdlib.h>

int main()
{
   int num1,num2;
   int *ponteiro1=&num1,*ponteiro2=&num2;

   printf("digite os dois numero para comparar\n");
   scanf("%d",ponteiro1);
   scanf("%d",ponteiro2);

   if(*ponteiro1 > *ponteiro2){
        printf("Numero %d maior que numero %d",*ponteiro1,*ponteiro2);
    }
    else if(*ponteiro1==*ponteiro2){
        printf("Numeros iguais");
    }
    else
         printf("Numero %d maior que numero %d",*ponteiro2,*ponteiro1);

}
