#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
 int data;
 struct Node* next;
} Node;

void push(Node** head_ref, int new_data) {
    Node* new_node = (Node*)malloc(sizeof(Node));
    new_node->data = new_data;
    new_node->next = *head_ref;
    *head_ref = new_node;
    return;
}

void printList(Node* node) {
    while (node != NULL) {
    printf(" %d ", node->data);
    node = node->next;
    }
}

int main() {
    Node* head = NULL;
    push(&head, 1);
    push(&head, 2);
    push(&head, 3);
    push(&head, 4);
    printf("Lista encadeada: ");
    printList(head);
    return 0;
}
