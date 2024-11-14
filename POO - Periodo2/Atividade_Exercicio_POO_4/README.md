# Questão 1 - Assinale verdadeiro ou falso:
* (`F`) Objetos são modelos para classes;
* (`F`) Atributos de uma classe devem ser obrigatoriamente inicializados para que as
classes compilem;
* (`F`) Uma variável declarada dentro de um método deve ser inicializada para que a
classe seja compilável;
* (`V`) Uma variável que seja uma classe declarada em um método é automaticamente
inicializada com undefined;
* (`V`) Construtores são rotinas especiais que servem para inicializar e configurar os
objetos no momento da instanciação;
* (`V`) Construtores não possuem tipo de retorno e podem ou não ter parâmetros;
* (`V`) Uma classe pode ter várias instâncias.

# Questão 2 - Suponha uma classe Hotel que sirva apenas para guardar a quantidade de solicitações de reservas feitas conforme abaixo:
```typescript
class Hotel {
    quantReservas : number;
    adicionarReserva() : void {
        this.quantReservas++;
    }
}
```
## Podemos afirmar que haverá um problema de compilação, pois a variável inteira não foi inicializada previamente? Justifique.
***Resposta:***

Sim, pode-se afirmar isso. Pois a variavel quando não possui uma inicialização recebe por padrão o valor `undefined`, assim não podendo incrementar a variável, logo gerando o erro no código.

# Questão 3 - Ainda sobre a classe do exemplo anterior, considere o código abaixo:
```typescript
let hotel : Hotel = new Hotel(2);
console.log(hotel.quantReservas);
```

### Adicione o construtor que aceite um parâmetro inteiro e faça a inicialização do atributo `quantReservas`. 
***Resposta:***

# Questão 4 - 4. Considere a classe Radio e as instruções que fazem seu uso abaixo:
```typescript
class Radio {
    volume : number;
    constructor(volume : number) {
    this.volume = volume;
    }
}

let r : Radio = new Radio();
r.volume = 10;
```
### Justifique o erro de compilação e proponha uma solução.

***Resposta:***

O erro ocorre pois o contrutor exige uma variável para inicializar o valor de volume, porém como ele não recebe esta variável, acaba gerando um erro no codigo. A solução é simples, ao invés de colocar `r.volume = 10`, pode ser colocado o valor 10 diretamente como o parametro de `Radio`, desta maneira a seguir `new Radio(10)`, assim a inicializará o volume corretamente.

# Questão 5 -Considerando o uso da classe Conta apresentada em aula e seu uso abaixo:
```typescript
let c1: Conta = new Conta("1",100);
let c2: Conta = new Conta("2",100);
let c3: Conta;
c1 = c2;
c3 = c1;
c1.sacar(10);
c1.transferir(c2,50);
console.log(c1.consultarSaldo());
console.log(c2.consultarSaldo());
console.log(c3.consultarSaldo());
```
### a. Qual o resultado dos dois "prints"? Justifique sua resposta.

***Resposta:***

 O resultado dos prints será 40 em todas as impressões, pois todas as variáveis `c1, c2, c3` apontam para o mesmo objeto de Conta, e todas as operações afetam esse único objeto

### b. O que acontece com o objeto para o qual a referência c1 apontava?

***Resposta:*** 

O objeto que `c1` apontava originalmente é substituído pela referência de `c2`, e se não houver mais referências para o objeto original, ele será eventualmente removido da memória.
# Questão 6 - Crie uma classe chamada Saudacao que:
* Contenha um atributo chamado texto e outro chamado destinatario, ambos String;
* Crie um construtor que inicializa os dois atributos;
* Crie um método obterSaudacao() que retorne a concatenação dos dois atributos. Ex: "Bom dia, João";
* Instancie uma classe Saudacao e teste seu método obterSaudacao().

***Resposta:*** 

Código da Main
```java
package application;
import entities.Saudacao;

public class Main {
    public static void main(String[] args) {
        Saudacao saudacao = new Saudacao("Bom dia, ", "João");
        System.out.println(saudacao.obterSaudacao());
    }
}
```
Código da Classe Saudação
```java
package entities;

public class Saudacao {
    private String saudacao;
    private String nome;

    public Saudacao(String saudacao, String nome) {
        this.saudacao = saudacao;
        this.nome = nome;
    }

    public String obterSaudacao() {
        return this.saudacao + this.nome;
    }
}
```

# Questão 7 - Crie uma classe chamada Triangulo que:
* Possua 3 atributos inteiros representando os lados;
* Crie um método que retorna true se os lados formarem um triângulo de
acordo com a regra: |b-c| < a < b+c;
* Crie 3 métodos: ehIsoceles(), ehEquilatero() e ehEscaleno() que retorne
verdadeiro caso o triângulo seja um dos tipos relacionados ao nome do
método. Eles devem chamar antes de tudo, o método da questão b. e
retornar false se esse método já retornar false também;
* Instancie classes Triangulo de diferentes lados e seus métodos.

***Resposta:*** 

Código da Main
```java
package application;
import entities.Triangulo;

public class Main {
    public static void main(String[] args) {
        Triangulo triangulo1 = new Triangulo(3, 4, 5);
        System.out.println("Triângulo 1 é triângulo: " + triangulo1.ehTriangulo());
        System.out.println("Triângulo 1 é isósceles: " + triangulo1.ehIsoceles());
        System.out.println("Triângulo 1 é equilátero: " + triangulo1.ehEquilatero());
        System.out.println("Triângulo 1 é escaleno: " + triangulo1.ehEscaleno());
        System.out.println();

        Triangulo triangulo2 = new Triangulo(2, 2, 2);
        System.out.println("Triângulo 2 é triângulo: " + triangulo2.ehTriangulo());
        System.out.println("Triângulo 2 é isósceles: " + triangulo2.ehIsoceles());
        System.out.println("Triângulo 2 é equilátero: " + triangulo2.ehEquilatero());
        System.out.println("Triângulo 2 é escaleno: " + triangulo2.ehEscaleno());
        System.out.println();

        Triangulo triangulo3 = new Triangulo(2, 2, 3);
        System.out.println("Triângulo 3 é triângulo: " + triangulo3.ehTriangulo());
        System.out.println("Triângulo 3 é isósceles: " + triangulo3.ehIsoceles());
        System.out.println("Triângulo 3 é equilátero: " + triangulo3.ehEquilatero());
        System.out.println("Triângulo 3 é escaleno: " + triangulo3.ehEscaleno());
        System.out.println();
        
    }
}
```
Código da Classe Triângulo
```java
package entities;

public class Triangulo {
    private int lado1;
    private int lado2;
    private int lado3;

    // Construtor para inicializar os lados do triângulo
    public Triangulo(int lado1, int lado2, int lado3) {
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }

    // Método que verifica se os lados formam um triângulo
    public boolean ehTriangulo() {
        return (Math.abs(this.lado2 - this.lado3) < this.lado1) && (this.lado1 < (this.lado2 + this.lado3)) &&
                (Math.abs(this.lado1 - this.lado3) < this.lado2) && (this.lado2 < (this.lado1 + this.lado3)) &&
                (Math.abs(this.lado1 - this.lado2) < this.lado3) && (this.lado3 < (this.lado1 + this.lado2));
    }

    // Método que verifica se o triângulo é isósceles
    public boolean ehIsoceles() {
        if (!ehTriangulo()) {
            return false;
        }
        return (lado1 == lado2 && lado1 != lado3) ||
                (lado1 == lado3 && lado1 != lado2) ||
                (lado2 == lado3 && lado2 != lado1);
    }

    // Método que verifica se o triângulo é equilátero
    public boolean ehEquilatero() {
        if (!ehTriangulo()) {
            return false;
        }
        return lado1 == lado2 && lado2 == lado3;
    }

    // Método que verifica se o triângulo é escaleno
    public boolean ehEscaleno() {
        if (!ehTriangulo()) {
            return false;
        }
        return lado1 != lado2 && lado1 != lado3 && lado2 != lado3;
    }
}

```
# Questão 8 - Uma classe Equipamento com:
* a. um atributo ligado (tipo boolean)
* b. dois métodos liga() e desliga(). O método liga torna o atributo ligado true e o método desliga torna o atributo ligado false.
* c. Crie um método chamado inverte(), que muda o status atual (se ligado, desliga...se desligado, liga)
* d. Crie um método que estaLigado() que retorna o valor do atributo ligado
* e. Altere o comportamento do método ligar() para caso o equipamento já esteja ligado, não ligue novamente. Faça o mesmo com o método desligar().
* f. Instancie uma classe Equipamento e teste todos os seus métodos.

***Resposta:*** 
Código da Main
```java
package application;
import entities.Equipamento;

public class Main {
    public static void main(String[] args) {
       Equipamento lampada = new Equipamento(false);

        System.out.println("Estados da Lampada:");

       //Liga o equipamento
        lampada.liga();
        System.out.println("Aparelho esta ligado? = " + lampada.estaLigado());
        System.out.println();

        //Desliga o aparelho
        lampada.desliga();
        System.out.println("Aparelho esta ligado? = " + lampada.estaLigado());
        System.out.println();

        //Inverte o estado atual do aparelho
        lampada.inverte();
        System.out.println("Aparelho esta ligado? = " + lampada.estaLigado());
    }
}
```
Código da Classe Equipamento
```java
package entities;

public class Equipamento {
    private boolean ligado;

    public Equipamento(boolean modo){
         this.ligado = modo;
    }
    public void liga(){
        if (this.ligado == true){
            ;
        }
        this.ligado = true;
    }

    public void desliga(){
        if (this.ligado == false){
            ;
        }
        this.ligado = false;
    }

    public void inverte(){
        this.ligado = !this.ligado;
    }

    public boolean estaLigado(){
        return this.ligado;
    }
}

```
# Questão 9 - Altere a classe conta dos slides conforme as instruções abaixo:
* Altere o método sacar de forma que ele retorne verdadeiro ou falso. Caso o saque deixe saldo negativo, o mesmo não será realizado, retornando falso;
* Altere o método transferir() para que retorne também um valor lógico e que não seja feita a transferência caso o sacar() na conta origem não seja satisfeito;
* Verifique as diferentes operações implementadas.

***Resposta:*** 

Código da Main
```java
package application;

import entities.Conta;

public class Main {
    public static void main(String[] args) {
        // Criação de contas para teste
        Conta conta1 = new Conta(500);
        Conta conta2 = new Conta(300);

        // Testando saque
        System.out.println("Saque de 200 da Conta 1: " + conta1.sacar(200));
        System.out.println("Saldo da Conta 1: " + conta1.getSaldo());
        System.out.println();

        System.out.println("Saque de 400 da Conta 1: " + conta1.sacar(400));
        System.out.println("Saldo da Conta 1: " + conta1.getSaldo());
        System.out.println();

        // Testando depósito
        System.out.println("Depósito de 100 na Conta 1: " + conta1.depositar(100)); // Deve retornar true
        System.out.println("Saldo da Conta 1: " + conta1.getSaldo());
        System.out.println();

        // Testando transferência
        System.out.println("Transferência de 150 da Conta 1 para Conta 2: " + conta1.transferir(conta2, 150)); // Deve retornar true
        System.out.println("Saldo da Conta 1: " + conta1.getSaldo());
        System.out.println("Saldo da Conta 2: " + conta2.getSaldo());
        System.out.println();

        System.out.println("Transferência de 300 da Conta 1 para Conta 2: " + conta1.transferir(conta2, 300)); // Deve retornar false
        System.out.println("Saldo da Conta 1: " + conta1.getSaldo());
        System.out.println("Saldo da Conta 2: " + conta2.getSaldo());
        System.out.println();
    }
}
```
Código da Classe Conta
```java
package entities;

public class Conta {
    private double saldo;

    // Construtor para inicializar o saldo
    public Conta(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            return true;
        }
        return false; // Saldo insuficiente ou valor inválido
    }

    public boolean depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            return true;
        }
        return false; // Valor inválido
    }

    public boolean transferir(Conta contaDestino, double valor) {
        if (this.sacar(valor)) { // Verifica se o saque na conta origem é bem-sucedido
            contaDestino.depositar(valor);
            return true;
        }
        return false; // Transferência falhou (saque na conta origem não foi satisfeito)
    }
}
```
# Questão 10 - Crie uma classe chamada Jogador e nela:
* Crie 3 atributos inteiros representando força, nível e pontos atuais;
* Crie um construtor no qual os 3 parâmetros são passados e inicialize os respectivos atributos;
* Crie um método chamado calcularAtaque. Nele, calcule e retorne o valor da multiplicação de força pelo nível. Esse resultado é o dano de ataque do jogador;
* Crie um método chamado atacar em que é passado um outro jogador (atacado) como parâmetro. Nele e é feita a subtração do dano (método calcularAtaque) dos pontos do atacado;
* Crie um método chamado estaVivo que retorna true caso o atributo pontos do jogador seja maior que zero e falso caso contrário.
* Altere o método atacar para usar o método está vivo e desconsiderar a operação, ou seja, não atacar, caso o jogador passado por parâmetro não esteja vivo.
* Crie um método chamado toString() que retorna a representação textual do jogador concatenando todos os seus atributos.
* Avalie em com testes dois jogadores instanciados e inicializados através do construtor. Utilize o método de ataque de cada jogador e ao final, verifique qual jogador tem mais pontos.

***Resposta:***

Código da Main 
```java
package application;

import entities.Jogador;

public class Main {
    public static void main(String[] args) {
        // Criação de dois jogadores
        Jogador jogador1 = new Jogador(10, 5, 100);
        Jogador jogador2 = new Jogador(8, 6, 90);

        System.out.println("Status inicial:");
        System.out.println("Jogador 1: " + jogador1);
        System.out.println("Jogador 2: " + jogador2);

        // Jogador 1 ataca Jogador 2
        jogador1.atacar(jogador2);
        System.out.println("\nApós o Jogador 1 atacar o Jogador 2:");
        System.out.println("Jogador 1: " + jogador1);
        System.out.println("Jogador 2: " + jogador2);

        // Jogador 2 ataca Jogador 1
        jogador2.atacar(jogador1);
        System.out.println("\nApós o Jogador 2 atacar o Jogador 1:");
        System.out.println("Jogador 1: " + jogador1);
        System.out.println("Jogador 2: " + jogador2);

        // Verificação final de qual jogador tem mais pontos
        if (jogador1.estaVivo() && jogador2.estaVivo()) {
            if (jogador1.verificarPontos() > jogador2.verificarPontos()) {
                System.out.println("\nJogador 1 tem mais pontos.");
            } else if (jogador2.verificarPontos() > jogador1.verificarPontos()) {
                System.out.println("\nJogador 2 tem mais pontos.");
            } else {
                System.out.println("\nAmbos os jogadores têm o mesmo número de pontos.");
            }
            if (jogador1.estaVivo()) {
            System.out.println("\nJogador 1 venceu (Jogador 2 está sem pontos).");
            } else if (jogador2.estaVivo()) {
            System.out.println("\nJogador 2 venceu (Jogador 1 está sem pontos).");
            } else {
            System.out.println("\nAmbos os jogadores estão sem pontos.");
            }
        }
    }
}
```
Código da Classe Jogador
```java
package entities;

public class Jogador {
    private int forca;
    private int nivel;
    private int pontosAtuais;

    public Jogador(int forca, int nivel, int pontosAtuais){
        this.forca = forca;
        this.nivel = nivel;
        this.pontosAtuais = pontosAtuais;
    }

    public int calcularAtaque(){
        return this.forca * this.nivel;
    }

    public void atacar(Jogador player){
        if (player.estaVivo()){
            player.pontosAtuais -= calcularAtaque();
        }
    }

    public boolean estaVivo(){
        return this.pontosAtuais > 0 ? true:false;
    }

    public String toString() {
        return "Atributos atuais/ Força = " + this.forca +
                " / Nível = " + this.nivel +
                " / Pontos Atuais = " + this.pontosAtuais;
    }

    public int verificarPontos(){
        return this.pontosAtuais;
    }
}
```
# Questão 11 - A abordagem da questão 9 é retornar códigos de erro ou acerto. Já a da questão 10 é desconsiderar a alteração. Quais das duas você acha mais correta? Compare com seus códigos escritos em outras disciplinas.

***Resposta:*** 

Para situações simples o codigo desconsiderando a alteração é melhor, pela fácil entendimento do código, porém em códigos mais complexos, onde a qualquer momento algo pode dar errado, é melhor pelo método da questão 9, pois é possível ter maior controle ao saber onde estão os erros e os acertos dentro do código.

