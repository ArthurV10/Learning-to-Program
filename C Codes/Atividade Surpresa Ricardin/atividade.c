#include <stdio.h>
#include <string.h>

#ifdef _WIN32
    #include <direct.h>  // Para _mkdir no Windows
#elif __linux__
    #include <sys/stat.h>  // Para mkdir no Linux
    #include <unistd.h>  // Para acesso ao sistema de arquivos
#endif

// Função para criar a pasta
int criarPasta(const char* nome) {
    char caminho[100];
    snprintf(caminho, sizeof(caminho), "../%s", nome);

    #ifdef _WIN32
        if (_mkdir(caminho) == 0) {
            printf("Pasta '%s' criada com sucesso no Windows!\n", caminho);
            return 0;
        } else {
            perror("Erro ao criar a pasta no Windows");
            return 1;
        }
    #elif __linux__
        if (mkdir(caminho, 0777) == 0) {
            printf("Pasta '%s' criada com sucesso no Linux!\n", caminho);
            return 0;
        } else {
            perror("Erro ao criar a pasta no Linux");
            return 1;
        }
    #else
        printf("Sistema operacional não suportado!\n");
        return 1;
    #endif
}

// Função para criar o caminho do arquivo
char* criarArquivo(const char* nomeArquivo, const char* nomePasta, char* caminhoCompleto) {
    // Formata o caminho completo do arquivo
    snprintf(caminhoCompleto, 256, "../%s/%s", nomePasta, nomeArquivo);
    return caminhoCompleto;
}

int main() {
    char nomePasta[100];
    char nomeArquivo[100];
    char caminhoCompleto[256];

    puts("=====================================");
    puts("Atividade  Extra do Ricardin");
    puts("Feita por: Arthur Vieira e Xama Cardoso");
    puts("=====================================");
    puts("");

    // Criar pasta
    printf("Digite o nome da pasta: ");
    scanf("%s", nomePasta);
    if (criarPasta(nomePasta) != 0) {
        return 1;  // Se não conseguiu criar a pasta, sai do programa
    }

    // Criar arquivo na pasta
    printf("Digite o nome do arquivo: ");
    scanf("%s", nomeArquivo);
    
    // Criar o caminho do arquivo
    criarArquivo(nomeArquivo, nomePasta, caminhoCompleto);
    
    // Criar e abrir o arquivo
    FILE* arquivo = fopen(caminhoCompleto, "w");
    if (arquivo == NULL) {
        perror("Erro ao criar o arquivo");
        return 1;
    }

    // Escrever algo no arquivo
    char mensagem[500];
    printf("Digite a mensagem que deseja colocar no arquivo: ");
    getchar();
    fgets(mensagem, sizeof(mensagem), stdin);
    fprintf(arquivo, "%s\n", mensagem);
    fclose(arquivo);
    
    printf("Arquivo '%s' criado com sucesso na pasta '%s'!\n", nomeArquivo, nomePasta);
    return 0;
}
