import random
import threading
import os
import time

def addRandomNumber():
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
    # Criar as threads para cada função
    thread1 = threading.Thread(target=addRandomNumber)
    thread2 = threading.Thread(target=multiplyRandomNumber)
    thread3 = threading.Thread(target=subtractRandomNumber)

    # Iniciar as threads
    thread1.start()
    thread2.start()
    thread3.start()

    # Aguarda a conclusão das threads
    thread1.join()
    thread2.join()
    thread3.join()

def main():
    for i in range(8): 
        os.system('cls' if os.name == 'nt' else 'clear')
        run_threads()
        time.sleep(4)  # Aguarda 2 segundos antes de limpar a tela
        os.system('cls' if os.name == 'nt' else 'clear')
    print("Encerrando processo...")
    
if __name__ == "__main__":
    main()
