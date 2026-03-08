package application;
import model.ContaBancaria;
import model.ContaCorrente;
import model.ContaPoupanca;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String nome;
        int opcao, opcaoTipoConta;
        double valorSaque, valorDeposito;
        boolean sair = false;

        Scanner tec = new Scanner(System.in);

        System.out.println("-- ABRIR CONTA --");
        System.out.println("Digite seu nome e sobrenome: ");
        nome = tec.nextLine().toUpperCase();

        System.out.println("Você deseja abrir uma Conta Corrente ou Conta Poupança?");
        System.out.println("Digite [1] para CC e [2] para CP");
        opcaoTipoConta = tec.nextInt();


        switch (opcaoTipoConta){
            case 1:
                ContaCorrente c1 = new ContaCorrente(nome, 10);
                System.out.println("SUA CONTA FOI ABERTA NO BANCO JAVA E VOCÊ GANHOU R$ 10,00");

                while (sair == false){
                    System.out.println(" _______________________________");
                    System.out.println(" |                             |");
                    System.out.println(" |  Escolha a opção desejada:  |");
                    System.out.println(" |  1 - Efetuar depósito       |");
                    System.out.println(" |  2 - Efetuar saque          |");
                    System.out.println(" |  3 - Obter extrato          |");
                    System.out.println(" |  4 - Sair                   |");
                    System.out.println(" |                             |");
                    System.out.println(" _______________________________");
                    opcao = tec.nextInt();

                    switch (opcao){
                        case 1:
                            System.out.println("Informe o valor a ser depositado: ");
                            valorDeposito = tec.nextDouble();
                            c1.depositar(valorDeposito);
                            continue;

                        case 2:
                            System.out.println("Informe o valor a ser sacado: ");
                            valorSaque = tec.nextDouble();
                            c1.sacar(valorSaque);
                            continue;

                        case 3:
                            System.out.println("EXTRATO: " + nome);
                            System.out.println("NÚMERO DA CONTA: " + c1.getNumeroConta());
                            System.out.println("SALDO: " + c1.getSaldo());
                            continue;

                        case 4:
                            System.out.println("FECHANDO SISTEMA");
                            sair = true;
                        default:
                            System.out.println("Opção inválida.");
                    }
                }
            case 2:
                ContaPoupanca cp1 = new ContaPoupanca(nome, 10, 0.002);
                System.out.println("SUA CP FOI ABERTA NO BANCO JAVA E VOCÊ GANHOU R$ 10,00");
                System.out.println("UMA CP NO BANCO JAVA RENDE 0,06% AO MÊS");

                while (sair == false){

                    System.out.println("Escolha a opção desejada: ");
                    System.out.println("1 - Efetuar depósito");
                    System.out.println("2 - Efetuar saque");
                    System.out.println("3 - Obter extrato");
                    System.out.println("4 - Sair");
                    opcao = tec.nextInt();

                    switch (opcao){
                        case 1:
                            System.out.println("Informe o valor a ser depositado: ");
                            valorDeposito = tec.nextDouble();
                            cp1.depositar(valorDeposito);
                            continue;
                        case 2:
                            System.out.println("Informe o valor a ser sacado: ");
                            valorSaque = tec.nextDouble();
                            cp1.sacar(valorSaque);
                            continue;

                        case 3:
                            cp1.aplicarRendimento();
                            System.out.println("EXTRATO: " + nome);
                            System.out.println("NÚMERO DA CONTA: " + cp1.getNumeroConta());
                            System.out.println("SALDO: " + cp1.getSaldo());
                            continue;
                        case 4:
                            System.out.println("FECHANDO SISTEMA");
                            sair = true;

                        default:
                            System.out.println("Opção inválida");
                    }
                }
            default:
                throw new IllegalArgumentException("A opção não existe");
        }

    }
}
