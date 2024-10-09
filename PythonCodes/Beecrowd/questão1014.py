#Entrada
Distancia = int(input())
Valor_gasto = float(input())

#Processamento
def calcular_media_do_gasto(num1, num2):
    return num1 / num2

resultado = calcular_media_do_gasto(Distancia, Valor_gasto)

#Saida
print(f"{resultado:.3f} km/l")