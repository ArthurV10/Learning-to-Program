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
**Ely**

**My payment time is 120.56**

**and**

**my preffered language is TypeScript**

```typescript
```