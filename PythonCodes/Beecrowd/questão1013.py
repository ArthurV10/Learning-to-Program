#Formatar em uma unica linha
Linha1 = input().split()

if len(Linha1) < 3:
    print("Por favor, insira pelo menos três números.")
# Entrada
else:
    ValorA = int(Linha1[0])
    ValorB = int(Linha1[1])
    ValorC = int(Linha1[2])

# Processamento
def calcular_maior(num1, num2):
     return (num1 + num2 + abs(num1 - num2)) / 2

resultado_de_AB = calcular_maior(ValorA, ValorB)
resultado_ver_maior = calcular_maior(resultado_de_AB, ValorC)

# Saida
print(f"{resultado_ver_maior:.0f} eh o maior")

