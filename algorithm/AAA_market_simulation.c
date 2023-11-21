#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int Menu() // funcao que imprime o menu e retorna a opcao escolhida
{
    int op;
    printf("=============================\n");
    printf("            MENU\n");
    printf("=============================\n");
    printf("[1] Inicializacao do Sistema:\n");
    printf("[2] Catalogo do Sistema:\n");
    printf("[3] Catalogo de Filiais:\n");
    printf("[4] Inserir Venda de um Produto/Trimestre:\n");
    printf("[5] Inserir Venda de um Produto/Filial:\n");
    printf("[6] Produto Mais Vendido por Filial:\n");
    printf("[7] Filial que Mais Vende por Trimestre:\n");
    printf("[8] Produto Mais Vendido:\n");
    printf("[9] Filial que Mais Vende:\n");
    printf("[10] Melhor Trimestre:\n");
    printf("[11] Inserir Novo Produto:\n");
    printf("[12] Inserir Nova Filial:\n");
    printf("[13] Remover Produto:\n");
    printf("[14] Produdo que Mais Vende por Trimestre[EXTRA]:\n");
    printf("[15] Inserir Venda de uma Filial/Trimestre[EXTRA]:\n");
    printf("[0] Sair:\n");
    printf("=============================\n");
    printf("Selecionar: ");
    setbuf(stdin, NULL);
    scanf("%d", &op);
    return op;
}

int main()
{
    int opcao;
    do
    {
        opcao = Menu(); // chama a funcao menu e atribtui a opcao escolhida
        switch (opcao)  // executa a opcao escolhida
        {
        case 1:
            printf("\n==== Inicializacao do Sistema ====\n");

            int nroProdutos, nroFiliais;
            setbuf(stdin, NULL);
            printf("Numero de produtos: ");
            scanf("%d", &nroProdutos);
            while (nroProdutos < 1) // limita o numero de produtos menores que zero
            {
                printf("Numero de produtos!! Digite outro: ");
                scanf("%d", &nroProdutos);
            }
            setbuf(stdin, NULL);
            printf("Numero de filiais: ");
            scanf("%d", &nroFiliais);
            while (nroFiliais < 1) // limita o numero de filiais menores que zer
            {
                printf("Numero de filiais!! Digite outro: ");
                scanf("%d", &nroFiliais);
            }

            // cria uma matriz[nroProdutos][nroFiliais][trimestre]
            int ***pMat = (int ***)malloc(nroProdutos * sizeof(int **));
            for (int i = 0; i < nroProdutos; i++)
            {
                pMat[i] = (int **)malloc(nroFiliais * sizeof(int *));
                for (int j = 0; j < nroFiliais; j++)
                    pMat[i][j] = (int *)malloc(4 * sizeof(int));
            }
            // zera as posicoes da matriz
            for (int i = 0; i < nroProdutos; i++)
                for (int j = 0; j < nroFiliais; j++)
                    for (int k = 0; k < 4; k++)
                        pMat[i][j][k] = 0;
            break;

        case 2:
            printf("\n==== Catalogo do Sistema ====\n");

            // Cria um vetor para armazenar o nome dos produtos
            char **catalogoProdutos = (char **)malloc(nroProdutos * sizeof(char *));
            for (int i = 0; i < nroProdutos; i++)
                catalogoProdutos[i] = (char *)malloc(20 * sizeof(char));

            // Le o nome de cada produto
            for (int i = 0; i < nroProdutos; i++)
            {
                printf("Produto %d: ", i + 1);
                scanf("%s", catalogoProdutos[i]);
            }
            break;

        case 3:
            printf("\n==== Catalogo de Filiais ====\n");

            // Cria um vetor para armazenar o nome das filiais
            char **catalogoFiliais = (char **)malloc(nroFiliais * sizeof(char *));
            for (int i = 0; i < nroFiliais; i++)
                catalogoFiliais[i] = (char *)malloc(20 * sizeof(char));

            // Le o nome de cada filial
            for (int i = 0; i < nroFiliais; i++)
            {
                printf("Filial %d: ", i + 1);
                scanf("%s", catalogoFiliais[i]);
            }
            break;

        case 4:
            printf("\n==== Venda de um Produto/Trimestre ====\n");

            int tri, aux = -1;
            char nomeProduto[20];
            setbuf(stdin, NULL);
            printf("Trimestre(1 a 4): ");
            scanf("%d", &tri);
            while (tri < 1 || tri > 4) // limita o numero de trimestres de 0 a 4
            {
                printf("Trimestre Invalido!! Digite novamente (1 a 4): ");
                scanf("%d", &tri);
            }

            printf("Nome do produto: ");
            do
            {
                setbuf(stdin, NULL);
                scanf("%s", nomeProduto);

                // Procura no catalogo de produtos o produto escolhido
                for (int i = 0; i < nroProdutos; i++)
                    if (strcmp(catalogoProdutos[i], nomeProduto) == 0)
                    {
                        aux = i; // Quando encontrado, aux recebe a posicao do produto no catalogo
                        break;
                    }

                if (aux == -1)
                    printf("Produto nao encontrado!Digite outro: ");
            } while (aux == -1); // repete ate que seja digitado um produto existente

            printf("\n");
            for (int j = 0; j < nroFiliais; j++)
            {
                printf("Vendas do produto %s, no trimestre %d, da filial %s: ", nomeProduto, tri, catalogoFiliais[j]);
                scanf("%d", &pMat[aux][j][tri - 1]); // atribui as vendas na matriz
            }

            break;

        case 5:
            printf("\n==== Venda de um Produto/Filial ====\n");

            int auxj = -1;
            aux = -1;
            char nomeFilial[20];
            printf("Nome da filial: ");
            do
            {
                setbuf(stdin, NULL);
                scanf("%s", nomeFilial);

                // Procura no catalogo de filiais a filial escolhida
                for (int j = 0; j < nroFiliais; j++)
                    if (strcmp(catalogoFiliais[j], nomeFilial) == 0)
                    {
                        auxj = j; // Quando encontrado, auxj recebe a posicao da filial no catalogo
                        break;
                    }
                if (auxj == -1)
                    printf("Filial nao encontrada!Digite outra: ");
            } while (auxj == -1); // repete ate que seja digitado uma filial existente

            printf("\nNome do produto: ");
            do
            {
                setbuf(stdin, NULL);
                scanf("%s", nomeProduto);

                // Procura o indice do produto no catalogo de produtos
                for (int i = 0; i < nroProdutos; i++)
                    if (strcmp(catalogoProdutos[i], nomeProduto) == 0)
                    {
                        aux = i; // Quando encontrado, aux recebe a posicao do produto no catalogo
                        break;
                    }
                if (aux == -1)
                    printf("Produto nao encontrado!Digite outro: ");
            } while (aux == -1); // repete ate que seja digitado um produto existente

            printf("\n");
            for (int i = 0; i < 4; i++)
            {
                printf("Vendas do produto %s, da filial %s, no trimestre %d: ", nomeProduto, nomeFilial, i + 1);
                scanf("%d", &pMat[aux][auxj][i]); // atribui as vendas na matriz
            }
            break;

        case 6:
            printf("\n==== Produto Mais Vendido por Filial ====\n");

            auxj = -1;
            printf("Nome da filial: ");
            do
            {
                setbuf(stdin, NULL);
                scanf("%s", nomeFilial);

                // Procura no catalogo de filiais a filial escolhida
                for (int j = 0; j < nroFiliais; j++)
                    if (strcmp(catalogoFiliais[j], nomeFilial) == 0)
                    {
                        auxj = j; // Quando encontrado, auxj recebe a posicao da filial no catalogo
                        break;
                    }
                if (auxj == -1)
                    printf("Filial nao encontrada!Digite outra: ");
            } while (auxj == -1); // repete ate que seja digitado uma filial existente

            int *pSoma = (int *)calloc(nroProdutos, sizeof(int)); // cria um vetor para armazenar a soma das vendas
            for (int i = 0; i < nroProdutos; i++)
                pSoma[i] = 0; // zera o vetor

            for (int i = 0; i < nroProdutos; i++)
                for (int j = 0; j < 4; j++)
                {
                    pSoma[i] += pMat[i][auxj][j]; // atribui a soma no vetor
                }
            // seleciona o produto mais vendido
            aux = 0;
            for (int i = 0; i < nroProdutos; i++)
                if (pSoma[i] > pSoma[aux])
                    aux = i;

            printf("\nFilial %s vendeu mais o produto: %s\n", nomeFilial, catalogoProdutos[aux]);

            free(pSoma); // libera a memoria alocada
            break;

        case 7:
            printf("\n==== Filial que Mais Vende por Trimestre ====\n");

            printf("Trimestre(1 a 4): ");
            scanf("%d", &tri);
            while (tri < 1 || tri > 4) // limita o numero de trimestres de 0 a 4
            {
                printf("Trimestre Invalido!! Digite outro: ");
                scanf("%d", &tri);
            }
            printf("\n");

            int *pSoma4 = (int *)calloc(nroFiliais, sizeof(int)); // cria um vetor para armazenar a soma das vendas
            for (int i = 0; i < nroFiliais; i++)
                pSoma4[i] = 0; // zera o vetor

            for (int i = 0; i < nroProdutos; i++)
                for (int j = 0; j < nroFiliais; j++)
                {
                    pSoma4[j] += pMat[i][j][tri - 1]; // atribui a soma no vetor
                }
            // seleciona a filial que mais vendeu
            aux = 0;
            for (int i = 0; i < nroFiliais; i++)
                if (pSoma4[i] > pSoma4[aux])
                    aux = i;

            printf("No trimestre %d a filial que mais vendeu foi: %s\n", tri, catalogoFiliais[aux]);

            free(pSoma4); // libera a memoria alocada
            break;

        case 8:
            printf("\n==== Produto Mais Vendido ====\n");

            int *pSoma1 = (int *)calloc(nroProdutos, sizeof(int)); // cria um vetor para armazenar a soma das vendas
            for (int i = 0; i < nroProdutos; i++)
                pSoma1[i] = 0; // zera o vetor

            for (int i = 0; i < 4; i++)
                for (int j = 0; j < nroFiliais; j++)
                    for (int k = 0; k < nroProdutos; k++)
                        pSoma1[k] += pMat[k][j][i]; // atribui a soma no vetor
            // seleciona o produto mais vendido
            aux = 0;
            for (int i = 0; i < nroProdutos; i++)
                if (pSoma1[i] > pSoma1[aux])
                {
                    aux = i;
                }

            printf("O produto mais vendido foi o: %s\n", catalogoProdutos[aux]);

            free(pSoma1); // libera a memoria alocada
            break;

        case 9:
            printf("\n==== Filial que Mais Vende ====\n");

            int *pSoma2 = (int *)calloc(nroFiliais, sizeof(int)); // cria um vetor para armazenar a soma das vendas
            for (int i = 0; i < nroFiliais; i++)
                pSoma2[i] = 0; // zera o vetor

            for (int i = 0; i < nroFiliais; i++)
                for (int j = 0; j < 4; j++)
                    for (int k = 0; k < nroProdutos; k++)
                        pSoma2[i] += pMat[k][i][j]; // atribui a soma no vetor
            // seleciona a filial que mais vendeu
            aux = 0;
            for (int i = 0; i < nroFiliais; i++)
                if (pSoma2[i] > pSoma2[aux])
                {
                    aux = i;
                }

            printf("A filial que mais vendeu foi: %s\n", catalogoFiliais[aux]);

            free(pSoma2); // libera a memoria alocada
            break;

        case 10:
            printf("\n==== Melhor Trimestre ====\n");

            int *pSoma3 = (int *)calloc(4, sizeof(int)); // cria um vetor para armazenar a soma das vendas
            for (int i = 0; i < 4; i++)
                pSoma3[i] = 0; // zera o vetor

            for (int i = 0; i < 4; i++)
                for (int j = 0; j < nroFiliais; j++)
                    for (int k = 0; k < nroProdutos; k++)
                        pSoma3[i] += pMat[k][j][i]; // atribui a soma no vetor
            // seleciona o timestre que mais vendeu
            aux = 0;
            for (int i = 0; i < 4; i++)
                if (pSoma3[i] > pSoma3[aux])
                {
                    aux = i;
                }

            printf("O trimestre mais movimentado foi: %d\n", aux + 1);

            free(pSoma3); // libera a memoria alocada
            break;

        case 11:
            printf("==== Inserir Novo Produto ====\n");

            nroProdutos++; // Incrementa o numero de produtos

            pMat = (int ***)realloc(pMat, nroProdutos * sizeof(int **)); // Realoca a matriz

            // Aloca memoria para o novo produto na matriz
            pMat[nroProdutos - 1] = (int **)malloc(nroFiliais * sizeof(int *));
            for (int j = 0; j < nroFiliais; j++)
                pMat[nroProdutos - 1][j] = (int *)malloc(4 * sizeof(int));

            catalogoProdutos = (char **)realloc(catalogoProdutos, nroProdutos * sizeof(char *)); // Realoca o catalogo de produtos

            catalogoProdutos[nroProdutos - 1] = (char *)malloc(20 * sizeof(char)); // Alocar memoria para o nome do novo produto

            printf("Escreva o nome do novo produto: ");
            do
            {
                aux = 0;
                scanf("%s", catalogoProdutos[nroProdutos - 1]);
                // Verifica se o novo produto ja existe no catalogo
                for (int i = 0; i < nroProdutos - 1; i++)
                {
                    if (strcmp(catalogoProdutos[i], catalogoProdutos[nroProdutos - 1]) == 0)
                    {
                        printf("Produto ja existe! Digite outro: ");
                        aux = 1; // Define como verdadeiro se o produto ja existe
                        break;
                    }
                }
            } while (aux); // Repete enquanto o produto ja existir

            for (int j = 0; j < nroFiliais; j++)
                for (int k = 0; k < 4; k++)
                    pMat[nroProdutos - 1][j][k] = 0; // Inicializa com zero vendas para todas as filiais e trimestres

            printf("\nProduto novo inserido com sucesso!!\n");
            break;

        case 12:
            printf("\n==== Inserir Nova Filial ====\n");

            nroFiliais++; // Incrementa o numero de filiais

            // Realoca a matriz para acomodar a nova filial
            for (int i = 0; i < nroProdutos; i++)
            {
                pMat[i] = (int **)realloc(pMat[i], nroFiliais * sizeof(int *));
                pMat[i][nroFiliais - 1] = (int *)malloc(4 * sizeof(int));
            }

            catalogoFiliais = (char **)realloc(catalogoFiliais, nroFiliais * sizeof(char *)); // Alocar memoria para o novo nome da filial

            catalogoFiliais[nroFiliais - 1] = (char *)malloc(20 * sizeof(char)); // Alocar memoria para o nome da nova filial

            printf("Escreva o nome da nova filial: ");
            do
            {
                aux = 0;

                scanf("%s", catalogoFiliais[nroFiliais - 1]);

                // Verifica se o novo produto ja existe no cat�logo
                for (int i = 0; i < nroFiliais - 1; i++)
                {
                    if (strcmp(catalogoFiliais[i], catalogoFiliais[nroFiliais - 1]) == 0)
                    {
                        printf("Filial ja existe! Digite outra: ");
                        aux = 1; // Define como verdadeiro se a filial ja existe
                        break;
                    }
                }
            } while (aux); // Repete enquanto a filial ja existir

            for (int i = 0; i < nroProdutos; i++)
                for (int j = 0; j < 4; j++)
                    pMat[i][nroFiliais - 1][j] = 0; // Inicializa com zero vendas para todos os produtos e trimestres

            printf("\nNova Filial inserida com sucesso!!\n");

            break;

        case 13:
            printf("\n==== Remover Produto ====\n");
            char nomeProdutoRemover[20];
            aux = -1;
            printf("Digite o nome do produto que deseja remover: ");
            do
            {
                setbuf(stdin, NULL);
                scanf("%s", nomeProdutoRemover);

                // Procura o indice do produto no cat�logo de produtos
                for (int i = 0; i < nroProdutos; i++)
                    if (strcmp(catalogoProdutos[i], nomeProdutoRemover) == 0)
                    {
                        aux = i; // Quando encontrado, aux recebe a posicao do produto no catalogo
                        break;
                    }
                if (aux == -1)
                    printf("Produto nao encontrado!Digite outro: ");

            } while (aux == -1); // repete ate que seja digitado um produto existente

            free(catalogoProdutos[aux]); // Libera a memoria alocada para o nome do produto

            // Realoca o catalogo de produtos para remover o produto
            for (int i = aux; i < nroProdutos - 1; i++)
            {
                catalogoProdutos[i] = catalogoProdutos[i + 1];
            }
            nroProdutos--; // decrementa o numero de produtos

            // Libera a memoria alocada para o produto na matriz
            for (int i = 0; i < nroFiliais; i++)
            {
                free(pMat[aux][i]);
            }
            free(pMat[aux]);

            // Realoca a matriz para remover o produto
            for (int i = aux; i < nroProdutos; i++)
            {
                pMat[i] = pMat[i + 1];
            }
            pMat = (int ***)realloc(pMat, nroProdutos * sizeof(int **));

            printf("Produto removido com sucesso!!\n");

            break;

        case 14:
            printf("\n==== Produto que Mais Vende por Trimestre ====\n");
            printf("Trimestre(1 a 4): ");
            scanf("%d", &tri);
            while (tri < 1 || tri > 4) // limita o numero de trimestres de 0 a 4
            {
                printf("Trimestre Invalido!! Digite outro: ");
                scanf("%d", &tri);
            }
            printf("\n");

            int *pSoma5 = (int *)calloc(nroProdutos, sizeof(int)); // cria um vetor para armazenar a soma das vendas
            for (int i = 0; i < nroProdutos; i++)
                pSoma5[i] = 0; // zera o vetor

            for (int i = 0; i < nroProdutos; i++)
            {
                for (int j = 0; j < nroFiliais; j++)
                {
                    pSoma5[i] += pMat[i][j][tri - 1]; // atribui a soma no vetor
                }
            }
            // seleciona o produto que mais vendeu
            aux = 0;
            for (int i = 0; i < nroProdutos; i++)
                if (pSoma5[i] > pSoma5[aux])
                    aux = i;

            printf("No trimestre %d, o produto que mais vendeu foi: %s\n", tri, catalogoProdutos[aux]);

            free(pSoma5); // libera a momoria alocada
            break;

        case 15:
            printf("\n==== Inserir Venda de uma Filial/Trimestre ====\n");
            printf("Trimestre(1 a 4): ");
            scanf("%d", &tri);
            while (tri < 1 || tri > 4) // limita o numero de trimestres de 0 a 4
            {
                printf("Trimestre Invalido!! Digite outro: ");
                scanf("%d", &tri);
            }
            auxj = -1;
            printf("Nome da filial: ");
            do
            {
                setbuf(stdin, NULL);
                scanf("%s", nomeFilial);

                // Procura no catalogo de filiais a filial escolhida
                for (int j = 0; j < nroFiliais; j++)
                    if (strcmp(catalogoFiliais[j], nomeFilial) == 0)
                    {
                        auxj = j; // Quando encontrado, auxj recebe a posicoo da filial no catalogo
                        break;
                    }
                if (auxj == -1)
                    printf("Filial nao encontrada!Digite outra: ");
            } while (auxj == -1); // repete ate que seja digitado uma filial existente

            printf("\n");
            for (int i = 0; i < nroProdutos; i++)
            {
                printf("Vendas do produto %s, da filial %s, no trimestre %d: ", catalogoProdutos[i], nomeFilial, tri);
                scanf("%d", &pMat[i][auxj][tri - 1]); // atribui as vendas na matriz
            }
            break;
        }
        printf("\n");
    } while (opcao != 0);
    printf("Encerrando...");

    return 0;
}
