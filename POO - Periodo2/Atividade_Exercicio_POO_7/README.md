# Atividade 7 - POO (Parte 1)
## Questão 1 - As classes Carro, Veiculo e CarroEletrico são bem semelhantes. Reescreva as classes usando herança para que os atributos duplicados não sejam mais necessários.

* ``class Veiculo {
placa: String;
ano: number;
}``

* ``class Carro {
placa: String;
ano: number;
modelo: String;
}``

* ``class CarroEletrico {
placa: String;
ano: number;
modelo: String;
autonomiaBateria: number;
}``

* Codigo Veiculo
```java
package entities;

public class Veiculo {
    private String placa;
    private int ano;

    public Veiculo (String numeroPlaca, int numeroAno){
        this.placa = numeroPlaca;
        this.ano = numeroAno;
    }
}
```
* Codigo Carro
```java
package entities;

import java.util.Date;

public class Carro extends Veiculo {
    private String modelo;

    public Carro (String numeroPlaca, int numeroAno, String nomeModelo){
        super(numeroPlaca, numeroAno);
        this.modelo = nomeModelo;
    }
}
```
* Codigo Carro Elétrico
```java
package entities;

public class CarroEletrico extends Carro {
    private int autonomiaBateria;

    public CarroEletrico (String numeroPlaca, int numeroAno, String nomeModelo, int numeroAutonomiaBateria){
        super(numeroPlaca, numeroAno,nomeModelo);
        this.autonomiaBateria = numeroAutonomiaBateria;
    }
}
```

## Questão 2 - Crie uma classe Calculadora com:
``a. Dois tributos privados chamados representando dois operandos;``


`b. Crie um construtor que inicializa os atributos;`


``c. Crie um método que retorna a soma dos dois atributos;``


``d. Teste a classe.``

```java
package entities;

public class Calculadora {
    private double operator1;
    private double operator2;

    public Calculadora(double operator1, double operator2){
        this.operator1 = operator1;
        this.operator2 = operator2;
    }

    public void setOperator1(double operator1) {
        this.operator1 = operator1;
    }
    public void setOperator2(double operator2){
        this.operator2 = operator2;
    }

    public double sumNumber(){
        return operator1 + operator2;
    }
}
```

## Questão 3 - Crie uma classe chamada CalculadoraCientifica que herda da classe Calculadora do exercício passado e:

#### a. Implemente um método chamado exponenciar que retorne o primeiro operando elevado ao segundo;

#### b. Teste a classe;
Resposta Letra `A` e `B`:
* Código Calculadora
```java
package entities;

public class Calculadora {
    private double operator1;
    private double operator2;

    public Calculadora(double operator1, double operator2){
        this.operator1 = operator1;
        this.operator2 = operator2;
    }

    public double getOperator1() {
        return operator1;
    }

    public double getOperator2() {
        return operator2;
    }

    public void setOperator1(double operator1) {
        this.operator1 = operator1;
    }
    public void setOperator2(double operator2){
        this.operator2 = operator2;
    }

    public double sumNumber(){
        return operator1 + operator2;
    }
}

```
* Código Calculadora Científica
```java
package entities;

public class CalculadoraCientifica extends Calculadora{

    public CalculadoraCientifica(double operator1, double operator2){
        super(operator1, operator2);
    }

    public double exponentiate(){
        return Math.pow(getOperator1(), 2);
    }
}
```
#### c. Foi necessária alguma modificação em Calculadora para o acesso aos atributos?

Resposta: Não, apenas adicionei os metodos "gets" porém, isso não é considerada uma alteração necessária para acessar os atributos, e sim, o método padrão.

## Questão 4 - Considerando a implementação da aplicação bancária, implemente:
#### a. Implemente na classe Banco o método renderJuros(numero: string): void, onde:
#### i. É passado por parâmetro o número de uma poupança e feita uma consulta para ver se a conta existe. Note que a consulta não se altera sendo Conta ou Poupança;
#### ii. Caso a poupança seja encontrada, teste se realmente se trata de uma poupança com o operador instanceof, desconsidere a operação caso contrário;

#### iii. Caso seja, faça um cast e invoque o método renderJuros da própria instância encontrada;
#### iv. Teste o método da classe Banco passando tanto um número de poupança como de conta passados inseridos anteriormente;
#### v. Altere a aplicação anteriormente sugerida para ter a opção de menu “Render Juros”.
* Codigo Main
```java
package application;

import entities.*;

public class Main {
    public static void main(String[] args) {
        App app = new App("Banco Vieira");
        Banco banco = new Banco();
        banco.menuConta(app, banco);
    }
}


```
* Codigo App
```java
package entities;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class App {
    private final String nome;
    
    public App(String nome){
        this.nome = nome;
    }
    
    public void inserirContaPoupanca(Banco banco, Scanner scanner) {
        System.out.print("Deseja criar:\n1 - Conta\n2 - Poupança\n>>> ");
        int opcao = scanner.nextInt();
        scanner.nextLine();
    
        switch (opcao) {
            case 1: 
                System.out.print("Informe o número da conta: ");
                String numeroContaCriada = scanner.nextLine();
                System.out.print("Informe o saldo inicial: ");
                float saldoInicialConta = scanner.nextFloat();
                scanner.nextLine();
    
                int idConta = banco.gerarId();
                banco.inserirConta(numeroContaCriada, saldoInicialConta, idConta); 
                System.out.println("Conta criada com sucesso! ID: " + idConta);
                break;
    
            case 2:
                System.out.print("Informe o número da poupança: ");
                String numeroPoupancaCriada = scanner.nextLine();
                System.out.print("Informe o saldo inicial: ");
                float saldoInicialPoupanca = scanner.nextFloat();
                scanner.nextLine();
    
               
                int idPoupanca = banco.gerarId();
                banco.inserirPoupanca(numeroPoupancaCriada, saldoInicialPoupanca, idPoupanca);
                System.out.println("Poupança criada com sucesso! ID: " + idPoupanca);
                break;
    
            default:
                System.out.println("Opção inválida.");
        }
    }
    

    public void consultarConta(Banco banco, Scanner scanner){
        System.out.print("Informe o número da conta: ");
        Conta contaConsultada = banco.consultarConta(scanner.nextLine());
        if (contaConsultada != null) {
            System.out.println("Conta: " + contaConsultada.getNumero() + ", Saldo: " + contaConsultada.consultarSaldo());
        } else {
            System.out.println("Conta não encontrada.");
        }
    }
                
    public void sacarDinheiro(Banco banco, Scanner scanner){
        System.out.print("Informe o número da conta: ");
        Conta numeroContaParaSacar = banco.consultarConta(scanner.nextLine());
        if (numeroContaParaSacar!= null) {
            System.out.print("Informe o valor para sacar: ");
            float valorSacar = scanner.nextFloat();
            numeroContaParaSacar.sacar(valorSacar);
        }
        else {
            System.out.println("Conta não encontrada.");
        }
    }
                    
    public void depositarDinheiro(Banco banco, Scanner scanner){
        System.out.print("Informe o número da conta: ");
        Conta numeroContaParaDeposito = banco.consultarConta(scanner.nextLine());
        if (numeroContaParaDeposito!= null) {
            System.out.print("Informe o valor para depositar: ");
            float valorSacar = scanner.nextFloat();
            numeroContaParaDeposito.depositar(valorSacar);
        }
        else {
            System.out.println("Conta não encontrada.");
        }
    }

    // falta remover a conta do antigo e adicionar no novo
    public void mudancaTitularidade(Banco banco, Scanner scanner){
        System.out.print("Informe o número da conta: ");
        Conta numeroContaParaMudanca = banco.consultarConta(scanner.nextLine());
        if (numeroContaParaMudanca == null) {
            System.out.println("Conta não encontrada.");
        }
        else{
            System.out.print("Informe o CPF do cliente: ");
            Cliente novoCliente = banco.consultarCliente(scanner.nextLine());
            if (novoCliente != null){
                numeroContaParaMudanca.getCliente().removeAccount(numeroContaParaMudanca);
                numeroContaParaMudanca.setCliente(novoCliente);
                novoCliente.setConta(numeroContaParaMudanca);
            }
            else{
                System.out.println("Cliente não encontrada");
            }
        }
    }

    public void excluirConta(Banco banco, Scanner scanner){
        System.out.print("Informe o número da conta: ");
        String numeroContaExcluir = scanner.nextLine();
        banco.excluirContaPeloIndices(numeroContaExcluir);
    }

    public void excluirCliente(Banco banco, Scanner scanner){
        System.out.print("Informe o CPF do Cliente: ");
        String cpfClienteExcluir = scanner.nextLine();
        banco.excluirClientePeloIndices(cpfClienteExcluir);
    }

    public void transferencia(Banco banco, Scanner scanner){
        System.out.print("Informe o número da conta de origem: ");
        String numeroContaOrigem = scanner.nextLine();
        System.out.print("Informe o número da conta de destino: ");
        String numeroContaDestino = scanner.nextLine();
        System.out.print("Informe o valor a ser transferido: ");
        float valor = scanner.nextFloat();
        banco.transferirDinheiro(numeroContaOrigem, numeroContaDestino, valor);
    }
                 
    public void totalizar(Banco banco){
        System.out.println("Total de contas: " + banco.quantidadeContas());
        System.out.println("Total de saldos: R$ " + banco.saldoContasTotal());
        System.out.println("Média dos saldos: R$ " + banco.mediaSaldos());
    }

    public void inserirCliente(Banco banco, Scanner scanner){
        int id = banco.gerarId();
        System.out.print("Informe o nome do Cliente: ");
        String nome = scanner.nextLine();

        System.out.print("Informe o CPF do Cliente: ");
        String cpfParaCadastro = scanner.nextLine();

        LocalDate dataNascimento = null;
        while (dataNascimento == null) {
            try {
                System.out.print("Informe a data de nascimento (dd/MM/yyyy): ");
                String dataInput = scanner.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                dataNascimento = LocalDate.parse(dataInput, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Formato de data inválido. Tente novamente.");
            }
        }

        Cliente cliente = new Cliente(id, nome, cpfParaCadastro, dataNascimento);
        banco.inserirCliente(cliente);
    }
                    
    public void consultarCliente(Banco banco, Scanner scanner){
        System.out.println("Informe o CPF do Cliente: ");
        Cliente contaClienteConsultado = banco.consultarCliente(scanner.nextLine());
        if (contaClienteConsultado != null) {
            // Informar nome, cpf, dataNascimento
            System.out.println("Nome do Cliente: " + contaClienteConsultado.getNome() + "\n" +
                    "CPF do Cliente: " + contaClienteConsultado.getCpf() + "\n" +
                    "Data de Nascimento: " + contaClienteConsultado.getDataNascimento());

            // Listar contas do cliente
            List<Conta> contasDoCliente = contaClienteConsultado.listarContasCliente();

            if (contasDoCliente == null) {
                System.out.println("Cliente não encontrado.");
            }
        }
    }
                   
    public void associarContaCliente(Banco banco, Scanner scanner){
        System.out.print("Informe o numero da Conta do Cliente: ");
        String numeroDaContaAssociada = scanner.nextLine();
        System.out.print("Informe o CPF do Cliente: ");
        String cpfParaAssociarConta = scanner.nextLine();
        banco.associarContaCliente(numeroDaContaAssociada, cpfParaAssociarConta);
    }

    public void listarContasNulas(Banco banco){
        for (Conta conta : banco.getContas()){
        System.out.println("Todas as contas nulas: ");
            if (conta.getCliente() == null){
                System.out.println("Numero da Conta: " + conta.getNumero());
                System.out.printf("Id da Conta: %.2f\n",  conta.getId());
            }
            else {
                System.out.println("Não existem contas nulas: ");
            }
        }
    }

    public void renderJuros(Banco banco, Scanner scanner){
        System.out.print("Informe o número da conta: ");
        String numeroContaParaJuros = scanner.nextLine();
        banco.renderJuros(numeroContaParaJuros);
    }
}
```
* Codigo Banco
```java
package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Banco {
    private List<Conta> contas;
    private List<Cliente> clientes;

    public Banco() {
        this.contas = new ArrayList<>();
        this.clientes = new ArrayList<>(); // Inicialização da lista de clientes
    }

    public void inserirConta(String numero, float saldo, int id) {
        Conta contaInserida = new Conta(numero, saldo, id);
        if (contas.contains(contaInserida)){
            System.out.println("Erro: Conta com número ou ID já cadastrada: " + numero);
            return; // Impede duplicação de contas
        }
        contas.add(contaInserida);
    }

    public void inserirPoupanca(String numero, float saldo, int id) {
        Poupanca contaInserida = new Poupanca(numero, saldo, id);
        if (contas.contains(contaInserida)){
            System.out.println("Erro: Conta com número ou ID já cadastrada: " + numero);
            return; // Impede duplicação de contas
        }
        contas.add(contaInserida);
    }

    public void inserirCliente(Cliente cliente){
        if (clientes.contains(cliente)){
            System.out.println("Erro: Cliente com ID ou CPF já cadastrado: " + cliente.getNome());
            return; // Impede duplicação de clientes
        }
        clientes.add(cliente);
    }

    public List<Conta> getContas(){
        return this.contas;
    }

    public List<Cliente> getClientes(){
        return this.clientes;
    }

    public Conta consultar(String numero) {
        for (Conta conta : getContas()) {
            if (conta.getNumero().equals(numero)) {
                return conta;
            }
        }
        return null;
    }
    
    public Conta consultarConta(String numeroConta) {
        for (Conta conta : getContas()) {
            if (conta.getNumero().equals(numeroConta)) {
                return conta;
            }
        }
        return null;
    }

    public Cliente consultarCliente(String cpfCliente) {
        for (Cliente cliente : getClientes()) {
            if (cliente.getCpf().equals(cpfCliente)) {
                return cliente;
            }
        }
        return null;
    }

    public void associarContaCliente(String numeroConta, String cpfCliente) {
        // Consulta a conta e o cliente
        Conta contaEncontrada = consultarConta(numeroConta);
        Cliente clienteEncontrado = consultarCliente(cpfCliente);
    
        // Verifica se a conta existe
        if (contaEncontrada == null) {
            System.out.println("Conta não encontrada.");
            return;
        }
    
        // Verifica se o cliente existe
        if (clienteEncontrado == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }
    
        // Verifica se a conta já tem um cliente associado
        if (contaEncontrada.getCliente() != null) {
            System.out.println("A conta já está associada a um cliente.");
            return;
        }
    
        // Associa o cliente à conta
        contaEncontrada.setCliente(clienteEncontrado);
        clienteEncontrado.setConta(contaEncontrada);
        System.out.println("Cliente " + cpfCliente + " associado à conta " + numeroConta + " com sucesso.");
    }
    

        // Consultar por Indice
        public Conta getContaPorIndice(int indice) {
            return this.contas.get(indice);
        }

        //Atualizar Conta
        public void atualizarConta(Conta conta){
            int indice = this.contas.indexOf(conta);
            if(indice!= -1){
                this.contas.set(indice, conta);
                System.out.println("Conta atualizada com sucesso.");
            } else {
                System.out.println("Conta não encontrada.");
            }
        }

        // Sacar Dinheiro
        public void sacarDinheiro(Conta conta, int valor){
            if(conta.consultarSaldo() >= valor){
                conta.sacar(valor);
                System.out.println("Saque realizado com sucesso!");
            }
            else{
                System.out.println("Não foi possivel realizar saque!");
            }
        }

        // Depositar Dinheiro
        public void depositarDinheiro(Conta conta, int valor){
            conta.depositar(valor);
            System.out.println("Deposito realizado com sucesso!");
        }

        // Transferir Dinheiro
        public void transferirDinheiro(String numeroContaOrigem, String numeroContaDestino, float valor){
            Conta contaOrigem = consultar(numeroContaOrigem);
            Conta contaDestino = consultar(numeroContaDestino);

            if ((contaOrigem != null) && (contaDestino != null)){
                if(contaOrigem.consultarSaldo() >= valor){
                    contaOrigem.sacar(valor);
                    contaDestino.depositar(valor);
                    System.out.println("Transferência realizada com sucesso!");
                }
                else{
                    System.out.println("Não foi possivel realizar a transferência!");
                }
            }
            else{
                System.out.println("Contas não encontradas.");
            }
        }

        public void transferirDinheiroMultiplas(String numeroContaOrigem, int valor) {
            Conta contaOrigem = consultar(numeroContaOrigem);
            
            if (contaOrigem == null) {
                System.out.println("Conta de origem inválida!");
                return;
            }
            
            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite a quantidade de contas para transferência: ");
            int qtdContas = scanner.nextInt();
            
            String[] contasDestino = new String[qtdContas];
            
            for (int i = 0; i < qtdContas; i++) {
                System.out.print("Digite o número da conta de destino " + (i + 1) + ": ");
                contasDestino[i] = scanner.next();
            }
            
            if (contaOrigem.consultarSaldo() < valor * qtdContas) {
                System.out.println("Saldo insuficiente para realizar todas as transferências!");
                return;
            }
            
            for (String numeroConta : contasDestino) {
                Conta contaDestino = consultar(numeroConta);
                
                if (contaDestino == null) {
                    System.out.println("Conta de destino inválida: " + numeroConta);
                    continue;
                }
                
                contaOrigem.sacar(valor);
                contaDestino.depositar(valor);
                System.out.println("Transferência realizada com sucesso para a conta " + numeroConta);
            }
        }


        public int quantidadeContas(){
            return this.contas.size();
        }

        public int saldoContasTotal(){
            int total = 0;
            for (Conta conta : this.contas) {
                total += conta.consultarSaldo();
            }
            return total;
        }

        public float mediaSaldos(){
            return saldoContasTotal()/quantidadeContas();
        }

        public int consultarContaPorIndices(String numeroConta){
            int index = -1;
            Conta verificarConta = consultar(numeroConta); 
            if (verificarConta != null){ 
                for (int i = 0; i < this.contas.size(); i++) {
                    if (this.contas.get(i).getNumero().equals(numeroConta)){
                        index = i;
                        break; 
                    } 
                } 
            } return index; 
        }

        public int consultarClientePorIndices(String cpf){
            int index = -1;
            Cliente verificarCliente = consultarCliente(cpf);
            if (verificarCliente != null) {
                for (int i = 0; i < this.clientes.size(); i++){
                    if (this.clientes.get(index).getCpf().equals(cpf)){
                        index = i;
                        break;
                    };
                }
            } return index;
        }

        public void excluirConta(String numero){
            int indexExcluir = consultarContaPorIndices(numero);
            if (indexExcluir != -1) {
                for (int i = indexExcluir; i < this.contas.size();i++){
                    this.contas.set(i, this.contas.get(i+1));
                }
            this.contas.remove(this.contas.size()-1);
            }
        }
        
        public void excluirContaPeloIndices(String numero) { 
            int indexExcluir = consultarContaPorIndices(numero); 
            if (indexExcluir != -1) { 
                this.contas.remove(indexExcluir); 
                System.out.println("Conta removida com sucesso."); 
            } 
            else { System.out.println("Conta não encontrada."); 
            } 
        }

        public void excluirClientePeloIndices(String numero){
            int indexExcluir = consultarClientePorIndices(numero);
            if (indexExcluir != -1) {
                for (int i = indexExcluir; i < this.clientes.size(); i++){
                    this.clientes.set(i, this.clientes.get(i+1));
                }
                this.clientes.remove(this.clientes.size()-1);
            }
        }

        public void renderJuros(String numero) {
            Conta conta = consultar(numero);
            if (conta != null) {
                if (conta instanceof Poupanca) {
                    Poupanca poupanca = (Poupanca) conta; // Cast para Poupança
                    poupanca.renderJuros(); // Invoca o método renderJuros
                } else {
                    System.out.println("A conta encontrada não é uma poupança.");
                }
            } else {
                System.out.println("Conta não encontrada.");
            }
        }

        public int gerarId(){
            Random random = new Random();
            return random.nextInt(100000000, 900000000);
        }

        public void exibirMenu() {
            System.out.println("\nBem-vindo ao Banco!");
            System.out.println("Digite uma opção:");
            System.out.println("=========================================================\nContas");
            System.out.println("|| 01 - Inserir      || 02 - Consultar          || 03 - Sacar        ||");
            System.out.println("|| 04 - Depositar    || 05 - Excluir            || 06 - Transferir   ||");
            System.out.println("|| 07 - Totalizações || 08 - Mudar Titularidade || 09 - Render Juros ||");
            System.out.println("=========================================================\nClientes:");
            System.out.println("|| 10 - Inserir      || 11 - Consultar          || 12 - Associar     ||");
            System.out.println("|| 13 - Excluir      || 14 - Contas Nulas       ||");
            System.out.println("|| 0  - Sair         ||\n");
        }
        

        public void menuConta(App aplicativo, Banco banco) {
            Scanner scanner = new Scanner(System.in);
            int opcao;
            do {
                exibirMenu();
                System.out.print("Opção: ");
                opcao = scanner.nextInt();
                scanner.nextLine();
    
                switch (opcao) {
                    case 1:
                        aplicativo.inserirContaPoupanca(banco, scanner);
                        break;

                    case 2:
                        aplicativo.consultarConta(banco, scanner);
                        break;

                    case 3:
                        aplicativo.sacarDinheiro(banco, scanner);
                            break;

                    case 4:
                        aplicativo.depositarDinheiro(banco, scanner);
                            break;

                    case 5:
                        aplicativo.excluirConta(banco, scanner);
                            break;
                            
                    case 6:
                        aplicativo.transferencia(banco, scanner);
                            break;

                    case 7:
                        aplicativo.totalizar(banco);
                            break;
                    case 8:
                        aplicativo.mudancaTitularidade(banco, scanner);
                        break;

                    case 9:
                        aplicativo.renderJuros(banco, scanner);
                        break;
                    case 10:
                        aplicativo.inserirCliente(banco, scanner);
                        break;

                    case 11:
                        aplicativo.consultarCliente(banco, scanner);
                        break;
                        
                    case 12:
                        aplicativo.associarContaCliente(banco, scanner);
                        break;
                    
                    case 13:
                        aplicativo.excluirCliente(banco, scanner);
                        break;

                    case 14:
                        aplicativo.listarContasNulas(banco);

                    case 0:
                        System.out.println("Saindo do menu...");
                        break;

                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                }
            } while (opcao != 0);
        }
}

```
* Codigo Cliente
```java
package entities;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private int id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private List<Conta> contas;

    public Cliente(int id, String nome, String cpf, LocalDate dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.contas = new ArrayList<>();
    }

    public void removeAccount(Conta conta) {
        if (this.contas.contains(conta)) {
            this.contas.remove(conta);
        }
    }

    public LocalDate getDataNascimento() {
        return this.dataNascimento;
    }   

    public String getNome() {
        return this.nome;
    }

    public int getId() {
        return this.id;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setConta(Conta contaCliente) {
        this.contas.add(contaCliente);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setData(Scanner scanner){
        LocalDate dataNascimento = null;
        while (dataNascimento == null) {
            try {
                System.out.print("Informe a data de nascimento (dd/MM/yyyy): ");
                String dataInput = scanner.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                dataNascimento = LocalDate.parse(dataInput, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Formato de data inválido. Tente novamente.");
            }
        }
        this.dataNascimento = dataNascimento;
    }

    public List<Conta> listarContasCliente() {
        if (contas != null) {
            for (int i = 0; i < this.contas.size(); i++) {
                System.out.println("Codigo Conta " + (i + 1) + ": " + contas.get(i).getNumero());
            }
            return this.contas;
        }
        System.out.println("Contas Inexistentes");
        return null;
    }

    public float totalizarSaldoCliente() {
        float valorTotal = 0;
        for (Conta contaCliente : this.contas) {
            valorTotal += contaCliente.consultarSaldo();
        }
        return valorTotal;
    }

    public String toString() {
        return "Nome: " + this.nome + ", CPF: " + this.cpf + ", Data Nascimento: " + this.dataNascimento;
    }
}

```
* Codigo Conta
```java
package entities;

public class Conta {
    private String numero;
    private float saldo;
    private int id;
    private Cliente cliente;

    public Conta(String numero, float saldo, int id) {
        this.numero = numero;
        this.saldo = saldo;
        this.id = id;
    }

    public Conta(String numero, float saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public int getId(){
        return this.id;
    }

    public float getSaldo() {
        return this.saldo;
    }

    public void sacar(float valor) {
        if (valor > 0 && this.saldo >= valor) {
            this.saldo -= valor;
        } else {
            System.out.println("Saque inválido.");
        }
    }

    public void depositar(float valor) {
        if (valor > 0) {
            this.saldo += valor;
        } else {
            System.out.println("Depósito inválido.");
        }
    }

    public float consultarSaldo() {
        return this.saldo;
    }

    public void transferir(Conta contaDestino, float valor) {
        if (valor > 0 && this.saldo >= valor) {
            this.sacar(valor);
            contaDestino.depositar(valor);
        } else {
            System.out.println("Transferência inválida: saldo insuficiente ou valor negativo.");
        }
    }
}

```
* Codigo Poupança
```java
package entities;

public class Poupanca extends Conta {

    public Poupanca(String numero, float saldo, int id) {
        super(numero, saldo, id);
    }

    public void renderJuros(){
        float juros = getSaldo() * 0.01f;
        depositar(juros);
        System.out.println("Juros de R$" + juros + " aplicados à poupança " + getNumero());
    }
}

```
