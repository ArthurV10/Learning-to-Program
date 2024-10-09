#Entrada
raio = float(input())
pi = 3.14159

#Processamento
def calculo_area(Numero1, Numero2):
    return (Numero1 ** 2) * Numero2

resultado = calculo_area(raio, pi)

#Saida
print(f"A={resultado:.4f}")


    