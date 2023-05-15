/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Objects.Consulta;
import Objects.Medico;
import Objects.Procedimento;

/**
 *
 * @author Vinicius Augusto
 */
public class ProcedimentoDAO {

    private Procedimento[] procedimentos;
    private int proximoID;

    public ProcedimentoDAO(int tamanhoMaximo) {
        this.procedimentos = new Procedimento[tamanhoMaximo];
        this.proximoID = 1;
    }

    public int criarProcedimento(Procedimento procedimento) {
        int id = this.proximoID++;
        procedimento.setId(id);
        this.procedimentos[id - 1] = procedimento;
        return id;
    }

    public void excluirProcedimento(int id) {
        if (id < 1 || id > this.proximoID - 1) {
            return; // ID invÃ¡lido
        }
        this.procedimentos[id - 1] = null;
    }

    public Procedimento buscarProcedimento(int id) {
        if (id < 1 || id > this.proximoID - 1) {
            return null; // ID invÃ¡lido
        }
        return this.procedimentos[id - 1];
    }

    public void atualizarProcedimento(Procedimento procedimento) {
        if (procedimento.getId() < 1 || procedimento.getId() > this.proximoID - 1) {
            return; // ID invÃ¡lido
        }
        this.procedimentos[procedimento.getId() - 1] = procedimento;
    }

    public Procedimento[] mostrarProcedimento() {

        /* boolean temMedicos = false;
        for (Procedimento m : procedimentos) {
            if (m != null) {
                System.out.println(m);
                temMedicos = true;
            }
        }
        if (!temMedicos) {
            System.out.println("nÃ£o existe procedimentos cadastrados");
        }*/
        return this.procedimentos;

    }

    public Procedimento[] getProcedimentosPorMedico(Medico medico) {
        Procedimento[] procedimentosPorMedico = new Procedimento[procedimentos.length];
        int contador = 0;
        for (Procedimento procedimento : procedimentos) {
            if (procedimento != null && procedimento.getConsulta() != null && procedimento.getConsulta().getMedico().equals(medico)) {
                procedimentosPorMedico[contador] = procedimento;
                contador++;
            }
        }
        return procedimentosPorMedico;
    }

    public Procedimento[] getProcedimentosPorConsulta(Consulta consulta) {
        Procedimento[] procedimentosPorConsulta = new Procedimento[procedimentos.length];
        int contador = 0;

        for (Procedimento procedimento : procedimentos) {
            if (procedimento != null && procedimento.getConsulta() != null && procedimento.getConsulta().equals(consulta)) {
                procedimentosPorConsulta[contador] = procedimento;
                contador++;
            }
        }
        return procedimentosPorConsulta;
    }

}
