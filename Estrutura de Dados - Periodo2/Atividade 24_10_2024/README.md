# Respostas da Atividade - 24/10/2024

### `Questões que não estão aqui, estão nos codigos de C`
## Questão 4.1 - Considerando o código acima, qual o valor de i e j ao final do programa?

### Resposta
A variável `I` será igual a 4 e a variável `J` será igual a 3.

### Código

```cpp
#include <stdio.h>
#include <string.h>
#include <iostream>
using namespace std;

typedef struct {
    char valor[10];
} Str;

main() {
    char valor[3] = {"um"};
    Str v = {"123"};
    int i = 0;

    while (i <= strlen(v.valor)) {
        cout << i << "--" << v.valor[i] << endl;
        i++;
    }

    cout << "---------";

    int j = 0;
    while (valor[j] != '\0') {
        cout << "j =" << j << "- " << valor[j] << endl;
        j++;
    }
    cout << j;
}
```


## Questão 5.1 (6.1 -> Questão do PDF) - O que será impresso ao final da execucao do programa?

### Resposta
Será impresso `1234`

### Código da Questão

```cpp
#include <stdio.h>
#include <iostream>
using namespace std;

typedef struct no {
    int item;
    struct no *prox;
} No;

main() {
    No v[4] = {{3, v + 2}, {1, v + 3}, {4, NULL}, {2, v + 0}};
    
    for (No *p = v + 1; p != NULL; p = p->prox) {
        cout << p->item;
    }
}
```

## Questão 6.1 (7.1 -> Questão do PDF) - O que será impresso ao final da execucao do programa?

### Resposta
Será impresso no output:

    1

    2

    3 

    4

### Código

```cpp
#include <stdio.h>
#include <iostream>
using namespace std;

typedef struct no {
    int item;
    struct no *prox;
} *Lst;

Lst no(int x, Lst p) {
    Lst n = (struct no*)malloc(sizeof(struct no));
    n->item = x;
    n->prox = p;
    return n;
}

main() {
    Lst p = (no(1, no(2, no(3, no(4, NULL)))));
    while (p) {
        cout << p->item << endl;
        p = p->prox;
    }
}
```

## Questão 7.1 (8.1 -> Questão do PDF) - O que será impresso ao final do programa?

### Resposta
Será impresso "Hello World!".

## Questão 7.2 (8.2 -> Questão do PDF) - O que a função X está fazendo?

### Resposta
A função está concatenando as duas strings

### Código do Programa
```c
#include <stdio.h>

void x(char *str1, char *str2) {
    while (*str1) {
        str1++;
    }
    while (*str2) {
        *str1 = *str2;
        str1++;
        str2++;
    }
    *str1 = '\0';
}

int main() {
    char str1[100] = "Hello ";
    char str2[] = "World!";
    x(str1, str2);
    printf(" %s\n", str1);
    return 0;
}
```
## Questão 8.1 (9.1 -> Questão do PDF) - O que será impresso ao final do programa?

### Resposta
Vai ser impresso o valor 11.

## Questão 8.2 (9.2 -> Questão do PDF) - O que a função X está fazendo?

### Resposta
A função está contando a quantidade de caracteres na string, incluindo os espaços vazios.

### Código do Programa
```c
#include <stdio.h>

int x(char *str) {
    int y = 0;
    while (*str) {
        y++;
        str++;
    }
    return y;
}

int main() {
    char str[] = "Hello World";
    int w = x(str);
    printf("%d\n", w);
    return 0;
}
```

## Questão 9.1 (10.1 -> Questão do PDF) - O que será impresso ao final do programa?

### Resposta
Vai ser impresso " 1 2 3 4 ".

### Código do Programa
```c
#include <stdio.h>
#include <stdlib.h>

// Definindo a estrutura do nó
typedef struct Node {
    int data;
    struct Node* next;
} Node;

void append(Node** head_ref, int new_data) {
    Node* new_node = (Node*)malloc(sizeof(Node));
    Node* p = *head_ref;
    new_node->data = new_data;
    new_node->next = NULL;

    if (*head_ref == NULL) {
        *head_ref = new_node;
        return;
    }

    while (p->next != NULL) {
        p = p->next;
    }
    p->next = new_node;
    return;
}

// Função para imprimir a lista
void printList(Node* node) {
    while (node != NULL) {
        printf(" %d ", node->data);
        node = node->next;
    }
}

int main() {
    Node* head = NULL;
    append(&head, 1);
    append(&head, 2);
    append(&head, 3);
    append(&head, 4);
    printf("Lista encadeada: ");
    printList(head);
    return 0;
}
