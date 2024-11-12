#include <iostream>
using namespace std;

int main(){
    string nome1;
    string nome2;
    int boollean;

    cout << "Digite o primeiro nome: ";
    cin >> nome1;

    cout << "Digite o segundo nome: ";
    cin >> nome2;

    boollean = nome1 == nome2 ? 1:0;

    if (boollean){
        cout << "Sao iguais" << endl;
    }
    else {
        cout << "Sao diferentes" << endl;
    }
    return 0;
}