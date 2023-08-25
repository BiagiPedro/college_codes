/******************************************************************************

Pedro BIagi Dias

*******************************************************************************/
#include <stdio.h>
#include <stdlib.h>

int main()
{
   char nome[20] = "Jose Augusto";

   int len = strlen(nome);

   for (int i = 0 ; i< len ; i++){
    printf(" %c", *(nome+i));
   }


}
