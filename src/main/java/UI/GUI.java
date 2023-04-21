/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI;

import Objects.Pessoa;
import Objects.Medico;
import Objects.TipoUsuario;
import java.util.Scanner;

/**
 *
 * @author Vinicius Augusto
 */
public class GUI {

    Scanner scan = new Scanner(System.in);

    public Pessoa cadastrarPessoa() {

        System.out.println("------ Criar Pessoa ------");
        System.out.println("Por favor, informe os dados da pessoa:");

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

        System.out.print("Tipo de usuário (1-Dono Franquia, 2-Dono Unidade, 3-Administrativo, 4-Médico, 5-Paciente): ");
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
            default:
                System.out.print("opçao invalida!");
        }
        return pessoa;
    }
    
    
     public Medico  cadastrarMedico(Pessoa pessoa) {

     
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
    

    public int pegaOpcaoUsuario() {

        System.out.println("1 cadastrar PESSOA");
        System.out.println("2 mostrar todas PESSOAS");
        System.out.println("3 alterar PESSOA");
        System.out.println("4 excluir pelo id  PESSOAS");
        System.out.println("5 cadastrar MEDICO");
        System.out.println("6 mostrar MEDICO");
        System.out.println("0 sair");

        System.out.print("Qual sua opcao ?");
        return Integer.parseInt(scan.nextLine());

    }

}
