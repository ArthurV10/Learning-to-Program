#Entrada
A = int(input())
B = int(input())
C = int(input())
D = int(input())

#Processamento
def calculo(num1, num2, num3, num4):
    return (num1 * num2) - (num3 * num4)

resultado = calculo(A, B, C, D)

#Saida
print(f"DIFERENCA = {resultado}")