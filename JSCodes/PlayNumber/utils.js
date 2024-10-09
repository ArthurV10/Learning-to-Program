import { question } from "readline-sync";
import fs from "fs"
import { transformInString } from "./vetor_utils.js";

export function getNumber(text){
    return Number(question(text))
}

export function getPositiveNumber(text){
    let number = Number(question(text))
    while (number < 0){
        console.log("Numero Negativo, Invalido!")
        number = Number(question("Digite Novamente: "))
    }
    return number
}

export function getNegativeNumber(text){
    let number = Number(question(text))
    while (number > 0){
        console.log("Numero Positvo, Invalido!")
        number = Number(question("Digite Novamente: "))
    }
    return number
}

export function getNumberInRange(mid, max, text){
    let number = getNumber(text)
    while (number < mid || number > max){
        console.log("Numero Invalido!")
        number = getNumber("Digite um numero novamente: ")
    }
    return number
}


export function getText(text){
    return String(question(text))
}

export function verificationMinMaxForNumber(min, max, number){
    while (number < min || number > max){
        console.log("Numero Anterior Invalido!")
        number = Number(question("Digite um valor entre o minimo e máximo: "))
    }
    return number
}

export function verificationMinMaxInRange(min, max){
    while (min > max){
        console.log("O valor minimo é superior ao máximo")
        console.log("Valor inserido é  invalido!")
        min = getNumber("Informe novamente o valor minimo: ")
        max = getNumber("Informe novamente o valor maximo: ")
    }
    return [min, max]
}

export function pressEnter(){
    return getText("Pressione Enter ")
}

export function clearScrean(){
   return process.stdout.write('\x1B[2J\x1B[3J\x1B[H');
}

/**
 * Salva um arquivo com um nome especificado
 * @param {string} name_archive Nome do arquivo a ser salvo
 * @param {Array} data Array que será convertido em string
 * @returns void
 */
export function saveArchive(name_archive, data) {
    data = transformInString(data);
    if (!fs.existsSync(name_archive)) {
        const newName = getText("Insira o nome do arquivo que deseja criar: ");
        return fs.writeFileSync(newName, data, "utf8");
    }
    return fs.writeFileSync(name_archive, data, "utf8");
}

export function print(text){
    return console.log(text)
}


