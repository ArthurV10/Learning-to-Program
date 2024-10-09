from utils import *
import random
import copy
from typing import Callable


# Definições de cores ANSI
BOLD = '\033[1m'
ITALIC = '\033[3m'
RED = '\033[91m'
GREEN = '\033[92m'
BLUE = '\033[94m'
RESET = '\033[0m'


TEXT_TUTORIAL = [
    F"|=======================|{BOLD}TUTORIAL{RESET}|=======================|",
    "| 1 - O Simbolo '-' Significa Vazio                      |",
    "|========================================================|",
    "|     Quando Quiser Mover Uma Peça Para Outro Local,     |",
    "| 2 - Digite O Simbolo Da Torre Que Deseja A Peça Mover, |",
    "|     O Simbolo Da Torre Que Deve Receber A Peca         |",
    "|========================================================|",
    f"|     Exemplo: '{RED}R{RESET}{GREEN}G{RESET}' Move A Peça Da Torre {RED}R{RESET} Para {GREEN}G{RESET}        |",
    "|========================================================|"
]


TEXT_MENU = [
    "Single Player        |",
    "Multiplayer          |",
    "Dificuldade          |",
    "Sair                 |"
]

def rainbow_text(text):
    for i in range(len(text)):
        color_code = 20 + (i % 216) 
        print(f"\033[38;5;{color_code}m{text[i]}", end="")
    print("\033[0m")  # Resetar a cor


def generateTowers(size: int = 1, qtd: int = 1, function: Callable[[], str] = lambda: ""):
    tower = []
    for i in range(size):
        tower.append([])  # Cria uma nova sublista para cada "andar"
        for j in range(qtd):
            if j == 0:
                tower[i].append(function())  # Chama a função para obter o valor
            elif j >= 1:
                 tower[i].append("-")  # Adiciona um espaço vazio
    return tower


def generateRandomRGB() -> str:
    number = random.randint(1, 3)
    match number:
        case 1:
            return "R"
        case 2:
            return "G"
        case 3:
            return "B"


def showTowerVertical(qtdtowers, sizeTower, towers):
    print(f"|=========||{BOLD}HANOI{RESET} {RED}R{RESET}{GREEN}G{RESET}{BLUE}B{RESET}||=========|")
    print(f"| Torre {RED}R{RESET} || Torre {GREEN}G{RESET} || Torre {BLUE}B{RESET} |")
    print("=================================")
    for i in range(sizeTower):  # Itera primeiro sobre os andares (linhas)
        for j in range(qtdtowers):  # Itera sobre as torres (colunas)
            # Adiciona cores dependendo do valor da torre
            cell = towers[i][j]
            if cell == "R":
                print(f"|    {RED}R{RESET}", end="    |")
            elif cell == "G":
                print(f"|    {GREEN}G{RESET}", end="    |")
            elif cell == "B":
                print(f"|    {BLUE}B{RESET}", end="    |")
            else:
                print(f"|    {cell}", end="    |")
        print()  # Pula para a próxima linha após cada andar
    print("=================================")


def showTutorial(arrayText):
    # Pega cada index do array criado, e printa valor por valor
    for index in range(len(arrayText)):
        print(arrayText[index])


def HanoiRGBGameMoviment(tower, answer):
    tower_map = {'R': 0, 'G': 1, 'B': 2}
    count = 0

    if len(answer) != 2:
        print("Erro: A entrada deve conter exatamente dois caracteres (ex: 'RG').")
        pressEnter()
        return count
    
    try:
        # Tenta obter os índices das torres a partir do dicionário
        from_tower = tower_map[answer[0]]
        to_tower = tower_map[answer[1]]

    except KeyError:
        # Se uma das chaves não for encontrada, imprime uma mensagem de erro e retorna
        print("Erro: Torre inválida. Use 'R', 'G', ou 'B'.")
        pressEnter()
        return count

    # Encontre a posição da peça a ser movida na torre de origem (de baixo para cima)
    piece = "-"
    for i in range(len(tower)):  # De baixo para cima
        if tower[i][from_tower] != "-":
            piece = tower[i][from_tower]
            tower[i][from_tower] = "-"  # Remove a peça do local encontrado
            break

    # Adiciona a peça no topo da torre de destino (de baixo para cima)
    if piece != "-":  # Se encontrou uma peça válida
        count += 1
        for i in range(len(tower) - 1, -1, -1):  # De cima para baixo
            if tower[i][to_tower] == "-":
                tower[i][to_tower] = piece  # Coloca a peça no novo local
                break
    return count


def verificationHanoiSuccessful(towers):
    # Funções para verificar cada torre individualmente
    def is_valid_tower(tower, valid_char):
        return all(cell == valid_char or cell == "-" for cell in tower)

    # Verifica as torres individualmente
    return (
        is_valid_tower([tower[0] for tower in towers], "R") and
        is_valid_tower([tower[1] for tower in towers], "G") and
        is_valid_tower([tower[2] for tower in towers], "B")
    )


def clearScreen():
    # Função para limpar o terminal
    import os
    os.system('cls' if os.name == 'nt' else 'clear')


def singlePlayer():
    count = 0
    towers = generateTowers(9, 3, generateRandomRGB)  # Gera torres com valores aleatórios

    while not verificationHanoiSuccessful(towers):
        clearScreen()
        showTowerVertical(3, 9, towers)
        rainbow_text(f"O Total De Movimentos Foi: {count}")
        _answer = input("Digite Seu Movimento (Ex: RG, BG): ").upper()
        count += HanoiRGBGameMoviment(towers, _answer)  # Agora a função modifica towers diretamente
    
    clearScreen()
    showTowerVertical(3, 9, towers)
    if count < 12:
        rainbow_text(f"{count} Movimento/s, Você Foi Muito Bem, Parabens!")
    elif count >= 12 and count <= 16:
        rainbow_text(f"{count} Movimento/s, Parabens!")
    else:
        rainbow_text(f"{count} Movimento/s, Nhe... Poderia Ser Melhor!")
    pressEnter()


def multiplayer():
    countPlayer1 = 0
    countPlayer2 = 0
    towersPlayer1 = generateTowers(9, 3, generateRandomRGB)  # Gera torres para o Player 1
    towersPlayer2 = copy.deepcopy(towersPlayer1)  # Cria uma cópia para o Player 2

    # Player 1 joga primeiro
    print(f"{ITALIC}Vez Do Player 1 Jogar!{RESET}")
    pressEnter()
    while not verificationHanoiSuccessful(towersPlayer1):
        clearScreen()
        showTowerVertical(3, 9, towersPlayer1)
        rainbow_text(f"O Total De Movimentos Foi: {countPlayer1}")
        _answer = input("Digite Seu Movimento (Ex: RG, BG): ").upper()
        countPlayer1 += HanoiRGBGameMoviment(towersPlayer1, _answer)

    # Player 2 joga após o Player 1 terminar
    print(f"{ITALIC}Vez Do Player 2 Jogar!{RESET}")
    pressEnter()
    while not verificationHanoiSuccessful(towersPlayer2):
        clearScreen()
        showTowerVertical(3, 9, towersPlayer2)
        rainbow_text(f"O Total De Movimentos Foi: {countPlayer2}")
        _answer = input("Digite Seu Movimento (Ex: RG, BG): ").upper()
        countPlayer2 += HanoiRGBGameMoviment(towersPlayer2, _answer)

    # Verifica quem venceu
    clearScreen()

    # Mostra o estado final das torres
    print("\nEstado final das torres do Player 1:")
    showTowerVertical(3, 9, towersPlayer1)
    print("\nEstado final das torres do Player 2:")
    showTowerVertical(3, 9, towersPlayer2)

    if countPlayer1 < countPlayer2:
        print(f"Player 1 Venceu Por {countPlayer2 - countPlayer1} Movimento(s)")
    elif countPlayer1 > countPlayer2:
        print(f"Player 2 Venceu Por {countPlayer1 - countPlayer2} Movimento(s)")
    else:
        print("O Jogo Encerrou Em Empate!")

    pressEnter()


def tutorial():
    answerTutorial = "?"
    while answerTutorial != "S":
        clearScreen()
        showTutorial(TEXT_TUTORIAL)
        answerTutorial = input(">>> Foi Possivel Entender A Brincadeirinha? (S/N): ").upper()
        if answerTutorial == "N":
            print()
            print(f"Para Obter Um Conhecimento Mais Amplo, Visite: {BLUE}https://clubes.obmep.org.br/blog/torre-de-hanoi/{RESET}")
            input("Pression ENTER para prosseguir!")


def menu(option):
    clearScreen()
    showMenu(TEXT_MENU, "|======| HANOI MENU |======|")
    print("============================")
    option = int(input(">>> "))
    match option:
        case 1:
            singlePlayer()
        case 2:
            multiplayer()
        case 3:
            difficult()
        case 4:
            return option


def main():
    option = 0
    tutorial()
    while option != 4:
        option = menu(option)
    print("Encerrando Program...")


main()
