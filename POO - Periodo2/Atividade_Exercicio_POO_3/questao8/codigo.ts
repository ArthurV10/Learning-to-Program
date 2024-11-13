function main(){
    const array = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15];
    const mapfolding = array.map(numero => numero * 2);
    const reduceSum = array.reduce((acumuldar, numero) => acumuldar + numero, 0);

    console.log(`Lista numeros dobrados: ${mapfolding}`);
    console.log(`Lista numeros somados: ${reduceSum}`);

}
main()