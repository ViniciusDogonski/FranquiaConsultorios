/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Objects.Consulta;

/**
 *
 * @author Vinicius Augusto
 */
public class ConsultaDAO {

    private Consulta[] consultas;
    private int proximoID;

    public ConsultaDAO(int tamanho) {
        this.consultas = new Consulta[tamanho];
        this.proximoID = 1;
    }
    public Consulta[] getConsultas(){
        return this.consultas;
    }
    public int cadastrarConsulta(Consulta consulta) {
        int id = this.proximoID++;
        consulta.setId(id);
        this.consultas[id - 1] = consulta;
        return id;
    }

    public void excluirConsulta(int id) {
        if (id < 1 || id > this.proximoID - 1) {
            return; // ID inválido
        }
        this.consultas[id - 1] = null;
    }

    public Consulta buscarConsulta(int id) {
        if (id < 1 || id > this.proximoID - 1) {
            return null; // ID inválido
        }
        return this.consultas[id - 1];
    }

    public void editarConsulta(Consulta consultaAtualizada) {
        if (consultaAtualizada.getId() < 1 || consultaAtualizada.getId() > this.proximoID - 1) {
            return; // ID inválido
        }
        this.consultas[consultaAtualizada.getId() - 1] = consultaAtualizada;
    }

    public void mostrarConsultas() {

        boolean temMedicos = false;
        for (Consulta m : consultas) {
            if (m != null) {
                System.out.println(m);
                temMedicos = true;
            }
        }
        if (!temMedicos) {
            System.out.println("não existe Consultas cadastradas");
        }

    }

}
