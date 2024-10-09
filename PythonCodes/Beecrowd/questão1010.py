#Entrada
Linha1 = input().split()
Linha2 = input().split()
#Ler os valores da peça 1!
codigo_peça1 = int(Linha1[0])
quantidade_peça1 = int(Linha1[1])
valor_peça1 = float(Linha1[2])

#Ler os valores da peça 2!

codigo_peça2 = int(Linha2[0])
quantidade_peça2 = int(Linha2[1])
valor_peça2 = float(Linha2[2])

#Processamento
def calcular_peça1(num1, num2):
    return num1 * num2

def calcular_peça2(num1, num2):
    return num1 * num2

soma = calcular_peça1(quantidade_peça1, valor_peça1) + calcular_peça2(quantidade_peça2, valor_peça2)
resultado = soma

#Saida
print(f"VALOR A PAGAR: R$ {resultado:.2f}")