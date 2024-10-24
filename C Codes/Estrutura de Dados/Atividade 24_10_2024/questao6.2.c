#include <stdio.h>
#include <stdlib.h>

typedef struct no {
    int item;
    struct no *prox;
} No;

int main() {
    int tamanhoLista;
    No *lista = NULL, *temp = NULL, *ultimo = NULL;

    printf("Digite o tamanho da lista: ");
    scanf("%d", &tamanhoLista);

    for (int i = 0; i < tamanhoLista; i++) {
        temp = (No*)malloc(sizeof(No));
        printf("Digite o termo %d: ", i + 1);
        scanf("%d", &temp->item);
        temp->prox = NULL;

        if (lista == NULL) {
            lista = temp;
        } else {
            ultimo->prox = temp;
        }
        ultimo = temp;
    }

    printf("Elementos da lista:\n");
    for (No *p = lista; p != NULL; p = p->prox) {
        printf("%d ", p->item);
    }
    printf("\n");
    
    No *atual = lista;
    while (atual != NULL) {
        No *proximo = atual->prox;
        free(atual);
        atual = proximo;
    }
    return 0;
}
