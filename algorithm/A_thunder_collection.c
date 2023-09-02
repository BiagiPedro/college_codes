/******************************************************************************

Pedro Biagi 12221BSI200 
*******************************************************************************/
Here's the translation of the provided C code into English:

```c
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define Width 10
#define Length 5

int main()
{
    typedef struct
    {
        int isStruckByLightning; // defines if lightning struck the quadrant
        int day, month, year;
        double intensity;
        char conditions[20];
    } QUADRANT;

    int choice, conditionChoice;
    int x, y;
    int lightningCount = 0; // how many lightning strikes occurred
    int unaffectedRegionsCount = 0; // counts how many regions were unaffected
    QUADRANT quadrant[Width][Length];
    QUADRANT *ptrQuadrant = &quadrant[0][0]; // pointer of struct type

    do
    {
        printf("=============================\n");
        printf("            MENU\n");
        printf("=============================\n");
        printf("[1] Mark Lightning Strike:\n");
        printf("[2] Number of Lightning Strikes:\n");
        printf("[3] Unaffected Areas:\n");
        printf("[4] Print Matrix:\n");
        printf("[5] Exit:\n");
        printf("=============================\n");
        printf("Select: ");
        scanf("%d", &choice);

        switch (choice)
        {
        case 1:

            printf("===== Mark Lightning Strike =====\n");
            lightningCount++; // counts the number of lightning strikes
            printf("Enter the coordinates of the quadrant (x/y): ");
            scanf("%d %d", &x, &y);
            while(x >= Width || x < 0 || y >= Length || y < 0 )
            {
                printf("\nLightning strike outside the city!! Enter another coordinate!!\n");
                printf("Enter the coordinates of the quadrant (x/y): ");
                scanf("%d %d", &x, &y);
            }

            if((ptrQuadrant + (x * Length + y))->isStruckByLightning == 1) // checks in the struct if isStruckByLightning is already filled
            {
                printf("TWO LIGHTNING STRIKES IN THE SAME PLACE!!!");
                return 0;
            }

            (ptrQuadrant + (x * Length + y))->isStruckByLightning = 1;// helps to determine if the region was affected or not

            printf("\n----- Date -----\n");
            printf("Day: ");
            setbuf(stdin,NULL);
            scanf("%d", &(ptrQuadrant + (x * Length + y))->day);
            while(((ptrQuadrant + (x * Length + y))->day) > 31 || ((ptrQuadrant + (x * Length + y))->day) <= 0 )
            {
                printf("Invalid Day!! Enter another day: ");
                setbuf(stdin,NULL);
                scanf("%d", &(ptrQuadrant + (x * Length + y))->day);
            }

            printf("Month: ");
            setbuf(stdin,NULL);
            scanf("%d", &(ptrQuadrant + (x * Length + y))->month);
            while(((ptrQuadrant + (x * Length + y))->month) > 12 || ((ptrQuadrant + (x * Length + y))->month) <= 0 )
            {
                printf("Invalid Month!! Enter another month: ");
                setbuf(stdin,NULL);
                scanf("%d", &(ptrQuadrant + (x * Length + y))->month);
            }

            printf("Year: ");
            setbuf(stdin,NULL);
            scanf("%d", &(ptrQuadrant + (x * Length + y))->year);
            while(((ptrQuadrant + (x * Length + y))->year) > 2023)
            {
                printf("Invalid Year!! Enter another year: ");
                setbuf(stdin,NULL);
                scanf("%d", &(ptrQuadrant + (x * Length + y))->year);
            }

            printf("\n----- Intensity (kWh) -----\n");
            scanf("%lf", &(ptrQuadrant + (x * Length + y))->intensity);

            printf("\n----- Conditions -----\n");
            printf("[1] Sunny:\n");
            printf("[2] Rainy:\n");
            printf("[3] Cloudy:\n");
            printf("[4] Other:\n");
            printf("----------------------\n");
            printf("Select: ");
            scanf("%d", &conditionChoice);
            switch (conditionChoice)
            {
            case 1:
                strcpy((ptrQuadrant + (x * Length + y))->conditions, "Sunny");
                break;
            case 2:
                strcpy((ptrQuadrant + (x * Length + y))->conditions, "Rainy");
                break;
            case 3:
                strcpy((ptrQuadrant + (x * Length + y))->conditions, "Cloudy");
                break;
            case 4:
                strcpy((ptrQuadrant + (x * Length + y))->conditions, "Other");
                break;
            default:
                printf("\nInvalid Condition!!");
                break;
            }
            printf("\n\n");
            break;
        case 2:

            printf("===== Number of Lightning Strikes =====\n");
            printf("---> %d lightning strikes occurred in the city!! <---\n", lightningCount);
            break;

        case 3:
            printf("===== Unaffected Regions =====\n");
            unaffectedRegionsCount = (Width * Length) - lightningCount;
            printf("%d regions were not affected by lightning strikes\n", unaffectedRegionsCount);
            break;

        case 4:
            printf("===== City Map =====\n");
            for(int i = 0; i < Width; i++)
            {
                for(int j = 0; j < Length; j++)
                    if((ptrQuadrant + (i * Length + j))->isStruckByLightning == 1)
                        printf("X ");
                    else
                        printf("O ");
                printf("\n");  // New line for the next row of the matrix
            }
            break;
        }
        printf("\n\n\n");
    }
    while (choice != 5); // repeats the menu until the user enters 5 (exit)

    return 0;
}
```

I've translated the variable names and comments to make the code more readable in English.