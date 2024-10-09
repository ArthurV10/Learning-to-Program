Linha1 = input().split()
#Entrada
Valor_A = float(Linha1 [0])
Valor_B = float(Linha1 [1])
Valor_C = float(Linha1 [2])
pi =  3.14159

#Processamento
def area_triangulo(base, altura):
    return (base * altura) / 2

def area_circulo(raio, pi):
    return (pi * (raio ** 2))

def area_trapezio (base_maior, base_menor, altura):
    return ((base_maior + base_menor) * altura) / 2

def area_quadrado(lado):
    return (lado ** 2)

def area_retangulo(base, altura):
    return (base * altura)

resultado_triangulo = area_triangulo(Valor_A, Valor_C)
resultado_circulo = area_circulo(Valor_C, pi)
resultado_trapezio = area_trapezio(Valor_A, Valor_B, Valor_C)
resultado_quadrado = area_quadrado(Valor_B)
resultado_retangulo = area_retangulo(Valor_A, Valor_B)


#Saida
print(f"TRIANGULO: {resultado_triangulo:.3f}")
print(f"CIRCULO: {resultado_circulo:.3f}")
print(f"TRAPEZIO: {resultado_trapezio:.3f}")
print(f"QUADRADO: {resultado_quadrado:.3f}")
print(f"RETANGULO: {resultado_retangulo:.3f}")
