def criarMatriz(linha, colunas):
    matriz = []
    for i in range(linha):
        matriz.append([])
        for j in range(colunas):
            matriz[i].append(0.0)
    return matriz

def preencherMatriz(matriz):
    count = 0
    for i in matriz:
        for j in matriz[i]:
            count += 1
            matriz[j].append(count)
    return matriz

def preencherMatrizManual(matriz):
    for linha in range(len(matriz)):
        for coluna in range(len(matriz[linha])):
            matriz[linha][coluna] = float(input())
    return matriz

def mediaOuSomaLinha(opcao, matriz, linha):
    somatorio = 0

    for numero in matriz[linha]:
        somatorio += numero
    
    media = somatorio / len(matriz[linha])

    return somatorio if opcao == "S" else media

def main():
    numeroL = int(input())
    caracter = input()
    matriz = criarMatriz(12, 12)
    preencherMatrizManual(matriz)
    resultado = mediaOuSomaLinha(caracter, matriz, numeroL)
    print(resultado)
    
main()
