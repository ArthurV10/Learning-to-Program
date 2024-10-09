import { getNumber, getText, verificationMinMaxForNumber, verificationMinMaxInRange} from "./utils.js";
import { loadArchive, multiplyNumbers, changeNegativeValueInRange, potentialNumber, fractionReduceNumber, sortList, shuffleVector} from "./vetor_utils.js";

export function showMenu(archive, title){
    let count = 0;
    console.log(title)
    for (let pharse of archive){
        count++;
        if (count < 10){
            console.log(`|0${count} - |${pharse}`);
        }
        else{
        console.log(`|${count} - |${pharse}`);
        }
    }
}

export function executeOptionsIn1(option, _nameArchive) {
    let _numberList = [];
    let rangeMid = 0;
    let rangeMax = 0;
    let range = [];
    let _qtd = 0; 

    if (option !== 3) {
        rangeMid = getNumber("Digite O Valor Minimo: ");
        rangeMax = getNumber("Digite O Valor Máximo: ");
        _qtd = getNumber("Digite A Quantidade De Itens Na Lista: ");
        range = verificationMinMaxInRange(rangeMid, rangeMax);
    }

    if (option === 1) {
        _numberList = generateRandomVectorInRange(range[0], range[1], _qtd, _numberList);
        console.log("Lista Gerada Automaticamente!");
    } else if (option === 2) {
        while (_qtd > 0) {
            _qtd -= 1;
            let _number = getNumber("Digite Um Numero Para Inserir Na Lista: ");
            _numberList.push(verificationMinMaxForNumber(range[0], range[1], _number));
        }
    } else if (option === 3) {
        _nameArchive = getText("Digite O Nome Do Arquivo (Ex: arquivo.txt): ");
        _numberList = loadArchive(_nameArchive);
        console.log("Arquivo Carregado!");
    }
    
    return [_numberList, _nameArchive];
}

export function executeOptionsIn10(list, option){
    let _newNumberList = []
    if (option === 1){
        let _multiple = getNumber("Digite O Numero Que Deseje Que Multiplique: ")
        _newNumberList = multiplyNumbers(list, _multiple)
    }
    else if (option === 2){
        let _potential = getNumber("Digite A Qual Numero Deseja Elevar: ")
        _newNumberList = potentialNumber(list, _potential)
    }
    else if (option === 3){
        let _fraction = getText("Digite A Qual Potencia Deseja Reduzir(Ex: 1/5): ")
        _newNumberList = fractionReduceNumber(list, _fraction)
    }
    else if (option === 4){
        let _min = getNumber("Digite o valor minimo: ")
        let _max = getNumber("Digite o valor maximo: ")
        let _range = verificationMinMaxInRange(_min, _max)
        _newNumberList = changeNegativeValueInRange(list, _range[0], _range[1])
    }
    else if (option === 5){
        _newNumberList = sortList(list)
        console.log("Lista Organizada: ", _newNumberList) 
    }
    else if (option === 6){
        _newNumberList  = shuffleVector(list)
        console.log("Lista Embaralhada: ", _newNumberList) 
    }
    return _newNumberList
}

export function generateRandomVectorInRange(mid, max, qtd, list){
    for (let i = 0; i < qtd; i++ ){
        list.push(Math.floor(Math.random() * (max - mid + 1)) + mid)
    }
    return list
}

export function generateRandom(mid, max){
    return Math.floor(Math.random() * (max - mid + 1)) + mid
} 

export function itensInTheValue(list , value){
    let count = 0 
    for (let item of list){
        if (item === value){
            count ++
        }
    }
    return `Existem ${count} numero(s)`
}
