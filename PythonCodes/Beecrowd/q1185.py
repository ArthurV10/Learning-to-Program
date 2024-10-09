def main():
    operation = input()
    matrix = createMatrix(12, 12)
    fillMatrixManual(matrix)
    result = sumOrAverageAboveDiagonalSecondary(matrix, operation)
    print(f"{result:.1f}")

def createMatrix(linha, coluna):
    matrix = []
    for i in range(linha):
        matrix.append([])
        for j in range(coluna):
            matrix[i].append(0.0)
    return matrix
    
def fillMatrixManual(matrix):
    for line in range(len(matrix)):
        for column in range(len(matrix[line])):
            matrix[line][column] = float(input())

def sumOrAverageAboveDiagonalSecondary(matrix, option):
    _sum = 0
    _qtd = 0
    for line in range(len(matrix)):
        for column in range(len(matrix[line])):
            if column + line < len(matrix) - 1:
                _sum += matrix[line][column]
                _qtd += 1
    return _sum if option == "S" else _sum / _qtd

main()
