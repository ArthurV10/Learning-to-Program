import fs from "fs"
import { getNumber, saveArchive } from "./utils.js"
import { generateRandom } from "./vetor_funcionalidades .js"


/**
 * Função que carrega um vetor numérico armazenado em arquivo.
 * @param {archive} archive Nome do arquivo a ser carregado
 * @returns lista de inteiros carregados
 */
export function loadArchive(archive){
    // Guardar nome do arquivo
    let archiveName = archive;

    // Caso o arquivo não exista, criar um novo.
    while (!fs.existsSync(archiveName)){
        console.log("Arquivo Não Existente!")
        console.log("É Nescessário Estar Na Mesma Pasta")
        console.log("É nova arquivo será criado")
        saveArchive(archiveName, " ", "utf8")
    }

    // Array de números carregados do arquivo.
    let archiveNumberArray = [];

    // Ler todas as linhas do arquivo
    let archiveList = fs.readFileSync(archiveName, "utf8").split("\n")
    for (let i = 0; i < archiveList.length; i++ ){
        // Para cada linha, converter em número caso possua um valor
        let _archiveLine = archiveList[i];
        if (_archiveLine.length > 0) {
            let _value = Number(_archiveLine);
            archiveList[i] = _value
            // Adicionar número ao Vetor
            archiveNumberArray.push(_value);
        }
    }
    return archiveNumberArray
}

export function summationList(list){
    let soma = 0
    for (let number of list){
        soma += number
    }
    return soma
}

export function calculateAverage(list){
    let soma = summationList(list)
    let qtdList = list.length
    return (soma / qtdList)
}

export function checkHigherLowerInList(list){
    let highValue = list[0]
    let lowValue = list[0]
    for (let item of list){
        if (item > highValue){
            highValue = item
        }
        else if (item < lowValue){
            lowValue = item
        }
    }
    return [`O Maior Numero Da Lista É ${highValue} `, `O Menor Numero Da Lista é ${lowValue}`]
}

export function checkPositiveNumbers(list) {
    const newList = [];
    let count = 0
    for (let number of list) {
        if (number > 0) {
            count ++
            if (!newList.includes(number)) {
                newList.push(number);
            }
        else{
            continue
        }
        }
    }
    return [newList, count]
}

export function checkNegativeNumbers(list) {
    const newList = [];
    let count = 0
    for (let number of list) {
        if (number < 0) {
            count ++
            if (!newList.includes(number)) {
                newList.push(number);
            }
        else{
            continue
        }
        }
    }
    return [newList, count]
}

export function multiplyNumbers(list, multiply){
    let newList = []
    for (let numbers of list){
        newList.push(numbers * multiply)
    }
    return newList
}

export function potentialNumber(list, potential){
    let newList = []
    for (let numbers of list){
        newList.push(numbers ** potential)
    }
    return newList
}

export function fractionReduceNumber(list, fraction){
    let newList = []
    let calculate = []
    let _fraction = 0
    if (fraction.includes("/")){
        for (let item of fraction){
            if(!item.includes("/")){
                calculate.push(Number(item))
            }
        }

        _fraction = calculate[0] / calculate[1]

        for (let numbers of list){
            newList.push(numbers * _fraction)
        }
    return newList
    }
    return list
}

export function changeNegativeValueInRange(list, min, max){
    let newList = []
    for (let numbers of list){
        if (numbers < 0){
            newList.push(generateRandom(min, max))
        }
        else{
            newList.push(numbers)
        }
        
    }
    return newList
}
    
export function addNumbersInList(list, qtd){
    for (let i = 0; qtd > i; i++ ){
        let _number = getNumber("Digite o numero que deseja adicionar: ")
        list.push(_number)
    }
    return list
}

export function removeItemInList(list, position){
    let newList = []
    if (position === -1){
        position = 0
    }
    for (let number of list){
        if (number === list[position]){
            continue
        }
        newList.push(number)
    }
    return newList
}

export function removeItemForValueInList(list , value){
    let newList = []
    for (let number of list){
        if (number === value){
            continue
        }
        newList.push(number)
    }
    return newList
}

export function transformInString(archive) {
    let newList = "";
    for (let item of archive) {
        newList += String(item) + "\n";
    }
    return newList.trim(); // Remove a última nova linha desnecessária
}

export function sortList(list) {
    let newList = [];
    while (list.length > 0) {
        let lowerNumber = list[0];
        let index = 0;

        for (let i = 1; i < list.length; i++) {
            if (list[i] < lowerNumber) {
                lowerNumber = list[i];
                index = i;
            }
        }
        newList.push(lowerNumber);
        list.splice(index, 1);
    }
    return newList;
}

export function shuffleVector(list) {
    let newList = [];
    while (list.length > 0) {
        // Gera um índice aleatório entre 0 e o comprimento atual da lista menos 1
        let indexNumber = generateRandom(0, list.length - 1);
        // Adiciona o item aleatório à nova lista
        newList.push(list[indexNumber]);
        // Remove o item selecionado da lista original
        list.splice(indexNumber, 1);
    }
    return newList;
}

export function toFilter(list, condition){
    const newList = []
    for (let item of list){
        if (condition(item)){
            newList.push(item)
        }
    }
    return newList
}
