#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>

void clearScreen() {
    // Verifica o sistema operacional e executa o comando adequado para limpar o console
    #ifdef _WIN32
        system("cls");  // Comando para Windows
    #else
        system("clear");  // Comando para Linux/macOS
    #endif  
}

void pressEnter() {
    getchar();
    printf("Pressione ENTER para continuar...");
    getchar();
    clearScreen();
}

void menu(int *option) {
    printf("Menu:\n");
    printf("================================\n");
    printf("1 - Insira o PID do processo que deseja o Status\n");
    printf("2 - Receba o Status do processo atual\n");
    printf("3 - Listar todos os processos\n");
    printf("4 - Encerre o programa\n");
    printf(">>> ");
    scanf("%d", option);
}

void callStats(int pidCode) {
    char command[256];
    
    // Exibir status usando tasklist
    #ifdef _WIN32
        snprintf(command, sizeof(command), "tasklist /FI \"PID eq %d\"", pidCode);
        printf("Status do processo com tasklist:\n");
        system(command); // Executa o comando tasklist

        // Agora exibir status usando Get-Process
        snprintf(command, sizeof(command), "powershell -Command \"Get-Process -Id %d | Select-Object Name, Responding\"", pidCode);
        printf("\nStatus do processo com Get-Process:\n");
        system(command); // Executa o comando Get-Process
    #else
        snprintf(command, sizeof(command), "ps -p %d", pidCode);
        system(command);
    #endif
}

void listProcess() {
    char command[100];
    #ifdef _WIN32
        snprintf(command, sizeof(command), "tasklist");
    #else
        snprintf(command, sizeof(command), "ps aux");
    #endif
    system(command);
}

int main() {
    int option = 0;  // Inicialize a variável
    while (option != 4) {
        int PID = getpid();
        menu(&option);  // Passe o endereço de option para a função
        printf("Opção selecionada: %d\n", option);
        
        switch (option) {
            case 1:
                printf("Insira o PID do processo desejado: ");
                scanf("%d", &PID);
                pressEnter();
                callStats(PID);
                break;
            case 2:
                printf("Status do processo atual (PID = %d)\n", PID);
                pressEnter();
                callStats(PID);
                break;
            case 3:
                printf("Listando todos os processos\n");
                pressEnter();
                listProcess();
                break;
            case 4:
                printf("Encerrando o programa...\n");
                pressEnter();
                break;
            default:
                printf("Opção inválida. Tente novamente.\n");
                break;
        }
        pressEnter();
    }
    return 0;
}
