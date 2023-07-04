/******************************************************************************
Pedro Biagi Dias 12221BSI200
*******************************************************************************/
#include <stdio.h>
#include <stdlib.h>

int main()
{
    int matrizA[10][5] = {{1, 2, 3, 4, 5},
                          {1, 2, 3, 4, 5},
                          {1, 2, 3, 4, 5},
                          {1, 2, 3, 4, 5},
                          {1, 2, 3, 4, 5},
                          {1, 2, 3, 4, 5},
                          {1, 2, 3, 4, 5},
                          {1, 2, 3, 4, 5},
                          {1, 2, 3, 4, 5},
                          {1, 2, 3, 4, 5}};
    int matrizB[5][10];

    for (int linhaMatrizB = 0; linhaMatrizB < 5; linhaMatrizB++)
    {
        for (int colunaMatrizB = 0; colunaMatrizB < 10; colunaMatrizB++)
        {
            matrizB[linhaMatrizB][colunaMatrizB] = matrizA[colunaMatrizB][linhaMatrizB];
            printf(" %d", matrizB[linhaMatrizB][colunaMatrizB]);
        }
        printf("\n");
    }
    return 0;
}