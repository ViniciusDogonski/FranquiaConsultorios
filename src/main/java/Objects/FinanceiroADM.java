/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

import java.time.LocalDateTime;

/**
 *
 * @author Vinicius Augusto
 */
public class FinanceiroADM {

    private int id;
    private TipoMovimentacao tipoMovimentacao;
    private double valor;
    private UnidadeFranquia unidade;
    private MovimentoDesc descriacao;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;

    public FinanceiroADM() {
        this.setDataCriacao();
        this.setDataModificacao(LocalDateTime.now());
    }

    public int getId() {
        return id;
    }

    public TipoMovimentacao getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public double getValor() {
        return valor;
    }

    public UnidadeFranquia getUnidade() {
        return unidade;
    }

    public MovimentoDesc getDescriacao() {
        return descriacao;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public LocalDateTime getDataModificacao() {
        return dataModificacao;
    }

    @Override
    public String toString() {
        return "FinanceiroADM{" + "id=" + id + ", tipoMovimentacao=" + tipoMovimentacao + ", valor=" + valor + ", unidade=" + unidade.toString() + ", descriacao=" + descriacao + ", dataCriacao=" + dataCriacao + ", dataModificacao=" + dataModificacao + '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setUnidade(UnidadeFranquia unidade) {
        this.unidade = unidade;
    }

    public void setDescriacao(MovimentoDesc descriacao) {
        this.descriacao = descriacao;
    }

    public void setDataCriacao() {
        this.dataCriacao = LocalDateTime.now();
    }

    public void setDataModificacao(LocalDateTime dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

}
