def main():
    sizeMatrix = 999
    while sizeMatrix > 0:
        sizeMatrix = int(input)
        matrix = createMatrix(sizeMatrix, sizeMatrix)
        fillMatrix( *2 ,matrix)

def createMatrix(line, column):
    matrix = []
    for i in range(line):
        matrix.append([])
        for j in range(column):
            matrix[line].append(0.0)
    return matrix

def fillMatrix(matrix):
    # Terminar depois a questão
    numeroProgressivo = 1
    numeroInicialLinha = 1
    for numero in range(len(matrix)):
        for numeroColumn in range(len(matrix[numero])):
        numeroInicialLinha += 1

