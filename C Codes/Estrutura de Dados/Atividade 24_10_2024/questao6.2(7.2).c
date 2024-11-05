 #include <stdio.h>
#include <stdlib.h>

typedef struct no {
    int item;
    struct no *prox;
} *Lst;

Lst criarNo(int x) {
    Lst n = (struct no*)malloc(sizeof(struct no));
    n->item = x;
    n->prox = NULL;  
    return n;
}

void inserirNoFinal(Lst *inicio, int valor) {
    Lst novo = criarNo(valor); 
    
    if (*inicio == NULL) { 
        *inicio = novo;
    } else {  
        Lst temp = *inicio;
        while (temp->prox != NULL) {
            temp = temp->prox;
        }
        temp->prox = novo; 
    }
}

int main() {
    int qtdList;
    printf("Digite a quantidade de itens na lista: ");
    scanf("%d", &qtdList);

    Lst p = NULL; 
    for (int i = 0; i < qtdList; i++) {
        int valor;
        printf("Digite o elemento %d: ", i + 1);
        scanf("%d", &valor);
        inserirNoFinal(&p, valor); 
    }

    printf("Elementos na lista:\n");
    Lst temp = p;
    while (temp) {
        printf("%d\n", temp->item);
        temp = temp->prox;
    }

    while (p) {
        Lst temp = p;
        p = p->prox;
        free(temp);
    }

    return 0;
}

