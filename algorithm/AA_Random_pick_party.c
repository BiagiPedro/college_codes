#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define N 15000

int main()
{
    int Ti, M;
    int limit = 0;

    int *p = (int *)malloc(N * sizeof(int)); // Creates an array of size N

    if (p == NULL)
    {
        printf("Error!\n");
        exit(1);
    }

    printf("Subjects: \n");
    for (int i = 0; i < N; i++)
    {
        *(p + i) = i + 1;
        printf("%d, ", *(p + i)); // Print subjects
    }

    printf("\nNumber of Turns: ");
    scanf("%d", &M); // Reads the number of turns
    while (M < 0)
    { // Accepts only positive numbers
        printf("Invalid number! ");
        scanf("%d", &M);
    }

    printf("Chosen Numbers:");
    for (int j = 0; j < M; j++)
    {

        scanf("%d", &Ti); // Reads the numbers for each turn
        if (Ti == 1)
        {
            *(p) = 0;
            continue;
        }

        for (int k = 0; k < N; k++)
        {
            if (*(p + k) % Ti == 0)
                *(p + k) = 0; // Assigns zero if the position is a multiple of Ti
        }
    }

    printf("Guests:\n");
    for (int i = 0; i < N; i++)
    {
        if (limit == 10000)
        {
            break;
        }
        if (*(p + i) != 0)
        {
            limit++;
            printf("%d\n", *(p + i));
        }
    }
    free(p);
    return 0;
}

