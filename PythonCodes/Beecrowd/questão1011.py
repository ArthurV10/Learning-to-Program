#Entrada
raio = float(input())
pi = 3.14159

#Processamento
def calcular_volume(num1):
    return (4 * pi * (num1 ** 3)) / 3

resultado = calcular_volume(raio)

#Saida
print(f"VOLUME = {resultado:.3f}")