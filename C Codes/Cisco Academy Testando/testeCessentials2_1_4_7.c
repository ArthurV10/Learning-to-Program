#include <stdio.h>
#include <stdlib.h>

typedef struct lista
{
    int value;
    Lista *prox;
}Lista;



int main(){
    int numberList[10] = {1,2,3,4,5,6,7,8,9,10};
    Lista head = (Lista*)malloc(sizeof(Lista));
    Lista currenteValue;
    Lista last;
    currenteValue = head;
    last = head;

    for (int i = 0; i < 10; i++){
        if (currenteValue != head){
            currenteValue = (Lista*)malloc(sizeof(Lista));
            last.prox = currenteValue;
        }
        currenteValue = 

    }
}