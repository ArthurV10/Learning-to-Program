#Entrada
nota1 = float(input())
nota2 = float(input())

#Processamento
def media(num1, num2):
    return ((num1 * 3.5) + (num2 * 7.5)) / 11

resultado = media(nota1, nota2)

#Saida
print(f"MEDIA = {resultado:.5f}")