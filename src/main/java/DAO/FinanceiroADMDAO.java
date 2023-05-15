/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Objects.FinanceiroADM;
import Objects.Franquia;
import Objects.MovimentoDesc;
import Objects.TipoMovimentacao;
import Objects.UnidadeFranquia;
import java.time.LocalDate;

/**
 *
 * @author Vinicius Augusto
 */
public class FinanceiroADMDAO {

    private FinanceiroADM[] financasADM;
    private int proximoID;

    public FinanceiroADMDAO(int tamanhoMaximo) {

        this.financasADM = new FinanceiroADM[tamanhoMaximo];
        this.proximoID = 1;
    }

    public int criarFinancas(FinanceiroADM financa) {
        int id = this.proximoID++;
        financa.setId(id);
        this.financasADM[id - 1] = financa;
        return id;
    }

    public FinanceiroADM buscarFinancas(int id) {
        if (id < 1 || id > this.proximoID - 1) {
            return null; // ID invÃ¡lido
        }
        return this.financasADM[id - 1];
    }

    public void atualizarFinancas(FinanceiroADM financa) {
        if (financa.getId() < 1 || financa.getId() > this.proximoID - 1) {
            return; // ID invÃ¡lido
        }
        this.financasADM[financa.getId() - 1] = financa;
    }

    public void excluirFinancas(int id) {
        if (id < 1 || id > this.proximoID - 1) {
            return; // ID invÃ¡lido
        }
        this.financasADM[id - 1] = null;
    }

    public FinanceiroADM[] mostrarFinancas() {

        /* boolean temFranquias = false;
        for (Franquia f : this.franquias) {
            if (f != null) {
                System.out.println(f);
                temFranquias = true;
            }
        }
        if (!temFranquias) {
            System.out.println("nÃ£o existe franquia cadastrada");
        }*/
        return this.financasADM;

    }
    public FinanceiroADM[] mostrarFinancasFranquia(Franquia franquia){
        FinanceiroADM [] fin = new FinanceiroADM[financasADM.length];
        int i =0;
        for(FinanceiroADM f : financasADM){
            if(((f!= null) && (f.getUnidade().getFranquia().equals(franquia)))){
                fin[i] = f;
                i++;
            }
        }
        return fin;
    }
    public FinanceiroADM[] mostrarFinancasUnidade(UnidadeFranquia unidade){
        FinanceiroADM [] fin = new FinanceiroADM[financasADM.length];
        int i =0;
        for(FinanceiroADM f : financasADM){
            if(((f!= null) && (f.getUnidade().equals(unidade)))){
                fin[i] = f;
                i++;
            }
        }
        return fin;
    }


    public FinanceiroADM[] buscarMovimentosEntreDatas(LocalDate dataInicial, LocalDate dataFinal) {

        FinanceiroADM[] dadosFinancaEncontrados = new FinanceiroADM[100];

        int indexDadosFinancav = 0;

        for (int i = 0; i < financasADM.length; i++) {

            FinanceiroADM movimento = financasADM[i];

            if (movimento != null && movimento.getDataCriacao().toLocalDate().isAfter(dataInicial) && movimento.getDataCriacao().toLocalDate().isBefore(dataFinal)) {

                dadosFinancaEncontrados[indexDadosFinancav] = movimento;
                indexDadosFinancav++;
            }

        }
        return dadosFinancaEncontrados;

    }

    public double calcularPagamentoAdmin(LocalDate dataAtual, UnidadeFranquia unidade) {

        LocalDate primeiroDiaMes = dataAtual.withDayOfMonth(1);

        FinanceiroADM[] movimentos = buscarMovimentosEntreDatas(primeiroDiaMes.minusMonths(1), primeiroDiaMes.minusDays(1));

        double valorFaturamento = 0;

        for (FinanceiroADM movimento : movimentos) {

            if (movimento != null && movimento.getTipoMovimentacao().equals(TipoMovimentacao.ENTRADA)
                    && movimento.getUnidade().equals(unidade) && (movimento.getDescriacao().equals(MovimentoDesc.CONSULTA) || movimento.getDescriacao().equals(MovimentoDesc.PROCEDIMENTO))) {

                valorFaturamento += movimento.getValor();

            }
           
        }

        double valorAdmin = 1000.0 + (valorFaturamento * 0.05);

        /* FinanceiroADM pagamento = new FinanceiroADM();*/
        return valorAdmin;
    }

}
