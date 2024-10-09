#include <iostream>
#include <math.h>
#include <iomanip>
using namespace std;

int main(){
    double a,b,c;
    cin >> a >> b >> c;
    double formulaDelta = (b * b) - 4 * a * c;
    double formulaX1 = ( -b + (pow(formulaDelta , 0.5))) / (2 * a);
    double formulaX2 = ( -b - (pow(formulaDelta , 0.5))) / (2 * a);
  

    if (formulaDelta < 0 || a == 0){
        cout << "Impossivel calcular" << endl;
    }
    else if (formulaDelta > 0){
        cout << fixed << setprecision(5) << "R1 = " << formulaX1 << endl;
        cout << fixed << setprecision(5) <<  "R2 = " << formulaX2 << endl;
    }
}