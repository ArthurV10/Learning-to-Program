#include <stdio.h>
#include <string.h>

int verificarIgualdade(char *nome1, char *nome2) {
    if (strcmp(nome1, nome2) == 0) {
        return 1;
    }
    return 0;
}

int main() {
    char nome1[30];
    char nome2[30];
    int bolleana;

    printf("Digite o primeiro nome: ");
    scanf("%s", nome1);
    printf("Digite o segundo nome: ");
    scanf("%s", nome2);

    bolleana = verificarIgualdade(nome1, nome2);

    if (bolleana) {
        printf("Sao iguais\n");
    } else {
        printf("Nao sao iguais\n");
    }

    return 0;
}
