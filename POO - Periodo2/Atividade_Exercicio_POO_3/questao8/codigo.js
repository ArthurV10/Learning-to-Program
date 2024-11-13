function main() {
    var array = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15];
    var mapfolding = array.map(function (numero) { return numero * 2; });
    var reduceSum = array.reduce(function (acumuldar, numero) { return acumuldar + numero; }, 0);
    console.log("Lista numeros dobrados: ".concat(mapfolding));
    console.log("Lista numeros somados: ".concat(reduceSum));
}
main();
