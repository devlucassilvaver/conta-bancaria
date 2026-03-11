package model;

import exception.SaldoInsuficienteException;
import exception.StringVaziaException;
import exception.ValorNegativoException;

public abstract class ContaBancaria {
    private static int sequencial = 1;
    private final int numeroConta;
    private String titular;
    private double saldo;

    // CONSTRUTOR
    public ContaBancaria(String titular, double saldoInicial) {
        if (saldoInicial < 0){
            throw new ValorNegativoException("Saldo inicial não pode ser negativo.");
        }
        if (titular == null || titular.trim().isEmpty()){
            throw new StringVaziaException("Titular não pode ser vazio");
        }

        this.numeroConta = sequencial++;
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    // MÉTODOS
    public void depositar(double valor){
        if (valor <= 0){
            throw new ValorNegativoException("O valor deve ser positivo.");
        }
        this.saldo += valor;
    }

    public void sacar(double valor){
        if (valor <= 0){
            throw new ValorNegativoException("O valor deve ser positivo.");
        }
        if (valor > this.saldo){
            throw new SaldoInsuficienteException("Saldo insuficiente.");
        }
        this.saldo -= valor;
    }

    // GET E SET
    public int getNumeroConta() {
        return numeroConta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        if (titular == null || titular.trim().isEmpty()){
            throw new StringVaziaException("Titular não pode ser vazio.");
        }
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "ContaBancaria:" +
                "\nNúmero da conta = " + numeroConta +
                "\nTitular = " + titular +
                String.format("\nSaldo = R$ %.2f", saldo);
    }
}
