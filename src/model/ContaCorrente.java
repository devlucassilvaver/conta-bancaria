package model;

import exception.SaldoInsuficienteException;

public class ContaCorrente extends ContaBancaria {
    private static final double TAXA_SAQUE = 5.0;

    public ContaCorrente(String titular, double saldoInicial) {
        super(titular, saldoInicial);
    }

    @Override
    public void sacar(double valor){
        double saqueTotal = valor + TAXA_SAQUE;

        System.out.printf("TAXA DE SAQUE: R$ %.2f\n", TAXA_SAQUE);
        System.out.printf("Saque realizado no valor de R$ %.2f\n", valor);

        super.sacar(saqueTotal);
    }

    @Override
    public String toString() {
        return "\nConta Corrente: " +
                "\nNúmero da conta = " + getNumeroConta() +
                "\nTitular = " + getTitular() +
                String.format("\nSaldo = R$ %.2f", getSaldo());
    }
}
