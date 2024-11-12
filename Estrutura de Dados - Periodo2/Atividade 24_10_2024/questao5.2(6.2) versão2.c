#include <stdio.h>

typedef struct no {
    int item;
    struct no *prox;
} No;

int main() {
    int qtdList;
    printf("Digite quantos itens deseja na lista: ");
    scanf("%d", &qtdList);

    No v[qtdList];

    for (int i = 0; i < qtdList; i++) {
        printf("Digite o numero da lista da posicao %d: ", i + 1);
        scanf("%d", &v[i].item);
        v[i].prox = (i < qtdList - 1) ? &v[i + 1] : NULL;
    }

    printf("Elementos da lista: ");
    for (No *p = v; p != NULL; p = p->prox) {
        printf("%d ", p->item);
    }
    printf("\n");

    return 0;
}
