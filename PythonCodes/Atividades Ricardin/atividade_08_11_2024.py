import random
import threading
import os
import time

def addRandomNumber():
    time.sleep(random.uniform(0.5, 1.5))  # Adiciona um atraso aleatório
    number1 = random.random()
    number2 = random.random()
    addNumbers = number1 + number2
    print(f"""
    =======================================================
    Processo 1:
    A soma dos números {number1:.4f} + {number2:.4f} = {addNumbers:.4f}
    =======================================================
    """)

def multiplyRandomNumber():
    time.sleep(random.uniform(0.5, 1.5))  # Adiciona um atraso aleatório
    number1 = random.random()
    number2 = random.random()
    multipliedNumbers = number1 * number2
    print(f"""
    =======================================================
    Processo 2:
    A multiplicação dos números {number1:.4f} x {number2:.4f} = {multipliedNumbers:.4f}
    =======================================================
    """)

def subtractRandomNumber():
    time.sleep(random.uniform(0.5, 1.5))  # Adiciona um atraso aleatório
    number1 = random.random()
    number2 = random.random()
    subtractedNumbers = number1 - number2
    print(f"""
    =======================================================
    Processo 3:
    A subtração dos números {number1:.4f} - {number2:.4f} = {subtractedNumbers:.4f}
    =======================================================
    """)

def run_threads():
    thread1 = threading.Thread(target=addRandomNumber)
    thread2 = threading.Thread(target=multiplyRandomNumber)
    thread3 = threading.Thread(target=subtractRandomNumber)

    thread1.start()
    thread2.start()
    thread3.start()

    thread1.join()
    thread2.join()
    thread3.join()

def main():
    for _ in range(3):
        os.system('cls' if os.name == 'nt' else 'clear')
        run_threads()
        time.sleep(2)
        os.system('cls' if os.name == 'nt' else 'clear')
    print("Encerrando Programa...")

if __name__ == "__main__":
    main()
