# Questão 1 - Qual a diferença entre tipagem dinâmica e tipagem estática?
**Resposta:** 

A tipagem dinâmica, não é necessário definir o tipo da variável; ele é determinado automaticamente com base no valor atribuído a ela e pode mudar ao longo do programa. Por exemplo, em linguagens como Python ou JavaScript, você pode fazer:
```python
x = 5    # 'x' é um inteiro agora
x = "texto"  # agora 'x' é uma string

```

Já na tipagem estática, é preciso definir o tipo da variável ao inicializá-la e, uma vez definido, o tipo não pode ser alterado. Se você tentar atribuir um valor de um tipo diferente, ocorrerá um erro. Por exemplo, em Java:

```java
int x = 5;   // 'x' é um inteiro
x = "texto"; // Erro: tipo incompatível
```
# Questão 2 - Qual o principal problema do uso de tipagem dinâmica?
**Resposta:**

O principal problema da tipagem dinâmica ocorre no momento do uso das variáveis, pois pode gerar erros "invisíveis". Como os tipos são determinados **durante a execução**, a linguagem não identifica problemas antecipadamente, como o uso de **tipos errados**.

Por exemplo, se uma função espera um valor do tipo `int` e você passa uma variável `string`, isso pode causar um erro apenas quando o código é executado. Esse tipo de erro é mais difícil de detectar, pois o programa pode falhar sem expressar claramente o motivo exato do problema, tornando a depuração mais complicada.

# Questão 3 - Pesquise um exemplo na internet em que a tipagem dinâmica pode ser problemático.
**Resposta:**

Em um caso normal como este não ocorrerá nenhum problema.

```python
def soma_lista(numeros):
    total = 0
    for numero in numeros:
        total += numero
    return total

# Testando a função
lista = [10, 20, 30]
print(soma_lista(lista))  # Saída esperada: 60
```

Porém se a lista criada possui valores diferentes de int, como na lista abaixo:

```python
lista = [10, 20, "30"]  # O último item é uma string, não um número
print(soma_lista(lista))
```

Irá ocorrer problemas no código ao ser executado.

# Questão 4 - Pesquise e exemplifique com um exemplo porque dizemos que a linguagem C, mesmo tendo tipagem estática, possui tipagem fraca.

Ele possui uma tipagem fraca, pois mesmo sendo estática existe maneiras de alterar o tipo da variável dentro da linguagem C, assim como é visto abaixo:
```c
#include <stdio.h>

int main() {
    int num = 65;
    char c = (char)num;  // Coerção explícita de int para char
    printf("O caractere é: %c\n", c);

    int *ptr = (int *)"Texto";
    printf("Valor do ponteiro: %d\n", *ptr); // Acessando memória inválida
    return 0;
}
```
Ocorre do `num` deixar de ser o número **65** e virar a letra `A`, por conta do código ASCII.

# Questão 5 - Poderíamos dizer que a tipagem do TypeScript é fraca por uma variável do tipo number aceitar tanto inteiros como ponto flutuante?
**Resposta:**

Não, pois uma váriavel do tipo `number` aceitar números inteiros e números flutuantes não entra no conceito de **tipagem fraca**, pois é algo da linguagem, números inteiros e flutuantes entram na categoria `number`, então não está alterando o tipo da variável.

# Questão 6 - Reescreva o exemplo abaixo, mantendo a quebra de linhas usando template strings e os valores Ely, 120.56 e TypeScript venham de variáveis declaradas separadamente e “interpoladas” na string:
* _Ely_

* _My payment time is 120.56_

* _and_

* _my preffered language is TypeScript_

**Resposta:**
```typescript
function main(){
    let name = "Ely";
    let value = 120.56;
    let language = "TypeScript";

    console.log(`${name}\nMy payment time is ${value}\nand\nmy preffered language is ${language}`);
}
main();
```

O codigo em TypeScript compilado ficará assim (JavaScript):
```javascript
"use strict";
function main() {
    let name = "Ely";
    let value = 120.56;
    let language = "TypeScript";
    console.log(`${name}\nMy payment time is ${value}\nand\nmy preffered language is ${language}`);
}
main();
```

O codigo acima não se diferencia muito antes e após a compilação, ele continua bem semelhante

# Questão 7 - Pesquise e configure o seu arquivo de configuração do TypeScript com as opções abaixo. Faça testes com as mudanças e perceba a diferença após a configuração.
* a. Alterar o local em que os arquivos *.js são gerados para a pasta build;
* b. allowUnreachableCode com valor true;
https://www.typescriptlang.org/pt/tsconfig#allowUnreachableCode
* c. noImplicitAny com valor true;
https://www.typescriptlang.org/pt/tsconfig#noImplicitAny
* d. target com o valor ES3. Além disso, utilize a classe do exercício anterior e
veja como ela é transpilada para JS;
* e. strictNullChecks para true e crie um exemplo que mostre a restrição;
* f. Configure um projeto seu para que seja possível realizar depuração
alterando o atributo sourceMap;

**Resposta:**

***Consequência da `Letra A`*** é definir onde os códigos compilados do typescript serão salvos. 
(Obs: É necessários descomentar a linha para ativar configuração)

Modificação:
```typescript
{
  "compilerOptions": {
    "outDir": "./build"
  }
}
```
***Consequência da `Letra B`*** é ignorar os códigos que não serão executados, pode até possuir algum erro nele, porém como está em um lugar onde será inatingível, por exemplo após um `return`, então ele não será executado, assim não notificará erros.

Modificação:
```typescript
{
  "compilerOptions": {
    "noImplicitAny": true
  }
}
```

***Consequência da `Letra C`*** é ele exigir que todas as variaveis sejam tipadas ao serem inicializadas, caso contrário irá ocorrer um erro no código.

Modificação:
```typescript
{
  "compilerOptions": {
    "noImplicitAny": true
  }
}
```

***Consequência da `Letra D`*** é o TypeScript transpila o código para uma versão do JavaScript compatível com navegadores e ambientes muito antigos, como o Internet Explorer 6.

Modificação: 
```typescript
{
  "compilerOptions": {
    "target": "ES3"
  }
}
```

***Consequência da `Letra E`*** é o TypeScript impede que variáveis aceitem `null` ou `undefined` como valores, a menos que sejam explicitamente do tipo null ou undefined. Isso ajuda a evitar erros comuns relacionados a valores nulos.

Modificação: 
```typescript
{
  "compilerOptions": {
    "strictNullChecks": true
  }
}
```
Exemplo Prático:
```typescript
function getLength(str: string): number {
  return str.length;
}

const myString: string | null = null;
console.log(getLength(myString)); // Com strictNullChecks: true, isso causará um erro.
```

***Consequência da `Letra F`*** é o compilador criar um arquivo `.map` assim permitindo que durante a depuração do código seja possivel ver os erros no código TypeScript ao invés do codigo compilado em JavaScript.

Modificação:
```typescript
{
  "compilerOptions": {
    "sourceMap": true
  }
}
```