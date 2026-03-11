package model;

import exception.DataInvalidaException;
import exception.StringVaziaException;
import exception.ValorInvalidoException;

import java.util.Scanner;

public class Pessoa {
    private String nomeCompleto, cpf, dataNascimento, genero, endereco, profissao, email, telefone;

    // CONSTRUTOR
    public Pessoa(String nomeCompleto, String cpf, String dataNascimento, String genero, String endereco, String profissao, String email, String telefone) {

        System.out.println("genero está saindo: " + genero);
        if (nomeCompleto == null || nomeCompleto.trim().isEmpty()){
            throw new StringVaziaException("Nome inválido");
        } if (dataNascimento.length() < 10 || dataNascimento.length() > 10){
            throw new DataInvalidaException("Data inválida");
        } if (genero == null || genero.isEmpty() ||
                (!genero.equals("F") && !genero.equals("M"))) {
            throw new StringVaziaException(
                    "Gênero inválido (Gênero deve ser [F] - feminino e [M] - masculino)"
            );
        } if (endereco == null || endereco.isEmpty()){
            throw new StringVaziaException("Endereço inválido");
        } if (profissao == null || profissao.isEmpty()){
            throw new StringVaziaException("Profissão inválida");
        } if (email == null || email.isEmpty()){
            throw new StringVaziaException("E-mail inválido");
        } if (cpf.length() < 11 || cpf.length() > 11){
            throw new ValorInvalidoException("CPF inválido.");
        } if (telefone.length() < 11 || telefone.length() > 11){
            throw new ValorInvalidoException("Telefone inválido.");
        }

        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
        this.endereco = endereco;
        this.profissao = profissao;
        this.email = email;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public String Dados() {
        String s = "\nDADOS:" +
                "\nNome Completo: " + nomeCompleto +
                "\nCPF: " + cpf +
                "\nData de nascimento: " + dataNascimento +
                "\nGênero: " + genero +
                "\nEndereço: " + endereco +
                "\nProfissão: " + profissao +
                "\nE-mail: " + email +
                "\nTelefone: " + telefone;
        return s;
    }

    // MÉTODOS
    public void alteracaoCadastral(){
        Scanner tec = new Scanner(System.in);

        boolean sair = false;
        int opcao;

        while (sair == false){
            System.out.println("ALTERAÇÃO CADASTRAL");
            System.out.println("1 - Alterar nome");
            System.out.println("2 - Alterar gênero");
            System.out.println("3 - Alterar endereço");
            System.out.println("4 - Alterar profissão");
            System.out.println("5 - Alterar e-mail");
            System.out.println("6 - Alterar telefone");
            System.out.println("7 - Sair");

            opcao = tec.nextInt();
            tec.nextLine();

            switch (opcao){
                case 1:
                    String alteracaoNomeCompleto;
                    System.out.println("NOME COMPLETO EM CADASTRO: " + getNomeCompleto());
                    System.out.println("DIGITE O NOME COMPLETO PARA ALTERAÇÃO: ");
                    alteracaoNomeCompleto = tec.nextLine();
                    if (alteracaoNomeCompleto == null || alteracaoNomeCompleto.isEmpty()){
                        throw new StringVaziaException("Nome completo inválido");
                    } else if (this.getNomeCompleto() == alteracaoNomeCompleto){
                        throw new IllegalArgumentException("O nome de alteração é igual ao nome já cadastrado em sistema");
                    }
                    System.out.println("NOME COMPLETO ALTERADO!");
                    this.setNomeCompleto(alteracaoNomeCompleto);
                    break;

                case 2:
                    String alteracaoGenero;
                    System.out.println("GÊNERO EM CADASTRO: " + getGenero());
                    alteracaoGenero = tec.nextLine();
                    if (alteracaoGenero == null || alteracaoGenero.isEmpty()){
                        throw new StringVaziaException("Gênero inválido");
                    } else if (this.getGenero() == alteracaoGenero){
                        throw new IllegalArgumentException("O gênero de alteração é igual ao gênero já cadastrado em sistema");
                    }
                    System.out.println("GÊNERO ALTERADO!");
                    this.setGenero(alteracaoGenero);
                    break;

                case 3:
                    String alteracaoEndereco;
                    System.out.println("ENDEREÇO EM CADASTRO: " + getEndereco());
                    alteracaoEndereco = tec.nextLine();

                    if (alteracaoEndereco == null || alteracaoEndereco.isEmpty()){
                        throw new StringVaziaException("Endereço inválido");
                    }
                    System.out.println("ENDEREÇO ALTERADO!");
                    this.setEndereco(alteracaoEndereco);
                    break;

                case 4:
                    String alteracaoProfissao;
                    System.out.println("PROFISSÃO EM CADASTRO: " + getProfissao());
                    alteracaoProfissao = tec.nextLine();

                    if (alteracaoProfissao == null || alteracaoProfissao.isEmpty()){
                        throw new StringVaziaException("PROFISSÃO INVÁLIDA");
                    }
                    System.out.println("PROFISSÃO ALTERADA!");
                    this.setProfissao(alteracaoProfissao);
                    break;

                case 5:
                    String alteracaoEmail;
                    System.out.println("E-MAIL EM CADASTRO: " + getEmail());
                    alteracaoEmail = tec.nextLine();

                    if (alteracaoEmail == null || alteracaoEmail.isEmpty()){
                        throw new StringVaziaException("E-MAIL INVÁLIDO");
                    }
                    System.out.println("E-MAIL ALTERADO!");
                    this.setEmail(alteracaoEmail);
                    break;

                case 6:
                    String alteracaoTelefone;
                    System.out.println("TELEFONE EM CADASTRO: " + getTelefone());
                    System.out.println("FORMATO DE NÚMERO DE TELEFONE: (00) 00000-0000");
                    alteracaoTelefone = tec.nextLine();

                    if (alteracaoTelefone.length() < 11 || alteracaoTelefone.length() > 11){
                        throw new ValorInvalidoException("TELEFONE INVÁLIDO");
                    }
                    System.out.println("TELEFONE ALTERADO!");
                    this.setTelefone(alteracaoTelefone);
                    break;

                case 7:
                    sair = true;
                    break;
            }
        }


    }

    // GET E SET

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
