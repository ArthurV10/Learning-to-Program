#Entrada
Linha1 = input().split()
Linha2 = input().split()

#Ler os valores de x1 e y1
Valor_x1 = float(Linha1[0])
Valor_y1 = float(Linha1[1])

#Ler os valores de x2 e y2
Valor_x2 = float(Linha2[0])
Valor_y2 = float(Linha2[1])

#Processamento
def calcular_tudo(x1, y1, x2, y2):
    return (((x2 - x1) ** 2) + ((y2 - y1) ** 2)) ** 0.5

resultado = calcular_tudo(Valor_x1, Valor_y1, Valor_x2, Valor_y2)

#Saida
print (f"{resultado:.4f}")