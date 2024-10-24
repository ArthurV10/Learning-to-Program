#include <stdio.h>

int main(void){
    typedef struct carro{
        char *cor;
        char *modelo;
    } Carro;

   Carro *cabeca;
   cabeca->cor = "Vermelho";
   cabeca->modelo = "BMW";

   printf("%s", cabeca->cor);

}