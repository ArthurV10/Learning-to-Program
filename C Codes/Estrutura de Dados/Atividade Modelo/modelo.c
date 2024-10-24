#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef struct {
	int mat;
	char nome[30];
	} TAluno;

TAluno v[20];
int ultimo = 0;

void inserir(TAluno *novo){
    if (ultimo >= 20) {
        printf("Total de alunos chegou ao máximo.\n");
        return;  // Saída antecipada se o limite for atingido
    }

    // Inserindo o nome do novo aluno
    printf("Insira o nome do aluno: ");
    scanf("%s", novo->nome);  // Usando '->' pois 'novo' é um ponteiro

    // Definindo a matrícula
    novo->mat = ultimo + 1;   // Matrícula sequencial
    ultimo++;                 // Incrementa o número de alunos
}



void remover(int indexAluno){

}


void mostra(char listaAlunos, int listaMatriculas){	
}

void menu(){
    int option;
    printf("===================================\n"
           "1 - Inserir Aluno no Sistema\n"
           "2 - Remover Aluno do Sistema\n"
           "3 - Mostrar Alunos do Sistema\n"
           "===================================\n"
           ">>> ");
    scanf("%d", &option);
    switch (option)
    {
    case 1:
        inserir(&v[ultimo]);  // Passa o próximo aluno a ser inserido
        break;
    case 2: {
        int index;
        printf("Informe o número do aluno para remover: ");
        scanf("%d", &index);
        remover(index);
        break;
    }
    case 3:
        // Chamar função para mostrar alunos
        break;
    default:
        printf("Opção inválida.\n");
        break;
    }
}


int main(void){
    menu();

	return 0;
}
