#include <stdio.h>
#include <string.h>
#include <stdlib.h>

// Function to encrypt a character
char encryptCharacter(char message, char key, char **matrix, char positionArray[52]) {
    int p1 = -1, p2 = -1;

    // Find the position of the character and the key in the position array
    for (int j = 0; j < 52; j++) {
        if (positionArray[j] == message)
            p1 = j;
        if (positionArray[j] == key)
            p2 = j;
    }

    if (p1 != -1 && p2 != -1)
        return matrix[p2][p1]; // Return the corresponding character in the matrix
    else
        return message; // Keep characters not found unchanged
}

// Function to encrypt the entire message
void encryptMessage(char *message, char *key, char **matrix, char positionArray[52]) {
    int lenMsg = strlen(message);
    char *keyword = (char *)malloc((lenMsg + 1) * sizeof(char)); // +1 for the \0
    char *encryptedMessage = (char *)malloc((lenMsg + 1) * sizeof(char));

    int k = 0;
    for (int i = 0; i < lenMsg; i++) {
        if (key[k] == '\0')
            k = 0; // Restart the keyword if it reaches the end

        if (message[i] != ' ') {
            keyword[i] = key[k];
            k++;
        } else
            keyword[i] = ' ';
    }

    keyword[lenMsg] = '\0'; // Add \0 at the end of the keyword
    printf("\nModified Keyword: %s\n", keyword);

    for (int i = 0; i < lenMsg; i++) {
        encryptedMessage[i] = encryptCharacter(message[i], keyword[i], matrix, positionArray);
    }
    encryptedMessage[lenMsg] = '\0';

    printf("Encrypted Message: %s\n", encryptedMessage);

    free(keyword);
    free(encryptedMessage);
}

int main() {
    char **matrix = (char **)malloc(52 * sizeof(char *));
    for (int i = 0; i < 52; i++) {
        matrix[i] = (char *)malloc(52);
    }

    char *positionArray = (char *)malloc(52 * sizeof(char *));

    char letter = 'A';
    // Fill even positions of the first row with uppercase letters
    for (int j = 0; j < 52; j += 2) {
        matrix[0][j] = letter;
        positionArray[j] = letter;
        letter++;
    }

    letter = 'a';
    // Fill odd positions of the first row with lowercase letters
    for (int j = 1; j < 52; j += 2) {
        matrix[0][j] = letter;
        positionArray[j] = letter;
        letter++;
    }

    // Move the characters to form the matrix
    for (int i = 0; i < 51; i++) {
        char temp2 = matrix[i][0];
        for (int j = 0; j < 51; j++) {
            char temp = matrix[i][j + 1];
            matrix[i + 1][j] = temp; // Move characters from the current row to the next
        }
        matrix[i + 1][51] = temp2; // Move the first character of the current row to the last position of the next row
    }

    char *key = (char *)malloc(500 * sizeof(char));
    char *message = (char *)malloc(500 * sizeof(char));

    printf("Enter the open message: ");
    gets(message);

    printf("Enter the keyword: ");
    gets(key);

    encryptMessage(message, key, matrix, positionArray);

    // Free dynamically allocated memory
    for (int i = 0; i < 52; i++) {
        free(matrix[i]);
    }
    free(matrix);
    free(key);
    free(message);

    return 0;
}
