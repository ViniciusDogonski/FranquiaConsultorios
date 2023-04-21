/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

import DAO.PessoaDAO;
import DAO.MedicoDAO;
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

    public Programa() {

        int opcaoUsuario;

        do {
            opcaoUsuario = gui.pegaOpcaoUsuario();

            switch (opcaoUsuario) {
                case 1:

                    Pessoa p = gui.cadastrarPessoa();
                    int id = pessoaDAO.criarPessoa(p);
                    System.out.println(id);

                    break;
                case 2:
                    pessoaDAO.mostrarPessoas();
                    break;

                case 3:

                    break;
                case 4:

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
                case 0:

                    break;
                default:
                    throw new AssertionError();
            }
        } while (opcaoUsuario != 0);

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
                //gui
                break;
            default:
                System.out.println("Tipo de usuário inválido.");
        }
    }

    public static void main(String[] args) {
        new Programa();
    }

}
