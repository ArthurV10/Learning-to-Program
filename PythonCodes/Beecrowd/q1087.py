def main():
    ## Entrada
    positions = list(map(int,input().split()))

    while positions != [0,0,0,0]:
        ## Processamento
        initalPostion = [positions[0],positions[1]]
        destinationPosition = [positions[2],positions[3]]

        differenceX = abs(initalPostion[0] - destinationPosition[0])
        differenceY = abs(initalPostion[1] - destinationPosition[1])

        moves = 0

        if initalPostion == destinationPosition:
            moves = 0
        elif differenceX == differenceY or initalPostion[0] == destinationPosition[0] or initalPostion[1] == destinationPosition[1]:
            moves = 1
        else:
            moves = 2


        ## Saída
        print(moves)

        positions = list(map(int,input().split()))

main()  