#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define N 3

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define N 5 // Assuming N is a predefined constant

int main() {
    FILE **f = (FILE **)malloc(N * sizeof(FILE *));
    if (f == NULL) {
        printf("Memory allocation failure.");
        return 1;
    }

    char nomeBIN[30] = "trabalho4\\rev1.bin";
    for (int i = 0; i < N; i++) {
        nomeBIN[13] = '1' + i;
        f[i] = fopen(nomeBIN, "rb");
        if (f[i] == NULL) {
            printf("Failed to open file %s.\n", nomeBIN);
            exit(1);
        }
    }

    char c;
    float contPalavra = 1, contParagrafo = N;
    int tamAtual = 0, tamMaior = 0, tamMenor = 100;
    char maiorPalavra[100];
    char menorPalavra[100];
    char palavraAtual[100];
    char caractereAnterior;

    for (int i = 0; i < N; i++) {
        while ((c = fgetc(f[i])) != EOF) {
            if (c == ' ' || c == '\n' || c == '\t' || c == ',' || c == '.') {
                if (tamAtual > tamMaior) {
                    tamMaior = tamAtual;
                    strcpy(maiorPalavra, palavraAtual);
                    maiorPalavra[tamAtual] = '\0';
                }
                if (tamAtual > 0 && tamAtual < tamMenor) {
                    tamMenor = tamAtual;
                    strcpy(menorPalavra, palavraAtual);
                    menorPalavra[tamAtual] = '\0';
                }
                tamAtual = 0;
            } else {
                palavraAtual[tamAtual] = c;
                tamAtual++;
            }
            if (c == ' ')
                contPalavra++;

            if ((caractereAnterior == '\n' && c == '\t') || c == -1) {
                contParagrafo++;
            }
            caractereAnterior = c;
        }
    }

    float mediaPalavras = contPalavra / N;
    float mediaParagrafos = (float)contParagrafo / N;

    FILE *Relatorio = fopen("report.out", "w");
    if (Relatorio == NULL) {
        printf("Failed to open file.");
        exit(1);
    }

    fprintf(Relatorio, "1) Average number of words per review: %.1f\n", mediaPalavras);
    fprintf(Relatorio, "2) Average number of paragraphs per review: %.1f\n", mediaParagrafos);
    fprintf(Relatorio, "3) Longest word: %s\n", maiorPalavra);
    fprintf(Relatorio, "4) Shortest word: %s\n", menorPalavra);

    fclose(Relatorio);

    for (int i = 0; i < N; i++) {
        char nomeTXT[50];
        sprintf(nomeTXT, "trabalho4text/rev%d.txt", i + 1);
        FILE *fileTXT = fopen(nomeTXT, "w");
        if (fileTXT == NULL) {
            printf("Failed to open file %s.\n", nomeTXT);
            exit(1);
        }

        fseek(f[i], 0, SEEK_SET);

        char c;
        while ((c = fgetc(f[i])) != EOF) {
            fputc(c, fileTXT);
        }
        fclose(fileTXT);
    }

    for (int i = 0; i < N; i++) {
        fclose(f[i]);
    }
    free(f);

    return 0;
}
