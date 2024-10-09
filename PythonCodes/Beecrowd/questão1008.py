#Entrada
Numero = int(input())
Salario = int(input())
Dinheiro_hora = float(input())

#Processamento
def calculo(num1, num2):
    return num1 * num2

resultado = calculo(Salario, Dinheiro_hora)

#Saida
print(f"NUMBER = {Numero}")
print(f"SALARY = U$ {resultado:.2f}")