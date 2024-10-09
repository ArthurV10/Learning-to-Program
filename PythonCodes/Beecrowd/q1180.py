def main():
    # Lê o tamanho do vetor
    TamanhoVetor = int(input())
    
    # Lê os valores e converte para uma lista de inteiros
    ValoresVetor = list(map(int, input().split()))
    
    # Encontra o menor valor e sua posição
    MenorValor = min(ValoresVetor)
    Posicao = ValoresVetor.index(MenorValor)
    
    # Exibe o menor valor e a posição
    print("Menor valor:", MenorValor)
    print("Posicao:", Posicao)

main()

