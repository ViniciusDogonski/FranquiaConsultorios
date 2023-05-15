/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Objects.FinanceiroMedico;
import Objects.Consulta;
import Objects.EstadoFinanceiroMedico;
import Objects.Estados;
import Objects.Procedimento;
import Objects.Medico;
import Objects.Franquia;
import Objects.UnidadeFranquia;
import java.time.LocalDate;

/**
 *
 * @author Vinicius Augusto
 */
public class FinanceiroMedicoDAO {

    private FinanceiroMedico[] financasMedico;
    private int proximoID;

    public FinanceiroMedicoDAO(int tamanhoMaximo) {

        this.financasMedico = new FinanceiroMedico[tamanhoMaximo];
        this.proximoID = 1;
    }

    public int criarFinancas(FinanceiroMedico financa) {
        int id = this.proximoID++;
        financa.setId(id);
        this.financasMedico[id - 1] = financa;
        return id;
    }

    public FinanceiroMedico buscarFinancas(int id) {
        if (id < 1 || id > this.proximoID - 1) {
            return null; // ID invÃ¡lido
        }
        return this.financasMedico[id - 1];
    }

    public void atualizarFinancas(FinanceiroMedico financa) {
        if (financa.getId() < 1 || financa.getId() > this.proximoID - 1) {
            return; // ID invÃ¡lido
        }
        this.financasMedico[financa.getId() - 1] = financa;
    }

    public void excluirFinancas(int id) {
        if (id < 1 || id > this.proximoID - 1) {
            return; // ID invÃ¡lido
        }
        this.financasMedico[id - 1] = null;
    }

    public FinanceiroMedico[] mostrarFinancas() {

        return this.financasMedico;
    }

    public void registrarPagamento(Medico medico, Consulta[] consultas, Procedimento[] procedimentos, Franquia franquia, LocalDate dataAtual) {

        //   System.out.println(medico);
        //   System.out.println(franquia);
        for (Consulta consulta : consultas) {
            //  System.out.println(consulta);
        }

        for (Procedimento procedimento : procedimentos) {
            // System.out.println(procedimento);
        }

        double totalConsultasAgendadas = 0.0;
        double totalProcedimentosAgendadas = 0.0;

        double totalConsultasRealizadas = 0.0;
        double totalProcedimentosRealizadas = 0.0;

        // Calcula o total das consultas realizadas pelo mÃ©dico no Ãºltimo mÃªs
        for (Consulta consulta : consultas) {
            if (consulta != null && consulta.getMedico().equals(medico) && consulta.getData().isAfter(dataAtual.minusMonths(1))) {

                if (consulta.getEstado().equals(Estados.AGENDADA)) {
                    totalConsultasAgendadas += consulta.getValor() * 0.7; // MÃ©dico ganha 70% do valor da consulta
                }

                if (consulta.getEstado().equals(Estados.REALIZADA)) {
                    totalConsultasRealizadas += consulta.getValor() * 0.7; // MÃ©dico ganha 70% do valor da consulta
                }

            }
        }
        // Calcula o total dos procedimentos realizados pelo mÃ©dico no Ãºltimo mÃªs
        for (Procedimento procedimento : procedimentos) {
            if (procedimento != null && procedimento.getConsulta().getMedico().equals(medico) && procedimento.getData().isAfter(dataAtual.minusMonths(1))) {

                if (procedimento.getEstado().equals(Estados.AGENDADA)) {
                    totalProcedimentosAgendadas += procedimento.getValor() * 0.5; // MÃ©dico ganha 50% do valor do procedimento
                }

                if (procedimento.getEstado().equals(Estados.REALIZADA)) {
                    totalProcedimentosRealizadas += procedimento.getValor() * 0.5; // MÃ©dico ganha 50% do valor do procedimento
                }

            }
        }

        //       System.out.println(totalConsultasAgendadas);
        //   System.out.println(totalConsultasRealizadas);
        // System.out.println(totalProcedimentosAgendadas);
        // System.out.println(totalProcedimentosRealizadas);
        double totalAgendada = totalConsultasAgendadas + totalProcedimentosAgendadas;
        double totalRealizadas = totalConsultasRealizadas + totalProcedimentosRealizadas;

        /* 
        //agendados-agendado
        //realizada-pago
         */
        if (totalAgendada > 0) {

            FinanceiroMedico agendada = new FinanceiroMedico();
            agendada.setEstado(EstadoFinanceiroMedico.AGENDADO);
            agendada.setMedico(medico);
            agendada.setValor(totalAgendada);
            agendada.setFranquia(franquia);

            this.criarFinancas(agendada);
        }

        if (totalRealizadas > 0) {

            FinanceiroMedico realizada = new FinanceiroMedico();
            realizada.setEstado(EstadoFinanceiroMedico.PAGO);
            realizada.setMedico(medico);
            realizada.setValor(totalRealizadas);
            realizada.setFranquia(franquia);

            this.criarFinancas(realizada);

        }

    }

    public FinanceiroMedico[] consultarFInacaPorMedico(Medico medico) {

        FinanceiroMedico[] FinanceiroMedicoDoMedico = new FinanceiroMedico[financasMedico.length];

        int index = 0;

        for (FinanceiroMedico financeiroMedico : financasMedico) {
            if (financeiroMedico != null && financeiroMedico.getMedico().equals(medico)) {
                FinanceiroMedicoDoMedico[index] = financeiroMedico;
                index++;
            }
        }

        return FinanceiroMedicoDoMedico;
    }

}
