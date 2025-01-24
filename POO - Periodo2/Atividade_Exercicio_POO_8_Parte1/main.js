"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var banco_1 = require("./banco"); // Importação correta
// Criando duas contas
var conta1 = new banco_1.Conta(1, "123", 100); // Conta com saldo insuficiente
var conta2 = new banco_1.Conta(2, "456", 500); // Conta de destino
// Exibindo os saldos iniciais
console.log("Saldo inicial:");
console.log("Conta 1 (Origem): R$".concat(conta1.saldo));
console.log("Conta 2 (Destino): R$".concat(conta2.saldo));
// Tentando realizar a transferência
try {
    console.log("\nTentando transferir R$200 da Conta 1 para a Conta 2...");
    conta1.transferir(conta2, 200);
}
catch (error) {
    console.log("Erro ao realizar a transferência:", error.message);
}
// Exibindo os saldos finais
console.log("\nSaldo final:");
console.log("Conta 1 (Origem): R$".concat(conta1.saldo));
console.log("Conta 2 (Destino): R$".concat(conta2.saldo));
