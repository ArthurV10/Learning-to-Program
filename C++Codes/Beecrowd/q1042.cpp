#include <iostream>
using namespace std;

int main() {
    int a,b,c;
    cin >> a >> b >> c;
    int num[3];
    num[0] = a;
    num[1] = b;
    num[2] = c;
    for (int i = 0; i < 3; ++i){
        cout << num[i] << " ";
    }
    return 0;
}