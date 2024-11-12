#include <stdio.h>
#include <string.h>

int verificarIgualdade(char *nome1, char *nome2) {
    if (strlen(nome1) != strlen(nome2)) {
        return 0;
    }

    for (int i = 0; nome1[i] != '\0'; i++) {
        if (nome1[i] != nome2[i]) {
            return 0;
        }
    }

    return 1;
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
