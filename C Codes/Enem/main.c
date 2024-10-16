#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(void) {
    FILE *file;
    char line[1024];

    // Abra o arquivo no modo de leitura
    file = fopen("C:\\Users\\Arthur\\OneDrive\\Desktop\\IFPI\\Learning-to-Program\\C Codes\\Enem\\files\\enem2014_nota_por_escola.csv", "r");

    // Verifica se o arquivo foi aberto corretamente
    if (file == NULL) {
        printf("Erro ao abrir o arquivo.\n");
        return 1;
    }

    // Lê o arquivo linha por linha
    while (fgets(line, sizeof(line), file)) {
        // Remove o caractere de nova linha no final, se presente
        line[strcspn(line, "\n")] = 0;

        // Divide a linha em tokens usando vírgula como delimitador
        char *token = strtok(line, ",");

        // Imprime cada token
        while (token != NULL) {
            printf("%s\t", token);
            token = strtok(NULL, ",");
        }
        printf("\n");  // Adiciona uma nova linha após imprimir os tokens de cada linha
    }

    // Fecha o arquivo
    fclose(file);

    return 0;
}
