#Entrada
Valor_hora = int(input())
Valor_Media_kmh = int(input())
Velocidade_automovel = 12

#Processamento
def calcular_distancia(num1, num2):
    return (num1 * num2)

def gasolina_gasta(num1, num2):
    return (num1 / num2)

resultado_distancia = calcular_distancia(Valor_hora, Valor_Media_kmh)
resultado_gasolina_utilizada = gasolina_gasta(resultado_distancia, Velocidade_automovel)

#Saida
print(f"{resultado_gasolina_utilizada:.3f}")
