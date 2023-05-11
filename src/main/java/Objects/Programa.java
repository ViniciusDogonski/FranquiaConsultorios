/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

/*DAOI*/
import DAO.PessoaDAO;
import DAO.MedicoDAO;
import DAO.ConsultaDAO;
import DAO.InfoConsultaDAO;
import DAO.ProcedimentoDAO;
import DAO.FranquiaDAO;
import DAO.UnidadeFranquiaDAO;

/*GRAFICO*/
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
    UnidadeFranquiaDAO unidadeFranquiaDAO = new UnidadeFranquiaDAO(100);

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
                case 1:
                    System.out.println("------ Criar Pessoa ------");
                    Pessoa p = gui.cadastrarPessoa();
                    int id = pessoaDAO.criarPessoa(p);
                    System.out.println(id);

                    break;
                case 2:
                    gui.mostrarPessoasPrint(pessoaDAO.mostrarPessoas());
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
                    gui.mostrarMedicosPrint(medicoDAO.mostrarMedicos());
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
//CADASTRO FRANQUIA 

                    System.out.println("------Criar franquia------");

                    System.out.print("id de Pessoa:");
                    int idDonoFranquia = Integer.parseInt(scan.nextLine());
                    Pessoa pessoaDonoFranquia = pessoaDAO.buscarPessoa(idDonoFranquia);
                    System.out.println(pessoaDonoFranquia);
                    pessoaDonoFranquia.setTipoUsuario(TipoUsuario.DONO_FRANQUIA);

                    Franquia franquiaCriada = gui.cadastrarFranquia(pessoaDonoFranquia);
                    franquiaDAO.criarFranquia(franquiaCriada);

                    break;
                case 10:
//MOSTRAR FRANQUIA

                    gui.mostrarFranquiasPrint(franquiaDAO.mostrarFranquias());

                    break;
                case 11:
//DELETE FRANQUIA

                    System.out.println("------ Delete franquia------");

                    System.out.print("id da franquia:");
                    int idDelFranquia = Integer.parseInt(scan.nextLine());

                    franquiaDAO.excluirFranquia(idDelFranquia);

                    break;
                case 12:
// EDIT FRANQUIA

                    System.out.println("------ EDIT franquia------");

                    System.out.print("id da franquia:");
                    int idEditFranquia = Integer.parseInt(scan.nextLine());
                    Franquia franquiaBuscado = franquiaDAO.buscarFranquia(idEditFranquia);
                    System.out.println(franquiaBuscado);

                    System.out.print("id de Pessoa:");
                    int idEditDonoFranquia = Integer.parseInt(scan.nextLine());
                    Pessoa pessoaEditDonoFranquia = pessoaDAO.buscarPessoa(idEditDonoFranquia);
                    System.out.println(pessoaEditDonoFranquia);
                    pessoaEditDonoFranquia.setTipoUsuario(TipoUsuario.DONO_FRANQUIA);

                    Franquia franquiaEdit = gui.cadastrarFranquia(pessoaEditDonoFranquia);
                    franquiaEdit.setId(idEditFranquia);

                    franquiaDAO.atualizarFranquia(franquiaEdit);

                    break;
                case 13:

                    System.out.println("------Criar unidade franquia------");

                    System.out.print("id de Pessoa:");
                    int idDonoUnidadeFranquia = Integer.parseInt(scan.nextLine());
                    Pessoa pessoaDonoUnidadeFranquia = pessoaDAO.buscarPessoa(idDonoUnidadeFranquia);
                    System.out.println(pessoaDonoUnidadeFranquia);
                    pessoaDonoUnidadeFranquia.setTipoUsuario(TipoUsuario.DONO_UNIDADE);

                    System.out.print("id de franquia:");
                    int idFranquia = Integer.parseInt(scan.nextLine());
                    Franquia buscarFranquia = franquiaDAO.buscarFranquia(idFranquia);

                    UnidadeFranquia unidadefranquiaCriada = gui.cadastrarUnidadeFranquia(buscarFranquia, pessoaDonoUnidadeFranquia);
                    unidadeFranquiaDAO.criarUnidade(unidadefranquiaCriada);

                    break;
                case 14:
                    gui.mostrarUnidadeFranquiasPrint(unidadeFranquiaDAO.mostrarUnidades());
                    break;
                case 15:

                    System.out.println("------ Delete unidade franquia------");

                    System.out.print("id da unidade franquia:");
                    int idDelUnidadeFranquia = Integer.parseInt(scan.nextLine());
                    unidadeFranquiaDAO.excluirUnidade(idDelUnidadeFranquia);

                    break;
                case 16:

                    System.out.println("------Edit unidade franquia------");

                    System.out.print("id de Pessoa:");
                    int idDonoUnidadeFranquiaEdit = Integer.parseInt(scan.nextLine());
                    Pessoa pessoaDonoUnidadeFranquiaEdit = pessoaDAO.buscarPessoa(idDonoUnidadeFranquiaEdit);
                    System.out.println(pessoaDonoUnidadeFranquiaEdit);
                    pessoaDonoUnidadeFranquiaEdit.setTipoUsuario(TipoUsuario.DONO_UNIDADE);

                    System.out.print("id de franquia:");
                    int idFranquiaEdit = Integer.parseInt(scan.nextLine());
                    Franquia buscarFranquiaEdit = franquiaDAO.buscarFranquia(idFranquiaEdit);
                    System.out.println(buscarFranquiaEdit);

                    UnidadeFranquia unidadefranquiaEdit = gui.cadastrarUnidadeFranquia(buscarFranquiaEdit, pessoaDonoUnidadeFranquiaEdit);
                    unidadefranquiaEdit.setId(buscarFranquiaEdit.getID());
                    unidadeFranquiaDAO.atualizarUnidade(unidadefranquiaEdit);

                    break;

                case 17:
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
                case 18:
                    gui.mostrarConsultasPrint(consultaDAO.mostrarConsultas());

                    break;
                case 19:
                    System.out.println("------ Delete Consulta------");
                    System.out.print("id do Consulta:");
                    consultaDAO.mostrarConsultas();

                    int idDelConsulta = Integer.parseInt(scan.nextLine());
                    consultaDAO.excluirConsulta(idDelConsulta);

                    break;

                case 20:
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
                case 21:

                    System.out.println("------ Criar info Consulta------");

                    System.out.print("id da Consulta:");
                    int idConsulta = Integer.parseInt(scan.nextLine());

                    Consulta consultaVinculada = consultaDAO.buscarConsulta(idConsulta);

                    InfoConsulta InfoConsultaCriado = gui.cadastrarInfoConsulta(consultaVinculada);

                    infoConsultaDAO.criarInfoConsulta(InfoConsultaCriado);

                    break;
                case 22:

                    gui.mostrarInfoConsultasPrint(infoConsultaDAO.mostrarInfoConsulta());

                    break;
                case 23:

                    System.out.println("------ Delete info Consulta------");
                    System.out.print("id do info Consulta:");
                    infoConsultaDAO.mostrarInfoConsulta();

                    int idDelInfoConsulta = Integer.parseInt(scan.nextLine());
                    infoConsultaDAO.excluirInfoConsulta(idDelInfoConsulta);

                    break;
                case 24:

                    System.out.println("------ EDIT info Consulta------");

                    System.out.print("id do info Consulta:");
                    int idEditInfoConsulta = Integer.parseInt(scan.nextLine());

                    System.out.print("id da Consulta:");
                    int idConsultaBusca = Integer.parseInt(scan.nextLine());

                    Consulta consultaBuscadaedit = consultaDAO.buscarConsulta(idConsultaBusca);

                    InfoConsulta infoCunsultaBusca = infoConsultaDAO.buscarInfoConsulta(idEditInfoConsulta);

                    InfoConsulta infoConsultaEditado = gui.cadastrarInfoConsulta(consultaBuscadaedit);
                    infoConsultaEditado.setId(infoCunsultaBusca.getId());

                    break;
                case 25:

                    System.out.println("------ Criar PROCEDIMENTO------");

                    System.out.print("id da Consulta:");
                    int idConsultaProcedimento = Integer.parseInt(scan.nextLine());

                    Consulta consultaVinculadaProcedimento = consultaDAO.buscarConsulta(idConsultaProcedimento);

                    Procedimento criadoPrecedimento = gui.cadastrarProcedimento(consultaVinculadaProcedimento);

                    procedimentoDAO.criarProcedimento(criadoPrecedimento);

                    break;
                case 26:

                    gui.mostrarProcedimentoPrint(procedimentoDAO.mostrarProcedimento());

                    break;
                case 27:
                    System.out.println("------ Delete PROCEDIMENTO------");

                    System.out.print("id do PROCEDIMENTO:");

                    int idDelProcedimento = Integer.parseInt(scan.nextLine());
                    procedimentoDAO.excluirProcedimento(idDelProcedimento);

                    break;
                case 28:
                    System.out.println("------ EDIT PROCEDIMENTO------");

                    System.out.print("id do PROCEDIMENTO:");
                    int idEditProcedimento = Integer.parseInt(scan.nextLine());

                    System.out.print("id da consulta:");
                    int idconsultaEditProce = Integer.parseInt(scan.nextLine());

                    Procedimento precedimentoBuscado = procedimentoDAO.buscarProcedimento(idEditProcedimento);
                    Consulta consultaBuscada = consultaDAO.buscarConsulta(idconsultaEditProce);

                    Procedimento novoProcedimento = gui.cadastrarProcedimento(consultaBuscada);
                    novoProcedimento.setId(precedimentoBuscado.getId());

                    procedimentoDAO.atualizarProcedimento(novoProcedimento);

                    break;
                case 0:
                    inicioMenu();
                    break;
                default:
                    throw new AssertionError();
            }
        } while (opcaoUsuario != 0);

    }

    public void dadosTEST() {

        /*adm*/
        Pessoa adm = new Pessoa();
        adm.setLogin("adm");
        adm.setNome("adm");
        adm.setSenha("adm");
        adm.setTipoUsuario(TipoUsuario.ADMINISTRADOR);
        pessoaDAO.criarPessoa(adm);

        /*pessoas*/
// Criando Pessoa 1
// pessoa dona de duas franquias
        Pessoa pessoa1 = new Pessoa();
        pessoa1.setNome("Maria");
        pessoa1.setCpf("1111");
        pessoa1.setEndereco("Rua A, 123");
        pessoa1.setTelefone("1111");
        pessoa1.setLogin("maria");
        pessoa1.setSenha("test");
        pessoa1.setTipoUsuario(TipoUsuario.DONO_FRANQUIA);
        pessoaDAO.criarPessoa(pessoa1);

// Criando Pessoa 2
// pessoa dona franquia
        Pessoa pessoa2 = new Pessoa();
        pessoa2.setNome("João");
        pessoa2.setCpf("2222");
        pessoa2.setEndereco("Rua B, 456");
        pessoa2.setTelefone("2222");
        pessoa2.setLogin("joao");
        pessoa2.setSenha("test");
        pessoa2.setTipoUsuario(TipoUsuario.DONO_FRANQUIA);
        pessoaDAO.criarPessoa(pessoa2);

// Criando Pessoa 3
// pessoa dona unidade
        Pessoa pessoa3 = new Pessoa();
        pessoa3.setNome("Ana");
        pessoa3.setCpf("3333");
        pessoa3.setEndereco("Rua C, 789");
        pessoa3.setTelefone("3333");
        pessoa3.setLogin("ana");
        pessoa3.setSenha("test");
        pessoa3.setTipoUsuario(TipoUsuario.DONO_UNIDADE);
        pessoaDAO.criarPessoa(pessoa3);

// Criando Pessoa 4
// pessoa dona unidade
        Pessoa pessoa4 = new Pessoa();
        pessoa4.setNome("Carlos");
        pessoa4.setCpf("4444");
        pessoa4.setEndereco("Rua D, 1011");
        pessoa4.setTelefone("4444");
        pessoa4.setLogin("carlos");
        pessoa4.setSenha("test");
        pessoa4.setTipoUsuario(TipoUsuario.DONO_UNIDADE);
        pessoaDAO.criarPessoa(pessoa4);

// Criando Pessoa 5
// pessoa paciente
        Pessoa pessoa5 = new Pessoa();
        pessoa5.setNome("Mariana");
        pessoa5.setCpf("5555");
        pessoa5.setEndereco("Rua E, 1213");
        pessoa5.setTelefone("5555");
        pessoa5.setLogin("mariana");
        pessoa5.setSenha("test");
        pessoa5.setTipoUsuario(TipoUsuario.PACIENTE);
        pessoaDAO.criarPessoa(pessoa5);

// Criando Pessoa 6
// pessoa paciente
        Pessoa pessoa6 = new Pessoa();
        pessoa6.setNome("Pedro");
        pessoa6.setCpf("6666");
        pessoa6.setEndereco("Rua F, 1415");
        pessoa6.setTelefone("6666");
        pessoa6.setLogin("pedro");
        pessoa6.setSenha("test");
        pessoa6.setTipoUsuario(TipoUsuario.PACIENTE);
        pessoaDAO.criarPessoa(pessoa6);

// Criando Pessoa 7
        Pessoa pessoa7 = new Pessoa();
        pessoa7.setNome("Fernanda");
        pessoa7.setCpf("7777");
        pessoa7.setEndereco("Rua G, 1617");
        pessoa7.setTelefone("7777");
        pessoa7.setLogin("fernanda");
        pessoa7.setSenha("test");
        pessoa7.setTipoUsuario(null);
        pessoaDAO.criarPessoa(pessoa7);

        /*medicos*/
// Criando Médico 2
        Pessoa medico2 = new Pessoa();
        medico2.setNome("Luiz");
        medico2.setCpf("2222");
        medico2.setEndereco("Rua B, 456");
        medico2.setTelefone("2222");
        medico2.setLogin("luiz");
        medico2.setSenha("test");
        medico2.setTipoUsuario(TipoUsuario.MEDICO);
        pessoaDAO.criarPessoa(medico2);

        Medico medicodemedico2 = new Medico();
        medicodemedico2.setCrm("22222");
        medicodemedico2.setEspecialidade("Cardiologia");
        medicodemedico2.setPessoa(medico2);
        medicoDAO.criarMedico(medicodemedico2);

// Criando Médico 3
        Pessoa medico3 = new Pessoa();
        medico3.setNome("Julia");
        medico3.setCpf("3333");
        medico3.setEndereco("Rua C, 789");
        medico3.setTelefone("3333");
        medico3.setLogin("julia");
        medico3.setSenha("test");
        medico3.setTipoUsuario(TipoUsuario.MEDICO);
        pessoaDAO.criarPessoa(medico3);

        Medico medicodemedico3 = new Medico();
        medicodemedico3.setCrm("33333");
        medicodemedico3.setEspecialidade("Pediatria");
        medicodemedico3.setPessoa(medico3);
        medicoDAO.criarMedico(medicodemedico3);

// Criando Médico 4
        Pessoa medico4 = new Pessoa();
        medico4.setNome("Ricardo");
        medico4.setCpf("4444");
        medico4.setEndereco("Rua D, 1011");
        medico4.setTelefone("4444");
        medico4.setLogin("ricardo");
        medico4.setSenha("test");
        medico4.setTipoUsuario(TipoUsuario.MEDICO);
        pessoaDAO.criarPessoa(medico4);

        Medico medicodemedico4 = new Medico();
        medicodemedico4.setCrm("44444");
        medicodemedico4.setEspecialidade("Dermatologia");
        medicodemedico4.setPessoa(medico4);
        medicoDAO.criarMedico(medicodemedico4);

        /*franquias*/
        Franquia franquia1 = new Franquia();
        franquia1.setNome("Franquia 1");
        franquia1.setCnpj("123456789");
        franquia1.setResponsavel(pessoa1);
        franquia1.setEndereco("Rua A, 123");
        franquia1.setCidade("São Paulo");

        Franquia franquia2 = new Franquia();
        franquia2.setNome("Franquia 2");
        franquia2.setCnpj("987654321");
        franquia2.setResponsavel(pessoa1);
        franquia2.setEndereco("Rua B, 456");
        franquia2.setCidade("Rio de Janeiro");

        Franquia franquia3 = new Franquia();
        franquia3.setNome("Franquia 3");
        franquia3.setCnpj("555555555");
        franquia3.setResponsavel(pessoa2);
        franquia3.setEndereco("Rua C, 789");
        franquia3.setCidade("Belo Horizonte");
        franquiaDAO.criarFranquia(franquia1);
        franquiaDAO.criarFranquia(franquia2);
        franquiaDAO.criarFranquia(franquia3);

        /*unidade franquia*/
        UnidadeFranquia unidadeFranquia1 = new UnidadeFranquia();
        unidadeFranquia1.setCidade("São Paulo");
        unidadeFranquia1.setEndereco("Rua A, 123");
        unidadeFranquia1.setFranquia(franquia1);
        unidadeFranquia1.setResponsavel(pessoa3);

        UnidadeFranquia unidadeFranquia2 = new UnidadeFranquia();
        unidadeFranquia2.setCidade("São Paulo");
        unidadeFranquia2.setEndereco("Rua B, 098");
        unidadeFranquia2.setFranquia(franquia1);
        unidadeFranquia2.setResponsavel(pessoa3);

        UnidadeFranquia unidadeFranquia3 = new UnidadeFranquia();
        unidadeFranquia3.setCidade("São Paulo");
        unidadeFranquia3.setEndereco("Rua c, 398");
        unidadeFranquia3.setFranquia(franquia2);
        unidadeFranquia3.setResponsavel(pessoa4);

        unidadeFranquiaDAO.criarUnidade(unidadeFranquia1);
        unidadeFranquiaDAO.criarUnidade(unidadeFranquia2);
        unidadeFranquiaDAO.criarUnidade(unidadeFranquia3);

        /*consultas*/
        //p 5 6
        //m 2 3 
        
////
        /*  Pessoa paciente1 = new Pessoa();
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

        Pessoa pessoaMedico = gui.cadastrarPessoa();
                    pessoaMedico.setTipoUsuario(TipoUsuario.MEDICO);
                    pessoaDAO.criarPessoa(pessoaMedico);
                    Medico medicocriado = gui.cadastrarMedico(pessoaMedico);
                    medicoDAO.criarMedico(medicocriado);*/
    }

    public static void main(String[] args) {
        new Programa();
    }

}
