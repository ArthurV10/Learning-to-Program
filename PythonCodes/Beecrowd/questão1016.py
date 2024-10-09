#Entrada
Valor_kmh = int(input())

#Processamento
def calcular_tempo(num1):
    return num1 * 2

resultado = calcular_tempo(Valor_kmh)

#Saida
print(f"{resultado} minutos")