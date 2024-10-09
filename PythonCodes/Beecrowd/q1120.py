def main():
    while True:
        entrada = input().split()
        NumeroQuebrado = entrada[0]
        NumeroEscolhido = entrada[1]
        
        if NumeroQuebrado == '0' and NumeroEscolhido == '0':
            break
        
        # Removendo o dígito falho do número
        NumeroEscolhidoQuebrado = NumeroEscolhido.replace(NumeroQuebrado, '')
        
        # Se a string resultante estiver vazia, imprimir 0
        if NumeroEscolhidoQuebrado == '':
            NumeroEscolhidoQuebrado = '0'
        
        # Remover zeros à esquerda
        print(int(NumeroEscolhidoQuebrado))

main()
