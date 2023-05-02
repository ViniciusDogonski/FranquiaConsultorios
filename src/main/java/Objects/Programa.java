/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

import DAO.PessoaDAO;
import DAO.MedicoDAO;
import DAO.FranquiaDAO;
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
    FranquiaDAO franquiaDAO = new FranquiaDAO(100);
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
                    pessoaDAO.mostrarPessoas();
                    break;

                case 3:
                    System.out.println("------ Editar Pessoa------");

                    System.out.print("id da pessoa:");
                    int idEdit = Integer.parseInt(scan.nextLine());
                    //Pessoa pessoaBuscada = pessoaDAO.buscarPessoa(idEdit);

                    Pessoa editPessoa = gui.cadastrarPessoa();
                    editPessoa.setId(idEdit);
                    pessoaDAO.atualizarPessoa(editPessoa);

                    break;
                case 4:
                    System.out.println("------ Delete Pessoa------");

                    System.out.print("id da pessoa:");
                    int idDel = Integer.parseInt(scan.nextLine());
                    pessoaDAO.excluirPessoa(idDel);

                    break;
                case 5:
                    System.out.println("------ Criar Medico ------");

                    System.out.print("id da pessoa:");
                    int idPessoa = Integer.parseInt(scan.nextLine());

                    Pessoa pessoaMedico = pessoaDAO.buscarPessoa(idPessoa);

                    Medico medicocriado = gui.cadastrarMedico(pessoaMedico);

                    medicoDAO.criarMedico(medicocriado);
                    pessoaMedico.setTipoUsuario(TipoUsuario.MEDICO);
                    //cadastrar medico
                    break;
                case 6:
                    //listar medicos 
                    medicoDAO.mostrarMedicos();
                    break;
                case 7:
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
                case 8:
                    System.out.println("Franquias Cadastradas:");
                    franquiaDAO.mostrarFranquias();
                    break;
                case 9:
                    System.out.println("Editar Franquia");
                    Franquia franquiaAtual = new Franquia();
                    System.out.println("Informe o id da Franquia que será alterada");
                    int id_franquia = Integer.parseInt(scan.nextLine());
                    franquiaDAO.criarFranquia(franquiaAtual);
                     franquiaAtual.setId(id_franquia);
                    franquiaDAO.atualizarFranquia(franquiaAtual);
                    break;
                case 10:
                    System.out.println("Deletar Franquia:");
                    System.out.println("informe o id da franquia:");
                    
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

    }

    public static void main(String[] args) {
        new Programa();
    }

}
