#Entrada
Nome = str(input("primeiro nome do vendedor"))
Salario = float(input())
Valor_vendas_mes = float(input())

#Processamento
def calculo_porcent(num1):
    return num1 * 0.15

valor_pela_porcentagem = calculo_porcent(Valor_vendas_mes)
valor_total = valor_pela_porcentagem + Salario
resultado = valor_total

#Saida
print(f"TOTAL = R$ {resultado:.2f}")

