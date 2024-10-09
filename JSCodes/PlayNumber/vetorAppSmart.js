// Importar funções de utilidades
import {
    print,
    getNumber, 
    getNumberInRange, 
    pressEnter, 
    clearScrean, 
    getPositiveNumber, 
    saveArchive
} from "./utils.js"

import {showMenu, executeOptionsIn1, itensInTheValue, executeOptionsIn10} from "./vetor_funcionalidades .js"
import {addNumbersInList, removeItemInList, removeItemForValueInList, toFilter, summationList} from "./vetor_utils.js";

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
            // Executa a opção escolhida
            list = executeOptionsIn1(getNumberInRange(1, 3, ">>> "), list[1])
        }
        else if (option === 2){
            console.log("O Valores São ", list[0])
        }
        else if (option === 3){
            list = [[]]
            print("Lista Resetada!")
        }
        else if (option === 4){
            text = itensInTheValue(list[0], getNumber("Digite o valor que deseja verificar: "))
            print(text)
        }
        else if (option === 5){
            print(`O Maior Numero Da Lista é ${(() => Math.max(...list))}`);
            print(`O Menor Numero Da Lista é ${(() => Math.min(...list))}`);
        }
        else if (option === 6){
            let _soma = summationList(list[0])
            print(`O somatorio é igual é ${_soma}`)
        }
        else if (option === 7){
            let _soma = summationList(list[0])
            print(`A média é igual a ${_soma / list[0].length}`)
        }
        else if (option === 8){
            print (`Os numeros positivos são ${(toFilter(list[0], (item) => item > 0))}`)
            print (`A quantidade de numeros positivos = ${(toFilter(list[0], (item) => item > 0).length)}`)
        }
        else if (option === 9){
            print (`Os numeros negativos são ${(toFilter(list[0], (item) => item < 0))}`)
            print (`A quantidade de numeros negativos são ${(toFilter(list[0], (item) => item < 0).length)}`)
        }
        else if (option === 10){
            clearScrean()
            showMenu(opcoesMenu3, "|=====|Terceiro Menu|=====|")
            let _option = getNumberInRange(1, 6, ">>> ")
            list[0] = executeOptionsIn10(list[0], _option)
            print (`Valores Atualizados!`)
        } 
        else if (option === 11){
            print("Lista Atual ", list[0])
            let _qtd = getPositiveNumber("Digite quantos numeros deseja adicionar: ")
            list[0] = addNumbersInList(list[0], _qtd)
        }
        else if (option === 12){
            print("Lista Atual ", list[0])
            let _value = getNumber("Digite o valor que deseja remover: ")
            list[0] = removeItemForValueInList(list[0], _value)
            print("Valor Removido Da Lista!")
        }
        else if (option === 13){
            print("Lista Atual ", list[0])
            let _position = getPositiveNumber("Digite a posição que deseja: ")
            list[0] = removeItemInList(list[0], (_position - 1))
            print("Item Removido Da Lista!")
        }
        else if (option === 14){
            saveArchive(list[1], list[0])
            print("Arquivo Salvo Manulmente")
        }
    pressEnter()
    clearScrean()
    }
    saveArchive(list[1], list[0]);
    print("Arquivo Salvo Automaticamente!");
    print("Encerrando . . .");
}
main()