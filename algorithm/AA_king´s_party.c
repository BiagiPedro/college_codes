#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define N 20000

int main()
{
    int *p; // Pointer that points to the array p
    int Ti; // Randomly chosen numbers
    int M; // Number of draws to choose
    int cont = 0;

    p = (int *) malloc(N * sizeof(int)); // Create an array of size N

    if (p == NULL)
    {
        printf("ERROR!\n");
        system("pause");
        return 0;
    }

    printf("===== Subjects =====\n");
    for (int i = 0; i < N; i++)
        *(p + i) = i + 1; // Assign the numbers to each subject

    for (int i = 0; i < N; i++)
        printf("%d  ", *(p + i));

    printf("\nEnter the number of draws: ");
    scanf("%d", &M); // Read the number of turns
    while (M < 0)
    {
        printf("Invalid number, enter another: ");
        scanf("%d", &M);
    }

    printf("\n\n======= Random Numbers =======\n");

    for (int j = 0; j < M; j++)
    {
        Ti = 1 + (rand() % N); // Generate a random number from 1 to N

        if (Ti == 1) // If Ti = 1, exception in the draw
        {
            printf("%d  ", Ti);
            *(p) = 0;
            continue;
        }

        printf("%d  ", Ti);

        for (int k = 0; k < N; k++)
        {
            if (*(p + k) % Ti == 0) // Check if the position is a multiple of the drawn number
                *(p + k) = 0; // If yes, assign zero
        }
    }

    printf("\n\n==== Invited Subjects ====\n");
    for (int i = 0; i < N; i++)
    {
        if (cont == 10000) // Limit
        {
            printf("Candidates exceeded");
            break;
        }
        if (*(p + i) != 0)
        {
            cont++;
            printf("%d\n", *(p + i)); // Print the values that are not equal to 0
        }
    }
    free(p);
    return 0;
}