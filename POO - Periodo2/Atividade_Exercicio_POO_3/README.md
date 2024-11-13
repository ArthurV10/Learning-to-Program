# Codigos das Questões
* Resposta para a terceira atividade do professor Ely

## Questão 1 - Crie uma função que recebe como parâmetro um número e retorna true se o número for par e false se for ímpar.
***Resposta:***
```java
import java.util.Scanner;

public class Main {

    public boolean VerificarPar(int numero) {
        return numero % 2 == 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main main = new Main();

        System.out.print("Digite o número que deseja verificar se é par: ");
        int numero = scanner.nextInt();

        if (main.VerificarPar(numero)) {
            System.out.println("O número " + numero + " é par.");
        } else {
            System.out.println("O número " + numero + " é ímpar.");
        }
        scanner.close();
    }
}

```
## Questão 2 - Crie uma função que receba como parâmetros um nome e um pronome de tratamento opcional. Caso esse último não seja fornecido, deve ser considerado o valor “Sr”. Ao final, imprima uma saudação semelhante a “Sra. Sávia”.
***Resposta:*** 
```java
import java.util.Scanner;

public class Main {

    // Método com dois parâmetros
    public String pronomeTratamento(String nome, String pronome) {
        return pronome + " " + nome;
    }

    // Sobrecarga do método para pronome padrão
    public String pronomeTratamento(String nome) {
        return pronomeTratamento(nome, "Sr");
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Bom dia, como prefere ser chamado, Sr ou Sra: ");
        String pronome = scanner.nextLine();

        // Verifica se o pronome é válido
        if (!pronome.equalsIgnoreCase("Sr") &&
                !pronome.equalsIgnoreCase("Sra") &&
                !pronome.equalsIgnoreCase("senhor") &&
                !pronome.equalsIgnoreCase("senhora")) {
            pronome = null;  // Define pronome como nulo se não for válido
        }

        System.out.print("Além disso, qual seu nome: ");
        String nome = scanner.nextLine();

        // Verifica se o pronome é nulo e aplica o tratamento adequado
        String tratamentoCompleto;
        if (pronome == null) {
            tratamentoCompleto = main.pronomeTratamento(nome);
        } else {
            tratamentoCompleto = main.pronomeTratamento(nome, pronome);
        }

        System.out.printf("Olá, %s%n", tratamentoCompleto);

        scanner.close();
    }
}
```
## Questão 3 - Crie uma função que retorne os números de um array passados por parâmetro separados por traço (-) no formato string. Para isso, use o método forEach dos arrays. 
***Resposta:***
```java
public class Main {

    public String toString(int parameter) {
        return String.valueOf(parameter);
    }

    public String colocarTraco(int[] listaNumeros) {
        StringBuilder newList = new StringBuilder();
        for (int i = 0; i < listaNumeros.length; i++) {
            if (i == listaNumeros.length - 1) {
                newList.append(toString(listaNumeros[i]));
            } else {
                newList.append(toString(listaNumeros[i])).append("-");
            }
        }
        return newList.toString();
    }

    public static void main(String[] args) {
        Main main = new Main();
        int[] list = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println("Colocando traços entre os números");
        String listComTracos = main.colocarTraco(list);
        System.out.printf("Lista com traços: %s%n", listComTracos);
    }
}
```
## Questão 4 - Dada a função soma abaixo, tente executar os scripts das alternativas e exiba os eventuais resultados:
```typescript
function soma(x: number, y?: any): number {
return x + y
}
a. console.log(soma(1, 2));
b. console.log(soma(1, "2"));
c. console.log(soma(1));
```
***Resposta:***
```java
public class Main {
    public int soma(int number, Object randomParameter) {
        if (randomParameter instanceof Integer) {
            return number + (Integer) randomParameter;
        } else if (randomParameter instanceof String) {
            try {
                return number + Integer.parseInt((String) randomParameter);
            } catch (NumberFormatException e) {
                System.out.println("O parâmetro String não é um número válido.");
                return number;
            }
        } else if (randomParameter == null) {
            return number;
        } else {
            System.out.println("Tipo de parâmetro não suportado.");
            return number;
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.soma(1, 2));
        System.out.println(main.soma(1, "2"));
        System.out.println(main.soma(1, null));
    }
}
```
## Questão 5 - Crie uma função exibir receba como parâmetro um “rest parameter” representando strings. A função deve exibir no log cada um dos elementos do “rest parameter”. Chame a função usando diferentes quantidade de parâmetros conforme abaixo:
```typescript
exibir(“a”, “b”);
exibir(“a”, “b”, “c”);
exibir(“a”, “b”, “c”, “d”);`
```
***Resposta:***
```java
public class Main {
    public void exibir(String... palavra){
        for (String print : palavra){
            System.out.printf("%s ",print);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Main main = new Main();

        main.exibir("a", "b");
        main.exibir("a", "b", "c");
        main.exibir("a", "b", "c", "d");
    }
}
```
## Questão 6 - Converta em arrow function a seguinte função:
```typescript
function ola(): void {
console.log("Olá");
}
```
***Resposta:***
```typescript
const ola = function () {
    console.log("Olá");
};

function main() {
    ola();
}

main()
```
## Questão 7 - Dado método filter dos arrays, crie uma implementação usando arrow function que filtre todos os elementos pares do array abaixo:
```typescript
const array = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15];
```
***Resposta:*** 
```typescript
function main() {
    var array = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15];
    var pares = array.filter(function (numero) { return numero % 2 === 0; });
    console.log(pares);
}
main();
```
## Questão 8 - Crie um exemplo usando a função map para dobrar os elementos de um array e reduce para totalizar a soma dos elementos do array.
***Resposta:***
```typescript
function main(){
    const array = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15];
    const mapfolding = array.map(numero => numero * 2);
    const reduceSum = array.reduce((acumuldar, numero) => acumuldar + numero, 0);

    console.log(`Lista numeros dobrados: ${mapfolding}`);
    console.log(`Lista numeros somados: ${reduceSum}`);

}
main()
```
