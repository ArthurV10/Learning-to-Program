# Questionamentos e Reflexões sobre o Design do Sistema (PARTE 1 Atividade)

## a. Você concorda que o banco faz o cadastro de duas entidades e ainda faz regras de negócios?

**Resposta**

Concordo, pois ao analisar o código por completo, a maneira que foi exigido a formação do código, proporcionou isso.

---

## b. Não seria adequado o banco ter uma classe `CadastroDeClientes` e `CadastroDeContas` e algumas regras de validação serem feitas no banco e deixar os métodos de consulta e inclusão os mais simples possíveis?

**Resposta**

Sim, essa abordagem é mais modular e facilita a manutenção do sistema, dessa maneira possuindo um melhor desempenho.

---

## c. O método "associar cliente a uma conta" deveria estar em que classe? `Banco`, `CadastroDeContas` ou `CadastroDeClientes`?

### Análise:
- **Banco**: É o local mais apropriado se o método envolve lógica que conecta múltiplas entidades. O `Banco` pode delegar parte da operação para as classes de cadastro e realizar validações finais.
- **CadastroDeContas** ou **CadastroDeClientes**: Não são recomendados para a lógica completa, mas podem expor métodos auxiliares, como `adicionarContaAoCliente()` ou `setClienteParaConta()`.

### Proposta:
O método "associar cliente a uma conta" deve estar no `Banco`, que:
1. Valida se o cliente e a conta existem.
2. Garante que uma conta não seja associada a mais de um cliente.
3. Invoca métodos nas classes de cadastro para realizar a associação.

```java
// Exemplo em Banco
public void associarContaCliente(String numeroConta, String cpfCliente) {
    Cliente cliente = cadastroDeClientes.consultarCliente(cpfCliente);
    Conta conta = cadastroDeContas.consultarConta(numeroConta);

    if (cliente == null || conta == null) {
        System.out.println("Erro: Cliente ou conta não encontrados.");
        return;
    }

    if (conta.getCliente() != null) {
        System.out.println("Erro: Conta já está associada a outro cliente.");
        return;
    }

    conta.setCliente(cliente);
    cliente.setConta(conta);
    System.out.println("Cliente " + cliente.getNome() + " associado à conta " + conta.getNumero());
}
