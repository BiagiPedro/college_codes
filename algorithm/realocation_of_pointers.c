#include <stdio.h>
#include <stdlib.h>

int main()
{
   int numi=10,*ponteiroi =&numi;
   float numf=12.5,*ponteirof = &numf;
   char numc, *ponteiroc = &numc;

   printf("Digite os novos valores:\n");
   scanf("%d",ponteiroi);
   scanf("%f",ponteirof);
   scanf(" %c",ponteiroc);

   printf("As variaeis digitadas foram: %d %.2f %c",*ponteiroi,*ponteirof,*ponteiroc);


}
