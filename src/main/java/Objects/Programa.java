/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

import DAO.PessoaDAO;
import DAO.MedicoDAO;

import DAO.ConsultaDAO;
import DAO.FinanceiroAdmDAO;
import DAO.InfoConsultaDAO;
import DAO.ProcedimentoDAO;

import DAO.FranquiaDAO;
import DAO.UnidadeFranquiaDAO;

import UI.GUI;
import java.util.Scanner;

/**
 *
 * @author Vinicius Augusto
 */
public class Programa {

    Scanner scan = new Scanner(System.in);
    GUI gui = new GUI();
    PessoaDAO pessoaDAO = new PessoaDAO(100);
    MedicoDAO medicoDAO = new MedicoDAO(100);

    ConsultaDAO consultaDAO = new ConsultaDAO(100);
    InfoConsultaDAO infoConsultaDAO = new InfoConsultaDAO(100);
    ProcedimentoDAO procedimentoDAO = new ProcedimentoDAO(100);
    FranquiaDAO franquiaDAO = new FranquiaDAO(100);
    UnidadeFranquiaDAO unidadeDAO = new UnidadeFranquiaDAO(100);
    FinanceiroAdmDAO financeiroAdmDAO = new FinanceiroAdmDAO(100);


    public Programa() {

        dadosTEST();

        inicioMenu();

    }

    public void inicioMenu() {
        int op = gui.pegaOpcaoLoginCadastro();

        switch (op) {
            case 1:
                System.out.println("------ CADASTRO ------");
                Pessoa pessoaCadastro = gui.cadastrarPessoa();
                pessoaCadastro.setTipoUsuario(TipoUsuario.PACIENTE);
                pessoaDAO.criarPessoa(pessoaCadastro);
                inicioMenu();
                break;
            case 2:
                System.out.println("------ LOGIN ------");
                System.out.print("login:");
                String log = scan.nextLine();
                System.out.print("senha:");
                String senha = scan.nextLine();
                login(log, senha);
                break;
            default:
                throw new AssertionError();
        }

    }

    public void login(String login, String senha) {
        Pessoa pessoa = pessoaDAO.buscarPessoaPorLogin(login);
        if (pessoa == null) {
            System.out.println("Login inválido.");
            return;
        }

        if (!pessoa.getSenha().equals(senha)) {
            System.out.println("Senha incorreta.");
            return;
        }

        switch (pessoa.getTipoUsuario()) {
            case DONO_FRANQUIA:
                //gui dono franquia
                break;
            case DONO_UNIDADE:
                //gui
                break;
            case ADMINISTRATIVO:
                //gui
                break;
            case MEDICO:
                //gui
                break;
            case PACIENTE:
                System.out.println("paciente");
                break;
            case ADMINISTRADOR:
                admMenu();
                break;

            default:
                System.out.println("Tipo de usuário inválido.");
        }
    }

    public void cadastrar() {

    }

    public void admMenu() {

        int opcaoUsuario;
        do {
            opcaoUsuario = gui.pegaOpcaoADM();

            switch (opcaoUsuario) {
                case 0:
                    inicioMenu();

                case 1:
                    System.out.println("------ Criar Pessoa ------");
                    Pessoa p = gui.cadastrarPessoa();
                    int id = pessoaDAO.criarPessoa(p);
                    System.out.println(id);

                    break;
                case 2:
                    pessoaDAO.mostrarPessoas();
                    break;

                case 3:
                    System.out.println("------ Editar Pessoa------");

                    System.out.print("id da pessoa:");
                    int idEdit = Integer.parseInt(scan.nextLine());
                    Pessoa pessoaBuscada = pessoaDAO.buscarPessoa(idEdit);

                    System.out.println(pessoaBuscada);

                    Pessoa editPessoa = gui.cadastrarPessoa();
                    editPessoa.setId(idEdit);
                    editPessoa.setTipoUsuario(pessoaBuscada.getTipoUsuario());

                    pessoaDAO.atualizarPessoa(editPessoa);

                    switch (pessoaBuscada.getTipoUsuario()) {
                        case MEDICO:

                            System.out.println(medicoDAO.findPessoaByMedico(idEdit));

                            break;
                        default:

                    }

                    break;
                case 4:
                    System.out.println("------ Delete Pessoa------");

                    System.out.print("id da pessoa:");
                    int idDel = Integer.parseInt(scan.nextLine());

                    if (pessoaDAO.buscarPessoa(idDel).getTipoUsuario() == null) {

                        pessoaDAO.excluirPessoa(idDel);
                    } else {

                        System.out.println("existe dados vinculados a pessoa");
                    }

                    break;
                case 5:
                    //cadastrar medico
                    System.out.println("------ Criar Medico ------");

                    Pessoa pessoaMedico = gui.cadastrarPessoa();
                    pessoaMedico.setTipoUsuario(TipoUsuario.MEDICO);
                    pessoaDAO.criarPessoa(pessoaMedico);
                    Medico medicocriado = gui.cadastrarMedico(pessoaMedico);
                    medicoDAO.criarMedico(medicocriado);

                    break;
                case 6:
                    //listar medicos 
                    medicoDAO.mostrarMedicos();
                    break;
                case 7:

                    System.out.println("------ Delete MEdico------");

                    System.out.print("id do medico:");
                    int idDelMedico = Integer.parseInt(scan.nextLine());

                    medicoDAO.buscarMedico(idDelMedico).getPessoa().setTipoUsuario(null);
                    medicoDAO.excluirMedico(idDelMedico);
                    break;
                case 8:
                    System.out.println("------ EDIT Medico------");

                    System.out.print("id do medico:");
                    int idEditMedico = Integer.parseInt(scan.nextLine());
                    Medico medicoBuscado = medicoDAO.buscarMedico(idEditMedico);
                    System.out.println(medicoBuscado);

                    Pessoa pessoaMedicoEdit = gui.cadastrarPessoa();
                    pessoaMedicoEdit.setTipoUsuario(TipoUsuario.MEDICO);

                    Medico medicoEdit = gui.cadastrarMedico(pessoaMedicoEdit);

                    medicoEdit.setId(idEditMedico);
                    medicoDAO.atualizarMedico(medicoEdit);

                    break;
                case 9:
                    System.out.println("------ Criar Consulta------");

                    System.out.print("id do medico:");
                    int idMedicoConsulta = Integer.parseInt(scan.nextLine());

                    pessoaDAO.buscarPacientes();
                    System.out.print("id do paciente:");
                    int idPacienteConsulta = Integer.parseInt(scan.nextLine());

                    Medico medicoconsulta = medicoDAO.buscarMedico(idMedicoConsulta);
                    Pessoa paceienteconsulta = pessoaDAO.buscarPessoa(idPacienteConsulta);

                    Consulta consultaInsert = gui.cadastrarConsulta(medicoconsulta, paceienteconsulta);

                    consultaDAO.cadastrarConsulta(consultaInsert);

                    break;
                case 10:
                    consultaDAO.mostrarConsultas();

                    break;
                case 11:
                    System.out.println("------ Delete Consulta------");
                    System.out.print("id do Consulta:");
                    consultaDAO.mostrarConsultas();

                    int idDelConsulta = Integer.parseInt(scan.nextLine());
                    consultaDAO.excluirConsulta(idDelConsulta);

                    break;

                case 12:

                    System.out.println("------ EDIT Consulta------");

                    System.out.print("id do Consulta:");
                    int idEditConsulta = Integer.parseInt(scan.nextLine());

                    Consulta consultaBuscado = consultaDAO.buscarConsulta(idEditConsulta);
                    System.out.println(consultaBuscado);

                    System.out.print("id do medico:");
                    int idMedicoConsultaEdit = Integer.parseInt(scan.nextLine());

                    pessoaDAO.buscarPacientes();
                    System.out.print("id do paciente:");
                    int idPacienteConsultaEdit = Integer.parseInt(scan.nextLine());

                    Medico medicoconsultaEdit = medicoDAO.buscarMedico(idMedicoConsultaEdit);
                    Pessoa paceienteconsultaEdit = pessoaDAO.buscarPessoa(idPacienteConsultaEdit);

                    Consulta consultaEdit = gui.cadastrarConsulta(medicoconsultaEdit, paceienteconsultaEdit);
                    consultaEdit.setId(consultaBuscado.getId());

                    consultaDAO.editarConsulta(consultaEdit);

                    break;
                
                 case 13:
                    System.out.println("CRIAR FRANQUIA");
                    Franquia franquiacriada= gui.cadastrarFranquia();
                   // Pessoa responsavel = new Pessoa();
                     System.out.println("Possíveis pessoas resposáveis pela franquia:");
                    pessoaDAO.mostrarPessoasQualificadas();
                    System.out.println("Informe o ID do responsável pela Franquia:");
                    int idResp = Integer.parseInt(scan.nextLine());
                    //responsavel= ;
                    franquiacriada.setResponsavel(pessoaDAO.buscarPessoa(idResp));
                    franquiaDAO.criarFranquia(franquiacriada);
                    break;
                case 14:
                    System.out.println("Franquias Cadastradas:");
                    franquiaDAO.mostrarFranquias();
                    break;
                case 15:
                    System.out.println("Editar Franquia");
                    Franquia franquiaAtual = new Franquia();
                    System.out.println("Informe o id da Franquia que será alterada");
                    int id_franquia = Integer.parseInt(scan.nextLine());
                    System.out.println("Possíveis pessoas resposáveis pela franquia:");
                    pessoaDAO.mostrarPessoasQualificadas();
                    System.out.println("Informe o ID do responsável pela Franquia:");
                    int resp_novo = Integer.parseInt(scan.nextLine());
                    franquiaAtual.setResponsavel(pessoaDAO.buscarPessoa(resp_novo));
                    franquiaDAO.criarFranquia(franquiaAtual);
                     franquiaAtual.setId(id_franquia);
                    franquiaDAO.atualizarFranquia(franquiaAtual);
                    break;
                case 16:
                    System.out.println("Deletar Franquia:");
                    System.out.println("informe o id da franquia:");
                    break;
                case 17:
                    System.out.println("cadastrar Unidade de Franquia:");
                    UnidadeFranquia unidade = gui.cadastrarUnidade();
                    System.out.println("Informe o id da Franquia:");
                    int franquia_id = Integer.parseInt(scan.nextLine());
                    unidade.setFranquia(franquiaDAO.buscarFranquia(franquia_id));
                    System.out.println("Possíveis pessoas resposáveis pela UNIDADE:");
                    pessoaDAO.mostrarPessoasQualificadas();
                    System.out.println("Informe o ID do responsável pela UNIDADE:");
                    int resp_unid = Integer.parseInt(scan.nextLine());
                    unidade.setResponsavel(pessoaDAO.buscarPessoa(resp_unid));
                    unidadeDAO.criarUnidade(unidade);
                    break;
                case 18:
                    System.out.println("Unidades Cadastradas:");
                    unidadeDAO.mostrarUnidades();
                    break;
                case 19:
                    System.out.println("Editar UNIDADE");
                    UnidadeFranquia unidadeNova = new UnidadeFranquia();
                    System.out.println("Informe o id da unidade:");
                    int id_unid = Integer.parseInt(scan.nextLine());
                    unidadeNova =gui.cadastrarUnidade();
                    System.out.println("Informe o id da Franquia:");
                    int franquia_nova = Integer.parseInt(scan.nextLine());
                    unidadeNova.setFranquia(franquiaDAO.buscarFranquia(franquia_nova));
                    System.out.println("Possíveis pessoas resposáveis pela UNIDADE:");
                    pessoaDAO.mostrarPessoasQualificadas();
                    System.out.println("Informe o ID do responsável pela UNIDADE:");
                    int responsavel_unid = Integer.parseInt(scan.nextLine());
                    //responsavel= ;
                    unidadeNova.setResponsavel(pessoaDAO.buscarPessoa(responsavel_unid));
                    unidadeNova.setId(id_unid);
                    unidadeDAO.atualizarUnidade(unidadeNova);

                    break;
                case 20:
                    FinaceiroAdm financa = gui.cadastrarFinanca();
                    System.out.println("Informe o id da Unidade de Franquia");
                    int idFinanca = Integer.parseInt(scan.nextLine());
                    financa.setUnidade(unidadeDAO.buscarUnidade(idFinanca));
                    financeiroAdmDAO.cadastrarFinanca(financa);
                    break;
                case 21:
                //mostrar financas
                    financeiroAdmDAO.mostrarFinancas();
                    break;
                default:
                    throw new AssertionError();
            }
        } while (opcaoUsuario != 0);

    }

    public void dadosTEST() {

        Pessoa adm = new Pessoa();
        adm.setLogin("adm");
        adm.setNome("adm");
        adm.setSenha("adm");
        adm.setTipoUsuario(TipoUsuario.ADMINISTRADOR);
        pessoaDAO.criarPessoa(adm);

        Pessoa paciente1 = new Pessoa();
        paciente1.setNome("maria");
        paciente1.setCpf("1111");
        paciente1.setEndereco("Rua A, 123");
        paciente1.setTelefone("1111");
        paciente1.setLogin("maria");
        paciente1.setSenha("test");
        paciente1.setTipoUsuario(TipoUsuario.PACIENTE);
        pessoaDAO.criarPessoa(paciente1);

        Pessoa medico1 = new Pessoa();
        medico1.setNome("ana");
        medico1.setCpf("1111");
        medico1.setEndereco("Rua A, 123");
        medico1.setTelefone("1111");
        medico1.setLogin("ana");
        medico1.setSenha("test");
        medico1.setTipoUsuario(TipoUsuario.MEDICO);
        pessoaDAO.criarPessoa(medico1);

        Medico medicodemedico1 = new Medico();
        medicodemedico1.setCrm("11111");
        medicodemedico1.setEspecialidade("joelho");
        medicodemedico1.setPessoa(medico1);
        medicoDAO.criarMedico(medicodemedico1);

        /*Pessoa pessoaMedico = gui.cadastrarPessoa();
                    pessoaMedico.setTipoUsuario(TipoUsuario.MEDICO);
                    pessoaDAO.criarPessoa(pessoaMedico);
                    Medico medicocriado = gui.cadastrarMedico(pessoaMedico);
                    medicoDAO.criarMedico(medicocriado);*/
    }

    public static void main(String[] args) {
        new Programa();
    }

}
