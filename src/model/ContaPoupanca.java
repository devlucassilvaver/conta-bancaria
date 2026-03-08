package model;

public class ContaPoupanca extends ContaBancaria {
    private double taxaRendimento;

    public ContaPoupanca(String titular, double saldoInicial, double taxaRendimento) {
        super(titular, saldoInicial);
        this.taxaRendimento = taxaRendimento;
    }

    public double getTaxaRendimento() {
        return this.taxaRendimento;
    }

    public double aplicarRendimento(){
        double rendimento = getSaldo() * taxaRendimento;
        setSaldo(getSaldo() + rendimento);

        return getSaldo();
    }

}
