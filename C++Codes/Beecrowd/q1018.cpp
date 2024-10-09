#include <iostream>
using namespace std;

int main() {
    int dinheiro;
    cin >> dinheiro;

    int dinheiroinicial = dinheiro;
    int nota100 = 0, nota50 = 0, nota20 = 0, nota10 = 0, nota5 = 0, nota2 = 0, nota1 = 0;

    // Contando as notas
    while (dinheiro > 0) {
        if (dinheiro >= 100) {
            ++nota100;
            dinheiro -= 100;
        } else if (dinheiro >= 50) {
            ++nota50;
            dinheiro -= 50;
        } else if (dinheiro >= 20) {
            ++nota20;
            dinheiro -= 20;
        } else if (dinheiro >= 10) {
            ++nota10;
            dinheiro -= 10;
        } else if (dinheiro >= 5) {
            ++nota5;
            dinheiro -= 5;
        } else if (dinheiro >= 2) {
            ++nota2;
            dinheiro -= 2;
        } else if (dinheiro >= 1) {
            ++nota1;
            dinheiro -= 1;
        }
    }

    // Exibindo o resultado
    cout << dinheiroinicial << endl;
    cout << nota100 << " nota(s) de R$ 100,00" << endl;
    cout << nota50 << " nota(s) de R$ 50,00" << endl;
    cout << nota20 << " nota(s) de R$ 20,00" << endl;
    cout << nota10 << " nota(s) de R$ 10,00" << endl;
    cout << nota5 << " nota(s) de R$ 5,00" << endl;
    cout << nota2 << " nota(s) de R$ 2,00" << endl;
    cout << nota1 << " nota(s) de R$ 1,00" << endl;

    return 0;
}
