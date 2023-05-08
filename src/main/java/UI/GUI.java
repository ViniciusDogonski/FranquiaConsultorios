/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI;

import Objects.Pessoa;
import Objects.TipoMovimento;
import Objects.Medico;

import Objects.Consulta;
import Objects.Estados;
import Objects.FinaceiroAdm;
import Objects.TipoUsuario;

import Objects.Franquia;
import Objects.UnidadeFranquia;

import java.util.Scanner;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Vinicius Augusto
 */
public class GUI {

    Scanner scan = new Scanner(System.in);

    public Pessoa cadastrarPessoa() {

        System.out.println("Por favor, informe os dados:");

        Pessoa pessoa = new Pessoa();

        System.out.print("Nome: ");
        String nome = scan.nextLine();
        pessoa.setNome(nome);

        System.out.print("Endereço: ");
        String endereco = scan.nextLine();
        pessoa.setEndereco(endereco);

        System.out.print("CPF: ");
        String cpf = scan.nextLine();
        pessoa.setCpf(cpf);

        System.out.print("Telefone: ");
        String telefone = scan.nextLine();
        pessoa.setTelefone(telefone);

        System.out.print("Login: ");
        String login = scan.nextLine();
        pessoa.setLogin(login);

        System.out.print("Senha: ");
        String senha = scan.nextLine();
        pessoa.setSenha(senha);

        /*  System.out.print("Tipo de usuário (1-Dono Franquia, 2-Dono Unidade, 3-Administrativo, 4-Médico, 5-Paciente, 6-Administrador): ");
        int tipoUsuario = Integer.parseInt(scan.nextLine());

        switch (tipoUsuario) {
            case 1:
                pessoa.setTipoUsuario(TipoUsuario.DONO_FRANQUIA);
                break;
            case 2:
                pessoa.setTipoUsuario(TipoUsuario.DONO_UNIDADE);
                break;
            case 3:
                pessoa.setTipoUsuario(TipoUsuario.ADMINISTRATIVO);
                break;
            case 4:
                pessoa.setTipoUsuario(TipoUsuario.MEDICO);
                break;
            case 5:
                pessoa.setTipoUsuario(TipoUsuario.PACIENTE);
                break;
            case 6:
                pessoa.setTipoUsuario(TipoUsuario.ADMINISTRADOR);
                break;
            default:
                System.out.print("opçao invalida!");
        }*/
        return pessoa;
    }

    public Medico cadastrarMedico(Pessoa pessoa) {

        System.out.println("Por favor, informe os dados do medico:");

        Medico medico = new Medico();

        System.out.print("CRM:");
        String crm = scan.nextLine();
        medico.setCrm(crm);

        System.out.print("Especialidade: ");
        String especialidade = scan.nextLine();
        medico.setEspecialidade(especialidade);

        medico.setPessoa(pessoa);

        return medico;
    }
    public Franquia cadastrarFranquia(){

        
        Franquia franquia = new Franquia();
        System.out.println("Por favor, informe os dados da Franquia abaixo:");
        System.out.println("Nome");
        String nome = scan.nextLine();
        franquia.setNome(nome);
        System.out.println(" CNPJ:");
        String cnpj = scan.nextLine();
        franquia.setCnpj(cnpj);
        System.out.println("Cidade:");
        String cidade = scan.nextLine();
        franquia.setCidade(cidade);
        System.out.println("Endereco:");
        String endereco = scan.nextLine();
        franquia.setEndereco(endereco);
        return franquia;

    }
    public UnidadeFranquia cadastrarUnidade(){
        UnidadeFranquia unidade = new UnidadeFranquia();
        System.out.println("Por favor informe os dados da UNIDADE:");
        System.out.println("Cidade:");
        unidade.setCidade(scan.nextLine());
        System.out.println("Endereco:");
        unidade.setEndereco(scan.nextLine());
        return unidade;
    }

    public Consulta cadastrarConsulta(Medico medico, Pessoa paciente) {

        System.out.println("Por favor, informe os dados da Consulta:");
        Consulta consulta = new Consulta();

        System.out.print("data da consulta (dd/MM/yyyy):");
        String dataConsulta = scan.nextLine();
        consulta.setData(DateConverter(dataConsulta));

        System.out.print("hora da consulta (HH:mm):");
        String horaConsulta = scan.nextLine();
        consulta.setHorario(TimeConverter(horaConsulta));

        consulta.setEstado(Estados.AGENDADA);
        consulta.setMedico(medico);
        consulta.setPaciente(paciente);
       
        return consulta;

    }
    public FinaceiroAdm cadastrarFinanca(){
        FinaceiroAdm financa = new FinaceiroAdm();
       
        System.out.println("É uma consulta ou procedimento?");
        System.out.println("1 - Sim");
        System.out.println("2 - Nao");
        int opc= Integer.parseInt(scan.nextLine());
        if(opc == 1){
            financa.setTipoMovimento(TipoMovimento.ENTRADA);
        }
        else{
            financa.setTipoMovimento(TipoMovimento.SAIDA);
        }
        System.out.println("Valor:");
        BigDecimal valor = BigDecimal.valueOf(Double.parseDouble(scan.nextLine()));
        financa.setValor(valor);
        System.out.println("Descrição:");
        String descricao = scan.nextLine();
        financa.setDescricao(descricao);
        return financa;


    }
    public int pegaOpcaoADM() {
        System.out.println("------ PESSOA------");
        System.out.println("1 cadastrar PESSOA");
        System.out.println("2 mostrar todas PESSOAS");
        System.out.println("3 alterar PESSOA");
        System.out.println("4 excluir pelo id  PESSOAS");
        System.out.println("------ MEDICO------");
        System.out.println("5 cadastrar MEDICO");
        System.out.println("6 mostrar MEDICO");

        System.out.println("7 deletar MEDICO");
        System.out.println("8 editar MEDICO");
        System.out.println("------CONSULTA------");
        System.out.println("9 cadastrar CONSULTA");
        System.out.println("10 mostrar CONSULTAS");
        System.out.println("11 deletar CONSULTA");
        System.out.println("12 editar CONSULTA");
        System.out.println("------FRANQUIA------");
        System.out.println(" 13- cadastrar FRANQUIA");
        System.out.println(" 14- mostrar FRANQUIA");
        System.out.println(" 15- alterar FRANQUIA");
        System.out.println(" 16- deletar FRANQUIA");
        System.out.println("------UNIDADE DE FRANQUIA------");
        System.out.println("17- cadastrar UNIDADE");
        System.out.println("18 - mostrar UNIDADE");
        System.out.println("19 - alterar UNIDADE");
        System.out.println("-------FINANCEIRO ADM-------");
        System.out.println("20 - Criar uma Movimentacao");
        System.out.println("0 sair");

        System.out.print("Qual sua opcao ?");
        return Integer.parseInt(scan.nextLine());

    }

    public int pegaOpcaoLoginCadastro() {

        System.out.println("1 cadastrar");
        System.out.println("2 logar");

        System.out.print("Qual sua opcao ?");
        return Integer.parseInt(scan.nextLine());

    }

    private LocalDate DateConverter(String dataConsulta) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(dataConsulta, formatter);
    }

    private LocalTime TimeConverter(String timeString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return LocalTime.parse(timeString, formatter);
    }

}
