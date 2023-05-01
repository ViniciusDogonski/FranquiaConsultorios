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
public class InfoConsulta {

    private int id;
    private Consulta consulta;
    private String descricao;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;

    public InfoConsulta() {
        /* this.setDataCriacao(dataCriacao);
        this.setDataModificacao(LocalDateTime.now());*/
    }

    public int getId() {
        return id;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public LocalDateTime getDataModificacao() {
        return dataModificacao;
    }

    @Override
    public String toString() {
        return "InfoConsulta{" + "id=" + id + ", consulta=" + consulta + ", descricao=" + descricao + ", dataCriacao=" + dataCriacao + ", dataModificacao=" + dataModificacao + '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void setDataModificacao(LocalDateTime dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

}
