/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI;

import Objects.Pessoa;
import Objects.Medico;
import Objects.Consulta;
import Objects.Estados;
import Objects.TipoUsuario;
import Objects.Franquia;
import Objects.InfoConsulta;
import Objects.UnidadeFranquia;
import Objects.Procedimento;
import Objects.FinanceiroMedico;
import java.util.Scanner;

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

        System.out.print("EndereÃ§o: ");
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

        /*  System.out.print("Tipo de usuÃ¡rio (1-Dono Franquia, 2-Dono Unidade, 3-Administrativo, 4-MÃ©dico, 5-Paciente, 6-Administrador): ");
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
                System.out.print("opÃ§ao invalida!");
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

    public Franquia cadastrarFranquia(Pessoa responsavelPessoa) {

        System.out.println("Por favor, informe os dados da Franquia:");

        Franquia franquia = new Franquia();

        franquia.setResponsavel(responsavelPessoa);

        System.out.print("nome:");
        String nome = scan.nextLine();
        franquia.setNome(nome);

        System.out.print(" CNPJ:");
        String cnpj = scan.nextLine();
        franquia.setCnpj(cnpj);

        System.out.print("cidade:");
        String cidade = scan.nextLine();
        franquia.setCidade(cidade);

        System.out.print("endereco:");
        String endereco = scan.nextLine();
        franquia.setEndereco(endereco);

        return franquia;

    }

    public UnidadeFranquia cadastrarUnidadeFranquia(Franquia franquia, Pessoa responsavel) {

        System.out.println("Por favor, informe os dados da Unidade Franquia:");

        UnidadeFranquia unidadeFranquia = new UnidadeFranquia();
        unidadeFranquia.setFranquia(franquia);
        unidadeFranquia.setResponsavel(responsavel);

        System.out.print("cidade:");
        String cidade = scan.nextLine();
        unidadeFranquia.setCidade(cidade);

        System.out.print("endereco:");
        String endereco = scan.nextLine();
        unidadeFranquia.setEndereco(endereco);

        return unidadeFranquia;

    }

    public InfoConsulta cadastrarInfoConsulta(Consulta consulta) {

        InfoConsulta InfoConsultaCriacao = new InfoConsulta();

        InfoConsultaCriacao.setConsulta(consulta);

        System.out.print("DescriÃ§Ã£o:");
        String descricao = scan.nextLine();
        InfoConsultaCriacao.setDescricao(descricao);

        return InfoConsultaCriacao;
    }

    public Procedimento cadastrarProcedimento(Consulta consulta) {

        Procedimento procedimentoCriacao = new Procedimento();
        procedimentoCriacao.setConsulta(consulta);

        System.out.print("nome:");
        String nome = scan.nextLine();
        procedimentoCriacao.setNome(nome);

        System.out.print("data do procedimento (dd/MM/yyyy):");
        String dataProcedimento = scan.nextLine();
        procedimentoCriacao.setData(DateConverter(dataProcedimento));

        System.out.print("hora do procedimento (HH:mm):");
        String horaProcedimento = scan.nextLine();
        procedimentoCriacao.setHorario(TimeConverter(horaProcedimento));

        procedimentoCriacao.setEstado(Estados.AGENDADA);

        System.out.print("Valor:");
        double valor = Double.parseDouble(scan.nextLine());
        procedimentoCriacao.setValor(valor);

        System.out.print("laudo:");
        String laudo = scan.nextLine();
        procedimentoCriacao.setLaudo(laudo);

        return procedimentoCriacao;
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
        System.out.println("------FRANQUIA------");
        System.out.println("9 cadastrar FRANQUIA");
        System.out.println("10 mostrar FRANQUIA");
        System.out.println("11 deletar FRANQUIA");
        System.out.println("12 editar FRANQUIA");
        System.out.println("------UNIDADE FRANQUIA------");
        System.out.println("13 cadastrar UNIDADE FRANQUIA");
        System.out.println("14 mostrar UNIDADE FRANQUIA");
        System.out.println("15 deletar UNIDADE FRANQUIA");
        System.out.println("16 editar UNIDADE FRANQUIA");
        System.out.println("------CONSULTA------");
        System.out.println("17 cadastrar CONSULTA");
        System.out.println("18 mostrar CONSULTAS");
        System.out.println("19 deletar CONSULTA");
        System.out.println("20 editar CONSULTA");
        System.out.println("------ INFO CONSULTA------");
        System.out.println("21 cadastrar INFO CONSULTA");
        System.out.println("22 mostrar INFO CONSULTAS");
        System.out.println("23 deletar INFO CONSULTA");
        System.out.println("24 editar INFO CONSULTA");
        System.out.println("------ PROCEDIMENTO------");
        System.out.println("25 cadastrar PROCEDIMENTO");
        System.out.println("26 mostrar PROCEDIMENTO");
        System.out.println("27 deletar PROCEDIMENTO");
        System.out.println("28 editar PROCEDIMENTO");
        System.out.println("0 sair");

        System.out.print("Qual sua opcao ?");
        return Integer.parseInt(scan.nextLine());

    }

    public int pegarOpcaoPaciente() {

        System.out.println("1 Ver minhas consultas");
        System.out.println("2 Ver informaÃ§Ã£o da consulta");
        System.out.println("3 ver procedimento");

        System.out.println("0 sair");

        System.out.print("Qual sua opcao ?");
        return Integer.parseInt(scan.nextLine());

    }

    public int pegarOpcaoMedico() {

        System.out.println("1 ver todas consultas do medico");
        System.out.println("2 ver informaÃ§Ã£o de uma consulta");
        System.out.println("3  ver procedimento de uma consulta");
        System.out.println("4  ver agenda de consultas da semana");
        System.out.println("5  ver consultas ja realizadas");
        System.out.println("------ INFO CONSULTA------");
        System.out.println("6 cadastrar INFO CONSULTA");
        System.out.println("7 buscar INFO CONSULTA");
        System.out.println("8 deletar INFO CONSULTA");
        System.out.println("9 editar INFO CONSULTA");
        System.out.println("------ PROCEDIMENTO------");
        System.out.println("10 cadastrar PROCEDIMENTO");
        System.out.println("11 mostrar PROCEDIMENTO");
        System.out.println("12 deletar PROCEDIMENTO");
        System.out.println("13 editar PROCEDIMENTO");
        System.out.println("14 RECEBIDOS");

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

    public void mostrarPessoasPrint(Pessoa[] pessoas) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa != null) {
                System.out.println(pessoa);
            }
        }
    }

    public void mostrarMedicosPrint(Medico[] medicos) {
        for (Medico medico : medicos) {
            if (medico != null) {
                System.out.println(medico);
            }
        }
    }

    public void mostrarFranquiasPrint(Franquia[] franquias) {
        for (Franquia franquia : franquias) {
            if (franquia != null) {
                System.out.println(franquia);
            }
        }
    }

    public void mostrarUnidadeFranquiasPrint(UnidadeFranquia[] unidadesFranquias) {
        for (UnidadeFranquia unidadeFranquia : unidadesFranquias) {
            if (unidadeFranquia != null) {
                System.out.println(unidadeFranquia);
            }
        }
    }

    public void mostrarConsultasPrint(Consulta[] consultas) {
        for (Consulta consulta : consultas) {
            if (consulta != null) {
                System.out.println(consulta);
            }
        }
    }

    public void mostrarInfoConsultasPrint(InfoConsulta[] infosconsultas) {
        for (InfoConsulta infoconsulta : infosconsultas) {
            if (infoconsulta != null) {
                System.out.println(infoconsulta);
            }
        }
    }

    public void mostrarProcedimentoPrint(Procedimento[] precedimentos) {
        for (Procedimento procedimento : precedimentos) {
            if (procedimento != null) {
                System.out.println(procedimento);
            }
        }
    }

    public void mostrarFinanceiroMedicoPrint(FinanceiroMedico[] fmedico) {

        for (FinanceiroMedico financeiroMedico : fmedico) {
            if (financeiroMedico != null) {
                System.out.println(financeiroMedico);
            }
        }

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
