/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Objects.Pessoa;
import Objects.TipoUsuario;

/**
 *
 * @author Vinicius Augusto
 */
public class PessoaDAO {

    private Pessoa[] pessoas;
    private int proximoID;

    public PessoaDAO(int tamanhoMaximo) {
        this.pessoas = new Pessoa[tamanhoMaximo];
        this.proximoID = 1;

    }

    public int criarPessoa(Pessoa pessoa) {
        int id = this.proximoID++;
        pessoa.setId(id);
        this.pessoas[id - 1] = pessoa;
        return id;
    }

    public Pessoa buscarPessoa(int id) {
        if (id < 1 || id > this.proximoID - 1) {
            return null; // ID inválido
        }
        return this.pessoas[id - 1];
    }

    public Pessoa buscarPessoaPorLogin(String login) {
        for (Pessoa pessoa : this.pessoas) {
            if (pessoa != null && pessoa.getLogin().equals(login)) {
                return pessoa;
            }
        }
        return null; // pessoa não encontrada
    }

    public boolean autenticarPessoa(String login, String senha) {
        Pessoa pessoa = buscarPessoaPorLogin(login);
        if (pessoa == null) {
            return false; // login não encontrado
        }
        return pessoa.getSenha().equals(senha); // autenticação bem-sucedida se a senha for igual
    }

    public void atualizarPessoa(Pessoa pessoa) {
        if (pessoa.getId() < 1 || pessoa.getId() > this.proximoID - 1) {
            return; // ID inválido
        }
        this.pessoas[pessoa.getId() - 1] = pessoa;
    }

    public void excluirPessoa(int id) {
        if (id < 1 || id > this.proximoID - 1) {
            return; // ID inválido
        }
        this.pessoas[id - 1] = null;
    }

    public void mostrarPessoas() {

        boolean temPessoas = false;
        for (Pessoa p : pessoas) {
            if (p != null) {
                System.out.println(p);
                temPessoas = true;
            }
        }
        if (!temPessoas) {
            System.out.println("não existe pessoas cadastrado");
        }

    }

    /*public PessoaDAO() {

        Pessoa p1 = new Pessoa();
        p1.setNome("josephina");
        this.adicionado(p1);

        Pessoa p2 = new Pessoa();
        p2.setNome("jaspion");
        this.adicionado(p2);
    }

    public boolean adicionado(Pessoa p) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            pessoas[proximaPosicaoLivre] = p;
            return true;
        } else {
            return false;
        }

    }

    public Pessoa getPessoaBYid(int id) {

        System.out.println(pessoas);

        for (Pessoa p : pessoas) {
            if (p != null) {
                System.out.println(p);
            }
        }

        return pessoas[id - 1];
    }

    public boolean ehVazio() {
        for (Pessoa pessoa : pessoas) {
            if (pessoa != null) {
                return false;
            }
        }
        return true;

    }

    private int proximaPosicaoLivre() {
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] == null) {
                return i;
            }

        }
        return -1;
    }

    public void mostrarTodos() {
        boolean temPessoas = false;
        for (Pessoa p : pessoas) {
            if (p != null) {
                System.out.println(p);
                temPessoas = true;
            }
        }
        if (!temPessoas) {
            System.out.println("não existe pessoas cadastrado");
        }
    }

    public boolean removerPessoa(String id) {
        boolean id_encontrado = false;
        long id_pessoa = Long.parseLong(id);
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i].getID() == id_pessoa) {
                pessoas[i] = null;
                System.out.println("Pessoa removida.");
                id_encontrado = true;
                return id_encontrado;

            }
        }
        if (!id_encontrado) {
            System.out.println("Pessoa não cadastrada.");

        }
        return id_encontrado;
    }*/
}
