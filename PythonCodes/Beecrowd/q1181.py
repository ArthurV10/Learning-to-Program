def criarMatriz(linha, colunas):
    matriz = []
    for i in range(linha):
        matriz.append([])
        for j in range(colunas):
            matriz[i].append(0.0)
    return matriz

def preencherMatrizManual(matriz):
    for linha in range(len(matriz)):
        for coluna in range(len(matriz[linha])):
            matriz[linha][coluna] = float(input())
    return matriz

def mediaOuSomaColuna(opcao, matriz, coluna):
    somatorio = 0
    qtd = 0

    for linha in range(len(matriz)):
        somatorio += matriz[linha][coluna]
        qtd += 1
    
    media = somatorio / qtd

    return somatorio if opcao == "S" else media

def main():
    numeroC = int(input())
    caracter = input()
    matriz = criarMatriz(12, 12)
    preencherMatrizManual(matriz)
    resultado = mediaOuSomaColuna(caracter, matriz, numeroC)
    print(f"{resultado:.1f}")
    
main()
