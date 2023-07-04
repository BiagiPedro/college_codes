/******************************************************************************

Pedro Biagi Dias 12221BSI200

*******************************************************************************/
#include <stdlib.h>
#include <stdio.h>
#include <math.h>

int main()
{
    int tamanhoVetor;
    printf("Digite o tamanho do vetor: ");
    scanf("%d", &tamanhoVetor);
    float vetorA[tamanhoVetor];
    float vetorB[tamanhoVetor];
    for (int i = 0; i < tamanhoVetor; i++)
    {
        printf("\nDigite a posicao %d do primeiro vetor: ", i+1);
        scanf("%f", &vetorA[i]);
        vetorA[i] = fabsf(vetorA[i]);
    }
    for (int i = 0; i < tamanhoVetor; i++)
    {
        printf("\nDigite a posicao %d do segundo vetor: ", i+1);
        scanf("%f", &vetorB[i]);
        vetorB[i] = fabsf(vetorB[i]);
    }
    float chebyshev = 0;
    for (int i = 0; i < tamanhoVetor; i++)
    {
        chebyshev += fabsf(vetorA[i] - vetorB[i]);
    }

    printf("\nA distancia de chebyshev e: %f", chebyshev);
    return 0;
}
