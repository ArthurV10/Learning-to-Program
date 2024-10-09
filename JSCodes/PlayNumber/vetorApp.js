// Importar funções de utilidades
import {
    getNumber, 
    getNumberInRange, 
    pressEnter, 
    clearScrean, 
    getPositiveNumber, 
    saveArchive
} from "./utils.js"

import {showMenu, executeOptionsIn1, itensInTheValue, executeOptionsIn10} from "./vetor_funcionalidades .js"
import { summationList, calculateAverage, checkPositiveNumbers, checkHigherLowerInList, checkNegativeNumbers,addNumbersInList, removeItemInList, removeItemForValueInList} from "./vetor_utils.js";

const opcoesMenu = [
    "Inicializar Uma Lista",
    "Mostrar Todos os Valores",
    "Resetar Lista",
    "Escolher Valor Para Apresentar Quantidade na Lista",
    "Apresentar o Menor e Maior Valor",
    "Somátorio dos Valores",
    "Média dos Valores",
    "Mostrar Valores Positivos e Quantidade",
    "Mostrar Valores Negativos e Suas Quantidades",
    "Atualizar todos os valores por uma das regras",
    "Adicionar Novos Valores",
    "Remover Itens Por Valor Exato",
    "Remover Por Posição",
    "Salvar Valores Em Arquivo",
    "Sair"
];

const opcoesMenu2 = [
    "Criar Lista Automaticamente",
    "Criar Lista Manualmente", 
    "Carregar Arquivo"
]

const opcoesMenu3 = [
    "Multipicar Lista Por Um Valor",
    "Elevar A Um Valor(Exponenciação)",
    "Reduzir A Uma Fração (Ex: 1/5)",
    "Substituir valores negativos entre um limite minimo e maximo",
    "Ordenar Valores",
    "Embaralhar Valores"
]

function main(){
    clearScrean()
    let list = [[], ""]
    let option = 0
    while (option !== 15){
        clearScrean()
        showMenu(opcoesMenu, "|=====|MENU|=====|");
        option = getNumberInRange(1, 15, ">>> ");
        clearScrean()
        
        // Opção 1 é escolhida e executa o proximo menu
        let text = ""
        if (option === 1){
            showMenu(opcoesMenu2, "|=====|Segundo Menu|=====|")
            // Pergunta qual opção dentro do menu 1 deve ser executada
            let _option = getNumberInRange(1, 3, ">>> ")
            // Executa a opção escolhida
            list = executeOptionsIn1(_option, list[1])
        }
        else if (option === 2){
            console.log("O Valores São ", list[0])
        }
        else if (option === 3){
            list = [[]]
            console.log("Lista Resetada!")
        }
        else if (option === 4){
            let value = getNumber("Digite o valor que deseja verificar: ")
            text = itensInTheValue(list[0], value)
            console.log(text)
        }
        else if (option === 5){
            let _listHigherLower = checkHigherLowerInList(list[0])
            console.log(_listHigherLower[0]);
            console.log(_listHigherLower[1]);
        }
        else if (option === 6){
            let _value = summationList(list[0])
            console.log(`O somatorio é igual é ${_value}`)
        }
        else if (option === 7){
            let _average = calculateAverage(list[0])
            console.log(`A média é igual a ${_average}`)
        }
        else if (option === 8){
            let positiveNumber = checkPositiveNumbers(list[0])
            console.log (`Os numeros positivos são ${positiveNumber[0]}`)
            console.log (`A quantidade de numeros positivos são ${positiveNumber[1]}`)
        }
        else if (option === 9){
            let negativeNumber = checkNegativeNumbers(list[0])
            console.log (`Os numeros negativos são ${negativeNumber[0]}`)
            console.log (`A quantidade de numeros negativos são ${negativeNumber[1]}`)
        }
        else if (option === 10){
            clearScrean()
            showMenu(opcoesMenu3, "|=====|Terceiro Menu|=====|")
            let _option = getNumberInRange(1, 6, ">>> ")
            list[0] = executeOptionsIn10(list[0], _option)
            console.log (`Valores Atualizados!`)
        } 
        else if (option === 11){
            console.log("Lista Atual ", list[0])
            let _qtd = getPositiveNumber("Digite quantos numeros deseja adicionar: ")
            list[0] = addNumbersInList(list[0], _qtd)
        }
        else if (option === 12){
            console.log("Lista Atual ", list[0])
            let _value = getNumber("Digite o valor que deseja remover: ")
            list[0] = removeItemForValueInList(list[0], _value)
            console.log("Valor Removido Da Lista!")
        }
        else if (option === 13){
            console.log("Lista Atual ", list[0])
            let _position = getPositiveNumber("Digite a posição que deseja: ")
            list[0] = removeItemInList(list[0], (_position - 1))
            console.log("Item Removido Da Lista!")
        }
        else if (option === 14){
            saveArchive(list[1], list[0])
            console.log("Arquivo Salvo Manulmente")
        }

    pressEnter()
    clearScrean()
    }
    saveArchive(list[1], list[0]);
    console.log("Arquivo Salvo Automaticamente!");
    console.log("Encerrando . . .");

}
main()

