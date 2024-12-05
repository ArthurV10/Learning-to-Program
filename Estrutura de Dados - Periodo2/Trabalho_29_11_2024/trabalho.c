#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>

// Definição da Pilha (Implementação Simples)
typedef struct {
    float *data;
    int top;
    int size;
} Pilha;

// Funções para manipulação da Pilha
Pilha pilha(int size) {
    Pilha p;
    p.data = (float *)malloc(size * sizeof(float));
    p.top = -1;
    p.size = size;
    return p;
}

void empilha(float val, Pilha *p) {
    if (p->top == p->size - 1) {
        printf("Erro: Pilha cheia.\n");
        exit(EXIT_FAILURE);
    }
    p->data[++p->top] = val;
}

float desempilha(Pilha *p) {
    if (p->top == -1) {
        printf("Erro: Pilha vazia.\n");
        exit(EXIT_FAILURE);
    }
    return p->data[p->top--];
}

float topo(Pilha *p) {
    if (p->top == -1) {
        printf("Erro: Pilha vazia.\n");
        exit(EXIT_FAILURE);
    }
    return p->data[p->top];
}

int vaziap(Pilha *p) {
    return p->top == -1;
}

void destroip(Pilha *p) {
    free(p->data);
    p->top = -1;
    p->size = 0;
}

// Função para definir a prioridade dos operadores
int prio(char o) {
    switch (o) {
        case '(': return 0;
        case '+':
        case '-': return 1;
        case '*':
        case '/': return 2;
        default: return -1; // Retorno para outros caracteres
    }
}

// Função para converter infixa para pós-fixa
char *posfixa(char *e) {
    static char s[256];
    Pilha P = pilha(256);
    int i, j = 0;

    for (i = 0; e[i]; i++) {
        if (e[i] == '(') {
            empilha('(', &P);
        } else if (isdigit(e[i]) || e[i] == '.') {
            s[j++] = e[i];
        } else if (strchr("+-*/", e[i])) {
            s[j++] = ' ';
            while (!vaziap(&P) && prio(topo(&P)) >= prio(e[i])) {
                s[j++] = desempilha(&P);
            }
            empilha(e[i], &P);
        } else if (e[i] == ')') {
            while (topo(&P) != '(') {
                s[j++] = desempilha(&P);
            }
            desempilha(&P);
        }
    }

    while (!vaziap(&P)) {
        s[j++] = desempilha(&P);
    }
    s[j] = '\0';
    destroip(&P);
    return s;
}

// Função para avaliar a expressão pós-fixa
float valor(char *e) {
    Pilha P = pilha(256);

    for (int i = 0; e[i]; i++) {
        if (isdigit(e[i])) {
            empilha(atof(e + i), &P);
            while (isdigit(e[i + 1]) || e[i + 1] == '.') i++;
        } else if (strchr("+-*/", e[i])) {
            float y = desempilha(&P);
            float x = desempilha(&P);
            switch (e[i]) {
                case '+': empilha(x + y, &P); break;
                case '-': empilha(x - y, &P); break;
                case '*': empilha(x * y, &P); break;
                case '/': empilha(x / y, &P); break;
            }
        }
    }

    float z = desempilha(&P);
    destroip(&P);
    return z;
}

// Programa principal
int main() {
    char infixa[256], *posfixaExpr;
    printf("Digite uma expressão infixa: ");
    fgets(infixa, 256, stdin);

    // Remove o caractere de nova linha
    infixa[strcspn(infixa, "\n")] = '\0';

    // Converte para pós-fixa
    posfixaExpr = posfixa(infixa);

    // Calcula o valor da expressão
    float resultado = valor(posfixaExpr);

    printf("Expressão pós-fixa: %s\n", posfixaExpr);
    printf("Resultado: %.2f\n", resultado);

    return 0;
}
