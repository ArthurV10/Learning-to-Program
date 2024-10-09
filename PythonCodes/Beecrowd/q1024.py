def inverter(palavras):
    palavrasInvertidas = ""
    for letra in palavras:
        palavrasInvertidas = letra + palavrasInvertidas

    return palavrasInvertidas

def converterParaASCII(frase):
    convertidoEmAscii = ""
    for letra in frase:
        codigoAscii = ord(letra)
        if (codigoAscii >= 65 and codigoAscii <= 90) or (codigoAscii >= 97 and codigoAscii <= 122):
            codigoAscii += 3
        
        caractereConvertido = chr(codigoAscii)
        convertidoEmAscii += caractereConvertido

    return convertidoEmAscii

def converterMetade(frase):
    novaFrase = ""
    quantidadeLetras = len(frase) // 2
    for letra in frase[quantidadeLetras:]:
        novaFrase += chr(ord(letra) - 1)
    return frase[:quantidadeLetras] + novaFrase

def main():
    N = int(input())
    for volta in range(N):
        frase = input()
        voltaInicial = converterParaASCII(frase)
        voltaSecundario = inverter(voltaInicial)
        voltaFinal = converterMetade(voltaSecundario)
        print(voltaFinal)
main()