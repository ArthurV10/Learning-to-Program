#Entrada
nota1 = float(input())
nota2 = float(input())
nota3 = float(input())

#Processamento
def media(num1, num2, num3):
    return ((num1 * 2) + (num2 * 3) + (num3 * 5)) / 10

resultado = media(nota1, nota2, nota3)

#Saida
print(f"MEDIA = {resultado:.1f}")