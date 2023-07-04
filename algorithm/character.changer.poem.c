/******************************************************************************

Pedro Biagi Dias 12221BSI200
Joao Gabriel Santos 12221BSI2

*******************************************************************************/
#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>

int main() {
    char verso[9][30] = { "o sapo nao lava o pe",
                          "nao lava porque nao quer",
                          "ele mora la na lagoa",
                          "nao lava o pe porque nao quer",
                          "o sapo nao lava o pe",
                          "nao lava porque nao quer",
                          "ele mora la na lagoa",
                          "nao lava o pe porque nao quer",
                          "mas que chule" };
    char vogal;
    int cont,b;
    for( cont=0 ; cont<1 ; cont++){

        for(int b=0 ; b<1 ; b++){
            printf("Digite uma vogal minuscula ou f par sair: ");
            scanf(" %c", &vogal);
             if (vogal == 'f') {
                return 0;
            }

            if (vogal != 'a' && vogal != 'e' && vogal != 'i' && vogal != 'o' && vogal != 'u') {
                printf("\nAviso: caractere digitado nao eh uma vogal ou espaco.\n");
                b--;

            }
        }

        printf("\nVerso: \n");

        for (int i = 0; i < 9; i++){
            for (int j = 0; verso[i][j] != '\0'; j++){
                    if (verso[i][j] == 'a' || verso[i][j] == 'e' || verso[i][j] == 'i' || verso[i][j] == 'o' || verso[i][j] == 'u') {
                        printf("%c", vogal);
                    }
                    else{
                    printf("%c", verso[i][j]);
                    }
            }
            printf("\n");
        }
    cont--;
   }
}