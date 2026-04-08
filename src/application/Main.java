package application;

import java.util.Scanner;
import model.ContaCorrente;
import model.ContaPoupanca;
import model.Pessoa;

public class Main {
    public static void main(String[] args) {
        int opcao = 0;
        boolean sair = false;
        Scanner tec = new Scanner(System.in);
        System.out.println("-- ABRIR CONTA --");
        System.out.println("Digite seu nome completo: ");
        String nomeCompleto = tec.nextLine().toUpperCase();
        System.out.println("Digite seu CPF: ");
        String cpf = tec.nextLine();
        System.out.println("Digite sua data de nascimento: ");
        String dataNascimento = tec.nextLine();
        System.out.println("Digite seu gênero | [F] para FEMININO e [M] para MASCULINO");
        String genero = tec.nextLine().toUpperCase();
        System.out.println("Digite seu endereço | FORMATO: [rua, numero, bairro, cidade, estado]: ");
        String endereco = tec.nextLine().toUpperCase();
        System.out.println("Digite sua profissão: ");
        String profissao = tec.nextLine().toUpperCase();
        System.out.println("Digite seu e-mail: ");
        String email = tec.nextLine().toLowerCase();
        System.out.println("Digite seu telefone: ");
        String telefone = tec.nextLine();
        Pessoa p1 = new Pessoa(nomeCompleto, cpf, dataNascimento, genero, endereco, profissao, email, telefone);
        System.out.println("Você deseja abrir uma Conta Corrente ou Conta Poupança?");
        System.out.println("Digite [1] para CC e [2] para CP");
        int opcaoTipoConta = tec.nextInt();
        switch (opcaoTipoConta) {
            case 1:
                ContaCorrente c1 = new ContaCorrente(nomeCompleto, (double)10.0F);
                System.out.println("SUA CONTA FOI ABERTA NO BANCO JAVA E VOCÊ GANHOU R$ 10,00");

                while(!sair) {
                    System.out.println(" |  Escolha a opção desejada:  |");
                    System.out.println(" |  1 - Efetuar depósito       |");
                    System.out.println(" |  2 - Efetuar saque          |");
                    System.out.println(" |  3 - Obter extrato          |");
                    System.out.println(" |  4 - Consultar dados        |");
                    System.out.println(" |  5 - Alterar dados          |");
                    System.out.println(" |  6 - Sair                   |");
                    opcao = tec.nextInt();
                    switch (opcao) {
                        case 1:
                            System.out.println("Informe o valor a ser depositado: ");
                            double valorDeposito = tec.nextDouble();
                            c1.depositar(valorDeposito);
                            break;
                        case 2:
                            System.out.println("Informe o valor a ser sacado: ");
                            double valorSaque = tec.nextDouble();
                            c1.sacar(valorSaque);
                            break;
                        case 3:
                            System.out.println("EXTRATO: " + nomeCompleto);
                            System.out.println("NÚMERO DA CONTA: " + c1.getNumeroConta());
                            System.out.println("SALDO: " + c1.getSaldo());
                            break;
                        case 4:
                            System.out.println(p1.Dados());
                            break;
                        case 5:
                            p1.alteracaoCadastral();
                            break;
                        case 6:
                            System.out.println("FECHANDO SISTEMA");
                            sair = true;
                            break;
                        default:
                            System.out.println("Opção inválida.");
                    }
                }
                break;
            case 2:
                ContaPoupanca cp1 = new ContaPoupanca(nomeCompleto, (double)10.0F, 0.002);
                System.out.println("SUA CP FOI ABERTA NO BANCO JAVA E VOCÊ GANHOU R$ 10,00");
                System.out.println("UMA CP NO BANCO JAVA RENDE " + cp1.getTaxaRendimento() + "% AO DIA");

                while(!sair) {
                    System.out.println(" |  Escolha a opção desejada:  |");
                    System.out.println(" |  1 - Efetuar depósito       |");
                    System.out.println(" |  2 - Efetuar saque          |");
                    System.out.println(" |  3 - Obter extrato          |");
                    System.out.println(" |  4 - Consultar dados        |");
                    System.out.println(" |  5 - Alterar dados          |");
                    System.out.println(" |  6 - Sair                   |");
                    opcao = tec.nextInt();
                    switch (opcao) {
                        case 1:
                            System.out.println("Informe o valor a ser depositado: ");
                            double valorDeposito = tec.nextDouble();
                            cp1.depositar(valorDeposito);
                            break;
                        case 2:
                            System.out.println("Informe o valor a ser sacado: ");
                            double valorSaque = tec.nextDouble();
                            cp1.sacar(valorSaque);
                            break;
                        case 3:
                            cp1.aplicarRendimento();
                            System.out.println("EXTRATO: " + nomeCompleto);
                            System.out.println("NÚMERO DA CONTA: " + cp1.getNumeroConta());
                            System.out.println("SALDO: " + cp1.getSaldo());
                            break;
                        case 4:
                            System.out.println(p1.Dados());
                            break;
                        case 5:
                            p1.alteracaoCadastral();
                            break;
                        case 6:
                            System.out.println("FECHANDO SISTEMA");
                            sair = true;
                            break;
                        default:
                            System.out.println("Opção inválida");
                    }
                }
                break;
            default:
                throw new IllegalArgumentException("A opção não existe");
        }

    }
}